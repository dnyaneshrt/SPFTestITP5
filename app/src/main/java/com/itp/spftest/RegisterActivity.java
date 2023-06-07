package com.itp.spftest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText et_mail,et_pass;
    Button btn_register;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_mail=findViewById(R.id.et_mailR);
        et_pass=findViewById(R.id.et_passR);
        btn_register=findViewById(R.id.btn_registerR);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //is used to get an Object of SPF
                SharedPreferences spf=   getSharedPreferences("mySPF", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=spf.edit();
                String email=et_mail.getText().toString();
                String pass=et_pass.getText().toString();

                editor.putString("email",email);
                editor.putString("pass",pass);

                if(editor.commit()) {
                    Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
                    else {
                    Toast.makeText(RegisterActivity.this, "failed to register", Toast.LENGTH_SHORT).show();
                } }
        });

    }
}