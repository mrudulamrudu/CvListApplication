package com.cv.cvlistapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cv.cvlistapplication.utils.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Cv implements Parcelable {

    public static final Creator<Cv> CREATOR = new Creator<Cv>() {
        @Override
        public Cv createFromParcel(Parcel in) {
            return new Cv(in);
        }

        @Override
        public Cv[] newArray(int size) {
            return new Cv[size];
        }
    };
    @SerializedName(Constants.NAME)
    private String name;
    @SerializedName(Constants.EMAIL)
    private String email;
    @SerializedName(Constants.PHONE)
    private String phone;
    @SerializedName(Constants.LINKEDIN)
    private String linkedin;
    @SerializedName(Constants.P_SUMMARY)
    private ArrayList<String> profSummary;
    @SerializedName(Constants.TECH_SKILLS)
    private ArrayList<String> technicalSkills;
    @SerializedName(Constants.COMPANIES)
    private ArrayList<Company> companiesList;

    public Cv(String name, String email, String phone, String linkedIn, ArrayList<String> profSummary,
              ArrayList<String> techSkills, ArrayList<Company> companies) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.linkedin = linkedIn;
        this.profSummary = profSummary;
        this.technicalSkills = techSkills;
        this.companiesList = companies;
    }

    private Cv(Parcel in) {
        name = in.readString();
        email = in.readString();
        phone = in.readString();
        linkedin = in.readString();

        boolean isSummaryNull = in.readByte() == (byte) 1;
        if (!isSummaryNull) {
            profSummary = new ArrayList<>();
            in.readStringList(profSummary);
        }

        boolean areSkillsNull = in.readByte() == (byte) 1;
        if (!areSkillsNull) {
            technicalSkills = new ArrayList<>();
            in.readStringList(technicalSkills);
        }
        companiesList = in.createTypedArrayList(Company.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(linkedin);
        boolean isSummaryNull = profSummary == null;
        dest.writeByte(isSummaryNull ? (byte) 1 : (byte) 0);
        if (!isSummaryNull) {
            dest.writeStringList(profSummary);
        }
        boolean areSkillsNull = technicalSkills == null;
        dest.writeByte(areSkillsNull ? (byte) 1 : (byte) 0);
        if (!areSkillsNull) {
            dest.writeStringList(technicalSkills);
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public ArrayList<String> getProfSummary() {
        return profSummary;
    }

    public ArrayList<String> getTechnicalSkills() {
        return technicalSkills;
    }

    public ArrayList<Company> getCompaniesList() {
        return companiesList;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Cv cv = (Cv) obj;
        return (cv.getName().equals(getName()) && cv.getEmail().equals(getEmail()) &&
                cv.getPhone().equals(getPhone()) && cv.getLinkedin().
                equals(getLinkedin()) && cv.getProfSummary().equals(getProfSummary()) &&
                cv.getProfSummary().equals(getProfSummary())
                && cv.getTechnicalSkills().equals(getTechnicalSkills()));
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
