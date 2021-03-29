package com.example.ouifit.MenuDeroulant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class ProfilActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        /*------------------------BOUTON-----------------------*/

        //Bouton de retour pour aller vers le menu Exercice
        Button buttonRetour = (Button) findViewById(R.id.btRetourProfil);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton retour profil", "execute");
                Intent i = new Intent(  ProfilActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour sauvegarder les données rentrée
        Button buttonSave = (Button) findViewById(R.id.btSauvegarder);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Sauvegarde", "execute");
                Intent i = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onPause() {
        super.onPause();
        finish();
    }

}


