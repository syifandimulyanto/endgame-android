package id.endgame.app.ui.main.notification

import dagger.Module
import dagger.Provides
import id.endgame.app.ui.main.home.HomeContract
import id.endgame.app.ui.main.home.HomePresenter

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
@Module
class NotificationFragmentModule {

    @Provides
    internal fun provideNotificationPresenter(presenter: NotificationPresenter<NotificationContract.View>) =
        presenter as NotificationContract.Presenter<NotificationContract.View>
}