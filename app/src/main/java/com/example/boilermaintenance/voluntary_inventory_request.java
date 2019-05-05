package com.example.boilermaintenance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class voluntary_inventory_request extends AppCompatActivity implements View.OnClickListener {
    Button placeO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voluntary_inventory_request);
        placeO=(Button)findViewById(R.id.placeOrder);
        placeO.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v==placeO){
            Toast.makeText(getApplicationContext(),"Order Successfully placed", Toast.LENGTH_LONG).show();
        }
    }
}
