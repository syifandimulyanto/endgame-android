package id.endgame.app.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import id.endgame.app.R
import id.endgame.app.ui.auth.login.LoginActivity
import id.endgame.app.utils.CommonUtil
import id.endgame.app.utils.NetworkUtil
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.custom_toast_layout.*
import kotlinx.android.synthetic.main.custom_toast_layout.view.*

abstract class BaseActivity : AppCompatActivity(), MvpView,
    BaseFragment.CallBack {
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun onError(message: String?) {
        if (message != null) {
            showSnackBar(message)
        } else {
            showSnackBar(getString(R.string.default_error))
        }
    }

    override fun onError(resId: Int) {
        onError(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtil.isNetworkConnected(applicationContext)
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun showMessage(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        createCustomToast(message)
    }

    override fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun openActivityOnTokenExpire() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        finish()
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView.findViewById(R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.show()
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    private fun createCustomToast(message: String) {
        val toast = Toast(this)
        toast.apply {
            val layout = layoutInflater.inflate(R.layout.custom_toast_layout, root_toast_layout)
            layout.toast_message_tv.text = message
            setGravity(Gravity.TOP, 0, 50)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }

}