package id.endgame.app.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.endgame.app.ui.base.BaseFragment
import javax.inject.Inject
import id.endgame.app.R
import id.endgame.app.data.entity.model.Slider
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by syifandimulyanto.id on 2019-08-08
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter<HomeContract.View>

    private lateinit var sliderAdapter: SliderAdapter

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
}
