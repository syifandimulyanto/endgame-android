package id.endgame.app.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.endgame.app.ui.base.BaseFragment
import javax.inject.Inject
import id.endgame.app.R
import id.endgame.app.data.entity.model.Menu
import id.endgame.app.data.entity.model.Reminder
import id.endgame.app.data.entity.model.Slider
import kotlinx.android.synthetic.main.fragment_home.*
import id.endgame.app.utils.GridItemOffsetDecoration
import id.endgame.app.ui.main.schedule.ScheduleActivity
import id.endgame.app.ui.main.scheduleChange.ScheduleChangeActivity

/**
 * Created by syifandimulyanto.id on 2019-08-08
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter<HomeContract.View>

    private lateinit var sliderAdapter: SliderAdapter
    private val homeMenuAdapter = HomeMenuAdapter()
    private val homeReminderAdapter = HomeReminderAdapter()

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
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
        setupMenuAdapter()
        val menus = listOf(
            Menu(slug = "schedule", title = "Jadwal", url = ""),
            Menu(slug = "schedule-change", title = "Perubahan Jadwal", url = "")
        )
        homeMenuAdapter.setItems(menus)

        // reminder
        setupReminderAdapter()
        val reminders = listOf(Reminder(title = "Notif"), Reminder(title = "Data masuk"))
        homeReminderAdapter.setItems(reminders)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun setSliders(sliders: List<Slider>) {
        setupViewPager()
        sliderAdapter.setMenuList(sliders)
    }

    private fun setupViewPager() {
        sliderAdapter = SliderAdapter(fragmentManager)
        sliderAdapter.notifyDataSetChanged()
        slider_vp?.apply {
            adapter = sliderAdapter
            clipToPadding = false
            setPadding(60, 0, 60, 0)
            pageMargin = 20
        }
    }

    private fun setupMenuAdapter() {
        val spaceItem = resources.getDimensionPixelSize(R.dimen.standard_small_margin)
        rv_list.addItemDecoration(GridItemOffsetDecoration(spaceItem))
        val layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        rv_list.layoutManager = layoutManager
        rv_list.adapter = homeMenuAdapter
        homeMenuAdapter.callback = object : HomeMenuAdapter.ItemAdapterCallback {
            override fun onItemClicked(data: Menu) {
                data?.let {
                    openMenu(data)
                }
            }
        }
        ViewCompat.setNestedScrollingEnabled(rv_list, false)
    }

    private fun setupReminderAdapter() {
        rv_reminder_list.layoutManager = LinearLayoutManager(context)
        rv_reminder_list.hasFixedSize()
        rv_reminder_list.adapter = homeReminderAdapter
        homeReminderAdapter.callback = object : HomeReminderAdapter.ItemAdapterCallback {
            override fun onItemClicked(data: Reminder) {
                data?.let {
                    //openMenu()
                }
            }
        }
        ViewCompat.setNestedScrollingEnabled(rv_reminder_list, false)
    }

    private fun openMenu(data: Menu) {

        when (data.slug) {
            "schedule" -> {
                var intent = Intent(context, ScheduleActivity::class.java)
                startActivity(intent)
            }
            "schedule-change" -> {
                var intent = Intent(context, ScheduleChangeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
