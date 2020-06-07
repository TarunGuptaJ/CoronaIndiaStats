package com.androiddevs.confused.ui

import android.annotation.SuppressLint
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.confused.R
import kotlinx.android.synthetic.main.list_of_districts.view.*
import kotlinx.android.synthetic.main.list_of_states.view.*

class StateAdapter(
    var states : MutableList<State>
): RecyclerView.Adapter<StateAdapter.DistrictsViewHolder>(), Filterable {

    var statesCopy : MutableList<State> = ArrayList(states)

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

//        fun getColoredSpanned (text : String, color : String) : String {
//            var input = "<font color=" + color + ">" + text + "</font>";
//            return input;
//        }

        var singleParsed = ""
        holder.itemView.apply {
            districtStateName.text = states[position].state
            for (j in 0 until states[position].districtData.size) {
                states[position].districtData[j].apply {
//                    var act = getColoredSpanned(active.toString(), "@color/red")
//                    var conf = confirmed.toString()
//                    var deaths = deceased.toString()
//                    var rec = getColoredSpanned(recovered.toString(), "@color/green")
//                    singleParsed += district.toString() + "\n" +
//                        "Confirmed: " + conf + "\t\t" +
//                        "Active: " + act + "\t\n" +
//                        "Deceased: " + deaths + "\t\t" +
//                        "Recovered: " + rec + "\n\n"
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

    private var stateFilter = object : Filter () {
        override fun performFiltering(constraint: CharSequence?): FilterResults? {

            val charSearch = constraint.toString().toLowerCase().trim()
            var filteredList: MutableList<State> = ArrayList<State>()

            if (charSearch.isEmpty()) {
                filteredList.addAll(statesCopy)
            } else {
                for (item in statesCopy) {
                    if (item.state.toLowerCase().trim().contains(charSearch)) {
                        filteredList.add(item)
                    }
                }
            }

            val results: FilterResults = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            states.clear()
            states.addAll(results?.values as List<State>)
            notifyDataSetChanged()
        }
    };

        override fun getFilter(): Filter {
            return stateFilter
        }
}