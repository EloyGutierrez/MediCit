package moviles.aplicaciones.medicit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InformacionhospitalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacionhospital);
    }
    public void Login(View view){
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
