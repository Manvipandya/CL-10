package com.example.login_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText username,updated_password;
    Button search,update;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        username=(EditText)findViewById(R.id.txt_username);
        search=(Button)findViewById(R.id.btn_search);
        update=(Button)findViewById(R.id.btn_update);
        updated_password=(EditText)findViewById(R.id.txt_password);
        DB = new DBHelper(this);

        update.setVisibility(View.GONE);
        updated_password.setVisibility(View.GONE);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DB.checkusername(username.getText().toString()))
                {
                    Toast.makeText(UpdateActivity.this, "User Found", Toast.LENGTH_SHORT).show();
                    update.setVisibility(View.VISIBLE);
                    updated_password.setVisibility(View.VISIBLE);

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String password=updated_password.getText().toString();
                            if(DB.updateData(username.getText().toString(),password))
                            {
                                Toast.makeText(UpdateActivity.this, "Updated Succesfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),UpdateActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(UpdateActivity.this, "Could not update user", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),UpdateActivity.class);
                                startActivity(intent);
                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(UpdateActivity.this, "No User Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
