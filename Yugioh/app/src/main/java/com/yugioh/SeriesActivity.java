package com.yugioh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.character.CharacterARCVActivity;
import com.character.CharacterDMActivity;
import com.character.CharacterFIVEDSActivity;
import com.character.CharacterGXActivity;
import com.character.CharacterZEXALActivity;

/**
 * Created by hpl on 2015/12/10.
 */
public class SeriesActivity extends Activity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    boolean isIconChange1 = false;
    boolean isIconChange2 = false;
    boolean isIconChange3 = false;
    boolean isIconChange4 = false;
    boolean isIconChange5 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.series_layout);

        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                if(isIconChange1){
                    button1.setBackgroundResource(R.drawable.second_button1);
                    isIconChange1 = false;
                }else{
                    button1.setBackgroundResource(R.drawable.second_button101);
                    isIconChange1 = true;
                    isIconChange2 = true;
                    isIconChange3 = true;
                    isIconChange4 = true;
                    isIconChange5 = true;
                }
                Intent intent1 = new Intent(SeriesActivity.this, CharacterDMActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_2:
                if(isIconChange2){
                    button2.setBackgroundResource(R.drawable.second_button2);
                    isIconChange2 = false;
                }else{
                    button2.setBackgroundResource(R.drawable.second_button201);
                    isIconChange1 = true;
                    isIconChange2 = true;
                    isIconChange3 = true;
                    isIconChange4 = true;
                    isIconChange5 = true;
                }
                Intent intent2 = new Intent(SeriesActivity.this, CharacterGXActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_3:
                if(isIconChange3){
                    button3.setBackgroundResource(R.drawable.second_button3);
                    isIconChange3 = false;
                }else{
                    button3.setBackgroundResource(R.drawable.second_button301);
                    isIconChange1 = true;
                    isIconChange2 = true;
                    isIconChange3 = true;
                    isIconChange4 = true;
                    isIconChange5 = true;
                }
                Intent intent3 = new Intent(SeriesActivity.this, CharacterFIVEDSActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_4:
                if(isIconChange4){
                    button4.setBackgroundResource(R.drawable.second_button4);
                    isIconChange4 = false;
                }else{
                    button4.setBackgroundResource(R.drawable.second_button401);
                    isIconChange1 = true;
                    isIconChange2 = true;
                    isIconChange3 = true;
                    isIconChange4 = true;
                    isIconChange5 = true;
                }
                Intent intent4 = new Intent(SeriesActivity.this, CharacterZEXALActivity.class);
                startActivity(intent4);
                break;
            case R.id.button_5:
                if(isIconChange5){
                    button5.setBackgroundResource(R.drawable.second_button5);
                    isIconChange5 = false;
                }else{
                    button5.setBackgroundResource(R.drawable.second_button501);
                    isIconChange1 = true;
                    isIconChange2 = true;
                    isIconChange3 = true;
                    isIconChange4 = true;
                    isIconChange5 = true;
                }
                Intent intent5 = new Intent(SeriesActivity.this, CharacterARCVActivity.class);
                startActivity(intent5);
                break;
            default:
                break;
        }

    }



    @Override  protected void onRestart() {
        super.onRestart();
        if(isIconChange1){
            button1.setBackgroundResource(R.drawable.second_button1);
            isIconChange1 = false;
        }else{
            button1.setBackgroundResource(R.drawable.second_button101);
            isIconChange1 = true;
        }

        if(isIconChange2){
            button2.setBackgroundResource(R.drawable.second_button2);
            isIconChange2 = false;
        }else{
            button2.setBackgroundResource(R.drawable.second_button201);
            isIconChange2 = true;
        }

        if(isIconChange3){
            button3.setBackgroundResource(R.drawable.second_button3);
            isIconChange3 = false;
        }else{
            button3.setBackgroundResource(R.drawable.second_button301);
            isIconChange3 = true;
        }

        if(isIconChange4){
            button4.setBackgroundResource(R.drawable.second_button4);
            isIconChange4 = false;
        }else{
            button4.setBackgroundResource(R.drawable.second_button401);
            isIconChange4 = true;
        }

        if(isIconChange5){
            button5.setBackgroundResource(R.drawable.second_button5);
            isIconChange5 = false;
        }else{
            button5.setBackgroundResource(R.drawable.second_button501);
            isIconChange5 = true;
        }
    }

}
