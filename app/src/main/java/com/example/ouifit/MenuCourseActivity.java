package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuCourseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_course);


        Button buttonStat = (Button)findViewById(R.id.btversStat2);
        buttonStat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuCourseActivity.this, MenuStatActivity.class);
                startActivity(i);
            }
        });

        Button buttonExercice = (Button)findViewById(R.id.btversExercice2);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuCourseActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });





    }

}
