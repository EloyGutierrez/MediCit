package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ResponseCache;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        validarSesion();

    }

    public void Informacionhospital(View view){
        Intent i = new Intent(this,InformacionhospitalActivity.class);
        startActivity(i);
    }

    private void validarSesion(){
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((this.getApplicationContext())));
        String dni=sharedPreferences.getString("USUARIO_DNI",null);
        if (dni!=null){
            irPrincipal();
        }
    }
    private void irPrincipal(){
        Intent i =new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }

}