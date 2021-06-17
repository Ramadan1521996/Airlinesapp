package com.techzone.airlinesapp.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.techzone.airlinesapp.R
import com.techzone.airlinesapp.databinding.ActivityAirlineDetailsBinding
import com.techzone.airlinesapp.models.Airline
import com.techzone.airlinesapp.viewModels.AirlineViewModel

class AirlineDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAirlineDetailsBinding
    private lateinit var mContext: Context
    private var currantAirline: Airline? = null
    private lateinit var airlineViewModel: AirlineViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_airline_details)
        binding = ActivityAirlineDetailsBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        mContext = this
        //////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////
        airlineViewModel = ViewModelProvider(this)[AirlineViewModel::class.java]
        /////////////////////////////////////////////////////////////////////////////////
        // setContentView(R.layout.activity_airline_details);
        /////////////////////////////////////////////////////////////////////////////////
        // setContentView(R.layout.activity_airline_details);
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        val intent = intent
        if (intent.getSerializableExtra("order") != null) {
            currantAirline = intent.getSerializableExtra("order") as Airline?
            updateUi(currantAirline!!)
        } else if (intent.getStringExtra("order_id") != null) {
            val id = intent.getStringExtra("order_id")
            airlineViewModel.getAirline(id!!)!!.observe(this, { airline ->
                currantAirline = airline
                if(currantAirline!=null){
                    updateUi(currantAirline!!)
                }
            })
        } else {
            Toast.makeText(mContext, "Order and order id are missing !", Toast.LENGTH_SHORT).show()
        }
    }

    fun onWebsiteClicked(view: View) {
        if (currantAirline != null) {
            var url = currantAirline!!.getWebsite()
            if (!url!!.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://$url"
            }
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }
    fun updateUi(airline: Airline) {
        ////////////////////////////////////////////////////////////////////
        binding.progressBar.visibility = View.GONE
        binding.airlineDetailsView.visibility = View.VISIBLE
        ///////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////
        Glide.with(mContext).load(airline.getLogo()).placeholder(R.drawable.load_spinner)
                .error(R.drawable.image_not_found).into(binding.logoImage)
        binding.airlineSlogan.text = airline.getSlogan()
        binding.airlineName.text = airline.getName()
        binding.airlineCountry.text = airline.getCountry()
        binding.airlineEstablished.text = airline.getEstablished()
        binding.airlineHeadQuaters.text = airline.getHead_quaters()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}