package nasser.com.athletes.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nasser.com.athletes.Fragments.HomeFragment
import nasser.com.athletes.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(HomeFragment(), "").commit()
    }


}