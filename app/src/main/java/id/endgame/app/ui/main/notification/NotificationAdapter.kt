package id.endgame.app.ui.main.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        private val titleTv = view.title_tv
        private val descriptionTv = view.description_tv
        private val imageIv = view.image_iv

        fun bindData(data: Notification, position: Int) {
            titleTv.text = data.title
            descriptionTv.text = data.description

            if (data.url != null && !data.url.isEmpty()) {
                Glide.with(itemView.context)
                    .load("${data.url}")
                    .error(R.drawable.dog)
                    .placeholder(R.drawable.dog)
                    .dontAnimate()
                    .into(imageIv)
            }else{
                Glide.with(itemView.context)
                    .load(R.drawable.dog)
                    .error(R.drawable.dog)
                    .placeholder(R.drawable.dog)
                    .dontAnimate()
                    .into(imageIv)
            }

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