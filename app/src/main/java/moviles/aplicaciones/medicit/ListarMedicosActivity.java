package moviles.aplicaciones.medicit;

import androidx.appcompat.app.AppCompatActivity;
import moviles.aplicaciones.medicit.entidades.Medicos;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarMedicosActivity extends AppCompatActivity {
    ListView lisdemedicos;
    ArrayList<String> listaInformacion;
    ArrayList<Medicos> listaMedicos;
    Cursor filamedicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_medicos);
        lisdemedicos=findViewById(R.id.listviewmedicos);

        listarmedicos();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        lisdemedicos.setAdapter(adapter);
        lisdemedicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListarMedicosActivity.this,"Elemento clicado :  "+position,Toast.LENGTH_LONG).show();
            }
        });

    }

    public void listarmedicos() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_medicos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        Medicos medico =null;
        listaMedicos =new ArrayList<Medicos>();
        filamedicos = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_MEDICO,null);

        while (filamedicos.moveToNext()){
            medico = new Medicos();
            medico.setId(filamedicos.getString(0));
            medico.setNombre(filamedicos.getString(1));
            medico.setApellidopaterno(filamedicos.getString(2));
            medico.setApellidomaterno(filamedicos.getString(3));
            medico.setEspecialidad(filamedicos.getString(4));
            medico.setSexo(filamedicos.getString(5));
            medico.setFechadenacimiento(filamedicos.getString(6));
            medico.setCorreo(filamedicos.getString(7));
            medico.setDireccion(filamedicos.getString(8));
            medico.setCelular(filamedicos.getString(9));
            listaMedicos.add(medico);
        }
        obtenerlista();
        System.out.println("se ejecuto listarmedico();");
    }

    private void obtenerlista() {
        listaInformacion=new ArrayList<String>();
        for (int i=0; i<listaMedicos.size();i++){
            listaInformacion.add(listaMedicos.get(i).getNombre()+"-"+listaMedicos.get(i).getApellidopaterno()+"-"+listaMedicos.get(i).getApellidomaterno()+"-"+listaMedicos.get(i).getEspecialidad());

        }
    }
}