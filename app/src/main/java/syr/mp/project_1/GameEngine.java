package syr.mp.project_1;
import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.*;

public class GameEngine {

    private cardPicks p;
    private Context context;

    public GameEngine(cardPicks picks, Context c) {
        GameEngine.this.p = picks;
        GameEngine.this.context = c;
    }

    public ArrayList<Integer> cardDrawList(int gridSize) {
        int[] n = new int[gridSize];
        ArrayList<Integer> nums = new ArrayList<>();
        Random random = new Random();

        //iterate through until the arraylist is the size of the grid.
        while (nums.size() < gridSize) {
            int rn = random.nextInt(gridSize / 2);
            rn+=1;
            //check to see if the number selected already exist in the array list. if not add. otherwise pick again.
            if (nums.contains(rn)) {
                //if the number already exist do nothing and repeat while loop. can't have more than two cards per set
                continue;
            } else {
                //adding twice since a matching pair is needed
                nums.add(rn);
                nums.add(rn);
            }
        }
        Collections.shuffle(nums);
        return nums;
    }

    public boolean checkMatch() {
        int v1 = p.getP1();
        int v2 = p.getP2();
        if (v1 == v2 && v1!=0) {
            return true;
        }
        return false;
    }

    public void gamePlay(int pick,String tag,int ivId) {
        boolean match;
        if (p.getP1() == 0) {
            p.setP1(pick);
            p.setTag1(tag);
            p.setIvId1(ivId);
            Toast.makeText(this.context, "First Pick Made", Toast.LENGTH_SHORT).show();
        } else if (p.getP2() == 0) {
            p.setP2(pick);
            p.setTag2(tag);
            p.setIvId2(ivId);
            p.setTries(p.getTries()+1);
            match = checkMatch();
            if (!match) {
                p.reset();
                p.resetTags();
                //tell user no match try again
                Toast.makeText(this.context, "Second Pick Doesn't Match. Try Again", Toast.LENGTH_SHORT).show();
            } else {
                //tell user match
                Toast.makeText(this.context, "Picks Match!", Toast.LENGTH_SHORT).show();
                //add to count
                int m=p.getMatches();
                m+=1;
                p.setMatches(m);
                //p.reset();
            }
        }
    }
}
