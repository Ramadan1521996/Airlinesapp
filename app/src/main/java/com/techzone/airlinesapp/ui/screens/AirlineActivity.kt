package com.techzone.airlinesapp.ui.screens

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techzone.airlinesapp.adapters.AirlineAdapter
import com.techzone.airlinesapp.databinding.ActivityAirlineBinding
import com.techzone.airlinesapp.iterfaces.AddAirlineInterface
import com.techzone.airlinesapp.models.Airline
import com.techzone.airlinesapp.ui.views.AddAirLineButtonSheet
import com.techzone.airlinesapp.util.MatchAirlineByName
import com.techzone.airlinesapp.viewModels.AirlineViewModel
import java.util.*

class AirlineActivity : AppCompatActivity() ,AddAirlineInterface{
    private lateinit var binding: ActivityAirlineBinding
    private lateinit var mContext: Context
    private  var airLineButtonSheet: AddAirLineButtonSheet?= null
    private var airlineAdapter: AirlineAdapter? = null
    private lateinit var airlineList: MutableList<Airline>

    private lateinit var airlineViewModel: AirlineViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_airline)
        binding = ActivityAirlineBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)
        mContext = this
        Objects.requireNonNull(supportActionBar)!!.elevation = 0f //remove elevation from action bar
        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        airlineViewModel = ViewModelProvider(this)[AirlineViewModel::class.java]
        airlineViewModel.getAirlinesList()!!.observe(
            this,
            { airlines -> // when data reached update ui

                airlineList.addAll(airlines)
                airlineAdapter!!.swapData(airlineList)
                airlineAdapter!!.notifyDataSetChanged()
                // hide the progress bar
                binding.progressBar.visibility = View.GONE
            })
        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        airlineList = ArrayList()
        val matchAirlineByName = MatchAirlineByName()
        airlineAdapter = AirlineAdapter(airlineList, mContext,matchAirlineByName)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.airlineRecyclerview.layoutManager = mLayoutManager
        binding.airlineRecyclerview.adapter = airlineAdapter
        ///////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////
        binding.floatingActionButtonAddAirline.setOnClickListener { //  Toast.makeText(mContext,"you clicked me ",Toast.LENGTH_SHORT).show();
            if (airLineButtonSheet == null) {
                airLineButtonSheet = AddAirLineButtonSheet(this)
                //airLineButtonSheet.setCancelable(false);
            }
            airLineButtonSheet!!.show(supportFragmentManager, "AddAirLineButtonSheet")
        }
        ////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                airlineAdapter!!.filter(s)
                return true
            }

            override fun onQueryTextChange(s: String): Boolean {
                airlineAdapter!!.filter(s)
                return true
            }
        })
    }

    override fun onResume() {
        super.onResume()
        airlineAdapter!!.setCanStart(true)
    }

    override fun onAddAirlineClicked(airline: Airline?) {
        airlineList.add(0, airline!!)
        airlineAdapter!!.notifyItemInserted(0)
    }
}