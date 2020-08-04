package moviles.aplicaciones.medicit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import moviles.aplicaciones.medicit.entidades.Usuario;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

public class PidetucitaFragment extends Fragment {

    Spinner comboespecialidad, combousuario;
    ConexionSQLiteHelper conn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view = i.inflate(R.layout.fragment_pidetucita, container, false);

        conn = new ConexionSQLiteHelper(getContext(), "db_medicos", null, 1);


        combousuario = view.findViewById(R.id.combousuario);
        comboespecialidad = view.findViewById(R.id.idspinnerespecialidad);


        ArrayAdapter<CharSequence> especialidadadapter = ArrayAdapter.createFromResource(getContext(), R.array.combo_especialidad, R.layout.spinner_item_estilos);
        comboespecialidad.setAdapter(especialidadadapter);




        return view;
    }

}
