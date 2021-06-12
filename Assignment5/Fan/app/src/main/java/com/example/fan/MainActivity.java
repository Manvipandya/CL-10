package com.example.fan;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
public class 1MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button slow, medium, fast, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slow = findViewById(R.id.slow);
        medium = findViewById(R.id.medium);
        fast = findViewById(R.id.fast);
        stop = findViewById(R.id.stop);
        imageView = findViewById(R.id.imageView);
        slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RotateAnimation animation = new RotateAnimation(0,1080, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(5000);
                animation.setRepeatCount(Animation.INFINITE);
                imageView.setAnimation(animation);
                imageView.startAnimation(animation);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RotateAnimation animation = new RotateAnimation(0,2160,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(5000);
                animation.setRepeatCount(Animation.INFINITE);
                imageView.setAnimation(animation);
                imageView.startAnimation(animation);
            }
        });

        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //RotateAnimation(fromDegree,toDegree,pivotXType,pivotXValue,pivotYType,pivotYValue)
                RotateAnimation animation = new RotateAnimation(0,3240, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(5000);
                animation.setRepeatCount(Animation.INFINITE);
                imageView.setAnimation(animation);
                imageView.startAnimation(animation);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //RotateAnimation(fromDegree,toDegree,pivotXType,pivotXValue,pivotYType,pivotYValue)
                RotateAnimation animation = new RotateAnimation(0,0, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(5000);
                animation.setRepeatCount(Animation.INFINITE);
                imageView.setAnimation(animation);
                imageView.startAnimation(animation);
            }
        });
    }
}