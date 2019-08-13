package id.endgame.app.ui.main.scheduleChange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.endgame.app.R
import id.endgame.app.data.entity.ScheduleChangeResponse
import kotlinx.android.synthetic.main.item_schedule_change.view.*

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class ScheduleChangeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listScheduleChange = mutableListOf<ScheduleChangeResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_schedule_change, parent, false))
    }

    override fun getItemCount(): Int {
        return listScheduleChange.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ScheduleChangeAdapter.ViewHolder) {
            holder.bindData(listScheduleChange[position], position)
        }
    }

    fun setItems(listProduct: List<ScheduleChangeResponse>?) {
        this.listScheduleChange.clear()
        val lastCount = itemCount
        listProduct?.let { this.listScheduleChange.addAll(it) }
        notifyDataSetChanged()
    }

    fun clearAdapter(){
        listScheduleChange.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTv = view.tv_reminder
        fun bindData(data: ScheduleChangeResponse, position: Int) {
            nameTv.text = data.schedule?.course?.name

            itemView.setOnClickListener {
                callback?.onItemClicked(data)
            }
        }
    }

    var callback: ScheduleChangeAdapter.ItemAdapterCallback?=null

    interface ItemAdapterCallback{
        fun onItemClicked(data: ScheduleChangeResponse)
    }
}