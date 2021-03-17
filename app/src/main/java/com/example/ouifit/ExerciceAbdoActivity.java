package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

public class ExerciceAbdoActivity extends Activity {

    View screenView;
    int[] images;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_abdos);

        images = new int[] {R.drawable.image_abdo1,R.drawable.image_abdo2,R.drawable.image_abdo3};


        //Bouton de retour pour aller vers le menu principal
        Button buttonRetour = (Button)findViewById(R.id.btRetourAbdoEx1);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ExerciceAbdoActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        screenView =findViewById(R.id.imageExoAbdo);

        //Bouton pour aller vers l'exercice suivant
        Button buttonSuivant = (Button) findViewById(R.id.btVersExo2Abdo);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int aryLength = images.length;
                int numExo = 0;
                screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(),images[numExo]));

            }

        });
    }
}
