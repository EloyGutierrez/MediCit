package moviles.aplicaciones.medicit;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

public class PidetucitaFragment extends Fragment {

    Spinner comboespecialidad;
    TextView txtusuario,edtNombreUsuario;
    ConexionSQLiteHelper conn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor Gespecialidad;
    Button btnsiguinte;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_pidetucita,container,false);

        conn = new ConexionSQLiteHelper(getContext(),"db_usuarios",null,1);

        edtNombreUsuario = view.findViewById(R.id.edtNombreUsuario);
        comboespecialidad = view.findViewById(R.id.idspinnerespecialidad);
        txtusuario= view.findViewById(R.id.edtusuario);
        btnsiguinte = view.findViewById(R.id.btnSiguientePidetucita);

        ArrayAdapter<CharSequence> especialidadadapter= ArrayAdapter.createFromResource(getContext(),R.array.combo_especialidad,R.layout.spinner_item_estilos);
        comboespecialidad.setAdapter(especialidadadapter);
        String especialidad = comboespecialidad.getSelectedItem().toString();
        System.out.println("ESPECIALIDAD: " +especialidad);
        //compartiendo dato especialidad
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getContext());
        Gespecialidad=sharedPreferences.edit();
        Gespecialidad.putString("PTC_ESPECIALIDAD",especialidad);
        Gespecialidad.apply();



        //obteniendo el dni que lledo del sharedpreference
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getActivity().getApplicationContext())));
        String dni=sharedPreferences.getString("USUARIO_DNI","dni defecto");
        String nombre=sharedPreferences.getString("USUARIO_NOMBRE","nombre defecto");
        String apellidopaterno=sharedPreferences.getString("USUARIO_APATERNO","nombre defecto");
        String apellidomaterno=sharedPreferences.getString("USUARIO_AMATERNO","nombre defecto");
        System.out.println("dni pidetucitafragment : " +dni);
        edtNombreUsuario.setText(nombre+" "+apellidopaterno+" "+apellidomaterno);

        btnsiguinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getContext(), SpidetucitaActivity.class);
                startActivity(i);
            }
        });

        return view;
    }


}
