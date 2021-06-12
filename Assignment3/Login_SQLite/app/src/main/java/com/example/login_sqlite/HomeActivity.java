package com.example.login_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.login_sqlite.DBHelper;

public class HomeActivity extends AppCompatActivity {

    Button update,delete,logout;
    TextView welcome;
    String username;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        update=(Button)findViewById(R.id.btn_update);
        delete=(Button)findViewById(R.id.btn_delete);
        logout=(Button)findViewById(R.id.btn_logout);
        welcome = (TextView)findViewById(R.id.txt_welcome);
        update.setVisibility(View.GONE);
        delete.setVisibility(View.GONE);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
            welcome.setText("Welcome "+username);
            if(username.equals("admin"))
            {
                update.setVisibility(View.VISIBLE);
                delete.setVisibility(View.VISIBLE);
                welcome.setText("Welcome Admin");
            }
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DeleteActivity.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UpdateActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
