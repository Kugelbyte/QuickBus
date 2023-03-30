package com.example.lnctbushelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText emailField;
    EditText passField;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    Button loginBtn;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        Button registerBtn = findViewById(R.id.button5);
        emailField = findViewById(R.id.editTextTextEmailAddress);
        passField = findViewById(R.id.editTextTextPassword);
        loginBtn = findViewById(R.id.button4);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog = new ProgressDialog(this);




        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
            }
        });
    }

    private void performLogin() {

        String email = emailField.getText().toString();
        String password = passField.getText().toString();



        if(!email.matches(emailPattern))
        {
            Toast.makeText(Login.this,"Invalid Email Format",Toast.LENGTH_SHORT).show();
            emailField.requestFocus();

        }
        else if(password.isEmpty() || password.length() < 6)
        {
            Toast.makeText(Login.this,"Invalid Password",Toast.LENGTH_SHORT).show();
            passField.requestFocus();
        }

        else {
            progressDialog.setMessage("Logging in....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                             progressDialog.dismiss();

                            Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT);

                            sendToAnotherActivity();
                        }
                        else
                        {
                            progressDialog.dismiss();
                            Toast.makeText(Login.this,""+task.getException(),Toast.LENGTH_SHORT);
                        }
                }
            });
        }
    }

    public void onClickRegisterBtn(View view) {

      Intent intent = new Intent(Login.this,Register.class);
      startActivity(intent);
    }

    public void sendToAnotherActivity()
    {
        Intent intent = new Intent(Login.this,Management.class);
        startActivity(intent);
    }
}