package nasser.com.athletes.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.R
import nasser.com.athletes.BusinessConstants

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val athele = extractBundleData()
        bindDataToViews(athele)

    }


    private fun extractBundleData(): AthleteModel.Athele {
        val bundle = intent.extras
        val athele = bundle.get(BusinessConstants.ACTIVITY_EXTRA) as AthleteModel.Athele
        return athele
    }

    private fun bindDataToViews(athele: AthleteModel.Athele) {
        Glide.with(this).load(athele.image).placeholder(R.drawable.default_imag).into(detailImage)
        detailName.text = athele.name
        detailBrief.text = athele.brief
    }

}