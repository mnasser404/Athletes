package nasser.com.athletes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONObject;

/**
 * Created by Moham on 9/20/2017.
 */

public class Utils {

    public static final String BASE_URL = "https://gist.githubusercontent.com/Bassem-Samy/f227855df4d197d3737c304e9377c4d4/raw/ece2a30b16a77ee58091886bf6d3445946e10a23/";
    public static final String ATHELETS_URL = "athletes.josn";
    public static final String NAME_EXTRA = "athleteName";
    public static final String IMAGE_EXTRA = "athleteImage";
    public static final String BRIEF_EXTRA = "athleteBrief";
    public static final String FRAGMENT_TAG = "MainFragment";

    public static final String ATHLETES = "athletes";
    public static final String ATHLETE_NAME = "name";
    public static final String ATHLETES_IMAGE = "image";
    public static final String ATHLETES_BRIEF = "brief";



    public static boolean CheckJSONObject(String JSON) {

        JSONObject jsonObj = null;

        try {
            jsonObj = new JSONObject(JSON.toString());
        } catch (Exception e) {

        }

        if (jsonObj != null) {
            return true;
        } else {
            return false;
        }


    }


}
