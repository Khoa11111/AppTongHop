package com.google.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {
    private AppCompatButton btnLogin;
    private TextView user, password, txtSignUp;
    String name = "";
    String pass = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (AppCompatButton) findViewById(R.id.btn_actLogin_login);
        txtSignUp = (TextView) findViewById(R.id.txt_actSingup);
        user = (TextView) findViewById(R.id.txt_actlogin_user);
        password = (TextView) findViewById(R.id.txt_actlogin_pass);

        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle = intent.getBundleExtra("bundle");
        if (bundle != null) {
            name = bundle.getString("acccomfirm");
            pass = bundle.getString("Passcomfirm");
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equals("") | password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu trống", Toast.LENGTH_SHORT).show();
                } else if (user.getText().toString().equals(name) && password.getText().toString().equals(pass)) {
                    Intent intent = new Intent(LoginActivity.this, ListTree.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
