package com.androiddevs.confused.ui
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.confused.R
import kotlinx.android.synthetic.main.list_of_states.view.*

class Adapter(
    var states: MutableList<RegionData>
): RecyclerView.Adapter<Adapter.StatesViewHolder>(), Filterable{

    var statesCopy = states

    inner class StatesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_of_states,parent,false)
        return StatesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return states?.size!!
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StatesViewHolder, position: Int) {
        holder.itemView.apply{
            statename.text = states?.get(position)?.state
            statedets.text = (states?.get(position)?.active).toString() + " " +
                             (states?.get(position)?.confirmed).toString() + " " +
                             (states?.get(position)?.deceased).toString() + " "+
                             (states?.get(position)?.recovered).toString()
        }
    }

    override fun getFilter(): Filter {
        return stateFilter
    }

    var stateFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val charSearch = constraint.toString().toLowerCase().trim()
            var filteredList = ArrayList<RegionData>()
            if (charSearch.isEmpty()) {
                filteredList.addAll(statesCopy)
            } else {
                for (item in statesCopy) {
                    if (item.state.toLowerCase().contains(charSearch)) {
                        filteredList.add(item)
                    }
                }
            }

            val results : FilterResults = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            states.clear()
            states.addAll(results?.values as ArrayList<RegionData>)
            notifyDataSetChanged()
        }

    };

}