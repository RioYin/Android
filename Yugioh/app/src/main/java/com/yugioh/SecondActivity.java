package com.yugioh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by hpl on 2015/12/30.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    private Button buttons1;
    private Button buttons2;
    private Button buttons3;
    private Button buttons4;
    private Button buttons5;
    private Button buttons6;
    private Button buttons7;
    private Button buttons8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttons1 = (Button) findViewById(R.id.button_start_duel);
        buttons1.setOnClickListener(this);
        buttons2 = (Button) findViewById(R.id.button_cnocg);
        buttons2.setOnClickListener(this);
        buttons3 = (Button) findViewById(R.id.button_forum);
        buttons3.setOnClickListener(this);
        buttons4 = (Button) findViewById(R.id.button_mycard);
        buttons4.setOnClickListener(this);
        buttons5 = (Button) findViewById(R.id.button_rentiantang);
        buttons5.setOnClickListener(this);
        buttons6 = (Button) findViewById(R.id.button_video);
        buttons6.setOnClickListener(this);
        buttons7 = (Button) findViewById(R.id.button_yu_gi_oh);
        buttons7.setOnClickListener(this);
        buttons8 = (Button) findViewById(R.id.button_ourocg);
        buttons8.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start_duel:
                Intent intent1 = new Intent(SecondActivity.this, StartGameActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_cnocg:
                Intent intent2 = new Intent(SecondActivity.this, CnocgActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_forum:
                Intent intent3 = new Intent(SecondActivity.this, ForumActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_mycard:
                Intent intent4 = new Intent(SecondActivity.this, MycardActivity.class);
                startActivity(intent4);
                break;
            case R.id.button_rentiantang:
                Intent intent5 = new Intent(SecondActivity.this, RentiantangActivity.class);
                startActivity(intent5);
                break;
            case R.id.button_ourocg:
                Intent intent6 = new Intent(SecondActivity.this, OurocgActivity.class);
                startActivity(intent6);
                break;
            case R.id.button_video:
                Intent intent7 = new Intent(SecondActivity.this, VideoActivity.class);
                startActivity(intent7);
                break;
            case R.id.button_yu_gi_oh:
                Intent intent8 = new Intent(SecondActivity.this, YugiohActivity.class);
                startActivity(intent8);
                break;
            default:
                break;


        }
    }
}
