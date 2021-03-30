package com.example.ouifit.MenuDeroulant;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ouifit.BaseDeDonnee.InscriptionActivity;
import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.ouifit.BaseDeDonnee.BDD.CALORIE_PERDU;
import static com.example.ouifit.BaseDeDonnee.BDD.EMAIL;
import static com.example.ouifit.BaseDeDonnee.BDD.IDENTIFIANT;
import static com.example.ouifit.BaseDeDonnee.BDD.NOM_PERSONNE;
import static com.example.ouifit.BaseDeDonnee.BDD.POIDS;
import static com.example.ouifit.BaseDeDonnee.BDD.TABLE_NAME;
import static com.example.ouifit.BaseDeDonnee.BDD.TAILLE;
import static com.example.ouifit.BaseDeDonnee.BDD.TPS_ENTRAINEMENT;

public class ProfilActivity extends Activity {

    EditText Nom;
    EditText Email;
    EditText Poids;
    EditText Taille;
    TextView Calorie;
    TextView TpsEntrainement;
    private int id;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        Nom = (EditText) findViewById(R.id.identifiant);
        Email = (EditText) findViewById(R.id.EmailProfil);
        Poids = (EditText) findViewById(R.id.poidsProfil);
        Taille = (EditText) findViewById(R.id.tailleProfil);
//      Calorie = (TextView) findViewById(R.id.caloriePerduProfil);
//      TpsEntrainement = (TextView) findViewById(R.id.TpsEntrainementProfil);
//
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
                String textNom = Nom.getText().toString();
                String textEmail = Email.getText().toString();
                String textPoids = Poids.getText().toString();
                textPoids.replace("kg", " ");
                textPoids.replace("kilos"," ");
                String textTaille =  Taille.getText().toString();
//                String strSql = "Update " + TABLE_NAME + " SET "
//                        + NOM_PERSONNE + " = '" + textNom    + "', "
//                        + EMAIL +        " = '" + textEmail  + "', "
//                        + POIDS +        " = '" + textPoids  + "', "
//                        + Taille +       " = '" + textTaille + "', "
//                        + " Where "+ IDENTIFIANT + " = "+ getId();
                String strWhere = IDENTIFIANT + " = "+ getId();
                ContentValues contentValues = new ContentValues();
                contentValues.put(NOM_PERSONNE, textNom);
                contentValues.put(EMAIL, textEmail);
                contentValues.put(POIDS,textPoids);
                contentValues.put(TAILLE,textTaille);
                (InscriptionActivity.myDatabase).getWritableDatabase().update(TABLE_NAME, contentValues
                        ,strWhere,null);
                (InscriptionActivity.myDatabase).close();
                Log.i("DATABASE" , "update invoked");
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

//    public void insertStat(EditText nom, EditText mail, EditText poids, EditText taille)
//    {
//
//        String strSql = "Update " + TABLE_NAME + " SET  '"
//                + NOM_PERSONNE +  " = '" + nom + "', "
//                + EMAIL + " = '" + mail + "', "
//                + TAILLE + " = '" + taille + "', "
//                + POIDS + " = '" + poids +
//                "' where " + IDENTIFIANT + " = " + IDENTIFIANT ;
//        (InscriptionActivity.myDatabase).getWritableDatabase().updateWithOnConflict();
//        InscriptionActivity.myDatabase.getWritableDatabase().update(TABLE_NAME, nom, );
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}


