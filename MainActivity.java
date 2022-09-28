package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView playerOneScore,playerTwoScore,playerStatus;
    private int playerOneScoreC,playerTwoScoreC;
    private Button[] buttons = new Button[81];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScore=(TextView) findViewById(R.id.playerOneScore);
        playerTwoScore=(TextView) findViewById(R.id.playerTwoScore);

        for(int i=0;i<buttons.length;i++){
            String buttonID = "btn_"+i;
            int resourceID = getResources().getIdentifier(buttonID,"id",getPackageName());
            buttons[i]=(Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v){
        Log.i("test", "onClick: click");
    }
}