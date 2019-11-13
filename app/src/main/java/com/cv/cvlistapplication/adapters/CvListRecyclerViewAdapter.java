package com.cv.cvlistapplication.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
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

    private static final int VIEW_TYPE_HEADER = 1000;
    private static final int VIEW_TYPE_CV_LIST = 1001;
    private static final int VIEW_TYPE_CV_DIVIDER = 1002;

    private Context context;
    private ArrayList<Cv> cvArrayList;
    private LayoutInflater inflater;

    public CvListRecyclerViewAdapter(WeakReference<Context> context, ArrayList<Cv> cvArrayList) {
        this.context = context.get();
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
        // Bind Header info
        CvListHeaderViewHolder cvListHeaderViewHolder = (CvListHeaderViewHolder) holder;
        TextView txtName = cvListHeaderViewHolder.getTxtName();
        TextView txtPhone = cvListHeaderViewHolder.getTxtPhone();
        TextView txtEmail = cvListHeaderViewHolder.getTxtEmail();
        TextView txtLinkedIn = cvListHeaderViewHolder.getTxtLinkedIn();

        txtName.setText(cv.getName());
        txtPhone.setText(cv.getPhone());
        txtEmail.setText(cv.getEmail());
        txtLinkedIn.setText(cv.getLinkedin());

        // Bind PS
        TextView txtPsummary = cvListHeaderViewHolder.getTxtPSummary();
        txtPsummary.setText(getSpannableString(cv.getProfSummary()), TextView.BufferType.SPANNABLE);


        // Bind TS


        // Bind CL
        renderCompaniesList(cvListHeaderViewHolder.getLayoutWeSummary(), cv.getCompaniesList());

    }

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
        private TextView txtPSummary;

        //We
        private LinearLayout layoutWeSummary;
        private TextView txtPosition;
        private TextView txtCompanyName;
        private TextView txtLocation;
        private TextView txtTenure;
        private TextView txtWeSummary;


        CvListHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public TextView getTxtName() {
            if (txtName == null) {
                txtName = itemView.findViewById(R.id.txtName);
            }
            return txtName;
        }

        public TextView getTxtEmail() {
            if (txtEmail == null) {
                txtEmail = itemView.findViewById(R.id.txtEmail);
            }
            return txtEmail;
        }

        public TextView getTxtPhone() {
            if (txtPhone == null) {
                txtPhone = itemView.findViewById(R.id.txtPhone);
            }
            return txtPhone;
        }

        public TextView getTxtLinkedIn() {
            if (txtLinkedIn == null) {
                txtLinkedIn = itemView.findViewById(R.id.txtLinkedIn);
            }
            return txtLinkedIn;
        }

        public TextView getTxtPSummary() {
            if (txtPSummary == null) {
                txtPSummary = itemView.findViewById(R.id.txtPsSummary);
            }
            return txtPSummary;
        }

        public TextView getTxtPosition() {
            if (txtPosition == null) {
                txtPosition = itemView.findViewById(R.id.txtPosition);
            }
            return txtPosition;
        }

        public TextView getTxtCompanyName() {
            if (txtCompanyName == null) {
                txtCompanyName = itemView.findViewById(R.id.txtCompanyName);
            }
            return txtCompanyName;
        }

        public TextView getTxtLocation() {
            if (txtLocation == null) {
                txtLocation = itemView.findViewById(R.id.txtCompanyLocation);
            }
            return txtLocation;
        }

        public TextView getTxtTenure() {
            if (txtTenure == null) {
                txtTenure = itemView.findViewById(R.id.txtTenure);
            }
            return txtTenure;
        }

        public TextView getTxtWeSummary() {
            if (txtWeSummary == null) {
                txtWeSummary = itemView.findViewById(R.id.txtWeSummary);
            }
            return txtWeSummary;
        }

        public LinearLayout getLayoutWeSummary() {
            if (layoutWeSummary == null) {
                layoutWeSummary = itemView.findViewById(R.id.layoutWeSummary);
            }
            return layoutWeSummary;
        }
    }
}
