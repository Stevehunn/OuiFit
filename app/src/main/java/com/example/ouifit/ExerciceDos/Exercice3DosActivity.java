package com.example.ouifit.ExerciceDos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.ouifit.Menu.MenuExercicesActivity;
import com.example.ouifit.R;

import static com.example.ouifit.R.drawable.image_dos3;

public class Exercice3DosActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice3);

        screenView = findViewById(R.id.imageExo);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), image_dos3));

        TextView titleview = (TextView) findViewById(R.id.titreExo3);
        titleview.setText(R.string.exoDos);

        /*------------------------BOUTON-----------------------*/

        //Bouton pour aller vers le menu principal
        Button buttonSuivant = (Button) findViewById(R.id.btExoVersMenu);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 3", "execute");
                Intent i = new Intent(Exercice3DosActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });

        //Bouton de rerour pour aller vers l'exercice 2
        Button buttonRetour = (Button) findViewById(R.id.btRetourEx3);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 3", "execute");
                Intent i = new Intent(Exercice3DosActivity.this, Exercice2DosActivity.class);
                startActivity(i);
            }
        });
    }
}
