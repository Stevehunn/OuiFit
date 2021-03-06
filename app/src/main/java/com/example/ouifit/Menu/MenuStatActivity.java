package com.example.ouifit.Menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import com.example.ouifit.MainActivity;
import com.example.ouifit.MenuDeroulant.ContactActivity;
import com.example.ouifit.MenuDeroulant.OptionActivity;
import com.example.ouifit.MenuDeroulant.ProfilActivity;
import com.example.ouifit.R;
import com.google.android.material.navigation.NavigationView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.ouifit.BaseDeDonnee.BDD.IDENTIFIANT;
import static com.example.ouifit.BaseDeDonnee.BDD.POIDS;
import static com.example.ouifit.BaseDeDonnee.BDD.TABLE_NAME;


public class MenuStatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    /*------------------------Variables-----------------------*/
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem menuItem;
    BDD ourBDD;
    GraphView graph;
    TextView text;

    /*
    BarChart barChart;
    int poids =100;
    int poids2 =97;
    int poids3 =94;
    int poids4 =90;
    int poids5 =80;
*/

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_stat);

        drawerLayout = findViewById(R.id.drawner_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        menuItem = findViewById(R.menu.menu_option);

        graph = (GraphView) findViewById(R.id.line_graph1);
        /*----------------Graph avec les donn??es non fonctionnels----------*/
        //String[] mois = {"Janvier", "F??vrier", "Mars","Avril","Mai","Juin","Juillet","Ao??t", "Septembre","Octobre","Novembre","D??cembre"};
        //barChart =(BarChart) findViewById(R.id.bargraph);
        String strSql = "Select " + POIDS + " from " + TABLE_NAME + " Where " + IDENTIFIANT + " = " + BDD.getId();
        Cursor cursor = (InscriptionActivity.myDatabase).getReadableDatabase().rawQuery(strSql, null);
        cursor.moveToFirst();

        // int i =-1;
        //si le cursor n'est pas au dernier emplacement alors il contient quelque chose
        /*if (!cursor.isAfterLast()) {
             LineGraphSeries<DataPoint> lineGraphSeries = new LineGraphSeries<>();
            while (!cursor.isAfterLast()) {
                i++;
                //tant que le curseur n'est pas sur le dernier taquet, il cr??e des DataPoint
                lineGraphSeries = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(new Date().getTime(), cursor.getInt(i))
                 });
            }
            graph.addSeries(lineGraphSeries);



        }*/
        /*----------- Graph sans les donn??es--------*/
        LineGraphSeries<DataPoint> lineGraphSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,5),
                new DataPoint(1,15),
                new DataPoint(2,20)
        });
        graph.addSeries(lineGraphSeries);

        /*------------------------Graph-----------------------
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(poids ,0));
        barEntries.add(new BarEntry(poids2 ,1));
        barEntries.add(new BarEntry(poids3 ,3));
        barEntries.add(new BarEntry(poids4 ,4));
        barEntries.add(new BarEntry(poids5 ,5));
        BarDataSet barDataSet =new BarDataSet(barEntries,"Dates");

        ArrayList<String> theDates =new ArrayList<>();
        theDates.add("Janvier");
        theDates.add("F??vrier");
        theDates.add("Mars");
        theDates.add("Avril");
        theDates.add("Mai");
        theDates.add("Juin");


        Dates.add("Juillet");
        Dates.add("Aout");
        Dates.add("Septembre");
        Dates.add("Octobre");
        Dates.add("Novembre");
        Dates.add("D??cembre");


        BarData theData = new BarData((IBarDataSet) theDates,barDataSet);
        barChart.setData(theData);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
*/

        /*------------------------Montrer ou cacher items-----------------------*/
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profil).setVisible(false);

        //l'utilisateur est connect?? donc le menu affiche "d??connexion" et "profil"
        if (ConnexionActivity.getConnecter(ConnexionActivity.isConnecter) == true){
            menu.findItem(R.id.nav_logout).setVisible(true);
            menu.findItem(R.id.nav_profil).setVisible(true);
            menu.findItem(R.id.nav_login).setVisible(false);
            Log.i("bouton" , "les boutons sont visibles");
        }
        //il est deconnect?? alors seul le bouton "se connecter" est visible
        else
        {
            menu.findItem(R.id.nav_logout).setVisible(false);
            menu.findItem(R.id.nav_profil).setVisible(false);
            menu.findItem(R.id.nav_login).setVisible(true);
        }

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

    /*------------------------Cycle de vie de l'activit??-----------------------*/
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


    /*------------------------Methode pour le Menu-----------------------*/
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }
    }

//    public void insertData(){
//        long xValue = new Date().getTime();
//        String strSql = "select " + POIDS +
//                " from "+ TABLE_NAME +
//                " where " + IDENTIFIANT + " = " + BDD.();
//    }


    /*----------- Gestion du menu d??roulant dans les statistiques-------------*/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_contact:
                Intent j = new Intent(MenuStatActivity.this, ContactActivity.class);
                startActivity(j);
                onPause();
                break;
            case R.id.nav_home:
                Intent k = new Intent(MenuStatActivity.this, MainActivity.class);
                startActivity(k);
                onPause();
                break;
            case R.id.nav_option:
                Intent l = new Intent(MenuStatActivity.this, OptionActivity.class);
                startActivity(l);
                onPause();
                break;
            case R.id.nav_login:
                Intent m = new Intent(MenuStatActivity.this, ConnexionActivity.class);
                startActivity(m);
                onPause();
                break;
            case R.id.nav_logout :
                Intent n = new Intent(MenuStatActivity.this, MainActivity.class);
                startActivity(n);
                onPause();
                Toast.makeText(getApplicationContext(),"D??connect??", Toast.LENGTH_SHORT).show();
                ConnexionActivity.isConnecter = false;
                break;
            case R.id.nav_profil :
                Intent o = new Intent(MenuStatActivity.this, ProfilActivity.class);
                startActivity(o);
                onPause();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}