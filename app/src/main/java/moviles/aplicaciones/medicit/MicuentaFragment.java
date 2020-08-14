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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Objects;

import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import static android.app.Activity.RESULT_OK;


public class MicuentaFragment extends Fragment {
    Button btnactualizar;
    ImageView imagen;
    TextView edtdni;
    EditText  edtnombre, edtapellidopaterno, edtapellidomaterno, edtcorreo, edtcelular, edtcontrasenia,  edtcontraseniaa;
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

        edtdni = view.findViewById(R.id.edtdni);
        edtnombre = view.findViewById(R.id.edtnombre);
        edtapellidopaterno = view.findViewById(R.id.edtapellidopaterno);
        edtapellidomaterno = view.findViewById(R.id.edtapellidomaterno);
        edtcorreo = view.findViewById(R.id.edtcorreo);
        edtcelular = view.findViewById(R.id.edtcelular);
        edtcontrasenia = view.findViewById(R.id.edtcontrasenia);
        edtcontraseniaa = view.findViewById(R.id.edtcontraseniaa);
        btnactualizar=view.findViewById(R.id.btnActualizar);
        capturaDatos();

        btnactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contrasenia=edtcontrasenia.getText().toString();
                String contraseniaa=edtcontraseniaa.getText().toString();



                if (contrasenia.equals(contraseniaa)){
                    actualizarUsuario();
                    Intent intent= new Intent(getContext(),LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;

    }




    private void actualizarUsuario() {
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getActivity().getApplicationContext())));

        String nombre =edtnombre.getText().toString();
        String apellidop =edtapellidopaterno.getText().toString();
        String apellidom =edtapellidomaterno.getText().toString();
        String sexo=sharedPreferences.getString("USUARIO_SEXO","correo defecto");
        String fechanacimiento=sharedPreferences.getString("USUARIO_FECHAN","correo defecto");
        String seguro=sharedPreferences.getString("USUARIO_SEGURO","correo defecto");
        String  correo=edtcorreo.getText().toString();
        String celular =edtcelular.getText().toString();
        String contrasenia =edtcontrasenia.getText().toString();
        String contraseniaa =edtcontraseniaa.getText().toString();
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(getContext(),"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros ={edtdni.getText().toString()};

        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,nombre);
        values.put(Utilidades.CAMPO_APELLIDOPATERNO,apellidop);
        values.put(Utilidades.CAMPO_APELLIDOMATERNO,apellidom);
        values.put(Utilidades.CAMPO_SEXO,sexo);
        values.put(Utilidades.CAMPO_FECHADENACIMIENTO,fechanacimiento);
        values.put(Utilidades.CAMPO_CELULAR,celular);
        values.put(Utilidades.CAMPO_CORREO,correo);
        values.put(Utilidades.CAMPO_SEGURO,seguro);
        values.put(Utilidades.CAMPO_CONTRASENIA,contrasenia);

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_DNI+"=?",parametros);
        Toast.makeText(getContext(),"se actualizo los datos del usuario",Toast.LENGTH_LONG).show();
        db.close();




    }

    public void capturaDatos(){
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getActivity().getApplicationContext())));
        String dni=sharedPreferences.getString("USUARIO_DNI","dni defecto");
        String pass=sharedPreferences.getString("USUARIO_PASS","dni defecto");
        String nombre=sharedPreferences.getString("USUARIO_NOMBRE","nombre defecto");
        String apellidopaterno=sharedPreferences.getString("USUARIO_APATERNO","nombre defecto");
        String apellidomaterno=sharedPreferences.getString("USUARIO_AMATERNO","nombre defecto");
        String celular=sharedPreferences.getString("USUARIO_CELULAR","celular defecto");
        String correo=sharedPreferences.getString("USUARIO_CORREO","correo defecto");


        edtdni.setText(dni);
        edtnombre.setText(nombre);
        edtapellidopaterno.setText(apellidopaterno);
        edtapellidomaterno.setText(apellidomaterno);
        edtcorreo.setText(correo);
        edtcelular.setText(celular);
        edtcontrasenia.setText(pass);
        edtcontraseniaa.setText(pass);



    }


}
