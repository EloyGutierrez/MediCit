package moviles.aplicaciones.medicit;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import static androidx.core.provider.FontsContractCompat.FontRequestCallback.RESULT_OK;

public class Configuracion extends Fragment implements View.OnClickListener{
    EditText edtdni, edtnombre, edtapellidopaterno, edtapellidomaterno, edtcorreo, edtcelular;
    Button btnactualizar;
    Intent x;
    ImageView imagen;

     ConexionSQLiteHelper conn;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view = i.inflate(R.layout.activity_configuracion, container, false);
        edtnombre = view.findViewById(R.id.edtnombre);
        edtapellidopaterno = view.findViewById(R.id.edtapellidopaterno);
        edtapellidomaterno = view.findViewById(R.id.edtapellidomaterno);
        edtcorreo = view.findViewById(R.id.edtcorreo);
        edtcelular = view.findViewById(R.id.edtcelular);
        btnactualizar = view.findViewById(R.id.btnactualizar);
        imagen=view.findViewById(R.id.imagenid);

        return view;

    }

    public void onclick(){
        cargarImagen();
    }

    private void cargarImagen() {
        Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.setType("image/");
        startActivityForResult(i.createChooser(i,"Seleccione la aplicación"),10);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnactualizar: actualizzarUsuario();
                break;
            case R.id.btnatras:

                break;
        }

    }



    private void actualizzarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String [] parametros={edtdni.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, edtnombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOPATERNO, edtapellidopaterno.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOMATERNO, edtapellidomaterno.getText().toString());
        values.put(Utilidades.CAMPO_CORREO, edtcorreo.getText().toString());
        values.put(Utilidades.CAMPO_CELULAR, edtcelular.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_DNI+"=?",parametros);
        Toast.makeText(getContext(),"el usuario se actualizo",Toast.LENGTH_LONG).show();
        db.close();


}

}

