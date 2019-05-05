package com.example.boilermaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoilerDetails extends AppCompatActivity implements View.OnClickListener {
   private Button sen, main, inven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boiler_details);
        sen = (Button) findViewById(R.id.sensor);
        main = (Button) findViewById(R.id.maintenance);
        inven = (Button) findViewById(R.id.inven);

        sen.setOnClickListener(this);
        main.setOnClickListener(this);
        inven.setOnClickListener(this);


}

    @Override
    public void onClick(View v) {
        if(v==sen){

            startActivity(new Intent(this, SensorDisplay.class));
        }
        if(v==main){
            startActivity(new Intent(this, Maintenance.class));

        }
        if(v==inven){
            startActivity(new Intent(this,InventoryDisplay.class));
        }

    }
}