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

        //Bouton de retour pour aller vers le menu principal
        Button buttonRetour = (Button)findViewById(R.id.btRetourStat);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuStatActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu exercice
        Button buttonExercice = (Button)findViewById(R.id.btversExercice3);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuStatActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu course
        Button buttonCourse = (Button)findViewById(R.id.btversCourse3);
        buttonCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuStatActivity.this, MenuCourseActivity.class);
                startActivity(i);
            }
        });
    }
}