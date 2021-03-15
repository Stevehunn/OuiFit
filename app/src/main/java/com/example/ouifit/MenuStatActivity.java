package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuStatActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_stat);




        Button buttonExercice = (Button)findViewById(R.id.btversExercice3);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuStatActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });

        Button buttonCourse = (Button)findViewById(R.id.btversCourse3);
        buttonCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuStatActivity.this, MenuCourseActivity.class);
                startActivity(i);
            }
        });
    }
}