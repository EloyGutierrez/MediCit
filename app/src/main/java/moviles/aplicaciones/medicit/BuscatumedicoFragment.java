package moviles.aplicaciones.medicit;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import moviles.aplicaciones.medicit.entidades.Medicos;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.ListAdapter;

public class BuscatumedicoFragment extends Fragment {
    ListView listamedicos;
    Button buscarmedicos;
    EditText nombremedico;
    Spinner comboespecialidad;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor Gespecialidad;
    ListAdapter myAdapter;
    Cursor filamedicos;
    List<Medicos> myList = new ArrayList<>();
    ArrayList<Medicos> listaMedicos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_buscatumedico,container,false);

        listamedicos = view.findViewById(R.id.lvlistamedicos);
        nombremedico=view.findViewById(R.id.edtnombremedico);
        comboespecialidad=view.findViewById(R.id.idspinnerespecialidad);

        buscarmedicos= view.findViewById(R.id.btnbuscarmedico);

        ArrayAdapter<CharSequence> especialidadadapter= ArrayAdapter.createFromResource(getContext(),R.array.combo_especialidad,R.layout.spinner_item_estilos);
        comboespecialidad.setAdapter(especialidadadapter);

        comboespecialidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String especialidad =parent.getItemAtPosition(position).toString();
                System.out.println("LA ESPECIALIDAD SELECCIONADA EN Buscatumedicofragment : "+especialidad);
                sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getContext());
                Gespecialidad=sharedPreferences.edit();
                Gespecialidad.putString("PTC_ESPECIALIDAD1",especialidad);
                Gespecialidad.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buscarmedicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listarmedicos();

                myAdapter = new ListAdapter(getContext(),R.layout.item_row,myList);
                listamedicos.setAdapter(myAdapter);
            }
        });

        return view;
    }

    public void listarmedicos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "bd_medicos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        Medicos medico =null;
        listaMedicos =new ArrayList<Medicos>();

        //recibiendo los datos de la especialidad
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getContext().getApplicationContext())));
        String ESPECIALIDAD = sharedPreferences.getString("PTC_ESPECIALIDAD1", "especialidad defecto");
        String NOMBREMEDICO = nombremedico.getText().toString();
        filamedicos = db.rawQuery( "SELECT apellidopaterno,apellidomaterno,especialidad,celular FROM medicos WHERE nombre='"+NOMBREMEDICO+"'AND especialidad ='"+ESPECIALIDAD+"'",null);
        while (filamedicos.moveToNext()){
            medico = new Medicos();
            medico.setNombre(NOMBREMEDICO);
            medico.setApellidopaterno(filamedicos.getString(0));
            medico.setApellidomaterno(filamedicos.getString(1));
            medico.setEspecialidad(filamedicos.getString(2));
            medico.setCelular(filamedicos.getString(3));
            listaMedicos.add(medico);
        }
        obtenerlista();
        System.out.println("se ejecuto listarmedico();");
    }

    private void obtenerlista() {
        for (int i=0; i<listaMedicos.size();i++){
            myList.add(new Medicos(listaMedicos.get(i).getNombre(),listaMedicos.get(i).getApellidopaterno(),listaMedicos.get(i).getApellidomaterno(),listaMedicos.get(i).getEspecialidad(),listaMedicos.get(i).getCelular()));

        }
    }
}
