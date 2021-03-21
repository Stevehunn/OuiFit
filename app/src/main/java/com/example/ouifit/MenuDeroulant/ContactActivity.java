package com.example.ouifit.MenuDeroulant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class ContactActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        /*------------------------BOUTON-----------------------*/

        //Bouton de retour pour aller vers le menu Exercice
        Button buttonRetour = (Button) findViewById(R.id.btRetourContact);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(ContactActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
