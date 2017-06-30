package com.example.matrices;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Eigen2 extends AppCompatActivity {

    private TextView a1;
    private TextView a2;
    private TextView a3;
    private TextView a4;

    private float b1;
    private float b2;
    private float b3;
    private float b4;

    public  int prec1;
    public  String prec2;

    private Button ok;
    private AlertDialog.Builder msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eigen2);



        Bundle income = getIntent().getExtras();
        prec1 = Integer.parseInt( income.getString("Precision")) + 1;
        prec2 = String.format("%d" , prec1);

        a1 = (TextView) findViewById(R.id.a1);
        a2 = (TextView) findViewById(R.id.a2);
        a3 = (TextView) findViewById(R.id.a3);
        a4 = (TextView) findViewById(R.id.a4);

        ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                msg = new AlertDialog.Builder(Eigen2.this);
                msg.setTitle("Result");
                msg.setCancelable(true);
                msg.setIcon(android.R.drawable.button_onoff_indicator_on);

                b1 = Float.parseFloat( a1.getText().toString());
                b2 = Float.parseFloat( a2.getText().toString());
                b3 = Float.parseFloat( a3.getText().toString());
                b4 = Float.parseFloat( a4.getText().toString());

                float det = b1 * b4 - b2 * b3;
                float trace = b1 + b4;
                float delta = trace * trace - 4 * det;

                if( delta >= 0) {

                    float r1 = (trace + (float)Math.sqrt( (double)delta)) / 2;
                    float r2 = (trace - (float)Math.sqrt( (double)delta)) / 2;

                    msg.setMessage(String.format("The eigen values are: \nr1 = %." + prec2 + "f , r2 = %." + prec2 + "f", r1, r2));

                    msg.show();

                } else {

                    float r1 = (float)Math.sqrt( (double)-delta) / 2;
                    float r2 = (float)Math.sqrt( (double)-delta) / 2;


                    msg.setMessage(String.format("The eigen values are: \nr1 = %." + prec2 + "f + (%." + prec2 + "f)i , %." + prec2 + "f - (%." + prec2 + "f)i", (float)trace/2, r1, (float)trace/2, r2));

                    msg.show();




                }




            }
        });


    }
}
