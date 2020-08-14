package moviles.aplicaciones.medicit;

import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import moviles.aplicaciones.medicit.entidades.Cita;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.ListAdapter;
import moviles.aplicaciones.medicit.utilidades.ListAdapterCita;

public class MiscitasFragment extends Fragment {
    SharedPreferences sharedPreferences;
    TextView nombreusuario;
    ListView listacitas;

    Cursor filacitas;
    ListAdapterCita myAdapter;
    List<Cita> myList = new ArrayList<>();
    ArrayList<Cita> listaCitas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_miscitas,container,false);

        nombreusuario= view.findViewById(R.id.edtNombreUsu);
        listacitas = view.findViewById(R.id.lvcitasmedicas);

        listacitas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"elemento selecionado :  "+position,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(),DetallesCitaActivity.class);
                intent.putExtra("ID_MEDICO",myAdapter.getItem(position).getMedico());
                intent.putExtra("NOM_USUARIO",myAdapter.getItem(position).getDni());
                intent.putExtra("ESP_MEDICO",myAdapter.getItem(position).getEspecialidad());
                intent.putExtra("FEC_CITA",myAdapter.getItem(position).getFecha());
                intent.putExtra("CIT_PRECIO",myAdapter.getItem(position).getPrecio());
                startActivity(intent);
            }
        });

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getActivity().getApplicationContext())));
        String nombre=sharedPreferences.getString("USUARIO_NOMBRE","nombre defecto");
        String apellidopaterno=sharedPreferences.getString("USUARIO_APATERNO","nombre defecto");
        String apellidomaterno=sharedPreferences.getString("USUARIO_AMATERNO","nombre defecto");

        nombreusuario.setText(nombre+" "+apellidopaterno+" "+apellidomaterno);

        listarcitas();

        myAdapter = new ListAdapterCita(getContext(),R.layout.item_row_cita,myList);
        listacitas.setAdapter(myAdapter);






        return view;
    }
    public void listarcitas() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "bd_citas", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        Cita cita =null;
        listaCitas =new ArrayList<Cita>();

        //recibiendo el dato dni usuario
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull((getContext().getApplicationContext())));
        String DNI_USU=sharedPreferences.getString("USUARIO_DNI","dni defecto");


        filacitas = db.rawQuery( "SELECT medico,precio,especialidad,fecha FROM citas WHERE dni='"+DNI_USU+"'",null);
        while (filacitas.moveToNext()){
            cita = new Cita();
            cita.setMedico(filacitas.getString(0));
            cita.setPrecio(filacitas.getString(1));
            cita.setEspecialidad(filacitas.getString(2));
            cita.setFecha(filacitas.getString(3));
            listaCitas.add(cita);
        }

        obtenerlista();
        System.out.println("se ejecuto listarcitas();");
    }

    private void obtenerlista() {
        for (int i=0; i<listaCitas.size();i++){
            myList.add(new Cita(listaCitas.get(i).getMedico(),listaCitas.get(i).getPrecio(),listaCitas.get(i).getEspecialidad(),listaCitas.get(i).getFecha()));

        }
    }
}
