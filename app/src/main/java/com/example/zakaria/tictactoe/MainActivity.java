package com.example.zakaria.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    int[] available={2,2,2,2,2,2,2,2,2};

    String winner ="NoOne";
    public  void dropIn(View view){

        int[][] WinningStates = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        ImageView counter = (ImageView) view;


                if(available[Integer.parseInt(counter.getTag().toString())]== 2 && (winner =="NoOne")){

                    if (activePlayer == 0) {
                        counter.setImageResource(R.drawable.o);
                        activePlayer = 1;
                    } else {
                        counter.setImageResource(R.drawable.x);
                        activePlayer = 0;
                    }

            available[Integer.parseInt(counter.getTag().toString())]  = activePlayer;
                    for (int[] game :WinningStates) {

                        if ((available[game[0]]==available[game[1]])&&
                                (available[game[2]]==available[game[1]]) && available[game[0]]!= 2)
                        {
                            if(available[game[0]]==0) {
                              winner="X";
                            }
                            else {winner = "O";}

                            Log.i("The winner is :" ,winner);
                            Toast.makeText(MainActivity.this,"winner :"+winner,Toast.LENGTH_LONG).show();

                            break;
                        }

                    }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
