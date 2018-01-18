
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Three_tiles extends Activity {

    private int goodTile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_tiles);

        goodTile = (int)(Math.random() * 3) + 1;
}

    private void nextStep(int value) {
        boolean stopWhile = false;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        if (value == goodTile) {
            while (!stopWhile) {
                int rand = ((int) (Math.random() * 3) + 1);
                if (rand != goodTile) {
                    stopWhile = true;
                    if (rand < goodTile) {
                        numbers.add(rand);
                        numbers.add(goodTile);
                    } else {
                        numbers.add(goodTile);
                        numbers.add(rand);
                    }
                }
            }
        } else {
            if (value < goodTile) {
                numbers.add(value);
                numbers.add(goodTile);
            } else {
                numbers.add(goodTile);
                numbers.add(value);
            }
        }

        Intent i = new Intent(this, Two_tiles.class);
        i.putExtra("list", numbers);
        i.putExtra("goodTile", goodTile);
        startActivity(i);
    }

    public void one(View view){
        nextStep(1);
    }
	
    public void two(View view){
		nextStep(2);
		}
		
    public void three(View view){
        nextStep(3);
    }
	
    public void about(View view){
        startActivity(new Intent(this, About.class));
    }
}
