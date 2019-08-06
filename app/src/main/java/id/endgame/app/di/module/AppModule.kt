package id.endgame.app.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import id.endgame.app.BuildConfig
import id.endgame.app.data.AppDataManager
import id.endgame.app.data.DataManager
import id.endgame.app.data.local.prefs.AppPreferenceHelper
import id.endgame.app.data.local.prefs.PreferenceHelper
import id.endgame.app.data.remote.ApiServiceHelper
import id.endgame.app.di.PreferenceInfo
import id.endgame.app.utils.AppConstants
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    fun providePreferenceHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper {
        return appPreferenceHelper
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiServiceHelper {
        return retrofit.create(ApiServiceHelper::class.java)
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor, preferenceHelper: PreferenceHelper): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                val accessToken = preferenceHelper.getAccessToken()
                Timber.d("access token : $accessToken")
                if (accessToken.isNullOrEmpty()) {
                    requestBuilder.addHeader("ClientId", BuildConfig.CLIENT_ID)
                    requestBuilder.addHeader("ClientSecret", BuildConfig.CLIENT_SECRET)
                } else {
                    requestBuilder.addHeader("Authorization", " Bearer $accessToken")
                }
                chain.proceed(requestBuilder.build())
            }
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gson)
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider =
        SchedulerProvider()


}