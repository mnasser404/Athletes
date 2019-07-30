package nasser.com.athletes.Fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import nasser.com.athletes.Adapters.RecyclerViewAdapter
import nasser.com.athletes.MainViewModel
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.R

class HomeFragment : Fragment() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var atheleList: List<AthleteModel.Athele>
    lateinit var viewModel: MainViewModel
    lateinit var layoutView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutView = inflater.inflate(R.layout.fragment_main, container, false)
        setupRecyclerView()
        initializeViewModel()
        return layoutView
    }

    private fun setupRecyclerView() {
        athletesRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        atheleList = listOf()
        adapter = RecyclerViewAdapter(activity, atheleList)
        athletesRecyclerView.adapter = adapter
    }

    private fun initializeViewModel() {
        val observer = Observer<List<AthleteModel.Athele>> { list ->
            list?.let {
                atheleList = list
                adapter.notifyDataSetChanged()
            }
        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.loadViewData().observe(this, observer)
    }

}