package com.example.ouifit.ExerciceBras;

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

import static com.example.ouifit.R.drawable.image_bras1;

public class Exercice1BrasActivity extends AppCompatActivity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice1);

        screenView = findViewById(R.id.imageExo);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), image_bras1));

        /*------------------------Changement des TexView en fonction des pages chargés-----------------------*/

        TextView titleview = (TextView) findViewById(R.id.titreExo1);
        titleview.setText(R.string.exoBras);

        TextView questionview = (TextView) findViewById(R.id.question1);
        questionview.setText(R.string.repetition);

        TextView reponseview = (TextView) findViewById(R.id.reponse1);
        reponseview.setText(R.string.repetition1);

        /*------------------------BOUTON-----------------------*/

        //Bouton pour aller vers l'exercice 2
        Button buttonSuivant = (Button) findViewById(R.id.btExoVersExo2);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(Exercice1BrasActivity.this, Exercice2BrasActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton de rerour pour aller vers le menu Exercice
        Button buttonRetour = (Button) findViewById(R.id.btRetourEx1);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(Exercice1BrasActivity.this, MenuExercicesActivity.class);
                startActivity(i);
                onPause();
            }
        });
    }

    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onDestroy() {
        super.onDestroy();
    }


}
