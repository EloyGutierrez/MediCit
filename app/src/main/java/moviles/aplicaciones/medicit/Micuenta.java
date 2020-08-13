package moviles.aplicaciones.medicit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import static androidx.core.provider.FontsContractCompat.FontRequestCallback.RESULT_OK;

public class Micuenta extends AppCompatActivity {

    EditText tv_dni, tv_nombre, tv_apellidopaterno, tv_apellidomaterno, tv_correo, tv_celular;
    Button btnactualizar;
    ImageView imagen;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micuenta);
        tv_dni = findViewById(R.id.tv_dni);
        tv_nombre = findViewById(R.id.tv_nombre);
        tv_apellidopaterno = findViewById(R.id.tv_apellidopaterno);
        tv_apellidomaterno = findViewById(R.id.tv_apellidomaterno);
        tv_correo = findViewById(R.id.tv_correo);
        tv_celular = findViewById(R.id.tv_celular);
        btnactualizar = findViewById(R.id.btnactualizar);
        imagen = findViewById(R.id.imagenid);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btnactualizar:
                actualizzarUsuario();
                break;
            case R.id.btnatras:
                break;
            case R.id.cargarimagen:
                cambiarImagen();
        }


    }

    private void cambiarImagen() {
        Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.setType("image/");
        startActivityForResult(i.createChooser(i,"Seleccione la aplicación"),10);
    }


    private void actualizzarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String [] parametros={tv_dni.getText().toString()};
        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_NOMBRE, tv_nombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOPATERNO, tv_apellidopaterno.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOMATERNO, tv_apellidomaterno.getText().toString());
        values.put(Utilidades.CAMPO_CORREO, tv_correo.getText().toString());
        values.put(Utilidades.CAMPO_CELULAR, tv_celular.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_DNI+"=?",parametros);
        Toast.makeText(getContext(),"el usuario se actualizo",Toast.LENGTH_LONG).show();
        db.close();


    }

    private Context getContext() {
        return null;
    }
}