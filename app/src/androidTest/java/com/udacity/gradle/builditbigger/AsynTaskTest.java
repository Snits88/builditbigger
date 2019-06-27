package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import com.udacity.gradle.builditbigger.tasks.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsynTaskTest{

    @Test
    public void testVerifyAsyncTaskResponse() {
        // Joke retriven from async call
        AsyncTask<Pair<Context, String>, Void, String> asyncJoke = new EndpointsAsyncTask().execute(new Pair<Context, String>(null, "TryBackend"));
        String joke;
        try {
            joke = asyncJoke.get();
        } catch (InterruptedException | ExecutionException e) {
            joke = null;
        }
        assertNotNull  (joke);
    }

}
