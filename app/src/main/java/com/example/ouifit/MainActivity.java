package com.example.ouifit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ouifit.Menu.MenuCourseActivity;
import com.example.ouifit.Menu.MenuExercicesActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawner_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //Toolbar
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_ouverture, R.string.navigation_drawer_fermeture);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //Bouton pour aller vers la page de connection
        Button buttonConnection = (Button) findViewById(R.id.btVersConnection);
        buttonConnection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "connection");
                Intent i = new Intent(MainActivity.this, ConnectionActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers la page d'incription
        Button buttonInscription = (Button) findViewById(R.id.btversInscription);
        buttonInscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "inscription");
                Intent i = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu exercice
        Button buttonExercice = (Button) findViewById(R.id.btversExercice0);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "menu exercice");
                Intent i = new Intent(MainActivity.this, MenuExercicesActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu course
        Button buttonCourse = (Button) findViewById(R.id.btversCourse0);
        buttonCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "menu course");
                Intent i = new Intent(MainActivity.this, MenuCourseActivity.class);
                startActivity(i);
            }
        });


    }
}