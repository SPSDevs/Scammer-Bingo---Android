package com.xelitexirish.scammerbingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewScore;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;

    public static int score = 0;
    public Button[] allButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textViewScore = (TextView) findViewById(R.id.textViewScore);

        this.button1 = (Button) findViewById(R.id.button1);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button3 = (Button) findViewById(R.id.button3);
        this.button4 = (Button) findViewById(R.id.button4);
        this.button5 = (Button) findViewById(R.id.button5);
        this.button6 = (Button) findViewById(R.id.button6);
        this.button7 = (Button) findViewById(R.id.button7);
        this.button8 = (Button) findViewById(R.id.button8);
        this.button9 = (Button) findViewById(R.id.button9);
        this.button10 = (Button) findViewById(R.id.button10);
        this.button11 = (Button) findViewById(R.id.button11);
        this.button12 = (Button) findViewById(R.id.button12);

        this.allButtons = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12};

        for(int x = 0; x < allButtons.length; x++){
            final Button button = allButtons[x];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonPressed(button);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_share) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "I scored a massive " + score + " / " + allButtons.length + " If you are getting scammed see what score you get too!");
            intent.setType("text/plain");
            startActivity(intent);

        }else if (id == R.id.action_reset) {
            score = 0;
            updateScore();
            setButtonsEnabled();
            return true;
        }else if (id == R.id.action_about){

        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonPressed(Button pressedButton) {

        score++;
        pressedButton.setEnabled(false);
        updateScore();
    }

    public void setButtonsEnabled() {
        for(int x = 0; x < allButtons.length; x++){
            Button button = allButtons[x];

            button.setEnabled(true);
        }
    }

    public void updateScore(){
        this.textViewScore.setText(score + " / " + allButtons.length);
    }
}
