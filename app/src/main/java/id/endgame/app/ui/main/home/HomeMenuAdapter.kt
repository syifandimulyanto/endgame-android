package id.endgame.app.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.endgame.app.R
import id.endgame.app.data.entity.model.Menu
import kotlinx.android.synthetic.main.item_home_menu.view.*

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class HomeMenuAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listMenu = mutableListOf<Menu>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_menu, parent, false))
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeMenuAdapter.ViewHolder) {
            holder.bindData(listMenu[position], position)
        }
    }

    fun setItems(listProduct: List<Menu>?) {
        this.listMenu.clear()
        val lastCount = itemCount
        listProduct?.let { this.listMenu.addAll(it) }
        notifyDataSetChanged()
    }

    fun clearAdapter(){
        listMenu.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nameTv = view.tv_menu
        private val imageIv = view.iv_menu

        fun bindData(data: Menu, position: Int) {
            nameTv.text = "${data.title}"

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

    var callback: HomeMenuAdapter.ItemAdapterCallback?=null

    interface ItemAdapterCallback{
        fun onItemClicked(data: Menu)
    }
}