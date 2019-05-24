package com.example.jim.uzazi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private static final String TAG = "";
    private EditText name, email_id, passwordcheck;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        TextView txtviewSignUp = (TextView) findViewById(R.id.login_page);

        txtviewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });

        mAuth= FirebaseAuth.getInstance();
        email_id = (EditText) findViewById(R.id.input_email);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        passwordcheck = (EditText) findViewById(R.id.input_password);
        Button BtnSignup = (Button) findViewById(R.id.btn_signup);

        BtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_id.getText().toString();
                String password = passwordcheck.getText().toString();

                //Validate Data

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter your Email Address",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Please Provide a password ",Toast.LENGTH_LONG).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()){
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent =new Intent(Register.this,Insert_Data_Activity.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register.this, "Sorry, Seems the Iternet connection is low, but Do't worry",
                                            Toast.LENGTH_LONG).show();
                                    Intent intent =new Intent(Register.this,Insert_Data_Activity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }

}
