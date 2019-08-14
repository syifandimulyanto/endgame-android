package id.endgame.app.ui.main.attend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.endgame.app.R
import id.endgame.app.data.entity.AttendResponse
import kotlinx.android.synthetic.main.item_attend.view.*

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
class AttendAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listNotifications = mutableListOf<AttendResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_attend, parent, false))
    }

    override fun getItemCount(): Int {
        return listNotifications.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AttendAdapter.ViewHolder) {
            holder.bindData(listNotifications[position], position)
        }
    }

    fun setItems(listProduct: List<AttendResponse>?) {
        this.listNotifications.clear()
        val lastCount = itemCount
        listProduct?.let { this.listNotifications.addAll(it) }
        notifyDataSetChanged()
    }

    fun clearAdapter(){
        listNotifications.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTv = view.tv_reminder
        fun bindData(data: AttendResponse, position: Int) {
            nameTv.text = data.studentSchedule?.schedule?.course?.name

            itemView.setOnClickListener {
                callback?.onItemClicked(data)
            }
        }
    }

    var callback: AttendAdapter.ItemAdapterCallback?=null

    interface ItemAdapterCallback{
        fun onItemClicked(data: AttendResponse)
    }
}