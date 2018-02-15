package samseraph.com.hellointents;

import android.content.Intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private Button btnCall, btnHome, btnMap, btnDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btn_call);
        btnHome = findViewById(R.id.btn_homepage);
        btnMap = findViewById(R.id.btn_map);
        btnDetails = findViewById(R.id.btn_details);

        btnCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("tel:+32475938112");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }

        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http:www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:35.837, 2.987");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


    }
}
