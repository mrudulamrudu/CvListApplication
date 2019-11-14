package com.cv.cvlistapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cv.cvlistapplication.R;
import com.cv.cvlistapplication.models.Company;
import com.cv.cvlistapplication.models.Cv;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class CvListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Cv> cvArrayList;
    private LayoutInflater inflater;

    public CvListRecyclerViewAdapter(WeakReference<Context> context, ArrayList<Cv> cvArrayList) {
        this.cvArrayList = cvArrayList;
        inflater = (LayoutInflater) context.get().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_cvlist_child_row, null);
        return new CvListHeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Cv cv = cvArrayList.get(position);
        // Bind Header Data
        CvListHeaderViewHolder cvListHeaderViewHolder = (CvListHeaderViewHolder) holder;
        TextView txtName = cvListHeaderViewHolder.getTxtName();
        TextView txtPhone = cvListHeaderViewHolder.getTxtPhone();
        TextView txtEmail = cvListHeaderViewHolder.getTxtEmail();
        TextView txtLinkedIn = cvListHeaderViewHolder.getTxtLinkedIn();

        txtName.setText(cv.getName());
        txtPhone.setText(cv.getPhone());
        txtEmail.setText(cv.getEmail());
        txtLinkedIn.setText(cv.getLinkedin());

        // Bind Professional Summary
        TextView txtPsHeader = cvListHeaderViewHolder.getTxtPsHeader();
        TextView txtPsummary = cvListHeaderViewHolder.getTxtPSummary();
        String summary = getSpannableString(cv.getProfSummary());
        txtPsHeader.setVisibility(TextUtils.isEmpty(summary) ? View.GONE : View.VISIBLE);
        txtPsummary.setText(summary);
        txtPsummary.setVisibility(TextUtils.isEmpty(summary) ? View.GONE : View.VISIBLE);

        // Bind Technical Skills
        TextView txtTsHeader = cvListHeaderViewHolder.getTxtTsHeader();
        TextView txtTechnicalSkills = cvListHeaderViewHolder.getTxtTechnicalSkills();
        String tSummary = getSpannableString(cv.getTechnicalSkills());
        txtTsHeader.setVisibility(TextUtils.isEmpty(tSummary) ? View.GONE : View.VISIBLE);
        txtTechnicalSkills.setText(getSpannableString(cv.getTechnicalSkills()));
        txtTechnicalSkills.setVisibility(TextUtils.isEmpty(tSummary) ? View.GONE : View.VISIBLE);

        // Bind Companies List
        renderCompaniesList(cvListHeaderViewHolder.getLayoutWeSummary(), cv.getCompaniesList());

    }

    public void setCvArrayList(ArrayList<Cv> cvArrayList){
        this.cvArrayList = cvArrayList;
    }

    /**
     * Method to bind companies List.
     * Iterate through the companies list and add each child to the parent view
     *
     * @param parent    Linearlayout
     * @param companies list of companies
     */
    private void renderCompaniesList(LinearLayout parent, ArrayList<Company> companies) {
        if (parent == null || companies == null || companies.isEmpty()) return;
        for (Company company : companies) {
            View child = inflater.inflate(R.layout.layout_child_company_row, parent, false);
            TextView txtPosition = child.findViewById(R.id.txtPosition);
            TextView txtCName = child.findViewById(R.id.txtCompanyName);
            TextView txtLocation = child.findViewById(R.id.txtCompanyLocation);
            TextView txtTenure = child.findViewById(R.id.txtTenure);
            TextView txtWSummary = child.findViewById(R.id.txtWeSummary);

            txtPosition.setText(company.getRole());
            txtCName.setText(company.getCompanyName());
            txtLocation.setText(company.getLocation());
            txtTenure.setText(company.getTenure());
            txtWSummary.setText(getSpannableString(company.getResponsibilities()));

            parent.addView(child);
        }
    }

    /**
     * Convert arraylist into bullet spannable strting
     *
     * @param pSummary professional summary
     * @return spannable string with bullets
     */
    private String getSpannableString(ArrayList<String> pSummary) {
        if (pSummary == null || pSummary.isEmpty()) return "";
        SpannableStringBuilder builder = new SpannableStringBuilder();
        int startIndex, endIndex;
        for (int i = 0; i < pSummary.size(); i++) {
            startIndex = builder.length();
            builder.append(pSummary.get(i));
            builder.append("\n");
            endIndex = builder.length();
            builder.setSpan(new BulletSpan(40, Color.BLACK), startIndex, endIndex,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return builder.toString();
    }

    @Override
    public int getItemCount() {
        return cvArrayList.size();
    }

    private static class CvListHeaderViewHolder extends RecyclerView.ViewHolder {

        // Header
        private TextView txtName;
        private TextView txtEmail;
        private TextView txtPhone;
        private TextView txtLinkedIn;

        // PS
        private TextView txtPsHeader;
        private TextView txtPSummary;

        // TS
        private TextView txtTsHeader;
        private TextView txtTechnicalSkills;

        //We
        private LinearLayout layoutWeSummary;

        CvListHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView getTxtName() {
            if (txtName == null) {
                txtName = itemView.findViewById(R.id.txtName);
            }
            return txtName;
        }

        TextView getTxtEmail() {
            if (txtEmail == null) {
                txtEmail = itemView.findViewById(R.id.txtEmail);
            }
            return txtEmail;
        }

        TextView getTxtPhone() {
            if (txtPhone == null) {
                txtPhone = itemView.findViewById(R.id.txtPhone);
            }
            return txtPhone;
        }

        TextView getTxtLinkedIn() {
            if (txtLinkedIn == null) {
                txtLinkedIn = itemView.findViewById(R.id.txtLinkedIn);
            }
            return txtLinkedIn;
        }

        TextView getTxtPSummary() {
            if (txtPSummary == null) {
                txtPSummary = itemView.findViewById(R.id.txtPsSummary);
            }
            return txtPSummary;
        }

        LinearLayout getLayoutWeSummary() {
            if (layoutWeSummary == null) {
                layoutWeSummary = itemView.findViewById(R.id.layoutWeSummary);
            }
            return layoutWeSummary;
        }

        TextView getTxtTechnicalSkills() {
            if (txtTechnicalSkills == null) {
                txtTechnicalSkills = itemView.findViewById(R.id.txtTechnicalSkills);
            }
            return txtTechnicalSkills;
        }

        TextView getTxtPsHeader() {
            if (txtPsHeader == null) {
                txtPsHeader = itemView.findViewById(R.id.txtPsHeader);
            }
            return txtPsHeader;
        }

        TextView getTxtTsHeader() {
            if (txtTsHeader == null) {
                txtTsHeader = itemView.findViewById(R.id.txtTsHeader);
            }
            return txtTsHeader;
        }
    }
}
