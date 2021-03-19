package com.example.ouifit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ouifit.ExerciceAbdo.Exercice1AbdoActivity;
import com.example.ouifit.Menu.MenuExercicesActivity;

public class InscriptionActivity extends Activity {

    private EditText identifiant;
    private EditText email;
    private EditText mdp1;
    private EditText mdp2;
    private Button bouton;

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


        //Bouton pour aller vers la page connection
        Button buttonVersConnection = (Button)findViewById(R.id.btConnection);
        buttonVersConnection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("Bouton exo 1","execute");
                Intent i = new Intent(InscriptionActivity.this, ConnectionActivity.class);
                startActivity(i);
            }
        });

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
/*
    public void onClick(View view)
    {
        if(view.getId() == R.id.btId)
        {
            String identifiantText = identifiant.getText().toString();
            String emailText = email.getText().toString();
            String MDP1Text = mdp1.getText().toString();
            String MDP2Text = mdp2.getText().toString();
            boolean concordance = MDP1Text.equals(MDP2Text);
            if (concordance)
            {
                try {
                    User user = new User(identifiantText,emailText,MDP1Text);// on doit créer un objet User permettant de sauvegarder les données d'un utilisateur
                    //On doit ajouter les utilisateurs à la BDD

                    //remise à zéro des champs du formaulaire
                    identifiant.setText(null);
                    email.setText(null);
                    mdp1.setText(null);
                    mdp2.setText(null);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

 */
}
