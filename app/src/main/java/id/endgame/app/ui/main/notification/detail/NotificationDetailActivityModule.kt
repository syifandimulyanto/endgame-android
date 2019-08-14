package id.endgame.app.ui.main.notification.detail

import dagger.Module
import dagger.Provides

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
@Module
class NotificationDetailActivityModule {

    @Provides
    internal fun provideNotificationDetailPresenter(presenter: NotificationDetailPresenter<NotificationDetailContract.View>) =
        presenter as NotificationDetailContract.Presenter<NotificationDetailContract.View>
}