package moviles.aplicaciones.medicit;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import static android.app.Activity.RESULT_OK;


public class MicuentaFragment extends Fragment {
    EditText tv_dni, tv_nombre, tv_apellidopaterno, tv_apellidomaterno, tv_correo, tv_celular;
    Button btnactualizar;
    ImageView imagen;

    ConexionSQLiteHelper conn;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_micuenta,container,false);

        conn = new ConexionSQLiteHelper(getContext(),"db_usuarios",null,1);

        tv_dni = view.findViewById(R.id.tv_dni);
        tv_nombre = view.findViewById(R.id.tv_nombre);
        tv_apellidopaterno = view.findViewById(R.id.tv_apellidopaterno);
        tv_apellidomaterno = view.findViewById(R.id.tv_apellidomaterno);
        tv_correo = view.findViewById(R.id.tv_correo);
        tv_celular = view.findViewById(R.id.tv_celular);
        btnactualizar = view.findViewById(R.id.btnactualizar);
        imagen = view.findViewById(R.id.imagenid);

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
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


}
