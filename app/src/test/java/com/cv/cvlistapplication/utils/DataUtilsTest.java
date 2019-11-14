package com.cv.cvlistapplication.utils;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class DataUtilsTest {

    private Context context;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        context = mock(Context.class);
    }

    @Test
    public void isInternetAvailable() throws Exception {
        assertFalse(DataUtils.isInternetAvailable(context));
    }
}