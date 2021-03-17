package com.example.ouifit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDD extends SQLiteOpenHelper {


    private static final String DB_NAME= "Sportifs";

private static final String TABLE_NAME = "Personne";
private static final String IDENTIFIANT = "Identifiant";
private static final int IDENTIFIANT_ID = 0;
private static final String NOM_PERSONNE = "Prénom";
private static final int NOM_PERSONNE_ID = 1;
private static final String EMAIL = "Adresse email";
private static final int EMAIL_ID = 2;
private static final String PASSWORD = "Password";
    private static final int PASSWORD_ID = 3;

private static final String TABLE_NAME2 = "Stats" ;
    private static final int IDENTIFIANT_ID2 = 0;
    private static final String POIDS = "Poids";
    private static final int POIDS_ID= 1;
    private static final String TAILLE ="Taille";
    private static final int TAILLE_ID = 2;
    private static final String TPS_ENTRAINEMENT = "Temps d'entraînement par semaine";
    private static final int TPS_ENTRAINEMENT_ID = 3;
    private static final String CALORIE_PERDU = "Calorie perdu par semaine";
    private static final int CALORIE_PERDU_ID = 4;

    private static final String REQUETE_CREA_DB = "CREATE DATABASE " + DB_NAME +";";

    private static final String REQUETE_CREA_TABLE1 = "CREATE TABLE " + TABLE_NAME + " ( " + IDENTIFIANT +
            " integer primary key autoincrement, " + NOM_PERSONNE + " text not null, " + EMAIL + "text not null, " + PASSWORD + " text not null"+" );";

    private static final String REQUETE_CREA_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + "(" + IDENTIFIANT +
            " integer primary key autoincrement, " + POIDS + " integer, " + TAILLE + " integer, " + TPS_ENTRAINEMENT + " integer, " + CALORIE_PERDU + " integer );";

    private SQLiteDatabase maBDD;

    public BDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Création d'une BDD avec deux tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(REQUETE_CREA_DB);
        db.execSQL(REQUETE_CREA_TABLE1);
        db.execSQL(REQUETE_CREA_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  db.d
    }



}
