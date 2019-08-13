package id.endgame.app.ui.main.schedule

import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import id.endgame.app.R
import id.endgame.app.data.entity.ScheduleResponse
import id.endgame.app.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_schedule.*
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class ScheduleActivity : BaseActivity(), ScheduleContract.View{

    @Inject
    lateinit var presenter: ScheduleContract.Presenter<ScheduleContract.View>
    private val scheduleAdapter = ScheduleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        presenter.onAttach(this)
        setupListener()
        supportActionBar?.apply {
            title=getString(R.string.title_schedule)
            setIcon(R.drawable.ic_toolbar_close)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun setSchedules(schedules: List<ScheduleResponse>?) {
        setupNotificationAdapter()
        scheduleAdapter.setItems(schedules)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupListener() {
    }

    private fun setupNotificationAdapter() {
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.hasFixedSize()
        rv_list.adapter = scheduleAdapter
        scheduleAdapter.callback = object : ScheduleAdapter.ItemAdapterCallback {
            override fun onItemClicked(data: ScheduleResponse) {
                data?.let {
                    //openDetail()
                }
            }
        }
    }

}
