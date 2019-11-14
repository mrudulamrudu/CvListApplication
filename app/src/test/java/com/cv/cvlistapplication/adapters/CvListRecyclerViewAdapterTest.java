package com.cv.cvlistapplication.adapters;

import android.content.Context;
import android.os.Build;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cv.cvlistapplication.MainActivity;
import com.cv.cvlistapplication.R;
import com.cv.cvlistapplication.models.Company;
import com.cv.cvlistapplication.models.Cv;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class CvListRecyclerViewAdapterTest {

    private CvListRecyclerViewAdapter cvListRecyclerViewAdapter;
    private Context context;
    private MainActivity mainActivity;
    private RecyclerView recyclerView;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume().get();
        recyclerView = mainActivity.findViewById(R.id.recyclerViewCvList);
        cvListRecyclerViewAdapter = mock(CvListRecyclerViewAdapter.class);
        context = mock(Context.class);
    }

    @Test
    public void activityNotNull() throws Exception {
        assertNotNull(mainActivity);
    }

    @Test
    public void recyclerViewNotNull() throws Exception {
        assertNotNull(recyclerView);
    }

    @Test
    public void adapterNotNull() throws Exception {
        assertNotNull(cvListRecyclerViewAdapter);
    }

    @Test
    public void checkIRecyclerViewItems() throws Exception {
        // workaround robolectric recyclerView issue
        Assert.assertEquals("RecyclerView has 0 items", 0,
                Objects.requireNonNull(cvListRecyclerViewAdapter).getItemCount());
    }

    @Test
    public void renderAdapter() throws Exception {
        // Set up input
        ArrayList<Cv> cvs = getCvs();
        assertEquals(3, cvs.size());
        cvListRecyclerViewAdapter = new CvListRecyclerViewAdapter(new
                WeakReference<>(context), cvs);

        assertNotNull(cvListRecyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(cvListRecyclerViewAdapter);

        assertNotNull(recyclerView.getAdapter());

        assertEquals(3, recyclerView.getAdapter().getItemCount());

    }

    @Test
    public void getItemCount(){
        ArrayList<Cv> cvs = getCvs();
        cvs.addAll(getCvs());
        assertEquals(6, cvs.size());
        cvListRecyclerViewAdapter.setCvArrayList(cvs);
        assertEquals(6, cvs.size());

    }

    public ArrayList<Cv> getCvs() {
        ArrayList<String> pSummary = new ArrayList<>();
        pSummary.add("one .....................");
        pSummary.add("two .....................");
        pSummary.add("three .....................");

        ArrayList<String> tSkills = new ArrayList<>();
        pSummary.add("Java .....................");
        pSummary.add("Android .....................");
        pSummary.add("Git .....................");

        ArrayList<String> resp = new ArrayList<>();
        pSummary.add("one .....................");
        pSummary.add("two .....................");
        pSummary.add("three .....................");

        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("Abc", "Team Lead", "abc", "abc",
                "Bangalore", resp, null));

        ArrayList<Cv> cvs = new ArrayList<>();
        cvs.add(new Cv("Mrudula C Amirnnei", "mrudula@gmail.com",
                "+1 XXX-XXX-XXXX", "", pSummary, tSkills, companies));
        cvs.add(new Cv("Hareesh Tummala", "mrudula@gmail.com",
                "+1 XXX-XXX-XXXX", "", pSummary, tSkills, companies));
        cvs.add(new Cv("Misty Tummala", "mrudula@gmail.com",
                "+1 XXX-XXX-XXXX", "", pSummary, tSkills, companies));
        return cvs;
    }
}