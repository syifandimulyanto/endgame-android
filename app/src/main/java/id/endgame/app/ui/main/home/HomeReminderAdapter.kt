package id.endgame.app.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.endgame.app.R
import id.endgame.app.data.entity.model.Reminder
import kotlinx.android.synthetic.main.item_home_reminder.view.*

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class HomeReminderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listReminders = mutableListOf<Reminder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_reminder, parent, false))
    }

    override fun getItemCount(): Int {
        return listReminders.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeReminderAdapter.ViewHolder) {
            holder.bindData(listReminders[position], position)
        }
    }

    fun setItems(listProduct: List<Reminder>?) {
        this.listReminders.clear()
        val lastCount = itemCount
        listProduct?.let { this.listReminders.addAll(it) }
        notifyDataSetChanged()
    }

    fun clearAdapter(){
        listReminders.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nameTv = view.tv_reminder
        //private val imageIv = view.iv_menu

        fun bindData(data: Reminder, position: Int) {
            nameTv.text = data.title

//            if (data.url != null && !data.url.isEmpty()) {
//                Glide.with(itemView.context)
//                    .load("${data.url}")
//                    .error(R.drawable.ic_logo)
//                    .placeholder(R.drawable.ic_logo)
//                    .dontAnimate()
//                    .into(imageIv)
//            }else{
//                Glide.with(itemView.context)
//                    .load(R.drawable.ic_logo)
//                    .error(R.drawable.ic_logo)
//                    .placeholder(R.drawable.ic_logo)
//                    .dontAnimate()
//                    .into(imageIv)
//            }

            itemView.setOnClickListener {
                callback?.onItemClicked(data)
            }
        }
    }

    var callback: HomeReminderAdapter.ItemAdapterCallback?=null

    interface ItemAdapterCallback{
        fun onItemClicked(data: Reminder)
    }
}