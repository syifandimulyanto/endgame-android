package id.endgame.app.ui.main.user.password

import android.os.Bundle
import android.view.MenuItem
import id.endgame.app.R
import id.endgame.app.ui.base.BaseActivity
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-20
 */
class UserPasswordActivity : BaseActivity(), UserPasswordContract.View{

    @Inject
    lateinit var presenter: UserPasswordContract.Presenter<UserPasswordContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update_password)
        presenter.onAttach(this)
        setupListener()
        supportActionBar?.apply {
            title=getString(R.string.title_user_update_password)
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