package com.example.ouifit.Menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class MenuCourseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_course);

        //Bouton de retour pour aller vers le menu principal
        Button buttonRetour = (Button)findViewById(R.id.btRetourCourse);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuCourseActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu stat
        Button buttonStat = (Button)findViewById(R.id.btversStat2);
        buttonStat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuCourseActivity.this, MenuStatActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu exercice
        Button buttonExercice = (Button)findViewById(R.id.btversExercice2);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuCourseActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });





    }

}
