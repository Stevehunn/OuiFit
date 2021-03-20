package com.example.ouifit.ExerciceAbdo;

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

import static com.example.ouifit.R.drawable.image_abdo1;

public class Exercice1AbdoActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_abdo1);

        screenView = findViewById(R.id.imageExoAbdo);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), image_abdo1));

        TextView titleview = (TextView) findViewById(R.id.titreExo1);
        titleview.setText(R.string.exoAbdo);

        //Bouton pour aller vers l'exercice 2
        Button buttonSuivant = (Button) findViewById(R.id.btExoVersExo2Abdo);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(Exercice1AbdoActivity.this, Exercice2AbdoActivity.class);
                startActivity(i);
            }
        });

        //Bouton de rerour pour aller vers le menu Exercice
        Button buttonRetour = (Button)findViewById(R.id.btRetourAbdoEx1);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(Exercice1AbdoActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });
    }

}
