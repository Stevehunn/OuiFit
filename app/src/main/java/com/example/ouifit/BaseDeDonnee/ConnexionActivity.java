package com.example.ouifit.BaseDeDonnee;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class ConnexionActivity extends AppCompatActivity implements View.OnClickListener{
    EditText login;
    EditText password;
    Button btnConnect;
    String NOM_PERSONNE = "Prénom";
    String TABLE_NAME = "Inscrit";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        BDD.maBDD= new BDD(this);




        /*------------------------BOUTON-----------------------*/

        //Bouton de retour pour aller vers le menu Exercice
        Button buttonRetour = (Button) findViewById(R.id.btRetourConnexion);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(ConnexionActivity.this, MainActivity.class);
                startActivity(i);
                onPause();
            }
        });



    }

    public void onClick (View view)
    {
        btnConnect = (Button) findViewById(R.id.btConnection);
        if(view.getId() == R.id.btConnection)
        {
            String txtLogin = login.getText().toString();
            String txtPassword = password.getText().toString();
            String strSql = "Select " + BDD.NOM_PERSONNE + ", "+ BDD.PASSWORD + " from " + BDD.TABLE_NAME +
                    " where " + BDD.NOM_PERSONNE + " = '" + txtLogin +
                    "' AND " + BDD.PASSWORD + " = '" + txtPassword + "';";
            Cursor cursor;
            if(test(txtLogin,txtPassword) == true)
            {
                cursor = BDD.maBDD.getReadableDatabase().rawQuery(strSql,null);
                cursor.moveToFirst();
                if(!cursor.isAfterLast())
                {
                    Intent i = new Intent (ConnexionActivity.this, MainActivity.class);
                    startActivity(i);
                } else
                {
                    Intent i = new Intent ( ConnexionActivity.this, InscriptionActivity.class);
                    Toast.makeText(ConnexionActivity.this, "Vous allez être redirigé vers la page d'inscription", Toast.LENGTH_LONG);
                    startActivity(i);
                }
            }
        }
    }

    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onPause() {
        super.onPause();
        finish();
    }

    //test pour voir si les champs sont remplis
    public boolean test (String txtLogin, String txtPassword)
    {
        int etapes = 2;
        boolean res =false;
       if (txtLogin.length()==0)
       {
           login.setError("Vous devez saisir ce champ");
           etapes--;
       }

       if (txtPassword.length()==0)
       {
           password.setError("Vous devez saisir ce champ");
           etapes--;
       }
       if (etapes==2)
           return true;
       else
           return false;
    }
}
