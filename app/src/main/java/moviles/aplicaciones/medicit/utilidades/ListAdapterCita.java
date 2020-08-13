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
import moviles.aplicaciones.medicit.entidades.Cita;

public class ListAdapterCita extends ArrayAdapter<Cita> {
    private List<Cita> myList;
    private Context myContext;
    private int resourceLayout;

    public ListAdapterCita(@NonNull Context context, int resource,List<Cita> objects) {
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

        Cita cita= myList.get(position);

        TextView medico = view.findViewById(R.id.EDTMEDICO);
        medico.setText(cita.getMedico());
        TextView precio = view.findViewById(R.id.EDTPRECIO);
        precio.setText(cita.getPrecio());
        TextView especialidad = view.findViewById(R.id.EDTESPECIALIDAD1);
        especialidad.setText(cita.getEspecialidad());
        TextView fecha = view.findViewById(R.id.EDTFECHA);
        fecha.setText(cita.getFecha());


        return view;
    }


}
