package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name1;
    EditText email1;
    EditText password1;
    Button button_save;
    SharedPreferences sharedPreferences;

     String SHARED_PREF_NAME="mypref";
     String KEY_NAME="name";
     String KEY_EMAIL="email";
     String KEY_PASSWORD="password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1=findViewById(R.id.name);
        email1=findViewById(R.id.email);
        password1=findViewById(R.id.password);
        button_save=findViewById(R.id.button);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_NAME,name1.getText().toString());
                editor.putString(KEY_EMAIL,email1.getText().toString());
                editor.putString(KEY_PASSWORD,password1.getText().toString());
                editor.apply();
                String name=sharedPreferences.getString(KEY_NAME,null);
                String email=sharedPreferences.getString(KEY_EMAIL,null);
                String password=sharedPreferences.getString(KEY_PASSWORD,null);
                if (!name.isEmpty()&&!email.isEmpty()&&Patterns.EMAIL_ADDRESS.matcher(email).matches()&&!password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Log In Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,LogOutActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Give Correct Value", Toast.LENGTH_SHORT).show();
            }
        });
    }
}