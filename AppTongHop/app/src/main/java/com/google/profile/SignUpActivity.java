package com.google.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private Button btnSignUp;
    private TextView txtLogin,txtaccount,txtPass,txtcomfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtLogin = (TextView) findViewById(R.id.txt_actLogin);
        txtaccount = (TextView) findViewById(R.id.txt_actSignup_accname);
        txtPass = (TextView) findViewById(R.id.txt_actSignup_pass);
        txtcomfirm = (TextView) findViewById(R.id.txt_actSingup_xacnhanpass);
        btnSignUp = (Button) findViewById(R.id.btn_actSignup_signup);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtaccount.getText().toString().equals("") | txtPass.getText().toString().equals("") | txtcomfirm.getText().toString().equals(""))
                {
                    Toast.makeText(SignUpActivity.this,"Bạn chưa nhập tài khoản hoặc mật khẩu hoặc xác nhận", Toast.LENGTH_SHORT).show();
                }
                else if (txtPass.getText().toString().equals(txtcomfirm.getText().toString()))
                    {
                        Toast.makeText(SignUpActivity.this,"Đã đắng ký thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("acccomfirm",txtaccount.getText().toString());
                        bundle.putString("Passcomfirm",txtPass.getText().toString());

                        intent.putExtra("bundle",bundle);

                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this,"Xác nhận mật khẩu sai",Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
    public void Bundle(String acc, String pass){
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("acccomfirm",acc);
        bundle.putString("Passcomfirm",pass);

        intent.putExtra("duLieu",bundle);

        startActivity(intent);
    }
}
