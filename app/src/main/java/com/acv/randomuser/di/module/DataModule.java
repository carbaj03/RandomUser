package com.acv.randomuser.di.module;

import com.acv.randomuser.BuildConfig;
import com.acv.randomuser.data.JsonUtil;
import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.data.local.LocalStorage;
import com.acv.randomuser.data.local.mapper.RandomDeleteUserLocalMapper;
import com.acv.randomuser.data.local.mapper.RandomUserLocalMapper;
import com.acv.randomuser.data.network.ApiClient;
import com.acv.randomuser.data.network.GsonUtil;
import com.acv.randomuser.data.network.RandomUserResult;
import com.acv.randomuser.data.network.RandomUserRetrofit;
import com.acv.randomuser.domain.RandomUserNetwork;
import com.acv.randomuser.domain.mapper.Mapper;
import com.acv.randomuser.domain.model.RandomUser;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule extends MapperData {

    @Provides
    @Singleton
    public RandomUserRepository provideRandomUserRepository(
            RandomUserNetwork network,
            LocalStorage localStorage,
            RandomDeleteUserLocalMapper mapperDelete) {
        return new RandomUserRepository(network, localStorage, mapperDelete);
    }

    @Provides
    @Singleton
    public LocalStorage provideLocalStorage(JsonUtil jsonUtil) {
        return new LocalStorage(jsonUtil);
    }

    @Provides
    @Singleton
    public RandomUserNetwork provideRandomUserGateway(
            ApiClient apiClient,
            Mapper<RandomUserResult, RandomUser> mapper
    ) {
        return new RandomUserRetrofit(apiClient, mapper);
    }

    @Provides
    @Singleton
    public JsonUtil provideJsonUtil() {
        return new GsonUtil();
    }

    @Provides
    @Singleton
    @Named("EndPoint")
    public String provideEndPoint() {
        return BuildConfig.API_URL;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(
            @Named("EndPoint") String endPoint,
            OkHttpClient okHttpClient
    ) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endPoint)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        logging.setLevel(level);
        return logging;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(final HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    public ApiClient provideApiClient(Retrofit retrofit) {
        return retrofit.create(ApiClient.class);
    }
}
