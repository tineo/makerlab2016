package debra.makerlab;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

/**
 * Created by tineo on 07/09/16.
 */
public class UsuariosLoadTask extends AsyncTask<Void, Void, Cursor> {

    private Context mContext;

    public UsuariosLoadTask(Context context){
        mContext = context;
    }

    @Override
    protected Cursor doInBackground(Void... voids) {


        DataBase mUsuariosDbHelper = new DataBase(mContext);
        Cursor cur = null;
        try {
            //if(mUsuariosDbHelper.getAllUsuarios() == null) System.out.println("TMR");
            cur = mUsuariosDbHelper.getAllUsuarios();

        }catch (Exception e){
            e.printStackTrace();
        }

        return cur;


    }

    @Override
    protected void onPostExecute(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0) {
            //mUsuariosDbHelper.swapCursor(cursor);
        } else {
            // Mostrar empty state
        }
    }
}