package id.endgame.app.ui.main.notification.detail

import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.Target
import id.endgame.app.R
import id.endgame.app.data.entity.model.Notification
import id.endgame.app.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_notification_detail.*
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
class NotificationDetailActivity : BaseActivity(), NotificationDetailContract.View{

    @Inject
    lateinit var presenter: NotificationDetailContract.Presenter<NotificationDetailContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_detail)
        presenter.onAttach(this)
        setupListener()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupListener() {
        val data = intent.getSerializableExtra("data") as Notification
        tv_title.text = data.title
        tv_description.text = data.description


        if (data.url != null && !data.url.isEmpty()) {
            Glide.with(this)
                .load("${data.url}")
                .error(R.drawable.dog)
                .placeholder(R.drawable.dog)
                .transform(RoundedCorners(35))
                .override(Target.SIZE_ORIGINAL)
                .into(image_iv)
        }else{
            Glide.with(this)
                .load(R.drawable.dog)
                .error(R.drawable.dog)
                .placeholder(R.drawable.dog)
                .transform(RoundedCorners(35))
                .override(Target.SIZE_ORIGINAL)
                .into(image_iv)
        }

        supportActionBar?.apply {
            title=data.title
            setIcon(R.drawable.ic_toolbar_close)
            setDisplayHomeAsUpEnabled(true)
        }
    }
}