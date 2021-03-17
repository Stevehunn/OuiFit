package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercice1AbdoActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice1_abdos);

        //Bouton pour aller vers l'exercice 2
        Button buttonSuivant = (Button) findViewById(R.id.btVersExo2Abdo);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Exercice1AbdoActivity.this, Exercice2AbdoActivity.class);
                startActivity(i);
            }
        });
    }
}
