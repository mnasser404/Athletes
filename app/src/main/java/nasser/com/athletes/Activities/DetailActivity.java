package nasser.com.athletes.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nasser.com.athletes.R;
import nasser.com.athletes.Utils;

public class DetailActivity extends AppCompatActivity {


    private String athleteName, athleteImageURL, athleteBrief;
    private TextView tvAthleteName, tvAthleteBrief;
    private ImageView athleteImage;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bundle = getIntent().getExtras();

        setupViews();
        fetchingDataFromBundle(bundle);
        bindingDataToViews();

    }


    private void fetchingDataFromBundle(Bundle bundle) {
        if (bundle != null) {
            athleteName = bundle.getString(Utils.NAME_EXTRA);
            athleteImageURL = bundle.getString(Utils.IMAGE_EXTRA);
            athleteBrief = bundle.getString(Utils.BRIEF_EXTRA);
        }
    }

    private void setupViews() {
        tvAthleteName = (TextView) findViewById(R.id.detailName);
        tvAthleteBrief = (TextView) findViewById(R.id.detailBrief);
        athleteImage = (ImageView) findViewById(R.id.detailImage);
    }

    private void bindingDataToViews() {
        tvAthleteName.setText(athleteName);
        tvAthleteBrief.setText(athleteBrief);
        Glide.with(this).load(athleteImageURL).placeholder(R.drawable.default_imag).into(athleteImage);
    }


}
