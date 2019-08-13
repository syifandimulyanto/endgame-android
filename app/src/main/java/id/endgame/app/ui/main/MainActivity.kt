package id.endgame.app.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import id.endgame.app.R
import id.endgame.app.ui.base.BaseActivity
import id.endgame.app.ui.main.home.HomeFragment
import id.endgame.app.ui.main.notification.NotificationFragment
import id.endgame.app.ui.main.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector,
    BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var presenter: MainContract.Presenter<MainContract.View>

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment.newInstance())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = HomeFragment.newInstance()
            }
            R.id.navigation_reminder -> {
                //fragment = MainHistoryFragment.newInstance()
            }
            R.id.navigation_notification -> {
                fragment = NotificationFragment.newInstance()
            }
            R.id.navigation_user -> {
                fragment = UserFragment.newInstance()
            }
        }
        return replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit()
            return true
        }
        return false
    }
}
