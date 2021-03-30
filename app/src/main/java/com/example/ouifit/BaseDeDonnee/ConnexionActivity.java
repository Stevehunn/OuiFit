 package com.example.ouifit.BaseDeDonnee;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class ConnexionActivity extends AppCompatActivity {

    /*------------------------Variables-----------------------*/
    EditText login;
    EditText password;
    Button btnConnect;
    public static boolean isConnecter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

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

        btnConnect = (Button) findViewById(R.id.btConnexion);
        btnConnect.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                    InscriptionActivity.myDatabase = new BDD(getApplicationContext());
                    String txtLogin = login.getText().toString();
                    String txtPassword = password.getText().toString();
                    //requête pour voir si l'utilisateurs qui rentre ses données est présent dans la BDD
                    String strSql = "Select " + BDD.NOM_PERSONNE + ", " + BDD.PASSWORD + " from " + BDD.TABLE_NAME +
                            " where " + BDD.NOM_PERSONNE + " = '" + txtLogin +
                            "' AND " + BDD.PASSWORD + " = '" + txtPassword + "';";

                    Cursor cursor;
                    Log.i("CONNECTION", "Select invoked");

                    //si les tests primaires sont correct
                    if (test(txtLogin, txtPassword)) {
                        //on pose la requête

                        cursor =  (InscriptionActivity.myDatabase).getReadableDatabase().rawQuery(strSql, null);
                        cursor.moveToFirst();
                        //Si la requête renvoit quelque chose => l'utilisateur est inscrit, et son mdp et son login sont les bons
                        if (!cursor.isAfterLast()) {
                            //remise des champs du formulaire à leur état d'origine
                            login.setText(null);
                            password.setText(null);
                            isConnecter = true;
                            Intent i = new Intent(ConnexionActivity.this, MainActivity.class);
                            startActivity(i);
                            Toast.makeText(getApplicationContext(), "Vous êtes connecté", Toast.LENGTH_LONG).show();

                        } else //si elle ne renvoit rien, => l'utilisateur n'est pas inscrit
                        {
                            //remise des champs du formulaire à leur état d'origine
                            login.setText(null);
                            password.setText(null);
                            Intent i = new Intent(ConnexionActivity.this, InscriptionActivity.class);
                            Toast.makeText(ConnexionActivity.this, "Vous avez été redirigé vers la page d'inscription car vous n'êtes pas inscrit", Toast.LENGTH_LONG).show();
                            startActivity(i);
                            isConnecter = false;
                            onPause();
                        }
                        cursor.close();
                    } else {
                        //remise des champs du formulaire à leur état d'origine
                        Toast.makeText(getApplicationContext(), "Vous devez remplir tout les champs de saisies.", Toast.LENGTH_SHORT).show();
                    }
                }


        });

    }

    public static boolean getConnecter (boolean test)
    {
        return test;
    }

    /*@Override
    public void onClick (View view)
    {

        btnConnect = (Button) findViewById(R.id.btConnection);
        btnConnect.
        );
        if(view.getId() == R.id.btConnection)
        {
            String txtLogin = login.getText().toString();
            String txtPassword = password.getText().toString();
            //requête pour voir si l'utilisateurs qui rentre ses données est présent dans la BDD
            String strSql = "Select " + BDD.NOM_PERSONNE + ", "+ BDD.PASSWORD + " from " + BDD.TABLE_NAME +
                    " where " + BDD.NOM_PERSONNE + " = '" + txtLogin +
                    "' AND " + BDD.PASSWORD + " = '" + txtPassword + "';";
            Cursor cursor;
            Log.i("CONNECTION", "onUpgrade invoquée");

            //on effectue les tests primaires
            if(test(txtLogin,txtPassword))
            {
                //on pose la requête
                cursor = BDD.maBDD.getReadableDatabase().rawQuery(strSql,null);
                cursor.moveToFirst();
                //Si la requête renvoit quelque chose => l'utilisateur est inscrit, et son mdp et son login sont les bons
                if(!cursor.isAfterLast())
                {
                    //remise des champs du formulaire à leur état d'origine
                    login.setText(null);
                    password.setText(null);
                    Intent i = new Intent (ConnexionActivity.this, MainActivity.class);
                    startActivity(i);
                } else //si elle ne renvoit rien, => l'utilisateur n'est pas inscrit
                {
                    //remise des champs du formulaire à leur état d'origine
                    login.setText(null);
                    password.setText(null);
                    Intent i = new Intent ( ConnexionActivity.this, InscriptionActivity.class);
                    Toast.makeText(ConnexionActivity.this, "Vous allez être redirigé vers la page d'inscription", Toast.LENGTH_LONG).show();
                    startActivity(i);

                }
            }
            else
            {
                //remise des champs du formulaire à leur état d'origine
                login.setText(null);
                password.setText(null);
                Toast.makeText(this, "Vous devez remplir tout les champs de saisies." , Toast.LENGTH_SHORT).show();

            }
        }
    }
*/
    /*------------------------Cycle de vie de l'activit&eacute;-----------------------*/
    protected void onPause() {
        super.onPause();
        finish();
    }

    //test pour voir si les champs sont remplis
    public boolean test(String txtLogin, String txtPassword) {
        if(txtLogin.length()!=0 && txtPassword.length()!=0)
            return true;
        else {
            if (txtLogin.length() == 0)
                login.setError("Vous devez saisir ce champ");
            if (txtPassword.length() == 0)
                password.setError("Vous devez saisir ce champ");
            return false;
        }


    }


}
