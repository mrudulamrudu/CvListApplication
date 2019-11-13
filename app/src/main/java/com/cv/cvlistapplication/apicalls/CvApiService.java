package com.cv.cvlistapplication.apicalls;

import com.cv.cvlistapplication.response.CvListApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CvApiService {

    @GET("mrudulamrudu/8f2fc3d93dad42892ef38d54eec4d163/raw/962487e90058211729d0ffbc73ffbe4b81988f28/cv_list.json")
    Call<CvListApiResponse> getCvList();

}
