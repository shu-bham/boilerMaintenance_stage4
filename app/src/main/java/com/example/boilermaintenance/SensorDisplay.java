package com.example.boilermaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SensorDisplay extends AppCompatActivity implements View.OnClickListener {
Button us_graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_display);
        us_graph=(Button)findViewById(R.id.us);


        us_graph.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==us_graph){
            startActivity(new Intent(this, us_graph.class));


        }
    }
}
