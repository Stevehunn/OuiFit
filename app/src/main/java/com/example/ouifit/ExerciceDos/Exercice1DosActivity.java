package com.example.ouifit.ExerciceDos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.example.ouifit.Menu.MenuExercicesActivity;
import com.example.ouifit.R;

public class Exercice1DosActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_dos1);
/*
        screenView =findViewById(R.id.imageExoDos);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(),image_dos1));

*/
        //Bouton pour aller vers l'exercice 2
        Button buttonSuivant = (Button)findViewById(R.id.btExoVersExo2Dos);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton retour exo 1","execute");
                Intent i = new Intent(Exercice1DosActivity.this, Exercice2DosActivity.class);
                startActivity(i);
            }
        });

        //Bouton de rerour pour aller vers le menu Exercice
        Button buttonRetour = (Button)findViewById(R.id.btRetourDosEx1);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(Exercice1DosActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });
    }

}