package com.cv.cvlistapplication;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cv.cvlistapplication.adapters.CvListRecyclerViewAdapter;
import com.cv.cvlistapplication.apicalls.CvApiAdapter;
import com.cv.cvlistapplication.apicalls.CvApiService;
import com.cv.cvlistapplication.models.Cv;
import com.cv.cvlistapplication.response.CvListApiResponse;
import com.cv.cvlistapplication.utils.DataUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerViews();
    }

    private void registerViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewCvList);
        progressBar = findViewById(R.id.progressBar);

        fetchCvsFromGist();
    }

    private void showToast(String txt) {
        if (TextUtils.isEmpty(txt)) return;
        Toast toast = Toast.makeText(this, txt, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    private void fetchCvsFromGist() {
        if (!checkInternetConnection()) {
            showToast(getString(R.string.no_connection));
            recyclerView.setVisibility(View.GONE);
            return;
        }
        showProgressDialog();
        CvApiService cvApiService = CvApiAdapter.getApiService();
        Call<CvListApiResponse> call = cvApiService.getCvList();
        call.enqueue(new Callback<CvListApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<CvListApiResponse> call,
                                   @NonNull Response<CvListApiResponse> response) {
                hideProgressDialog();
                if (response.body() != null) {
                    setAdapter(response.body().cvArrayList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CvListApiResponse> call, @NonNull Throwable t) {
                hideProgressDialog();
            }
        });
    }

    private void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressDialog() {
        progressBar.setVisibility(View.GONE);
    }

    public boolean checkInternetConnection() {
        return DataUtils.isInternetAvailable(getApplicationContext());
    }

    private void setAdapter(ArrayList<Cv> cvArrayList) {
        if (cvArrayList == null || cvArrayList.isEmpty()) return;
        recyclerView.setVisibility(View.VISIBLE);
        CvListRecyclerViewAdapter cvListRecyclerViewAdapter = new CvListRecyclerViewAdapter
                (new WeakReference<Context>(this),
                cvArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cvListRecyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
