package com.example.ouifit.ExerciceBras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.example.ouifit.R;

import static com.example.ouifit.R.drawable.image_bras2;

public class Exercice2BrasActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("EX2BRAS", "onCreate");

        setContentView(R.layout.exercice_bras2);

        screenView = findViewById(R.id.imageExoBras);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), image_bras2));


        //Bouton pour aller vers l'exercice 2
        Button buttonSuivant = (Button) findViewById(R.id.btExoVersExo3Bras);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton retour exo 1", "execute");
                Intent i = new Intent(Exercice2BrasActivity.this, Exercice3BrasActivity.class);
                startActivity(i);
            }
        });

        //Bouton de retour pour aller vers le menu Exercice
        Button buttonRetour = (Button) findViewById(R.id.btRetourBrasEx2);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(Exercice2BrasActivity.this, Exercice1BrasActivity.class);
                startActivity(i);
            }
        });
    }

}
