package com.example.matrices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class Choose extends AppCompatActivity {

    private Button ok;
    private RadioGroup rGroup;
    private RadioButton rBtn;
    private int opt;
    private int sel = 0;
    private AlertDialog.Builder msg;
    private SeekBar bar;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        text = (TextView) findViewById(R.id.textView2);

        bar = (SeekBar) findViewById(R.id.seekBar);
        bar.setMax(2);
        bar.setProgress(0);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text.setText(String.format("%d" , bar.getProgress() + 1));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rGroup = (RadioGroup) findViewById(R.id.radioGroup);
        ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent stat = getIntent();

                opt = rGroup.getCheckedRadioButtonId();
                rBtn = (RadioButton) findViewById(opt);

                if( rBtn == null) {

                    msg = new AlertDialog.Builder( Choose.this);
                    msg.setTitle( "Error!");
                    msg.setCancelable( true);
                    msg.setMessage( "Please select an option!");
                    msg.show();



                } else {

                    if( opt == R.id.radio2){
                        sel = 2;


                    } else if (opt == R.id.radio3){
                        sel = 3;


                    } else if (opt == R.id.radio4) {
                        sel = 4;


                    }

                    String out1 = String.format("%d", sel);
                    String out2 = String.format("%d", bar.getProgress());

                    stat.putExtra( "Key", out1);
                    stat.putExtra( "Precision", out2);
                    setResult( 1, stat);
                    finish();

                }



            }
        });












    }
}
