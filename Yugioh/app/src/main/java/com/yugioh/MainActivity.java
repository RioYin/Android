package com.yugioh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button button;
    private Button button01;
    boolean isIconChange1 = false;
    boolean isIconChange2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isIconChange1){
                    button.setBackgroundResource(R.drawable.mainbutton);
                    isIconChange1 = false;
                }else{
                    button.setBackgroundResource(R.drawable.mainbutton01);
                    isIconChange1 = true;
                    isIconChange2 = true;
                }
                Intent intent = new Intent(MainActivity.this, SeriesActivity.class);
                startActivity(intent);

        }
        });

        button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isIconChange2){
                    button01.setBackgroundResource(R.drawable.mainbutton2);
                    isIconChange2 = false;
                }else{
                    button01.setBackgroundResource(R.drawable.mainbutton201);
                    isIconChange2 = true;
                    isIconChange1 = true;
                }
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override  protected void onRestart() {
        super.onRestart();
        if(isIconChange1){
            button.setBackgroundResource(R.drawable.mainbutton);
            isIconChange1 = false;
        }else{
            button.setBackgroundResource(R.drawable.mainbutton01);
            isIconChange1 = true;
        }
        if(isIconChange2){
            button01.setBackgroundResource(R.drawable.mainbutton2);
            isIconChange2 = false;
        }else{
            button01.setBackgroundResource(R.drawable.mainbutton201);
            isIconChange2 = true;
        }
    }

}
