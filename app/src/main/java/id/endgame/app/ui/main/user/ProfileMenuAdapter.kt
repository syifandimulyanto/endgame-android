package id.endgame.app.ui.main.user

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.endgame.app.utils.AppConstants
import id.endgame.app.R
import id.endgame.app.data.local.prefs.PreferenceHelper
import id.endgame.app.ui.auth.login.LoginActivity
import id.endgame.app.ui.main.user.password.UserPasswordActivity

/**
 * Created by syifandimulyanto.id on 2019-06-25
 */
class ProfileMenuAdapter(val menuList: List<ProfileMenuItem>): RecyclerView.Adapter<RecyclerView.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile_menu, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = menuList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bindData(menuList[position])
        }
    }

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view){

        lateinit var preferenceHelper: PreferenceHelper

        fun bindData(profileMenuItem: ProfileMenuItem) {
            view.findViewById<TextView>(R.id.label_menu_tv).text=itemView.context.getString(profileMenuItem.label)

            itemView.setOnClickListener {
                when(profileMenuItem.action){
                    AppConstants.MenuChangePassword -> {
                        val intent = Intent(view.context, UserPasswordActivity::class.java)
                        view.context.startActivity(intent)
                    }
                    AppConstants.MenuLogout -> {
                        menuCallback?.logout()
                        val intent = Intent(view.context, LoginActivity::class.java)
                        view.context.startActivity(intent)
                    }
                }
            }
        }
    }

    var menuCallback: MenuCallback ?= null

    interface MenuCallback{
        fun logout()
    }
}