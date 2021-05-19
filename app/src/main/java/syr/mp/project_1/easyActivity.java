package syr.mp.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class easyActivity extends AppCompatActivity {

    cardPicks easyPicks = new cardPicks();
    GameEngine ge = new GameEngine(easyPicks, easyActivity.this);
    ArrayList<Integer> cardValues = ge.cardDrawList(6);
    private HashMap<String, Integer> hiddenValues = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        ArrayList<Integer> cardValues=ge.cardDrawList(6);

        hiddenValues.put("1",cardValues.get(0));
        hiddenValues.put("2",cardValues.get(1));
        hiddenValues.put("3",cardValues.get(2));
        hiddenValues.put("4",cardValues.get(3));
        hiddenValues.put("5",cardValues.get(4));
        hiddenValues.put("6",cardValues.get(5));

    }

    public void Click_1(View v) {
        String tag = v.getTag().toString();
        //imageview id
        int ivId = v.getId();
        ge.gamePlay((int)hiddenValues.get(tag), tag, ivId);

        int pickedCardValue= hiddenValues.get(tag);

        switch (pickedCardValue){
            case 0:
                Toast.makeText(this,"King",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,"Queen",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,"Two",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this,"Three",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this,"Four",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this,"Five",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this,"Six",Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(this,"Seven",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(this,"Eight",Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(this,"Nine",Toast.LENGTH_SHORT).show();
            case 10:
                Toast.makeText(this,"Ten",Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(this,"Jack",Toast.LENGTH_SHORT).show();
            case 12:
                Toast.makeText(this,"Joker",Toast.LENGTH_SHORT).show();
                break;
        }
        boolean matchCheck;
        matchCheck = ge.checkMatch();

        //matches getting and UI setting
        int matches = easyPicks.getMatches();
        String m = String.valueOf(matches);
        TextView tv;
        tv = (TextView) findViewById(R.id.matches);
        tv.setText(m);

        //tries getting and UI setting
        int tries = easyPicks.getTries();
        String t = String.valueOf(tries);
        TextView triesTv;
        triesTv = (TextView) findViewById(R.id.tries);
        triesTv.setText(t);

        //logic to pre-process if controls should be disabled or card flipped

        if (matchCheck) {
            ImageView imageView1;
            ImageView imageView2;
            int ivId1 = easyPicks.getIvId1();
            int ivId2 = easyPicks.getIvId2();

                imageView1 = (ImageView) findViewById(ivId1);
                imageView2 = (ImageView) findViewById(ivId2);

                //do mapping of hidden value to real
                String tag1 =easyPicks.getTag1();
                String tag2 =easyPicks.getTag2();

                int c1=hiddenValues.get(tag1);
                 if(c1==0){
                    imageView1.setImageResource(R.drawable.num0);
                }
                else if(c1==1){
                    imageView1.setImageResource(R.drawable.num1);
                }
                else if(c1==2){
                    imageView1.setImageResource(R.drawable.num2);
                }
                else if(c1==3){
                    imageView1.setImageResource(R.drawable.num3);
                }
                else if(c1==4){
                    imageView1.setImageResource(R.drawable.num4);
                }
                else if(c1==5){
                    imageView1.setImageResource(R.drawable.num5);
                }

                else{
                    imageView1.setImageResource(R.drawable.blank1);
                }
                int c2=hiddenValues.get(tag2);

                if(c2==0){
                    imageView2.setImageResource(R.drawable.num0);
                }
                else if(c2==1){
                    imageView2.setImageResource(R.drawable.num1);
                }
                else if(c2==2){
                    imageView2.setImageResource(R.drawable.num2);
                }
                else if(c2==3){
                    imageView2.setImageResource(R.drawable.num3);
                }
                else if(c2==4){
                    imageView2.setImageResource(R.drawable.num4);
                }
                else if(c2==5){
                    imageView2.setImageResource(R.drawable.num5);
                }

                else{
                    imageView2.setImageResource(R.drawable.blank1);
                }

            easyPicks.resetTags();
            easyPicks.reset();

        }


    }
}