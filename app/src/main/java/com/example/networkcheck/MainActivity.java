package com.example.networkcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Button btncheck;
    TextView txtState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncheck=findViewById(R.id.btnCheck);
        txtState=findViewById(R.id.txtState);

        if (isOnline()) {
            Toast.makeText(MainActivity.this, "you are connected the internet", Toast.LENGTH_SHORT).show();
            txtState.setText("You Are Connected :)");
        } else {
            Toast.makeText(MainActivity.this, "you are not connected the internet", Toast.LENGTH_SHORT).show();
            txtState.setText("You Are Not Connected :(");
        }

        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    Toast.makeText(MainActivity.this, "you are connected the internet", Toast.LENGTH_SHORT).show();
                    txtState.setText("You Are Connected :)");
                } else {
                    Toast.makeText(MainActivity.this, "you are not connected the internet", Toast.LENGTH_SHORT).show();
                    txtState.setText("You Are Not Connected :(");
                }
            }
        });
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}