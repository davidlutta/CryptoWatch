package com.davidlutta.galactic_ninja.cryptowatch;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.beginButton) Button mBeginButton;
    @Bind(R.id.to) TextView mToTextView;
    @Bind(R.id.welcome) TextView mWelcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Typeface cool = Typeface.createFromAsset(getAssets(),"fonts/coolvetica.ttf");
        mBeginButton.setTypeface(cool);
        mToTextView.setTypeface(cool);
        mWelcomeTextView.setTypeface(cool);
    }
}
