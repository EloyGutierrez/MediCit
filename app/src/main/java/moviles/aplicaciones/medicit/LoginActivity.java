package moviles.aplicaciones.medicit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
public void Principal(View view){
        Intent i =new Intent(this, PrincipalActivity.class);
        startActivity(i);
}
    public void Olvidemicontraseña(View view){
        Intent i =new Intent(this, Olvidemicontraseña.class);
        startActivity(i);
    }
}
