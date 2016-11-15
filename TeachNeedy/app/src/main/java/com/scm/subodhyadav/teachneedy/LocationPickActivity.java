package com.scm.subodhyadav.teachneedy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LocationPickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_pick);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"Government Boys Senior Secondary School, Okhla", "Government Boys Senior Secondary School, Hari Nagar", "Government Girls/Boys Senior Secondary School No. 1, Shakti Nagar","Govt. Co. Ed. Senior Secondary School, Laxmi Bagh"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        final Spinner dropdown2 = (Spinner)findViewById(R.id.spinner2);
        String[] items2 = new String[]{"Basic Maths","Basic English"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);

        Spinner dropdown3 = (Spinner)findViewById(R.id.spinner3);
        String[] items3 = new String[]{"1:00 PM - 2.30 PM", "6:00 PM - 7:30 PM"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);

        Button cb = (Button) findViewById(R.id.mychoice);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT).show();
                // do something when the corky is clicked
            }
        });
    }
}
