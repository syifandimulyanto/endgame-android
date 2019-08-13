package id.endgame.app.ui.main.scheduleChange

import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import id.endgame.app.R
import id.endgame.app.data.entity.ScheduleChangeResponse
import id.endgame.app.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_schedule.*
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class ScheduleChangeActivity : BaseActivity(), ScheduleChangeContract.View{

    @Inject
    lateinit var presenter: ScheduleChangeContract.Presenter<ScheduleChangeContract.View>
    private val scheduleChangeAdapter = ScheduleChangeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_change)
        presenter.onAttach(this)
        setupListener()
        supportActionBar?.apply {
            title=getString(R.string.title_schedule_change)
            setIcon(R.drawable.ic_toolbar_close)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun setScheduleChange(schedules: List<ScheduleChangeResponse>?) {
        setupScheduleChangeAdapter()
        scheduleChangeAdapter.setItems(schedules)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupListener() {
    }

    private fun setupScheduleChangeAdapter() {
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.hasFixedSize()
        rv_list.adapter = scheduleChangeAdapter
        scheduleChangeAdapter.callback = object : ScheduleChangeAdapter.ItemAdapterCallback {
            override fun onItemClicked(data: ScheduleChangeResponse) {
                data?.let {
                    //openDetail()
                }
            }
        }
    }

}
