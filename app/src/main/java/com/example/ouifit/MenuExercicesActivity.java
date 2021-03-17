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

        //Bouton de retour pour aller vers le menu principal
        Button buttonRetour = (Button)findViewById(R.id.btRetourEx);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuExercicesActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers l'exercice Abdominaux
        Button buttonExoAbdos = (Button)findViewById(R.id.btexoAbdo);
        buttonExoAbdos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuExercicesActivity.this, Exercice1AbdoActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu stat
        Button buttonStat = (Button)findViewById(R.id.btversStat1);
        buttonStat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuExercicesActivity.this, MenuStatActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu course
        Button buttonCourse = (Button)findViewById(R.id.btversCourse1);
        buttonCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuExercicesActivity.this, MenuCourseActivity.class);
                startActivity(i);
            }
        });

    }
}
