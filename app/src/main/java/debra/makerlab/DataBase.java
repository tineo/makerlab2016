package debra.makerlab;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by Debra on 06/09/2016.
 */
public class DataBase extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;

    private static final String NOMBRE_BASEDATOS = "MakerLab.db";

    private static final String TABLA_USUARIO = "CREATE TABLE usuario" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, dni VARCHAR(8), correo VARCHAR(250),  numeroCelular VARCHAR(20), " +
            "direccion VARCHAR(250), nombre VARCHAR(100), apellido VARCHAR(100))";

    public DataBase(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertarUsuario(String nombre, String apellido, String correo, String direccion, String celular, String dni) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("dni", dni);
            valores.put("numeroCelular", celular);
            valores.put("apellido", apellido);
            valores.put("direccion", direccion);
            valores.put("nombre", nombre);
            valores.put("correo", correo);

            db.insert("usuario", null, valores);
            db.close();

        }}
      public Usuario recuperaUsuario(int id) {
            SQLiteDatabase db = getReadableDatabase();
            String[] valores_recuperar = {"id","dni", "correo","numeroCelular","direccion", "nombre","apellido"};
            Cursor c = db.query("usuario", valores_recuperar, "id=" + id, null, null, null, null);
            if (c != null) {
                c.moveToFirst();
            }
            Usuario usuario = new Usuario(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4),c.getString(5), c.getString(6));
            db.close();
            c.close();
            return usuario;


        }
    public void actualizar (String nombre, int id){

        /*SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre",nombre);

        int i = db.update(TABLA_NOMBRES,
                values,
                " _id = ?",
                new String[] { String.valueOf( id ) });
        db.close();*/
    }

    public Cursor getAllUsuarios() {

        /*SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id","dni", "correo","numeroCelular","direccion", "nombre","apellido"};
        Cursor c = db.query("usuario", valores_recuperar, null, null, null, null, null);
        /*if (c != null) {
            c.moveToFirst();
        }*/



        //return c;

        //return getReadableDatabase().rawQuery("select * from usuario",null);
        return getReadableDatabase()
                .query(
                        "usuario",
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }


    public void swapCursor(Cursor cursor) {

    }
}