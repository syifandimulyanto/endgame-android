package id.endgame.app.ui.main.user


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

import id.endgame.app.R
import id.endgame.app.data.entity.model.User
import id.endgame.app.ui.base.BaseFragment
import id.endgame.app.ui.auth.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

class UserFragment : BaseFragment(), UserContract.View {

    @Inject
    lateinit var presenter: UserContract.Presenter<UserContract.View>

    companion object {
        @JvmStatic
        fun newInstance() =
            UserFragment().apply {
                arguments = Bundle()
            }
    }

    override fun setUp() {
        presenter.createMenu()
        setupListener()
    }

    override fun onResume() {
        super.onResume()
        presenter.loadUser()
    }

    override fun displayMenu(menuList: List<ProfileMenuItem>) {
        val adapter = ProfileMenuAdapter(menuList)
        adapter.menuCallback = object: ProfileMenuAdapter.MenuCallback{
            override fun logout() {
                presenter.setUserAsLoggedOut()
            }
        }
        menu_rv.adapter = adapter
        menu_rv.layoutManager = LinearLayoutManager(getBaseActivity())
        ViewCompat.setNestedScrollingEnabled(menu_rv, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun displayProfile(user: User?) {
        profile_name_tv.text=user?.firstName
        //if (!user?.pic.isNullOrEmpty()) Glide.with(this).load(user?.pic).into(pic_civ)
    }

    override fun openLoginActivity() {
        getBaseActivity()?.finish()
        val intent = Intent(getBaseActivity(), LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    private fun setupListener(){
        edit_profile_tv.setOnClickListener {
            openUserUpdateActivity()
        }
    }

    private fun openUserUpdateActivity(){
        //val intent = Intent(getBaseActivity(), UserUpdateActivity::class.java)
        //startActivity(intent)
    }
}
