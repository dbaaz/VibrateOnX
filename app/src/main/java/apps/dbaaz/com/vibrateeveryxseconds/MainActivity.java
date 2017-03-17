package apps.dbaaz.com.vibrateeveryxseconds;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;

import static apps.dbaaz.com.vibrateeveryxseconds.MainActivity.state;

public class MainActivity extends AppCompatActivity {
    boolean state=false;
    EditText textbox;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timer t = new Timer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textbox=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button2);

    }


    void vibratePhone()
    {

    }
}
