package nasser.com.athletes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import nasser.com.athletes.Activities.DetailActivity;
import nasser.com.athletes.Models.Athlete;
import nasser.com.athletes.R;
import nasser.com.athletes.Utils;

/**
 * Created by Moham on 9/20/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    private Context context;
    private List<Athlete> athleteList;


    public RecyclerViewAdapter(Context context, List<Athlete> athleteList) {
        this.context = context;
        this.athleteList = athleteList;
    }

    @Override
    public RecyclerViewAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.athlete_recycler_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.Holder holder, int position) {
        Athlete athlete = athleteList.get(position);
        Glide.with(context).load(athlete.getImageUrl()).placeholder(R.drawable.default_imag).into(holder.athleteImage);
        holder.athleteName.setText(athlete.getName());
    }

    @Override
    public int getItemCount() {
        return athleteList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {

        private ImageView athleteImage;
        private TextView athleteName;

        public Holder(View itemView) {
            super(itemView);

            athleteImage = (ImageView) itemView.findViewById(R.id.athleteImage);
            athleteName = (TextView) itemView.findViewById(R.id.athleteName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Athlete athlete = athleteList.get(getAdapterPosition());
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra(Utils.NAME_EXTRA, athlete.getName());
                    i.putExtra(Utils.IMAGE_EXTRA, athlete.getImageUrl());
                    i.putExtra(Utils.BRIEF_EXTRA, athlete.getBrief());
                    context.startActivity(i);
                }
            });
        }
    }
}
