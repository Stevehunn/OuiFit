package com.example.ouifit.MenuDeroulant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ouifit.LocaleHelper;
import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class OptionActivity extends Activity implements AdapterView.OnItemSelectedListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

/*
        LocaleHelper.setLocale(this, "fr"); //for french;

        LocaleHelper.setLocale(this,"en"); //for english;
*/
        /*------------------------Spinner changer de langue-----------------------*/
        Spinner spinner = (Spinner) findViewById(R.id.select_language);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.select_language, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        /*------------------------BOUTON-----------------------*/

        //Bouton de retour pour aller vers le menu Exercice
        Button buttonRetour = (Button) findViewById(R.id.btRetourOption);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(OptionActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour vers le menu principal
        Button buttonValide = (Button) findViewById(R.id.btValide);
        buttonValide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(OptionActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onDestroy() {
        super.onDestroy();
    }


    /*------------------------Spinner changer de langue-----------------------*/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                LocaleHelper.setLocale(this, "fr"); //for french
                break;
            case 1:
                String text2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text2, Toast.LENGTH_SHORT).show();
                LocaleHelper.setLocale(this, "en"); //for english;
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
