package moviles.aplicaciones.medicit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PidetucitaFragment extends Fragment {

    Spinner comboespecialidad,combousuario;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_pidetucita,container,false);

        combousuario = view.findViewById(R.id.combousuario);
        comboespecialidad = view.findViewById(R.id.idspinnerespecialidad);
        ArrayAdapter<CharSequence> especialidadadapter= ArrayAdapter.createFromResource(getContext(),R.array.combo_especialidad,R.layout.spinner_item_estilos);
        comboespecialidad.setAdapter(especialidadadapter);

        combousuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}
