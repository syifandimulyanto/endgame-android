package id.endgame.app.ui.main.user.update

import android.os.Bundle
import android.view.MenuItem
import id.endgame.app.R
import id.endgame.app.ui.base.BaseActivity
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-20
 */
class UserUpdateActivity : BaseActivity(), UserUpdateContract.View{

    @Inject
    lateinit var presenter: UserUpdateContract.Presenter<UserUpdateContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update)
        presenter.onAttach(this)
        setupListener()
        supportActionBar?.apply {
            title=getString(R.string.title_user_update)
            setIcon(R.drawable.ic_toolbar_close)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupListener() {
    }

}