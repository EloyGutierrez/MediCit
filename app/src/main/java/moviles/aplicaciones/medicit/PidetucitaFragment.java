package moviles.aplicaciones.medicit;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;

public class PidetucitaFragment extends Fragment {

    Spinner comboespecialidad;
    TextView txtusuario,edtNombreUsuario;
    ConexionSQLiteHelper conn;
    SharedPreferences sharedPreferences;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_pidetucita,container,false);

        conn = new ConexionSQLiteHelper(getContext(),"db_usuarios",null,1);

        edtNombreUsuario = view.findViewById(R.id.edtNombreUsuario);
        comboespecialidad = view.findViewById(R.id.idspinnerespecialidad);
        txtusuario= view.findViewById(R.id.edtusuario);
        ArrayAdapter<CharSequence> especialidadadapter= ArrayAdapter.createFromResource(getContext(),R.array.combo_especialidad,R.layout.spinner_item_estilos);
        comboespecialidad.setAdapter(especialidadadapter);


        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getActivity().getApplicationContext())));

        System.out.println("el sharedpreference llego : "+ sharedPreferences.getInt("USUARIO_DNI",0));
        int f =sharedPreferences.getInt("USUARIO_DNI",0);
        edtNombreUsuario.setText(f+"");
        return view;
    }



}
