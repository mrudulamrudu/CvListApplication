package com.cv.cvlistapplication.apicalls;

import com.cv.cvlistapplication.response.CvListApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CvApiService {

    @GET("mrudulamrudu/8f2fc3d93dad42892ef38d54eec4d163/raw/422186f6515ed109af9bc1b7c9a117f8c95604cf/cv_list.json")
    Call<CvListApiResponse> getCvList();

}
