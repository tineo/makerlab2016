package debra.makerlab;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListadoActivity extends AppCompatActivity
implements UsuarioFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        UsuarioFragment fragment = (UsuarioFragment)
                getSupportFragmentManager().findFragmentById(R.id.usuarios_container);

        if (fragment == null) {
            fragment = UsuarioFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.usuarios_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
