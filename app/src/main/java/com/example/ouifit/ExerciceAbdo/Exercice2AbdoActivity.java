package com.example.ouifit.ExerciceAbdo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.ouifit.R;

import static com.example.ouifit.R.drawable.image_abdo2;

public class Exercice2AbdoActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice2);

        screenView = findViewById(R.id.imageExo);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), image_abdo2));

        /*------------------------Changement des TexView en fonction des pages chargés-----------------------*/

        TextView titleview = (TextView) findViewById(R.id.titreExo2);
        titleview.setText(R.string.exoAbdo);

        TextView questionview = (TextView) findViewById(R.id.question2);
        questionview.setText(R.string.repetition);

        TextView reponseview = (TextView) findViewById(R.id.reponse2);
        reponseview.setText(R.string.repetition2);

        /*------------------------BOUTON-----------------------*/

        //Bouton pour aller vers l'exercice 3
        Button buttonSuivant = (Button) findViewById(R.id.btExoVersExo3);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 2", "execute");
                Intent i = new Intent(Exercice2AbdoActivity.this, Exercice3AbdoActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton de rerour pour aller vers l'exercice 1
        Button buttonRetour = (Button) findViewById(R.id.btRetourEx2);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 2", "execute");
                Intent i = new Intent(Exercice2AbdoActivity.this, Exercice1AbdoActivity.class);
                startActivity(i);
                onPause();
            }
        });

    }

    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onPause() {
        super.onPause();
        finish();
    }
}
