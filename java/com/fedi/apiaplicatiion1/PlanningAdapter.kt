package com.fedi.apiaplicatiion1

/*import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanningAdapter(private val planningList: List<Planning>) : RecyclerView.Adapter<PlanningAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planning, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planning = planningList[position]
        holder.bind(planning)
    }

    override fun getItemCount(): Int = planningList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        private val taskTextView: TextView = itemView.findViewById(R.id.taskTextView)

        fun bind(planning: Planning) {
            titleTextView.text = planning.title
            dateTextView.text = planning.date
            taskTextView.text = planning.Tache
        }
    }
}*/
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanningAdapter(private var planningList: List<Planning>) : RecyclerView.Adapter<PlanningAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        private val taskTextView: TextView = itemView.findViewById(R.id.taskTextView)

        fun bind(planning: Planning) {
            titleTextView.text = planning.title
            dateTextView.text = planning.date
            taskTextView.text = planning.Tache
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planning, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(planningList[position])
    }

    override fun getItemCount(): Int {
        return planningList.size
    }

    // Method to update the data in the adapter
    fun setData(newPlanningList: List<Planning>) {
        planningList = newPlanningList
        notifyDataSetChanged()
    }
}