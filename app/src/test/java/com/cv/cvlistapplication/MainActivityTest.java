package com.cv.cvlistapplication;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cv.cvlistapplication.apicalls.CvApiAdapter;
import com.cv.cvlistapplication.apicalls.CvApiService;
import com.cv.cvlistapplication.response.CvListApiResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityNotNull() throws Exception {
        assertNotNull(mainActivity);
    }

    @Test
    public void checkIRecyclerViewItems() throws Exception {
        RecyclerView recyclerView = mainActivity.findViewById(R.id.recyclerViewCvList);
        // workaround robolectric recyclerView issue
        recyclerView.measure(0, 0);
        recyclerView.layout(0, 0, 100, 1000);
        assertTrue("RecyclerView has more than 0 items",
                Objects.requireNonNull(recyclerView.getAdapter()).getItemCount() > 0);
        assertEquals(2, Objects.requireNonNull(recyclerView.getAdapter()).getItemCount());
    }

    @Test
    public void fetchCvsFromGist() {
        CvApiService cvApiService = CvApiAdapter.getApiService();
        Call<CvListApiResponse> call = cvApiService.getCvList();
        call.enqueue(new Callback<CvListApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<CvListApiResponse> call,
                                   @NonNull Response<CvListApiResponse> response) {
                assertTrue(response.isSuccessful() && response.body() != null);
            }

            @Override
            public void onFailure(@NonNull Call<CvListApiResponse> call, @NonNull Throwable t) {

            }
        });
    }
}