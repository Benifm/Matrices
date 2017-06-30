package com.example.matrices;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Determinant4 extends AppCompatActivity {

    private TextView a1;
    private TextView a2;
    private TextView a3;
    private TextView a4;
    private TextView a5;
    private TextView a6;
    private TextView a7;
    private TextView a8;
    private TextView a9;
    private TextView a10;
    private TextView a11;
    private TextView a12;
    private TextView a13;
    private TextView a14;
    private TextView a15;
    private TextView a16;

    private float b1;
    private float b2;
    private float b3;
    private float b4;
    private float b5;
    private float b6;
    private float b7;
    private float b8;
    private float b9;
    private float b10;
    private float b11;
    private float b12;
    private float b13;
    private float b14;
    private float b15;
    private float b16;

    private Button ok;
    private AlertDialog.Builder msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinant4);

        a1 = (TextView) findViewById(R.id.a1);
        a2 = (TextView) findViewById(R.id.a2);
        a3 = (TextView) findViewById(R.id.a3);
        a4 = (TextView) findViewById(R.id.a4);
        a5 = (TextView) findViewById(R.id.a5);
        a6 = (TextView) findViewById(R.id.a6);
        a7 = (TextView) findViewById(R.id.a7);
        a8 = (TextView) findViewById(R.id.a8);
        a9 = (TextView) findViewById(R.id.a9);
        a10 = (TextView) findViewById(R.id.a10);
        a11 = (TextView) findViewById(R.id.a11);
        a12 = (TextView) findViewById(R.id.a12);
        a13 = (TextView) findViewById(R.id.a13);
        a14 = (TextView) findViewById(R.id.a14);
        a15 = (TextView) findViewById(R.id.a15);
        a16 = (TextView) findViewById(R.id.a16);

        ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b1 = Float.parseFloat( a1.getText().toString());
                b2 = Float.parseFloat( a2.getText().toString());
                b3 = Float.parseFloat( a3.getText().toString());
                b4 = Float.parseFloat( a4.getText().toString());
                b5 = Float.parseFloat( a5.getText().toString());
                b6 = Float.parseFloat( a6.getText().toString());
                b7 = Float.parseFloat( a7.getText().toString());
                b8 = Float.parseFloat( a8.getText().toString());
                b9 = Float.parseFloat( a9.getText().toString());
                b10 = Float.parseFloat( a10.getText().toString());
                b11 = Float.parseFloat( a11.getText().toString());
                b12 = Float.parseFloat( a12.getText().toString());
                b13 = Float.parseFloat( a13.getText().toString());
                b14 = Float.parseFloat( a14.getText().toString());
                b15 = Float.parseFloat( a15.getText().toString());
                b16 = Float.parseFloat( a16.getText().toString());


                float minor1 = b6 * (b11 * b16 - b12 * b15) - b7 * (b10 * b16 - b12 * b14) + b8 * (b10 * b15 - b11 * b14);
                float minor2 = b5 * (b11 * b16 - b12 * b15) - b7 * (b9 * b16 - b12 * b13) + b8 * (b9 * b15 - b11 * b13);
                float minor3 = b5 * (b10 * b16 - b12 * b14) - b6 * (b9 * b16 - b12 * b13) + b8 * (b9 * b14 - b10 * b13);
                float minor4 = b5 * (b10 * b15 - b11 * b14) - b6 * (b9 * b15 - b14 * b13) + b7 * (b9 * b14 - b10 * b13);

                float det = b1 * minor1 - b2 * minor2 + b3 * minor3 - b4 * minor4;

                msg = new AlertDialog.Builder( Determinant4.this);
                msg.setTitle( "Result");
                msg.setCancelable( true);
                msg.setMessage( String.format("The determinant is: %.2f", det));

                msg.show();




            }
        });



    }
}
