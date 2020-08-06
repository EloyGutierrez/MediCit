package moviles.aplicaciones.medicit.utilidades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import moviles.aplicaciones.medicit.entidades.Usuario;

public class UsuarioDAO {
    SQLiteDatabase sql;

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.clear();
        Cursor cursor=sql.rawQuery("SELECT * FROM usuarios",null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                Usuario usu = new Usuario();
                usu.setDni(cursor.getInt(0));
                usu.setNombre(cursor.getString(1));
                usu.setApellidopaterno(cursor.getString(2));
                usu.setApellidomaterno(cursor.getString(3));
                usu.setSexo(cursor.getString(4));
                Date date1 = new Date(cursor.getLong(5)*1000);
                usu.setFechadenacimiento(date1);
                usu.setCorreo(cursor.getString(6));
                usu.setCelular(cursor.getInt(7));
                usu.setSeguro(cursor.getString(8));
                usu.setContrasenia(cursor.getString(9));
                lista.add(usu);

            }while (cursor.moveToNext());
        }
        return  lista;
    }
}


