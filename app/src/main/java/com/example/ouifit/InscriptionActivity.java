package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InscriptionActivity extends Activity implements  View.OnClickListener{


    private int identifiant =0;
    private EditText nom;
    private EditText email;
    private EditText mdp1;
    private EditText mdp2;
    private Button btId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        //Bouton de retour pour aller vers le menu Principal
        Button buttonRetour = (Button)findViewById(R.id.btRetourInscription);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(InscriptionActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

/*
        //Bouton pour aller vers la page connection
        Button buttonVersConnection = (Button)findViewById(R.id.btConnection);
        buttonVersConnection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(InscriptionActivity.this, ConnectionActivity.class);
                startActivity(i);
            }
        });
*/
        //Bouton pour aller vers la page MainConnectActivity
        Button buttonVersMainConnect = (Button)findViewById(R.id.btId);
        buttonVersMainConnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(InscriptionActivity.this, MainConnectActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View view)
    {
        //Si le clique est bien sur le bouton "S'inscrire"
        if(view.getId() == R.id.btId)
        {
            //on récupère tout les champs
            String nomText = nom.getText().toString();
            String emailText = email.getText().toString();
            String MDP1Text = mdp1.getText().toString();
            String MDP2Text = mdp2.getText().toString();
            //on vérifie si le MDP1 est le même que le MDP2
            boolean concordance = MDP1Text.equals(MDP2Text);
            boolean test = nomText.isEmpty()||emailText.isEmpty()||MDP1Text.isEmpty()||MDP2Text.isEmpty();
            //création d'un nouveau sportif
            if (concordance && !test)
            {
                try {
                    identifiant++;
                    //ajout d'un nouvel utilisateur à la BDD
                    BDD.openE();
                    BDD.maBDD.execSQL("Insert Into " + BDD.TABLE_NAME + "( " + BDD.IDENTIFIANT +", "+ BDD.NOM_PERSONNE +", "+ BDD.EMAIL +", "+ BDD.PASSWORD + ") " +
                            "VALUES ( '" + identifiant +"', '"+ nomText  +"', '"+ emailText +"', '"+  MDP1Text +"');" );

                    //remise à zéro des champs du formulaire
                    nom.setText(null);
                    email.setText(null);
                    mdp1.setText(null);
                    mdp2.setText(null);
                    //renvoies à la page d'acceuil connecté
                    Intent i = new Intent(InscriptionActivity.this, MainConnectActivity.class);
                    startActivity(i);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {

            }
        }
    }



}
