package com.cv.cvlistapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cv.cvlistapplication.R;
import com.cv.cvlistapplication.models.Cv;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class CvListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
        return new CvListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cvArrayList.size();
    }

    private static class CvListViewHolder extends RecyclerView.ViewHolder {

        public CvListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
