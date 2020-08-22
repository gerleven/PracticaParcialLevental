package isi.dam.dam.gui01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // a nivel swing setContentPane

        boton1 = findViewById(R.id.btnActividad01V2);
        if(System.currentTimeMillis()%2 == 2){
            boton1.setBackgroundColor(Color.parseColor("#FF0000"));
        } else {
            boton1.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        boton1.setText("NUEVO "+System.currentTimeMillis());
    }
}