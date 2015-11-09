package com.example.s2109787.numberguesser23;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class IntroScreen extends AppCompatActivity {

   int randomNum = 0;
    int tries = 5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);
         Random rand = new Random();
         randomNum = rand.nextInt((100 - 1) + 1) + 1;
        System.out.println(randomNum);

    }

    public void onClick(View source) {

        EditText e = (EditText)findViewById(R.id.editText);
        String s = e.getText().toString();
        try {
            int y =
                    Integer.parseInt(s);

            if (y == randomNum) {
                Intent Winscreenintent = new Intent(this, Winscreen.class);
                startActivity(Winscreenintent);
            } else if (y != randomNum){
                Toast.makeText(this, "You have "+ tries + " tries left", Toast.LENGTH_SHORT).show();
                tries = tries-1;
            if (tries == -1) {
                Intent losescreenintent = new Intent(this, LoseScreen.class);
                startActivity(losescreenintent);
            }

            }


        } catch (Exception ex) {
            ex.printStackTrace();
            // invalid input
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
