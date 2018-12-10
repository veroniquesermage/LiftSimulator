package fr.wildcodeschool.liftsimulator;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button one = (Button) findViewById(R.id.button1);
        final Button two = (Button) findViewById(R.id.button2);
        final Button three = (Button) findViewById(R.id.button3);
        final Button four = (Button) findViewById(R.id.button4);
        final Button five = (Button) findViewById(R.id.button5);
        final Button six = (Button) findViewById(R.id.button6);
        final Button seven = (Button) findViewById(R.id.button7);
        final Button eight = (Button) findViewById(R.id.button8);
        final Button nine = (Button) findViewById(R.id.button9);
        final Button zero = (Button) findViewById(R.id.button0);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(5);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(9);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFloor(0);
            }
        });

    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            isLiftMoving = true;
            new MoveLift().execute(floor);
        }else{
            isLiftMoving=false;
        }
    }


    private class MoveLift extends AsyncTask <Integer, Void, Integer > {


        protected void onPostExecute(Integer floor) {
            currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            moveNextFloor(floor);

        }

        protected Integer doInBackground(Integer... param) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            return param[0];
        }


    }
}



