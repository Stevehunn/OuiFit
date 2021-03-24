package com.example.ouifit.ExerciceAbdo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.ouifit.Menu.MenuExercicesActivity;
import com.example.ouifit.R;

import static com.example.ouifit.R.drawable.image_abdo3;

public class Exercice3AbdoActivity extends AppCompatActivity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice3);

        screenView = findViewById(R.id.imageExo);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), image_abdo3));

        /*------------------------Changement des TexView en fonction des pages chargés-----------------------*/

        TextView titleview = (TextView) findViewById(R.id.titreExo3);
        titleview.setText(R.string.exoAbdo);

        TextView questionview = (TextView) findViewById(R.id.question3);
        questionview.setText(R.string.repetition);

        TextView reponseview = (TextView) findViewById(R.id.reponse3);
        reponseview.setText(R.string.repetition1);

        /*------------------------BOUTON-----------------------*/

        //Bouton pour aller vers le menu principal
        Button buttonSuivant = (Button) findViewById(R.id.btExoVersMenu);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 3", "execute");
                Intent i = new Intent(Exercice3AbdoActivity.this, MenuExercicesActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton de rerour pour aller vers l'exercice 2
        Button buttonRetour = (Button) findViewById(R.id.btRetourEx3);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 3", "execute");
                Intent i = new Intent(Exercice3AbdoActivity.this, Exercice2AbdoActivity.class);
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
