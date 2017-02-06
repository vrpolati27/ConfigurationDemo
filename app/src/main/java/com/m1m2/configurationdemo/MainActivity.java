package com.m1m2.configurationdemo;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView developerFullName;
    private TextView description;
    private ImageView welcomeImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Identifying TextView and adding Reference */
        developerFullName = (TextView) findViewById(R.id.tv_welcome);
        description = (TextView) findViewById(R.id.tv_description);
        welcomeImg = (ImageView) findViewById(R.id.img_welcome);

        /* changing font from default to sportify */
        String customFontPath = getResources().getString(R.string.sportifyFont);
        Typeface type = Typeface.createFromAsset(getAssets(),customFontPath);
        developerFullName.setTypeface(type);
        description.setTypeface(type);
        description.setText(getResources().getString(R.string.portrait_description));

        /* Changing Action bar title */
        getSupportActionBar().setTitle("Modified action Title");

    }


    /* we have override onConfigurationChanged() to handle orientation change */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        /* Action you want when phone orientation changes to Landscape */
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            description.setText(getResources().getString(R.string.landscape_description));
            //welcomeImg.setImageResource(R.drawable.nature_landscape);
        }/* Action you want when phone orientation changes to portrait */
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            description.setText(getResources().getString(R.string.portrait_description));
            //welcomeImg.setImageResource(R.drawable.nature);
        }
    }
}
