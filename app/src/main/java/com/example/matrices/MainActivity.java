package com.example.matrices;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button choose;
    private Button det;
    private Button inv;
    private Button eigenVal;
    private Button eigenVec;
    private Button exit;

    private AlertDialog.Builder msg;

    protected final int REQ_CODE = 10;
    public String precision = "0";
    public String selected = "0";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        choose = (Button) findViewById(R.id.choose);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult( new Intent( MainActivity.this, Choose.class), REQ_CODE);


            }
        });

        det = (Button) findViewById(R.id.det);
        det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( selected.equals("2")) {

                    startActivity( new Intent(MainActivity.this, Determinant2.class).putExtra("Precision", precision));

                }

                if( selected.equals("3")) {

                    startActivity( new Intent(MainActivity.this, Determinant3.class).putExtra("Precision", precision));

                }

                if( selected.equals("4")) {

                    startActivity( new Intent(MainActivity.this, Determinant4.class).putExtra("Precision", precision));

                }

            }
        });

        inv = (Button) findViewById(R.id.inv);
        inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( selected.equals("2")) {

                    startActivity( new Intent(MainActivity.this, Inverse2.class).putExtra("Precision", precision));

                }

                if( selected.equals("3")) {

                    startActivity( new Intent(MainActivity.this, Inverse3.class).putExtra("Precision", precision));

                }


            }


        });

        eigenVal = (Button) findViewById(R.id.eigenVal);
        eigenVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( selected.equals("2")) {

                    startActivity( new Intent(MainActivity.this, Eigen2.class).putExtra("Precision", precision));

                }

            }
        });

        eigenVec = (Button) findViewById(R.id.eigenVec);
        eigenVec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( selected.equals("2")) {

                    startActivity( new Intent(MainActivity.this, EigenV2.class).putExtra("Precision", precision));

                }

            }
        });

        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                msg = new AlertDialog.Builder( MainActivity.this);
                msg.setTitle("Exit");
                msg.setIcon(android.R.drawable.dialog_holo_dark_frame);
                msg.setMessage("Are you sure?");
                msg.setCancelable(false);
                msg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                msg.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // Align the buttons to Center

                final AlertDialog msgFinal = msg.create();

                msgFinal.show();

                final Button pBtn = msgFinal.getButton(AlertDialog.BUTTON_POSITIVE);

                final Button nBtn = msgFinal.getButton(AlertDialog.BUTTON_NEGATIVE);

                LinearLayout pA = (LinearLayout) pBtn.getParent();
                pA.setGravity(Gravity.CENTER_HORIZONTAL);
                View pSpacer = pA.getChildAt(1);
                pSpacer.setVisibility(View.GONE);

                LinearLayout nA = (LinearLayout) nBtn.getParent();
                nA.setGravity(Gravity.CENTER_HORIZONTAL);
                View nSpacer = nA.getChildAt(1);
                nSpacer.setVisibility(View.GONE);




            }
        });


    }

    protected void onActivityResult( int reqCode, int res, Intent data) {
        if( reqCode == REQ_CODE) {
            if( res == 1) {
                selected = data.getStringExtra( "Key");
                Toast.makeText(MainActivity.this, "Number of rows set to: " + selected, Toast.LENGTH_SHORT).show();

                precision = data.getStringExtra( "Precision");
                Toast.makeText( MainActivity.this, "Precision set to: " + String.format("%d", Integer.parseInt( precision) + 1), Toast.LENGTH_SHORT).show();
            }

            }
        }
}
