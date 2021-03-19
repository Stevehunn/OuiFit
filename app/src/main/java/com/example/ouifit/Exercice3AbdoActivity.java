package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import static com.example.ouifit.R.drawable.image_abdo3;

public class Exercice3AbdoActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_abdo3);

        screenView =findViewById(R.id.imageExoAbdo);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(),image_abdo3));


        //Bouton pour aller vers le menu principal
        Button buttonSuivant = (Button)findViewById(R.id.btExoVersMenuAbdo);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(Exercice3AbdoActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Bouton de rerour pour aller vers l'exercice 2
        Button buttonRetour = (Button)findViewById(R.id.btRetourAbdoEx3);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(Exercice3AbdoActivity.this, Exercice2AbdoActivity.class);
                startActivity(i);
            }
        });
    }
}
