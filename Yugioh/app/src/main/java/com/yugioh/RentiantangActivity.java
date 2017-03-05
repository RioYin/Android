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
public class RentiantangActivity extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rentiantang);


        button = (Button) findViewById(R.id.button_to_rentiantang);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://bbs.newwise.com/forum-8-1.html"));
                startActivity(intent);
            }

        });
    }
}
