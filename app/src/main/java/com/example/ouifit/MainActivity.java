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

import com.example.ouifit.BaseDeDonnee.BDD;
import com.example.ouifit.BaseDeDonnee.ConnexionActivity;
import com.example.ouifit.BaseDeDonnee.InscriptionActivity;
import com.example.ouifit.Menu.MenuCourseActivity;
import com.example.ouifit.Menu.MenuExercicesActivity;
import com.example.ouifit.Menu.MenuStatActivity;
import com.example.ouifit.MenuDeroulant.ContactActivity;
import com.example.ouifit.MenuDeroulant.OptionActivity;
import com.example.ouifit.MenuDeroulant.ProfilActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem menuItem;
    BDD ourBDD;


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
        Button buttonInscription = (Button) findViewById(R.id.btversInscription);
        Button buttonConnexion = (Button) findViewById(R.id.btVersConnection);

        /*------------------------Toolbar-----------------------*/
        setSupportActionBar(toolbar);



        /*------------------------Montrer ou cacher items-----------------------*/
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profil).setVisible(false);


        /* l'utilisateur est connecté alors les boutons déconnexion et profil ainsi que stat sont visible*/
        if (ConnexionActivity.getConnecter(ConnexionActivity.isConnecter) == true){
            menu.findItem(R.id.nav_logout).setVisible(true);
            menu.findItem(R.id.nav_profil).setVisible(true);
            menu.findItem(R.id.nav_login).setVisible(false);
            buttonStat.setVisibility(View.VISIBLE);
            buttonConnexion.setVisibility(View.INVISIBLE);
            Log.i("bouton" , "les boutons sont visibles");
        }
        /*il est deconnecté alors seul le bouton "se connecter" est visible*/
        else
        {
            menu.findItem(R.id.nav_logout).setVisible(false);
            menu.findItem(R.id.nav_profil).setVisible(false);
            menu.findItem(R.id.nav_login).setVisible(true);
            buttonStat.setVisibility(View.INVISIBLE);
            buttonConnexion.setVisibility(View.VISIBLE);
        }



        /*-----------------------Navigation View + Drawer-----------------------*/

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_ouverture, R.string.navigation_drawer_fermeture);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        /*------------------------BOUTON-----------------------*/

        //Bouton pour aller vers la page d'incription

        buttonInscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "inscription");
                Intent i = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers la page connexion
        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "connexion");

                Intent i = new Intent(MainActivity.this, ConnexionActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le menu Stats
        buttonStat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "menu stat");
                Intent i = new Intent(MainActivity.this, MenuStatActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le menu exercice
        Button buttonExercice = (Button) findViewById(R.id.btversExercice0);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "menu exercice");
                Intent i = new Intent(MainActivity.this, MenuExercicesActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le menu course
        Button buttonCourse = (Button) findViewById(R.id.btversCourse0);
        buttonCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("MainActivity", "menu course");
                Intent i = new Intent(MainActivity.this, MenuCourseActivity.class);
                startActivity(i);
                onPause();
            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putInt();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /*------------------------Methode pour le Menu-----------------------*/
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }
    }

    /*----------- Gestion du menu déroulant dans l'écran d'acceuil-------------*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_contact:
                Intent j = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(j);
                onPause();
                break;
            case R.id.nav_home:
                Intent k = new Intent(MainActivity.this, MainActivity.class);
                startActivity(k);
                onPause();
                break;
            case R.id.nav_option:
                Intent l = new Intent(MainActivity.this, OptionActivity.class);
                startActivity(l);
                onPause();
                break;
            case R.id.nav_login:
                Intent m = new Intent(MainActivity.this, ConnexionActivity.class);
                startActivity(m);
                onPause();
                break;
            case R.id.nav_profil :
                Intent o = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(o);
                onPause();
                break;
            case R.id.nav_logout :
                Intent n = new Intent(MainActivity.this, MainActivity.class);
                startActivity(n);
                onPause();
                Toast.makeText(getApplicationContext(),"Déconnecté", Toast.LENGTH_SHORT).show();
                ConnexionActivity.isConnecter = false;
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onDestroy() {
        super.onDestroy();
    }


}