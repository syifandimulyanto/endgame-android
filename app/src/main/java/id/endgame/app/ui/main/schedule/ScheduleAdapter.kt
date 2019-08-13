package id.endgame.app.ui.main.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.endgame.app.R
import id.endgame.app.data.entity.ScheduleResponse
import kotlinx.android.synthetic.main.item_schedule.view.*

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class ScheduleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listSchedules = mutableListOf<ScheduleResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_schedule, parent, false))
    }

    override fun getItemCount(): Int {
        return listSchedules.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ScheduleAdapter.ViewHolder) {
            holder.bindData(listSchedules[position], position)
        }
    }

    fun setItems(listProduct: List<ScheduleResponse>?) {
        this.listSchedules.clear()
        val lastCount = itemCount
        listProduct?.let { this.listSchedules.addAll(it) }
        notifyDataSetChanged()
    }

    fun clearAdapter(){
        listSchedules.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTv = view.tv_reminder
        fun bindData(data: ScheduleResponse, position: Int) {
            nameTv.text = data.schedule?.course?.name

            itemView.setOnClickListener {
                callback?.onItemClicked(data)
            }
        }
    }

    var callback: ScheduleAdapter.ItemAdapterCallback?=null

    interface ItemAdapterCallback{
        fun onItemClicked(data: ScheduleResponse)
    }
}