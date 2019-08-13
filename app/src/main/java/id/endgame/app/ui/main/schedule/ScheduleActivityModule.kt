package id.endgame.app.ui.main.schedule

import dagger.Module
import dagger.Provides
/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
@Module
class ScheduleActivityModule {

    @Provides
    internal fun provideSchedulePresenter(presenter: SchedulePresenter<ScheduleContract.View>) =
        presenter as ScheduleContract.Presenter<ScheduleContract.View>
}