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

public class Register extends AppCompatActivity {
    EditText emailField;
    EditText passField;
    EditText confirmField;
    Button regBtn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        emailField =  findViewById(R.id.editTextTextEmailAddress2);
        passField  = findViewById(R.id.editTextTextPassword2);
        confirmField  = findViewById(R.id.editTextTextPassword2);
         regBtn= findViewById(R.id.button6);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog = new ProgressDialog(this);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAuth();
            }
        });










    }
    private void sendToNewActivity()
    {
        Intent intent = new Intent(Register.this,Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private void performAuth() {

        String email = emailField.getText().toString();
        String password = passField.getText().toString();
        String confirmPassword = confirmField.getText().toString();


        if(!email.matches(emailPattern))
        {
            Toast.makeText(Register.this,"Invalid Email Format",Toast.LENGTH_SHORT).show();
            emailField.requestFocus();
        }
        else if(password.isEmpty() || password.length() < 6)
        {
            Toast.makeText(Register.this,"Invalid Password",Toast.LENGTH_SHORT).show();
            passField.requestFocus();
        }
        else if(!password.equals(confirmPassword))
        {
            Toast.makeText(Register.this,"Password do not match.",Toast.LENGTH_SHORT).show();
        }
        else
        {
            progressDialog.setMessage("Registering....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Register.this,"Registration Successful.",Toast.LENGTH_SHORT).show();
                        sendToNewActivity();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(Register.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

}