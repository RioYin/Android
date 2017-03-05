package com.yugioh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by hpl on 2015/12/30.
 */
public class VideoActivity extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        button = (Button) findViewById(R.id.button_to_video);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.bilibili.com/mobile/search.html?keyword=%E6%B8%B8%E6%88%8F%E7%8E%8B&p=1&order=&tids=-1&type=series"));
                startActivity(intent);
            }

        });
    }
}