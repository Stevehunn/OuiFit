package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuExercicesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_exercices);

        Button buttonStat = (Button)findViewById(R.id.btversStat1);
        Button buttonCourse = (Button)findViewById(R.id.btversCourse1);

        buttonStat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuExercicesActivity.this, MenuStatActivity.class);
                startActivity(i);
            }
        });

        buttonCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuExercicesActivity.this, MenuCourseActivity.class);
                startActivity(i);
            }
        });

    }
}
