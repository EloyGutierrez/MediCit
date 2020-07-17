package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ResponseCache;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void principal(View view){
        Intent i = new Intent(this,PrincipalActivity.class);
        startActivity(i);
    }




    public void Olvidemicontraseña(View view){
        Intent i = new Intent(this,Olvidemicontraseña.class);
        startActivity(i);
    }


}