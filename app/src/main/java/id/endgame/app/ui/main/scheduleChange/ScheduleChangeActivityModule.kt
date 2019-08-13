package id.endgame.app.ui.main.scheduleChange

import dagger.Module
import dagger.Provides

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
@Module
class ScheduleChangeActivityModule {

    @Provides
    internal fun provideScheduleChangePresenter(presenter: ScheduleChangePresenter<ScheduleChangeContract.View>) =
        presenter as ScheduleChangeContract.Presenter<ScheduleChangeContract.View>
}