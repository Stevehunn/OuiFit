package com.example.ouifit.Menu;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ouifit.BaseDeDonnee.BDD;
import com.example.ouifit.BaseDeDonnee.ConnexionActivity;
import com.example.ouifit.MainActivity;
import com.example.ouifit.MenuDeroulant.ContactActivity;
import com.example.ouifit.MenuDeroulant.OptionActivity;
import com.example.ouifit.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

public class MenuCourseActivity extends Activity implements LocationListener, NavigationView.OnNavigationItemSelectedListener {

    /*
    ,OnMapReadyCallback,
        GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener
     */

    /*------------------------Variables-----------------------*/
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    MenuItem menuItem;
    BDD ourBDD;

    private static final int PERMS_CALL_ID = 1234;
    private LocationManager lm;
    private MapFragment mapFragment;
    private GoogleMap googleMap;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_course);

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


        /*------------------------Fragment-----------------------*/
        FragmentManager fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map);

        /*------------------------BOUTON-----------------------*/

        Button buttonStart = (Button) findViewById(R.id.btStart);
        Button buttonStop = (Button) findViewById(R.id.btStop);

        //Bouton Start
        buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                buttonStart.setVisibility(View.INVISIBLE);
                buttonStop.setVisibility(View.VISIBLE);

            }
        });

        //Bouton Stop
        buttonStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                buttonStart.setVisibility(View.VISIBLE);
                buttonStop.setVisibility(View.INVISIBLE);

            }
        });

        //Bouton pour aller vers le menu stat
        Button buttonStat = (Button) findViewById(R.id.btversStat2);
        buttonStat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuCourseActivity.this, MenuStatActivity.class);
                startActivity(i);
                onPause();
            }
        });

        //Bouton pour aller vers le menu exercice
        Button buttonExercice = (Button) findViewById(R.id.btversExercice2);
        buttonExercice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MenuCourseActivity.this, MenuExercicesActivity.class);
                startActivity(i);
                onPause();
            }
        });

        /*------------------------Montrer ou cacher items-----------------------*/

        buttonStart.setVisibility(View.VISIBLE);
        buttonStop.setVisibility(View.INVISIBLE);


    }

    /*------------------------Cycle de vie de l'activité-----------------------*/

    @Override
    protected void onResume() {
        super.onResume();
        checkPermissions();
    }

    private void checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMS_CALL_ID);
            return;
        }

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this);
        }
        if (lm.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
            lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 1000, 0, this);
        }
        if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, this);
        }
        loadMap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMS_CALL_ID) {
            checkPermissions();
        }
    }

    protected void onPause() {
        super.onPause();
        if (lm != null) {
            lm.removeUpdates(this);
        }
    }

    @SuppressWarnings("MissingPermission")
    private void loadMap() {
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                MenuCourseActivity.this.googleMap = googleMap;
                googleMap.moveCamera(CameraUpdateFactory.zoomBy(25));
                googleMap.setMyLocationEnabled(true);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(47.5860921, 1.3359475)).title("Blois"));
            }
        });
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();


        Toast.makeText(this, "Location: " + latitude + "/" + longitude, Toast.LENGTH_LONG).show();
        if (googleMap != null) {
            LatLng googleLocation = new LatLng(latitude, longitude);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(googleLocation));
        }
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this tutorial, we add polylines and polygons to represent routes and areas on the map.
     */
    /*
    public void onMapReady(Location location,GoogleMap googleMap) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        // Add polylines to the map.
        // Polylines are useful to show a route or some other connection between points.
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(latitude, longitude)

                ));

        // Set listeners for click events.
        googleMap.setOnPolylineClickListener(this);
        googleMap.setOnPolygonClickListener(this);
    }


    @Override
    public void onPolygonClick(Polygon polygon) {

    }

    @Override
    public void onPolylineClick(Polyline polyline) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
    */
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
                Intent j = new Intent(MenuCourseActivity.this, ContactActivity.class);
                startActivity(j);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                Intent k = new Intent(MenuCourseActivity.this, MainActivity.class);
                startActivity(k);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/menu_principal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_option:
                Intent l = new Intent(MenuCourseActivity.this, OptionActivity.class);
                startActivity(l);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_login:
                Intent m = new Intent(MenuCourseActivity.this, ConnexionActivity.class);
                startActivity(m);
                onPause();
                Toast.makeText(getApplicationContext(), "@strings/login", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
