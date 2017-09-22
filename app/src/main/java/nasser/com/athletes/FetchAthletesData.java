package nasser.com.athletes;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nasser.com.athletes.Models.Athlete;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by  Moham on 9/20/2017.
 */

public class FetchAthletesData extends AsyncTask<String, Void, List<Athlete>> {


    private List<Athlete> athleteList;
    private String json;


    @Override
    protected List<Athlete> doInBackground(String... strings) {

        athleteList = new ArrayList<>();

        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(strings[0]).build();
            Response response = client.newCall(request).execute();
            json = response.body().string();

            if (Utils.CheckJSONObject(json)) {

                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray(Utils.ATHLETES);

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject currentJSONObject = jsonArray.getJSONObject(i);

                    String name = currentJSONObject.getString(Utils.ATHLETE_NAME);
                    String imageUrl = currentJSONObject.getString(Utils.ATHLETES_IMAGE);
                    String brief = currentJSONObject.getString(Utils.ATHLETES_BRIEF);

                    Athlete athlete = new Athlete();
                    athlete.setName(name);
                    athlete.setImageUrl(imageUrl);
                    athlete.setBrief(brief);

                    athleteList.add(athlete);

                }

            } else {

            }


        } catch (Exception ex) {

        }

        return athleteList;

    }


}
