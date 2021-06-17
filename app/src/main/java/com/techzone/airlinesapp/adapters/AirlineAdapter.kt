package com.techzone.airlinesapp.adapters

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.techzone.airlinesapp.R
import com.techzone.airlinesapp.models.Airline
import com.techzone.airlinesapp.ui.screens.AirlineDetailsActivity
import java.util.*
import java.util.regex.Pattern

class AirlineAdapter(private var airlines: MutableList<Airline>?,
                     private var context: Context?) : RecyclerView.Adapter<AirlineAdapter.MyViewHolder>() {
    private val itemsCopy: MutableList<Airline> = ArrayList<Airline>()
    private var searchText = ""
    private var canStart = true

    init {
        itemsCopy.addAll(this.airlines!!)
    }

    fun setCanStart(can: Boolean) {
        canStart = can
    }

    fun swapData(airlines: List<Airline?>?) {
        //  this.airlines=airlines;
        itemsCopy.clear()
        itemsCopy.addAll(this.airlines!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.airline_cell, parent, false)
        val viewHolder = MyViewHolder(itemView)
        viewHolder.view_container.setOnClickListener {
            if (canStart) {
                canStart = false // do canStart false
                // Do what you don't want to run twice due to double tap
                val intent = Intent(context, AirlineDetailsActivity::class.java)
                val airline: Airline = airlines!![viewHolder.adapterPosition]
                if (airline.getId() != null) {
                    intent.putExtra("order_id", airline.getId())
                } else {
                    intent.putExtra("order", airline)
                }
                context!!.startActivity(intent)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data: Airline = airlines!![position]
        if (searchText.trim { it <= ' ' }.length == 0) {
            holder.airlineName.setText(data.getName())
        } else {
            data.getName()?.let { name->
                val currant: String = name
                val replaceString = "(?i)" + Pattern.quote(searchText)
                val htmlText = currant.replace(replaceString.toRegex(),
                        "<font color='#8BC34A'>$searchText</font>")
                holder.airlineName.text = Html.fromHtml(htmlText)
            }

        }
    }

    override fun getItemCount(): Int {
        return airlines!!.size
    }

    fun filter(text: String) {
        var text = text
        airlines!!.clear()
        if (text.isEmpty()) {
            airlines!!.addAll(itemsCopy)
            searchText = ""
        } else {
            text = text.toLowerCase()
            searchText = text
            for (item in itemsCopy) {
                if (item.getName()!!.toLowerCase().contains(text)) {
                    airlines!!.add(item)
                }
            }
        }
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var airlineName: TextView
        var view_container: CardView

        init {
            view_container = itemView.findViewById(R.id.container)
            airlineName = itemView.findViewById(R.id.airline_name)
        }
    }
}