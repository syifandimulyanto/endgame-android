package id.endgame.app.ui.main.attend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.endgame.app.ui.base.BaseFragment
import javax.inject.Inject
import id.endgame.app.R
import id.endgame.app.data.entity.AttendResponse
import kotlinx.android.synthetic.main.fragment_attend.*

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
class AttendFragment : BaseFragment(), AttendContract.View {

    @Inject
    lateinit var presenter: AttendContract.Presenter<AttendContract.View>
    private val attendAdapter = AttendAdapter()

    companion object {
        @JvmStatic
        fun newInstance() =
            AttendFragment().apply {
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
        return inflater.inflate(R.layout.fragment_attend, container, false)
    }

    override fun setAttends(attends: List<AttendResponse>?) {
        setupAttendAdapter()
        attendAdapter.setItems(attends)
    }

    private fun setupAttendAdapter() {
        rv_list.layoutManager = LinearLayoutManager(context)
        rv_list.hasFixedSize()
        rv_list.adapter = attendAdapter
        attendAdapter.callback = object : AttendAdapter.ItemAdapterCallback {
            override fun onItemClicked(data: AttendResponse) {
                data?.let {
                    openDetail()
                }
            }
        }
    }

    private fun openDetail() {

    }
}