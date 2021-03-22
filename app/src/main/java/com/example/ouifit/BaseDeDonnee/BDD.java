package com.example.ouifit.BaseDeDonnee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDD extends SQLiteOpenHelper {
    private static final String BDD_NOM = "InscritEtStats";
    public static SQLiteDatabase maBDD;
    private int version;

    //le nom de la table
    public static final String TABLE_NAME = "Inscrit";
//Instanciation des éléments du tableau avec leurs positions
    public static final String IDENTIFIANT = "Identifiant";
    private static final int IDENTIFIANT_ID = 0;
    public static final String NOM_PERSONNE = "Prénom";
    private static final int NOM_PERSONNE_ID = 1;
    public static final String EMAIL = "Adresse email";
    private static final int EMAIL_ID = 2;
    public static final String PASSWORD = "Password";
    private static final int PASSWORD_ID = 3;
    private static final String POIDS = "Poids";
    private static final int POIDS_ID= 4;
    private static final String TAILLE ="Taille";
    private static final int TAILLE_ID = 5;
    private static final String TPS_ENTRAINEMENT = "Temps d'entraînement par semaine";
    private static final int TPS_ENTRAINEMENT_ID = 6;
    private static final String CALORIE_PERDU = "Calorie perdu par semaine";
    private static final int CALORIE_PERDU_ID = 7;

//requête de création de la BDD
    private static final String REQUETE_CREA_TABLE1 = "CREATE TABLE " + TABLE_NAME + " ( " + IDENTIFIANT +
            " integer primary key autoincrement, " + NOM_PERSONNE + " text not null, " + EMAIL + "text not null, " + PASSWORD + " text not null, "
            + POIDS + " integer, " + TAILLE + " integer, " + TPS_ENTRAINEMENT + " integer , " + CALORIE_PERDU + " integer );";

    public static BDD baseHelper;

    public BDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        baseHelper = new BDD(context, BDD_NOM ,null, version);
    }

    //Création d'une BDD avec une table
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(REQUETE_CREA_TABLE1);
        version++;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP table if exists " + TABLE_NAME + ";");
        onCreate(db);
        version=newVersion;
    }

    //ouverture de la bdd en mode écriture
    public static SQLiteDatabase openE()
    {
        maBDD = baseHelper.getWritableDatabase();
        return maBDD;
    }

    //ouverture de la BDD en mode lecture seule
    public static SQLiteDatabase openL()
    {
        maBDD = baseHelper.getReadableDatabase();
        return maBDD;
    }
}
