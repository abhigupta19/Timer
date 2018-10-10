package com.example.user.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView t;
private SeekBar s;
Button c;
private CountDownTimer countdown;
boolean cou=false;
public void update(int e)
{
    int m=(int)e/60;
    int sec=e-m*60;
    String second=Integer.toString(sec);
    if(sec<=9)
    {
        second="0"+second;
    }

    t.setText(Integer.toString(m)+":"+second);
}
public void controlTimer(View view)
{
    if(cou==false) {
        cou = true;
        s.setEnabled(false);
        c.setText("stop");

     countdown=   new CountDownTimer(s.getProgress() * 1000 + 100, 1000) {

            @Override
            public void onTick(long l) {
                update((int) l / 1000);
            }

            @Override
            public void onFinish() {
                t.setText("0.00");
            }
        }.start();
    }
    else
    {
        s.setEnabled(true);
        s.setProgress(30);
        t.setText("0:30");
        countdown.cancel();
        c.setText("go");
        cou=false;

    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   s=(SeekBar)findViewById(R.id.seekBar);
         t=(TextView)findViewById(R.id.textView);
         c=(Button)findViewById(R.id.button);
        s.setMax(600);
        s.setProgress(30);



        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                update(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
