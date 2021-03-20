package com.example.ouifit.ExerciceBras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.example.ouifit.Menu.MenuExercicesActivity;
import com.example.ouifit.R;

import static com.example.ouifit.R.drawable.image_bras1;

public class Exercice1BrasActivity extends Activity {

    View screenView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice_bras1);

        screenView =findViewById(R.id.imageExoBras);
        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(),image_bras1));


        //Bouton pour aller vers l'exercice 2
        Button buttonSuivant = (Button)findViewById(R.id.btExoVersExo2Bras);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 2", "execute");
                Intent i = new Intent(Exercice1BrasActivity.this, Exercice2BrasActivity.class);
                startActivity(i);
            }
        });

        //Bouton de rerour pour aller vers le menu Exercice
        Button buttonRetour = (Button)findViewById(R.id.btRetourBrasEx1);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(Exercice1BrasActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });
    }

}
