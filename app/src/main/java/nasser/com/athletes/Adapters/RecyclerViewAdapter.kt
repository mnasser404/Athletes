package nasser.com.athletes.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.athlete_recycler_item.view.*
import nasser.com.athletes.Activities.DetailActivity
import nasser.com.athletes.BusinessConstants
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.R

class RecyclerViewAdapter(var context: Context?, var atheletList: List<AthleteModel.Athele>) : RecyclerView.Adapter<RecyclerViewAdapter.AtheleHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): AtheleHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.athlete_recycler_item, viewGroup, false)
        val holder = AtheleHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return atheletList.size
    }

    override fun onBindViewHolder(holder: AtheleHolder, position: Int) {
        val currentAthele = atheletList.get(position)
        holder.atheleText.text = currentAthele.name
        Glide.with(context).load(currentAthele.image).placeholder(R.drawable.default_imag).into(holder.atheleImage)
    }


    inner class AtheleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var atheleImage: ImageView
        var atheleText: TextView


        init {
            atheleImage = itemView.athleteImage
            atheleText = itemView.athleteName
            itemView.setOnClickListener {
                val selectedAthele = atheletList.get(adapterPosition)
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(BusinessConstants.ACTIVITY_EXTRA, selectedAthele)
                context?.let { it.startActivity(intent) }
            }
        }


    }


}