package nasser.com.athletes.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import nasser.com.athletes.Adapters.RecyclerViewAdapter
import nasser.com.athletes.MainViewModel
import nasser.com.athletes.Models.AthleteModel
import nasser.com.athletes.R

class HomeFragment : Fragment() {

    lateinit var adapter: RecyclerViewAdapter
    lateinit var viewModel: MainViewModel
    lateinit var layoutView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutView = inflater.inflate(R.layout.fragment_main, container, false)
        return layoutView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        initializeViewModel()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
    }

    private fun initializeViewModel() {
        val observer = Observer<List<AthleteModel.Athele>> { list ->
            adapter = RecyclerViewAdapter(activity, list)
            recyclerView.adapter = adapter

        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.loadViewData().observe(this, observer)
    }

}