package com.cv.cvlistapplication.apicalls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CvApiAdapter {

    private static final String BASE_API_URL = "https://gist.githubusercontent.com/";

    private static volatile CvApiService cvApiService;
    private static volatile OkHttpClient okHttpClient;

    private CvApiAdapter() {
    }

    public static synchronized CvApiService getApiService() {
        if (cvApiService == null) {
            cvApiService = refreshCvApiService();
        }
        return cvApiService;
    }

    private static CvApiService refreshCvApiService() {
        OkHttpClient okHttpClient = getHttpClient();
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return restAdapter.create(CvApiService.class);
    }

    public static OkHttpClient getHttpClient() {
        if (okHttpClient != null) return okHttpClient;
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(interceptor);

        okHttpClient = builder.build();
        return okHttpClient;
    }
}
