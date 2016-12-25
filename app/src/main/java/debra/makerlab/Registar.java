package debra.makerlab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Registar extends AppCompatActivity {
    DataBase database;
    private EditText txtCorreo, txtNombre, txtDni, txtApellido, txtDireccion, txtCelular;
    private Button btnRegistrarUsuario;
    private Usuario usuario;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        database = new DataBase(Registar.this);
        btnRegistrarUsuario = (Button) findViewById(R.id.btnRegistrarUsuario);

        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtCelular = (EditText) findViewById(R.id.txtCelular);
        txtDni = (EditText) findViewById(R.id.txtDni);


        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Toast.makeText(getActivity(),
                        "Usuario  guardado correctamente", Toast.LENGTH_SHORT).show();*/

                database.insertarUsuario(txtNombre.getText().toString(),
                        txtApellido.getText().toString(), txtCorreo.getText().toString(),
                        txtDireccion.getText().toString(), txtCelular.getText().toString(),
                        txtDni.getText().toString());

                Toast.makeText(getApplicationContext(),
                        "Usuario  guardado correctamente", Toast.LENGTH_SHORT).show();

                if (txtCorreo.getText().toString() == null || txtCorreo.getText().toString().compareTo("") == 0) {
                    Toast.makeText(Registar.this, "Correo es obligatorio", Toast.LENGTH_LONG).show();

                }


                Intent intent = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(intent);


            }


        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Registar Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://debra.makerlab/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Registar Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://debra.makerlab/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
