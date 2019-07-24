package nasser.com.athletes.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nasser.com.athletes.Adapters.RecyclerViewAdapter;
import nasser.com.athletes.FetchAthletesData;
import nasser.com.athletes.Models.Athlete;
import nasser.com.athletes.R;
import nasser.com.athletes.Utils;
import nasser.com.athletes.data.Repository;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private RecyclerView athletesRecyclerView;
    private RecyclerViewAdapter adapter;
    private List<Athlete> athleteList;
    private View view ;

    public MainFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        athleteList = new ArrayList<>();
        athletesRecyclerView = (RecyclerView) view.findViewById(R.id.athletesRecyclerView);
        athletesRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return view ;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (Utils.isNetworkAvailable(getActivity())) {
           new  Repository().geDatatFromRemote();
        } else {
            Toast.makeText(getActivity() , getString(R.string.check_ur_internet) , Toast.LENGTH_SHORT).show();
        }
    }
}
