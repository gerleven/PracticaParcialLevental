package isi.dam.dam.gui01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton1;
    Button boton2;
    ImageButton boton3;
    ImageView imgCabecera;
    CheckBox cbOptA,cbOptB;
    TextView opcionesElegidas;
    String estadoA,estadoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // a nivel swing setContentPane
        // obtener referencias a los widgets
        boton1 = findViewById(R.id.btnEjemplo01);
        boton2 = findViewById(R.id.btnEjemplo02);
        boton3 = findViewById(R.id.imageButton);
        imgCabecera = findViewById(R.id.imgCabecera);
        cbOptA = findViewById(R.id.optA);
        cbOptB = findViewById(R.id.optB);
        opcionesElegidas = findViewById(R.id.tvDescOpc);

        if(cbOptA.isChecked()){
            estadoA ="OPCION A ELEGIDA ! ";
        } else {
            estadoA ="OPCION A NO ELEGIDA ! ";
        }
        if(cbOptB.isChecked()){
            estadoB = "OPCION B ELEGIDA ! ";
        }else {
            estadoB = "OPCION B NO ELEGIDA!";
        }

        opcionesElegidas.setText(estadoA+" "+estadoB);

        CompoundButton.OnCheckedChangeListener listenerCB = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.optA:
                        if(isChecked) estadoA = "<<A>> ELEGIDO";
                        else  estadoA = "<<A>> NOOO ELEGIDO";
                        break;
                    case R.id.optB:
                        if(isChecked) estadoB = "<<B>> ELEGIDO";
                        else estadoB = "<<B>> NOOO ELEGIDO";
                        break;
                }
                opcionesElegidas.setText(estadoA+" "+estadoB);
            }
        };

        cbOptA.setOnCheckedChangeListener(listenerCB);
        cbOptB.setOnCheckedChangeListener(listenerCB);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"CLICK EN BOTON 1 CLASE ANONIMA",Toast.LENGTH_LONG).show();
                TextView tv = findViewById(R.id.textView1);
                tv.setVisibility(View.INVISIBLE);
            }
        });
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCabecera.setImageResource(R.drawable.logo_campus);
                TextView tv = findViewById(R.id.textView1);
                tv.setVisibility(View.GONE);
            }
        });

        if(System.currentTimeMillis()%2 == 2){
            boton1.setBackgroundColor(Color.parseColor("#FF0000"));
        } else {
            boton1.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        boton1.setText("NUEVO "+System.currentTimeMillis());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEjemplo01:
                Toast.makeText(this,"CLICK EN BOTON 1",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnEjemplo02:
                Toast.makeText(this,"CLICK EN BOTON 2",Toast.LENGTH_LONG).show();
                TextView tv = findViewById(R.id.textView1);
                tv.setVisibility(View.VISIBLE);
                cbOptA.toggle();
                cbOptB.toggle();
                break;
        }
    }
}