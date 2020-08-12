package moviles.aplicaciones.medicit.utilidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import moviles.aplicaciones.medicit.R;
import moviles.aplicaciones.medicit.entidades.Medicos;

public class ListAdapter extends ArrayAdapter<Medicos> {
        private List<Medicos> myList;
        private Context myContext;
        private int resourceLayout;

    public ListAdapter(@NonNull Context context, int resource,List<Medicos> objects) {
        super(context, resource, objects);
        this.myList= objects;
        this.myContext= context;
        this.resourceLayout =resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View view= convertView;

       if (view==null)
           view= LayoutInflater.from(myContext).inflate(resourceLayout,null);

       Medicos medicos= myList.get(position);

        TextView nombre = view.findViewById(R.id.EDTNOMBRE);
        nombre.setText(medicos.getNombre());
        TextView apellidopaterno = view.findViewById(R.id.EDTAPELLIDOPATERNO);
        apellidopaterno.setText(medicos.getApellidopaterno());
        TextView apellidomaterno = view.findViewById(R.id.EDTAPELLIDOMATERNO);
        apellidomaterno.setText(medicos.getApellidomaterno());
        TextView especialidad = view.findViewById(R.id.EDTESPECIALIDAD);
        especialidad.setText(medicos.getEspecialidad());


       return view;
    }


}
