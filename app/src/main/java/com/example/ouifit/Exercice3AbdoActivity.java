package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercice3AbdoActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice3_abdos);

        //Bouton pour aller vers le Menu Exercice
        Button buttonSuivant = (Button) findViewById(R.id.btVersMenuAbdo);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Exercice3AbdoActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });
    }
}
