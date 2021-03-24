package com.example.ouifit.MenuDeroulant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ouifit.LocaleHelper;
import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class OptionActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);


        LocaleHelper.setLocale(this, "fr"); //for french;
/*
        LocaleHelper.setLocale(this,"en"); //for english;
*/

        /*------------------------BOUTON-----------------------*/
        /*
        //Bouton pour mettre en français
        Button buttonFrancais = (Button) findViewById(R.id.btLangue1);
        buttonFrancais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(OptionActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour mettre en Anglais
        Button buttonAnglais = (Button) findViewById(R.id.btLangue2);
        buttonAnglais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");

                Intent i = new Intent(OptionActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
*/


        //Bouton de retour pour aller vers le menu Exercice
        Button buttonRetour = (Button) findViewById(R.id.btRetourOption);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(OptionActivity.this, MainActivity.class);
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
