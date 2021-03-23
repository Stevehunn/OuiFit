package com.example.ouifit.Menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ouifit.BaseDeDonnee.BDD;
import com.example.ouifit.BaseDeDonnee.ConnexionActivity;
import com.example.ouifit.MainActivity;
import com.example.ouifit.MenuDeroulant.ContactActivity;
import com.example.ouifit.MenuDeroulant.OptionActivity;
import com.example.ouifit.R;
import com.google.android.material.navigation.NavigationView;

public class MenuStatActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener {


    /*------------------------Variables-----------------------*/
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem menuItem;
    BDD ourBDD;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_stat);

        drawerLayout = findViewById(R.id.drawner_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        menuItem = findViewById(R.menu.menu_option);

        /*------------------------Toolbar-----------------------*/
        //setSupportActionBar(toolbar);


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

        //Bouton pour aller vers le menu exercice
        Button buttonExercice = (Button) findViewById(R.id.btversExercice3);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuStatActivity.this, MenuExercicesActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le menu course
        Button buttonCourse = (Button) findViewById(R.id.btversCourse3);
        buttonCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuStatActivity.this, MenuCourseActivity.class);
                startActivity(i);
                onPause();
            }
        });
    }

    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onPause() {
        super.onPause();
        finish();
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
                Intent j = new Intent(MenuStatActivity.this, ContactActivity.class);
                startActivity(j);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                Intent k = new Intent(MenuStatActivity.this, MainActivity.class);
                startActivity(k);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/menu_principal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_option:
                Intent l = new Intent(MenuStatActivity.this, OptionActivity.class);
                startActivity(l);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_login:
                Intent m = new Intent(MenuStatActivity.this, ConnexionActivity.class);
                startActivity(m);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/login", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}