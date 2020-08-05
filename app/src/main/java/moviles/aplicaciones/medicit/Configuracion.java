package moviles.aplicaciones.medicit;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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

import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

public class Configuracion extends Fragment implements View.OnClickListener{
    EditText edtdni, edtnombre, edtapellidopaterno, edtapellidomaterno, edtcorreo, edtcelular;
    Button btnactualizar;
    Intent x;

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

        return view;
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
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, edtnombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOPATERNO, edtapellidopaterno.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOMATERNO, edtapellidomaterno.getText().toString());
        values.put(Utilidades.CAMPO_CORREO, edtcorreo.getText().toString());
        values.put(Utilidades.CAMPO_CELULAR, edtcelular.getText().toString());

        //db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_DNI+="")


}

}

