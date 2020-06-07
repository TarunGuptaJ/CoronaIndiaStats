package com.androiddevs.confused.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.confused.R
import kotlinx.android.synthetic.main.list_of_districts.view.*
import kotlinx.android.synthetic.main.list_of_states.view.*

class StateAdapter(
    var states : List<State>,
    var districts : MutableList<List<DistrictData>>
): RecyclerView.Adapter<StateAdapter.DistrictsViewHolder>() {

    inner class DistrictsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StateAdapter.DistrictsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_of_districts,parent,false)
        return DistrictsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return states.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DistrictsViewHolder, position: Int) {
        if (position == 0) {
            holder.itemView.apply {
                districtStateName.text = "State with district names"
                districtDetails.visibility = View.GONE
            }
            return
        }
        var singleParsed = ""
        holder.itemView.apply {
            districtStateName.text = states[position].state
            for (j in 0 until districts[position].size) {
                districts[position][j].apply {
                    singleParsed += district.toString() + "\n" +
                            "Active: " + active.toString() + "\t\t" +
                            "Confirmed: " + confirmed.toString() + "\t\n" +
                            "Deceased: " + deceased.toString() + "\t\t" +
                            "Recovered: " + recovered.toString() + "\n\n"
                }
            }
            districtDetails.text = singleParsed
        }
    }

//    override fun getFilter(): Filter {
//        TODO("Not yet implemented")
//    }

}