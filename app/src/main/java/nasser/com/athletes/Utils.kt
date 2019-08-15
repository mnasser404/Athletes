package nasser.com.athletes

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class Utils {


    companion object {

        private val HEADER_PRAGMA = "Pragma"
        private val HEADER_CACHE_CONTROL = "Cache-Control"
        private val cacheSize = 5 * 1024 * 1024L
        private var retrofit: Retrofit? = null
        private var okHttpClient: OkHttpClient? = null


        fun isNetworkAvailable(context: Context): Boolean {
            var isConnected = false
            var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetworkInfo = connectivityManager.activeNetworkInfo
            activeNetworkInfo?.let { isConnected = it.isConnected }
            return isConnected
        }


        fun initRetrofit(context: Context): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BusinessConstants.BASE_URL)
                        .client(okHttpClient(context))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit
        }


        fun cache(context: Context): Cache {
            return Cache(File(context.cacheDir, "cache"), cacheSize)
        }

        fun okHttpClient(context: Context): OkHttpClient {
            if (okHttpClient == null) {
                okHttpClient = OkHttpClient()
                        .newBuilder()
                        .cache(cache(context))
                        .addInterceptor(offlineInterceptor(context))
                        .addNetworkInterceptor(networkInterceptor())
                        .build()
            }
            return okHttpClient as OkHttpClient
        }

        private fun offlineInterceptor(context: Context): Interceptor {
            return object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    var request = chain.request()
                    if (!isNetworkAvailable(context)) {
                        val cacheControl = CacheControl
                                .Builder()
                                .maxStale(7, TimeUnit.DAYS)
                                .build()

                        request = request
                                .newBuilder()
                                .removeHeader(HEADER_PRAGMA)
                                .removeHeader(HEADER_CACHE_CONTROL)
                                .cacheControl(cacheControl)
                                .build()
                    }
                    return chain.proceed(request)
                }

            }
        }

        private fun networkInterceptor(): Interceptor {
            return object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    var response = chain.proceed(chain.request())
                    val cacheControl = CacheControl
                            .Builder()
                            .maxAge(5, TimeUnit.SECONDS)
                            .build()

                    return response
                            .newBuilder()
                            .removeHeader(HEADER_PRAGMA)
                            .removeHeader(HEADER_CACHE_CONTROL)
                            .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                            .build()

                }

            }
        }

    }
}