package com.example.ouifit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ouifit.BaseDeDonnee.ConnexionActivity;
import com.example.ouifit.BaseDeDonnee.InscriptionActivity;
import com.example.ouifit.Menu.MenuCourseActivity;
import com.example.ouifit.Menu.MenuExercicesActivity;
import com.example.ouifit.Menu.MenuStatActivity;
import com.example.ouifit.MenuDeroulant.ContactActivity;
import com.example.ouifit.MenuDeroulant.OptionActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem menuItem;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawner_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        menuItem = findViewById(R.menu.menu_option);

        Button buttonStat = (Button) findViewById(R.id.btversStat);

        /*------------------------Toolbar-----------------------*/
        setSupportActionBar(toolbar);


        /*------------------------Montrer ou cacher items-----------------------*/
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profil).setVisible(false);

        /*utilisateur est connecté alors les boutons déconnexion et profil sont visible
        if (){
            menu.findItem(R.id.nav_logout).setVisible(true);
            menu.findItem(R.id.nav_profil).setVisible(true);
        }
        */


        /*-----------------------Navigation View + Drawer-----------------------*/

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_ouverture, R.string.navigation_drawer_fermeture);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
        /*------------------------BOUTON-----------------------*/

        //Bouton pour aller vers la page d'incription
        Button buttonInscription = (Button) findViewById(R.id.btversInscription);
        buttonInscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "inscription");
                Intent i = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers la page connexion
        Button buttonConnexion = (Button) findViewById(R.id.btVersConnection);
        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "connexion");
                buttonStat.setVisibility(View.VISIBLE);
                Intent i = new Intent(MainActivity.this, ConnexionActivity.class);
                startActivity(i);
            }
        });

        //Bouton pour aller vers le menu Stats

        buttonStat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "menu stat");
                Intent i = new Intent(MainActivity.this, MenuStatActivity.class);
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

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_contact:
                Intent j = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(j);
                Toast.makeText(getApplicationContext(), "@strings/option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                Intent k = new Intent(MainActivity.this, MainActivity.class);
                startActivity(k);
                Toast.makeText(getApplicationContext(), "@strings/menu_principal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_option:
                Intent l = new Intent(MainActivity.this, OptionActivity.class);
                startActivity(l);
                Toast.makeText(getApplicationContext(), "@strings/option", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


/*
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){


        switch (menuItem.getItemId()) {

            case R.id.nav_contact:
                Intent i = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "@strings/contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                Intent j = new Intent(MainActivity.this, MainActivity.class);
                startActivity(j);
                Toast.makeText(getApplicationContext(), "@strings/menu_principal", Toast.LENGTH_SHORT).show();
                break;

        }

        return true;

    }
*/

}