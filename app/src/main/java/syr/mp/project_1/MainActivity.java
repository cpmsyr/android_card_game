package syr.mp.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create radio group and button instance to identify selected in playClick event
    }

    public void playClick(View view) {
        RadioGroup rg;
        RadioButton selectedRadio;
        Log.d(TAG, "playClick: ");
        rg=(RadioGroup)findViewById(R.id.rg);
        int selectedButtonId=rg.getCheckedRadioButtonId();
        selectedRadio=(RadioButton)findViewById(selectedButtonId);
        String t=selectedRadio.getText().toString();

        if (t.equals("Easy")){
            Intent intent = new Intent(MainActivity.this,
                    easyActivity.class);
            startActivity(intent);
        }
        else if (t.equals("Medium")){
            Intent intent = new Intent(MainActivity.this,
                    mediumActivity.class);
            startActivity(intent);
        }
        //Hard button selected
        else{
            Intent intent = new Intent(MainActivity.this,
                    hardActivity.class);
            startActivity(intent);
        }

    }
}
