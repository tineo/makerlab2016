package debra.makerlab;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnRegistrar;
    private Button btnEliminar;
    private Button btnModificar;

    @Nullable
    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistrar= (Button)findViewById(R.id.btnRegistrar);
        btnEliminar= (Button)findViewById(R.id.btnEliminar);
        btnModificar= (Button)findViewById(R.id.btnModificar);




        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MainActivity.this, Registar.class);
                    startActivity(intent1);

            }
        });


                btnModificar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent2 = new Intent(MainActivity.this, Modificar.class);
                        startActivity(intent2);
                    }
                });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 =new Intent(MainActivity.this, Eliminar.class);
                    startActivity(intent3);
            }
        });






    }



}
