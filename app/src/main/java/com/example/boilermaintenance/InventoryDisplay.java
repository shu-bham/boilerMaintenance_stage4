package com.example.boilermaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InventoryDisplay extends AppCompatActivity implements View.OnClickListener {
    Button volun,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_display);
     volun=(Button)findViewById(R.id.voluntaryCheck);
     reg=(Button)findViewById(R.id.regularCheck);

     volun.setOnClickListener(this);
     reg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==volun){
            startActivity(new Intent(this, voluntary_inventory_request.class));
        }
        if(v==reg){
            startActivity(new Intent(this, inventory_boiler_requires.class));
        }
    }
}
