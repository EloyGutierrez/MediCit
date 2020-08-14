package moviles.aplicaciones.medicit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import moviles.aplicaciones.medicit.interfaces.IComunicaFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class PrincipalActivity extends AppCompatActivity implements IComunicaFragments, NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        //carga fragment predeterminado
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new PrincipalFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.inicio){

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new PrincipalFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.mi_cuenta){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentTransaction replace;
            replace = fragmentTransaction.replace(R.id.container_fragment, new MicuentaFragment());
            fragmentTransaction.commit();

        }
        if(item.getItemId() == R.id.ayuda){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new AyudaFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.pidetucita){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new PidetucitaFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.buscatumedico){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new BuscatumedicoFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.miscitas){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new MiscitasFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.consultatuseguro){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new ConsultatuseguroFragment());
            fragmentTransaction.commit();
        }

        if(item.getItemId() == R.id.cerrarsesion){
            sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((this.getApplicationContext())));
            sharedPreferences.edit().clear().apply();
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new cerrarsesion());
            fragmentTransaction.commit();

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);

        }
        return false;
    }


    @Override
    public void PideTuCita() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new PidetucitaFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void BuscaTuMedico() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new BuscatumedicoFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void MisCitas() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new MiscitasFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void ConsultaTuSeguro() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new ConsultatuseguroFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void CerrarSesion(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new cerrarsesion());
        fragmentTransaction.commit();
    }
}