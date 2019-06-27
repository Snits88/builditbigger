package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.udacity.javalib.MyJokes;
import com.android.udacity.project.myandroidjokes.DiplayJokeActivity;
import com.android.udacity.project.myandroidjokes.utils.BuildItBiggerCostants;
import com.udacity.gradle.builditbigger.tasks.EndpointsAsyncTask;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    AsyncTask<Pair<Context, String>, Void, String> asyncJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    public void tellJoke(View view) {
        // Joke retriven from async call
        asyncJoke = new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "TryBackend"));
        String joke;
        try {
            joke = asyncJoke.get();
        } catch (InterruptedException | ExecutionException e) {
            joke = null;
        }
        // Prepare Intent for use Android Library
        Intent intent = new Intent(MainActivity.this, DiplayJokeActivity.class);

        if(StringUtils.isEmpty(joke)) {
            List<String> jokes = MyJokes.getJokes();
            Random rn = new Random();
            int rnInt = rn.nextInt(jokes.size());
            Toast.makeText(this, jokes.get(rnInt), Toast.LENGTH_SHORT).show();
            intent.putExtra(BuildItBiggerCostants.JOKE, jokes.get(rnInt));
        }else{
            intent.putExtra(BuildItBiggerCostants.JOKE, joke);
        }
        startActivity(intent);

    }

}
