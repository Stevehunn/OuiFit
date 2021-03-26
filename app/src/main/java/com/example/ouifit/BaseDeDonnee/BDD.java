package com.example.ouifit.BaseDeDonnee;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.ouifit.ExerciceAbdo.Exercice1AbdoActivity;

public class BDD extends SQLiteOpenHelper {
    public static final String BDD_NOM = "InscritEtStats.db";
    public static final int DATABASE_VERSION =10;

    //le nom de la table
    public static final String TABLE_NAME = "Inscrit";
//Instanciation des éléments du tableau avec leurs positions
    public static final String IDENTIFIANT = "Identifiant";
    public static final String NOM_PERSONNE = "Prénom";
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";
    public static final String POIDS = "Poids";
    private static final String TAILLE ="Taille";
    private static final String TPS_ENTRAINEMENT = "TempsEntraînementParSemaine";
    private static final String CALORIE_PERDU = "CaloriePerduParSemaine";

    public static BDD maBDD;

    public BDD(Context context)
    {
        super(context, BDD_NOM, null, DATABASE_VERSION);
        //baseHelper = new BDD(context);
    }


    //Création d'une BDD avec une table
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //requête de création de la BDD
        String REQUETE_CREA_TABLE = "Create table Inscrit ( "
                + "Identifiant integer primary key autoincrement, "
                + NOM_PERSONNE + " text not null, "
                + EMAIL +" text not null, "
                + PASSWORD + " text not null, "
                + POIDS + " integer, "
                + TAILLE + " integer, "
                + TPS_ENTRAINEMENT + " integer, "
                + CALORIE_PERDU + " integer)";
        db.execSQL(REQUETE_CREA_TABLE);
        Log.i("DATABASE", "onCreate invoked");
    }
//Amélioration d'une BDD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String strSql = "drop table Inscrit";
        db.execSQL(strSql);
        this.onCreate(db);
        Log.i("DATABASE", "onUpgrade invoquée");

    }
    /*------------Méthode pour ajouter un nouvel utilisateur à la BDD----------*/

    public void insertUser(String login, String email, String password)
    {
        login = login.replace("'","''");
        email = email.replace("'","''");
        password = password.replace("'","''");

        String strSQL = "Insert into Inscrit ( " +
                NOM_PERSONNE + ", "
                + EMAIL + ", "
                + PASSWORD + ") VALUES ('"
                + login + "', '"
                + email + "', '"
                + password +"')";
        //en écriture
        this.getWritableDatabase().execSQL(strSQL);
        Log.i("DATABASE", "insertUser invoquée");

    }
}
