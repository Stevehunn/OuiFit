package com.example.ouifit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button buttonStat = (Button)findViewById(R.id.btversStat0);
    Button buttonExercice = (Button)findViewById(R.id.btversExercice0);
    Button buttonCourse = (Button)findViewById(R.id.btversCourse0);


        buttonStat.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, MenuStatActivity.class);
            startActivity(i);
        }});


        buttonExercice.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, MenuExercicesActivity.class);
            startActivity(i);
        }});


        buttonCourse.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, MenuCourseActivity.class);
            startActivity(i);
        }});

    }
}