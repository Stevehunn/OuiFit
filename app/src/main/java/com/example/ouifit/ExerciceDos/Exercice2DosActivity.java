package com.example.ouifit.ExerciceDos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.example.ouifit.R;

import static com.example.ouifit.R.drawable.image_abdo2;

public class Exercice2DosActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_abdo2);

        screenView = findViewById(R.id.imageExoAbdo);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), image_abdo2));


        //Bouton pour aller vers l'exercice 3
        Button buttonSuivant = (Button) findViewById(R.id.btExoVersExo3Abdo);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 2", "execute");
                Intent i = new Intent(Exercice2DosActivity.this, Exercice3DosActivity.class);
                startActivity(i);
            }
        });

        //Bouton de rerour pour aller vers l'exercice 1
        Button buttonRetour = (Button) findViewById(R.id.btRetourAbdoEx2);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 2", "execute");
                Intent i = new Intent(Exercice2DosActivity.this, Exercice1DosActivity.class);
                startActivity(i);
            }
        });

    }
}
