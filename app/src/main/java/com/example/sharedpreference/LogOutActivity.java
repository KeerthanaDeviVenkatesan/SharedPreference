package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogOutActivity extends AppCompatActivity {
    TextView text_name;
    TextView text_email;
    TextView text_password;

    Button button_logout;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASSWORD="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        text_name=findViewById(R.id.name1);
        text_email=findViewById(R.id.email1);
        text_password=findViewById(R.id.password1);
        button_logout=findViewById(R.id.button);


        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name=sharedPreferences.getString(KEY_NAME,null);
        String email=sharedPreferences.getString(KEY_EMAIL,null);
        String password=sharedPreferences.getString(KEY_PASSWORD,null);
        if (name!=null||email!=null||password!=null) {
            text_name.setText("Your Name --- "+name);
            text_email.setText("Your Email id --- "+email);
            text_password.setText("Your Password ---"+password);
        }
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogOutActivity.this, "Log Out Successfully", Toast.LENGTH_SHORT).show();
                finish();
                    Intent intent=new Intent(LogOutActivity.this,MainActivity.class);
                    startActivity(intent);
            }
        });

    }
}