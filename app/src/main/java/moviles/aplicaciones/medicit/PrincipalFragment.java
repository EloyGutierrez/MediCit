package moviles.aplicaciones.medicit;

import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import moviles.aplicaciones.medicit.interfaces.IComunicaFragments;
import moviles.aplicaciones.medicit.utilidades.ConexionSQLiteHelper;
import moviles.aplicaciones.medicit.utilidades.Utilidades;

public class PrincipalFragment extends Fragment {
    Activity actividad;
    IComunicaFragments interfaceComunicaFragments;

    ConexionSQLiteHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater i = getLayoutInflater();
        View view= i.inflate(R.layout.fragment_principal,container,false);

        //comunicacion con la base de datos
        conn = new ConexionSQLiteHelper(getContext(),"db_usuarios",null,1);

        // se pasa a la siguiente fragment
        ImageView pidetucita = view.findViewById(R.id.pidetucita);
        pidetucita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.PideTuCita();
            }

        });

        ImageView buscatumedico = view.findViewById(R.id.buscatumedico);
        buscatumedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.BuscaTuMedico();
            }
        });

        ImageView miscitas = view.findViewById(R.id.miscitas);
        miscitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.MisCitas();
            }
        });

        ImageView consultatuseguro = view.findViewById(R.id.consultatuseguro);
        consultatuseguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceComunicaFragments.ConsultaTuSeguro();
            }
        });



        return view;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            actividad = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) actividad;
        }else{
            throw new ClassCastException(context.toString() + "escuchando");
        }
    }



}
