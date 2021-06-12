package com.example.login_sqlite;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText username;
    Button delete;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        username=(EditText)findViewById(R.id.txt_username);
        delete=(Button)findViewById(R.id.btn_delete);
        DB = new DBHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                Toast.makeText(DeleteActivity.this, "hey : "+username.getText().toString(), Toast.LENGTH_SHORT).show();
                Boolean deleteuser = DB.deleteData(user);

                if (deleteuser == true) {
                    Toast.makeText(DeleteActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),DeleteActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(DeleteActivity.this, "No user found", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}