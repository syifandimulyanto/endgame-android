package id.endgame.app.ui.splash

import android.content.Intent
import android.os.Bundle
import id.endgame.app.R
import id.endgame.app.ui.base.BaseActivity
import id.endgame.app.ui.auth.login.LoginActivity
import id.endgame.app.ui.main.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter<SplashContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun openLoginActivity() {
        finish()
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun openMainActivity() {
        finish()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
