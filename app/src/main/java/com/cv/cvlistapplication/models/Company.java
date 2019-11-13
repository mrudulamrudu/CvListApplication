package com.cv.cvlistapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.cv.cvlistapplication.utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Company implements Parcelable {

    @SerializedName(Constants.COMP_NAME)
    private String companyName;

    @SerializedName(Constants.COMP_LOGO)
    private String companyLogo;

    @SerializedName(Constants.ROLE)
    private String role;

    @SerializedName(Constants.TENURE)
    private String tenure;

    @SerializedName(Constants.LOCATION)
    private String location;

    @SerializedName(Constants.RESPONSIBILITIES)
    private ArrayList<String> responsibilities;

    @SerializedName(Constants.ACHIEVEMENTS)
    private ArrayList<String> achievements;

    private Company(Parcel in) {
        companyName = in.readString();
        companyLogo = in.readString();
        role = in.readString();
        tenure = in.readString();
        boolean isRespNull = in.readByte() == (byte) 1;
        if (!isRespNull) {
            responsibilities = new ArrayList<>();
            in.readStringList(responsibilities);
        }
        boolean isAchieNull = in.readByte() == (byte) 1;
        if (!isAchieNull) {
            achievements = new ArrayList<>();
            in.readStringList(achievements);
        }
        location = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(companyName);
        dest.writeString(companyLogo);
        dest.writeString(role);
        boolean isRespNull = responsibilities == null;
        dest.writeByte(isRespNull ? (byte) 1 : (byte) 0);
        if (!isRespNull) {
            dest.writeStringList(responsibilities);
        }
        boolean isAchieNull = achievements == null;
        dest.writeByte(isAchieNull ? (byte) 1 : (byte) 0);
        if (!isAchieNull) {
            dest.writeStringList(achievements);
        }
        dest.writeString(location);
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public String getRole() {
        return role;
    }

    public String getTenure() {
        return tenure;
    }

    public ArrayList<String> getResponsibilities() {
        return responsibilities;
    }

    public ArrayList<String> getAchievements() {
        return achievements;
    }

    public String getLocation() {
        return location;
    }
}


