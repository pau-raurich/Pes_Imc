package cat.dam.pau.pes_imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        //Creació dels components
        final TextView et_kg = (TextView) findViewById(R.id.et_kg);
        final TextView et_height = (TextView) findViewById(R.id.et_height);
        final Button btn_calculate = (Button) findViewById(R.id.btn_menu);

        btn_calculate.setOnClickListener((View v) -> {
            //Creació del intent i el bundle
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            Bundle bundle = new Bundle();

            //Guardat al bundle dels valors introduits per l'usuari
            bundle.putString("kg",et_kg.getText().toString());
            bundle.putString("height",et_height.getText().toString());

            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}