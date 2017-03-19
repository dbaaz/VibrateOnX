package apps.dbaaz.com.vibrateeveryxseconds;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    boolean state=false;
    EditText textbox;
    Button btn;
    int time,temp;
    Timer t;
    Vibrator vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timer t = new Timer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textbox=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button2);
        vib= (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }
    @Override
    protected void onSaveInstanceState(Bundle b)
    {
        b.putBoolean("state",state);
        t.cancel();
    }
    @Override
    protected void onRestoreInstanceState(Bundle b)
    {
        if(b.getBoolean("state"))
        {
            startTimer();
            btn.setText("stop");
        }
    }


    void vibratePhone()
    {
        vib.vibrate(1000);
    }
    public void handleButton(View v)
    {
        state=!state;
        if(state) {
            startTimer();
            btn.setText("stop");
        }
        else
        {
            t.cancel();
            btn.setText("start");
            textbox.setText(time+"");
        }
        textbox.setFocusable(!state);
        textbox.setClickable(!state);
        textbox.setFocusableInTouchMode(!state);
    }
    void startTimer()
    {
        time = Integer.parseInt(textbox.getText().toString());
        temp = time;
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(temp>0) {
                    temp--;

                }
                else
                {
                    vibratePhone();
                    temp=time;
                }
                myhand.obtainMessage(1).sendToTarget();
            }
        },0,1000);
    }
    public Handler myhand = new Handler() {
      public void handleMessage(Message msg)
      {
        textbox.setText(temp+"");
      }
    };
}
