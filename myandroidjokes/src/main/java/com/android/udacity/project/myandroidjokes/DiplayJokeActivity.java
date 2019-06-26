package com.android.udacity.project.myandroidjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.udacity.project.myandroidjokes.utils.BuildItBiggerCostants;

import org.apache.commons.lang3.StringUtils;

public class DiplayJokeActivity extends AppCompatActivity {

    private String joke;

    private TextView jokeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplay_joke);
        joke = getIntent().getExtras().getString(BuildItBiggerCostants.JOKE);
        if(!StringUtils.isEmpty(joke)){
            jokeView = findViewById(R.id.jokes_description);
            jokeView.setText(joke);
        }
    }
}
