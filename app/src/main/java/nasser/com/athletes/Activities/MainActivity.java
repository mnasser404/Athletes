package nasser.com.athletes.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import nasser.com.athletes.Fragments.MainFragment;
import nasser.com.athletes.R;
import nasser.com.athletes.Utils;

public class MainActivity extends AppCompatActivity {



    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            fragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().add(fragment , Utils.FRAGMENT_TAG).commit();
        }else{
           fragment = getSupportFragmentManager().findFragmentByTag(Utils.FRAGMENT_TAG);
        }



    }




}
