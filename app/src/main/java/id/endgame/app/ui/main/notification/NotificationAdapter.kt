package id.endgame.app.ui.main.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.endgame.app.R
import id.endgame.app.data.entity.model.Notification
import kotlinx.android.synthetic.main.item_notification.view.*

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class NotificationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listNotifications = mutableListOf<Notification>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_notification, parent, false))
    }

    override fun getItemCount(): Int {
        return listNotifications.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NotificationAdapter.ViewHolder) {
            holder.bindData(listNotifications[position], position)
        }
    }

    fun setItems(listProduct: List<Notification>?) {
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
        fun bindData(data: Notification, position: Int) {
            nameTv.text = data.title

            itemView.setOnClickListener {
                callback?.onItemClicked(data)
            }
        }
    }

    var callback: NotificationAdapter.ItemAdapterCallback?=null

    interface ItemAdapterCallback{
        fun onItemClicked(data: Notification)
    }
}