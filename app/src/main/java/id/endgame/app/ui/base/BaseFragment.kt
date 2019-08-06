package id.endgame.app.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import id.endgame.app.utils.CommonUtil

abstract class BaseFragment : Fragment(), MvpView {
    private var parentActivity: BaseActivity? = null
    var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun onError(resId: Int) {
        getBaseActivity()?.onError(resId)
    }

    override fun onError(message: String?) {
    }

    override fun isNetworkConnected(): Boolean {
        if (getBaseActivity() == null) {
            return false
        }
        return getBaseActivity()?.isNetworkConnected()!!
    }

    override fun hideKeyboard() {
    }

    override fun showMessage(message: String) {
        getBaseActivity()?.showMessage(message)
    }

    override fun showMessage(resId: Int) {
        getBaseActivity()?.showMessage(resId)
    }

    override fun openActivityOnTokenExpire() {
        getBaseActivity()?.openActivityOnTokenExpire()
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(requireContext())
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    fun getBaseActivity() = parentActivity


    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()

}