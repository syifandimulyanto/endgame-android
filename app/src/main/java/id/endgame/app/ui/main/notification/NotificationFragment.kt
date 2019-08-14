package id.endgame.app.ui.main.notification

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.endgame.app.ui.base.BaseFragment
import javax.inject.Inject
import id.endgame.app.R
import id.endgame.app.ui.main.notification.detail.NotificationDetailActivity
import id.endgame.app.data.entity.model.Notification
import id.endgame.app.data.entity.model.Reminder
import kotlinx.android.synthetic.main.fragment_notification.*

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class NotificationFragment : BaseFragment(), NotificationContract.View {

    @Inject
    lateinit var presenter: NotificationContract.Presenter<NotificationContract.View>
    private val notificationAdapter = NotificationAdapter()

    companion object {
        @JvmStatic
        fun newInstance() =
            NotificationFragment().apply {
                arguments = Bundle()
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun setUp() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun setNotifications(notifications: List<Notification>?) {
        setupNotificationAdapter()
        notificationAdapter.setItems(notifications)
    }

    private fun setupNotificationAdapter() {
        rv_list.layoutManager = LinearLayoutManager(context)
        rv_list.hasFixedSize()
        rv_list.adapter = notificationAdapter
        notificationAdapter.callback = object : NotificationAdapter.ItemAdapterCallback {
            override fun onItemClicked(data: Notification) {
                data?.let {
                    openDetail(data)
                }
            }
        }
    }

    private fun openDetail(data: Notification) {
        val intent = Intent(context, NotificationDetailActivity::class.java)
        intent.putExtra("data", data)
        startActivity(intent)
    }
}
