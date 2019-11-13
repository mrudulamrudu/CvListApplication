package com.cv.cvlistapplication.apicalls;

import com.cv.cvlistapplication.response.CvListApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CvApiService {

    @GET("")
    Call<CvListApiResponse> getCvList();

}
