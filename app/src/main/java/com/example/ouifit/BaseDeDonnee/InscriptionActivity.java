package com.example.ouifit.BaseDeDonnee;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ouifit.MainActivity;
import com.example.ouifit.R;

public class InscriptionActivity extends AppCompatActivity {

    /*------------------------Variables-----------------------*/
    private EditText nom;
    private EditText email;
    private EditText mdp1;
    private EditText mdp2;
    private Button btInscription;
    public static BDD myDatabase ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        myDatabase = new BDD(this);
        nom = (EditText) findViewById(R.id.strIdInscription);
        email = (EditText) findViewById(R.id.strMailInscription);
        mdp1 = (EditText) findViewById(R.id.strMdp1);
        mdp2 = (EditText) findViewById(R.id.strMdp2);

        btInscription = (Button) findViewById(R.id.btId);
        btInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomText = nom.getText().toString();
                String emailText = email.getText().toString();
                String mdp1Text = mdp1.getText().toString();
                String mdp2Text = mdp2.getText().toString();


                if (test(nomText, emailText, mdp1Text, mdp2Text)) {
                    myDatabase.insertUser(nomText, emailText, mdp1Text);
                    myDatabase.close();
                    ConnexionActivity.isConnecter=true;
                    Log.i("DATABASE", "User create");
                    Intent i = new Intent(InscriptionActivity.this, MainActivity.class);
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(), "Vous devez compléter le formulaire correctement", Toast.LENGTH_LONG).show();
            }
        });


        /*------------------------BOUTON-----------------------*/

        //Bouton de retour pour aller vers le menu Principal
        Button buttonRetour = (Button) findViewById(R.id.btRetourInscription);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");
                Intent i = new Intent(InscriptionActivity.this, MainActivity.class);
                startActivity(i);
                onPause();
            }
        });


        //Bouton pour aller vers la page connection
        Button buttonVersConnection = (Button) findViewById(R.id.btVersConnexion);
        buttonVersConnection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1", "execute");

                //if (v.getId() == R.id.btConnection) {
                Intent i = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                startActivity(i);
                onPause();
                //  }
            }
        });


    }


    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onPause() {
        super.onPause();
        finish();
    }

    /*------------------------Test Validation enregistrement-----------------------*/
    public boolean test(String txtLogin, String textEmail, String textMdp1, String textMdp2) {
        if (txtLogin.length() != 0 && textEmail.length() != 0 && textMdp1.length() != 0 && textMdp2.length() != 0 && textMdp1.compareTo(textMdp2)==0) {
            Toast.makeText(getApplicationContext(), "Vous êtes inscrit", Toast.LENGTH_LONG).show();
            return true;
        } else {
       // if (txtLogin.length() == 0 || textEmail.length() ==0 || textMdp1.length()==0 || textMdp2.length()==0||textMdp1.compareTo(textMdp2) == 0){
            if (txtLogin.length() == 0) {
                nom.setError("Vous devez saisir ce champ");
            }
            if (textEmail.length() == 0) {
                email.setError("Vous devez saisir ce champ");
            }
            if (textMdp1.length() == 0) {
                mdp1.setError("Vous devez saisir ce champ");
            }
            if (textMdp2.length() == 0) {
                mdp2.setError("Vous devez saisir ce champ");
            }
            if (!textMdp1.equals(textMdp2)) {
                mdp1.setText(null);
                mdp2.setText(null);
                mdp2.setError("Ce mot de passe est différent de celui d'au-dessus");
            }
            return false;
        }
//        else
//            return true;

    }

}
