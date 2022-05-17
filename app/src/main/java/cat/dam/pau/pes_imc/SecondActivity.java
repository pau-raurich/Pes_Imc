package cat.dam.pau.pes_imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public String [] weight_group = new String[8]; //Array on es guarden els noms dels grups

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        //Creació de componeents
        final TextView tv_result_BMI = (TextView) findViewById(R.id.tv_result_BMI);
        final TextView tv_result_group = (TextView) findViewById(R.id.tv_result_group);
        final Button btn_menu = (Button) findViewById(R.id.btn_menu);

        //Agafem els bundle que hem enviat anteriorment
        Bundle bundle = this.getIntent().getExtras();

        //Assignem els continguts a variables locals
        int bundle_kg = Integer.parseInt(bundle.getString("kg"));
        Float bundle_height = Float.parseFloat(bundle.getString("height"));

        //Cridem a la funció que emplena l'array
        fillWeightGroupArray();

        //Calculem l'IMC
        float imc = bundle_kg / (bundle_height*2);

        //Enviem els resultats als 'TextView'
        tv_result_BMI.setText(tv_result_BMI.getText().toString()+" "+imc);
        tv_result_group.setText(tv_result_group.getText().toString()+" "+getWeightGroup(imc));

        //Listener per tornar al primer .java
        btn_menu.setOnClickListener((View v)->{
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);

            startActivity(intent);
        });
    }

    //Funció que donat un IMC et retorna el grup en 'String'
    public String getWeightGroup(float imc){

        if(imc<18.5){ return weight_group[0]; }
        if(imc>=18.5 && imc<=24.9){ return weight_group[1]; }
        if(imc>=25 && imc<=26.9){ return weight_group[2]; }
        if(imc>=27 && imc<=29.9){ return weight_group[3]; }
        if(imc>=30 && imc<=34.9){ return weight_group[4]; }
        if(imc>=35 && imc<=39.9){ return weight_group[5]; }
        if(imc>=40 && imc<=49.9){ return weight_group[6]; }
        if(imc>=50){ return weight_group[7]; }

        return weight_group[0];
    }

    //Funció que emplena l'array 'weight_group' amb 'String' dels grups
    public void fillWeightGroupArray(){
        weight_group[0] = getResources().getString(R.string.group_0);
        weight_group[1] = getResources().getString(R.string.group_1);
        weight_group[2] = getResources().getString(R.string.group_2);
        weight_group[3] = getResources().getString(R.string.group_3);
        weight_group[4] = getResources().getString(R.string.group_4);
        weight_group[5] = getResources().getString(R.string.group_5);
        weight_group[6] = getResources().getString(R.string.group_6);
        weight_group[7] = getResources().getString(R.string.group_7);
    }
}
