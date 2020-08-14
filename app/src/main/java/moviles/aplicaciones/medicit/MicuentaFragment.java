package moviles.aplicaciones.medicit;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

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
    SharedPreferences sharedPreferences;

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
        capturaDatos();

        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizzarUsuario();
                Intent i = new Intent(getContext(),PrincipalActivity.class);
                startActivity(i);
            }
        });


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


    private void cambiarImagen() {
        Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.setType("image/");
        startActivityForResult(i.createChooser(i,"Seleccione la aplicación"),10);
    }

    private void actualizzarUsuario() {
        conn = new ConexionSQLiteHelper(getContext(),"db_usuarios",null,1);
        SQLiteDatabase db=conn.getReadableDatabase();

        String dni=tv_dni.getText().toString();
        String nombre=tv_nombre.getText().toString();
        String apellidopaterno=tv_apellidopaterno.getText().toString();
        String apellidomaterno=tv_apellidomaterno.getText().toString();
        String correo=tv_correo.getText().toString();
        String celular=tv_celular.getText().toString();

        String[] parametros = {dni,nombre,apellidopaterno,apellidomaterno,correo,celular};

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_DNI,dni);
        values.put(Utilidades.CAMPO_NOMBRE,nombre);
        values.put(Utilidades.CAMPO_APELLIDOPATERNO,apellidopaterno);
        values.put(Utilidades.CAMPO_APELLIDOMATERNO,apellidomaterno);
        values.put(Utilidades.CAMPO_CORREO,correo);
        values.put(Utilidades.CAMPO_CELULAR,celular);

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_DNI+"=?",parametros);
        System.out.println("los datos de actualizaron");

        db.close();



    }

    public void capturaDatos(){
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getActivity().getApplicationContext())));
        String dni=sharedPreferences.getString("USUARIO_DNI","dni defecto");
        String nombre=sharedPreferences.getString("USUARIO_NOMBRE","nombre defecto");
        String apellidopaterno=sharedPreferences.getString("USUARIO_APATERNO","nombre defecto");
        String apellidomaterno=sharedPreferences.getString("USUARIO_AMATERNO","nombre defecto");
        String celular=sharedPreferences.getString("USUARIO_CELULAR","celular defecto");
        String correo=sharedPreferences.getString("USUARIO_CORREO","correo defecto");
        tv_dni.setText(dni);
        tv_nombre.setText(nombre);
        tv_apellidopaterno.setText(apellidopaterno);
        tv_apellidomaterno.setText(apellidomaterno);
        tv_correo.setText(correo);
        tv_celular.setText(celular);


    }


}
