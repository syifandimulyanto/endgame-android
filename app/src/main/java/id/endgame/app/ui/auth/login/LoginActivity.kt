package id.endgame.app.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import id.endgame.app.R
import id.endgame.app.ui.base.BaseActivity
import id.endgame.app.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter<LoginContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.onAttach(this)
        setupListener()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    private fun setupListener() {
        login_btn.setOnClickListener{
            presenter.procesLogin(phone_tie.text.toString(), password_tie.text.toString())
        }

        phone_tie.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (!s.isNullOrEmpty() && s.length >= 8) {
                    phone_til.error=null
                }
            }
        })

        password_tie.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (!s.isNullOrEmpty() && s.length >= 3) {
                    password_til.error=null
                }
            }
        })
    }

    override fun showErrorLoginPhone(error_login_phone: Int) {
        phone_til.error=getString(error_login_phone)
    }

    override fun showErrorLoginPassword(error_login_password: Int) {
        password_til.error=getString(error_login_password)
    }

    override fun openMainActivity() {
        finish()
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}
