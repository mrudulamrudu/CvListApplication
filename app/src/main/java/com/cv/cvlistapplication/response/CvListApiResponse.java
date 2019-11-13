package com.cv.cvlistapplication.response;

import com.cv.cvlistapplication.models.Cv;
import com.cv.cvlistapplication.utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CvListApiResponse {

    @SerializedName(Constants.CV_LIST)
    public ArrayList<Cv> cvArrayList;
}
