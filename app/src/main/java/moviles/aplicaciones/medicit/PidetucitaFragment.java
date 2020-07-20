package moviles.aplicaciones.medicit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PidetucitaFragment extends Fragment {

    Spinner comboespecialidad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_pidetucita,container,false);


        comboespecialidad = view.findViewById(R.id.idspinnerespecialidad);
        ArrayAdapter<CharSequence> especialidadadapter= ArrayAdapter.createFromResource(getContext(),R.array.combo_especialidad,R.layout.spinner_item_estilos);
        comboespecialidad.setAdapter(especialidadadapter);

        return view;
    }
}
