package moviles.aplicaciones.medicit;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.interfaces.IComunicaFragments;

public class Login extends AppCompatActivity {
    EditText nombres,contraseña;
    Button registrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombres= (EditText) findViewById(R.id.registro_nombres);
        contraseña= (EditText) findViewById(R.id.registro_contraseña);
        registrar= (Button) findViewById(R.id.registrar);

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new Login();
            }
        });

    }


}
