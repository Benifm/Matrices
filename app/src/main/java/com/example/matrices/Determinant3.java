package com.example.matrices;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Determinant3 extends AppCompatActivity {

    private TextView a1;
    private TextView a2;
    private TextView a3;
    private TextView a4;
    private TextView a5;
    private TextView a6;
    private TextView a7;
    private TextView a8;
    private TextView a9;

    private float b1;
    private float b2;
    private float b3;
    private float b4;
    private float b5;
    private float b6;
    private float b7;
    private float b8;
    private float b9;

    private Button ok;
    private AlertDialog.Builder msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinant3);

        a1 = (TextView) findViewById(R.id.a1);
        a2 = (TextView) findViewById(R.id.a2);
        a3 = (TextView) findViewById(R.id.a3);
        a4 = (TextView) findViewById(R.id.a4);
        a5 = (TextView) findViewById(R.id.a5);
        a6 = (TextView) findViewById(R.id.a6);
        a7 = (TextView) findViewById(R.id.a7);
        a8 = (TextView) findViewById(R.id.a8);
        a9 = (TextView) findViewById(R.id.a9);

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


                float det = b1 * (b5 * b9 - b8 * b6) - b2 * (b4 * b9 - b6 * b7) + b3 * (b4 * b8 - b5 * b7);

                msg = new AlertDialog.Builder( Determinant3.this);
                msg.setTitle( "Result");
                msg.setCancelable( true);
                msg.setIcon(android.R.drawable.button_onoff_indicator_on);
                msg.setMessage( String.format("The determinant is: %.2f", det));

                msg.show();




            }
        });


    }
}
