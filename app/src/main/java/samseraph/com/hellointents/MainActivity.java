package samseraph.com.hellointents;

import android.content.Intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private Button btnCall, btnHome, btnMap, btnDetails;
    private Spinner spNameslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btn_call);
        btnHome = findViewById(R.id.btn_homepage);
        btnMap = findViewById(R.id.btn_map);
        btnDetails = findViewById(R.id.btn_details);
        spNameslist = findViewById(R.id.sp_nameslist);

        //array, gegevens om weer te geven
        String names[] = {"Jan", "Piet", "Joris", "Korneel"};
        //adapter -> klasse die elementen it lijst in layout steekt per rij voor bv. spinner, listview, ...
        //arrayadapter kan maar 1 lijn tekst weergeven per rij
        ArrayAdapter<String> myArrayadapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, names);
        //adapter toevoegen aan spinner
        spNameslist.setAdapter(myArrayadapter);
        //zelf startwaarde bepalen (hier item op index 3, kan ook via length -1 om de laatste te pakken
        spNameslist.setSelection(3);


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

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedName = (String) spNameslist.getSelectedItem();

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", selectedName);
                startActivity(intent);
            }
        });

    }
}
