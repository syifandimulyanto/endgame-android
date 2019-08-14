package id.endgame.app.ui.main.attend

import dagger.Module
import dagger.Provides

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
@Module
class AttendFragmentModule {

    @Provides
    internal fun provideAttendPresenter(presenter: AttendPresenter<AttendContract.View>) =
        presenter as AttendContract.Presenter<AttendContract.View>
}