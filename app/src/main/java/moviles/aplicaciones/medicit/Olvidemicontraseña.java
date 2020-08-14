package moviles.aplicaciones.medicit;

import android.os.Bundle;
import android.widget.CheckBox;

public class Olvidemicontraseña extends MainActivity {

    CheckBox checknumero,checkcorreo,checktengoproblemascomosiempre;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidemicontrasena);

        checknumero=findViewById(R.id.checkBox);
        checkcorreo=findViewById(R.id.checkBox2);
        checktengoproblemascomosiempre=findViewById(R.id.checkBox3);



    }
}
