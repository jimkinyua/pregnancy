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

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    private static final String TAG = "";
    private EditText inputEmail, inputPassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    SignInButton button;
    private final static int RC_SIGN_IN = 123;
//    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth.AuthStateListener mAuthListner;
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        mAuth.addAuthStateListener(mAuthListner);
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        //Check the current user

//        if (mAuth.getCurrentUser()!=null){
//
//            startActivity(new Intent(Login.this, Insert_Data_Activity.class));
//            finish();
//
//        }

        setContentView(R.layout.login);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.Password);
        Button LoginButton = (Button) findViewById(R.id.buttonlogin);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView TextviewSignIn = (TextView) findViewById(R.id.sign_in_button);




        TextviewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter email ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //Authenticate User

                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                if (task.isSuccessful()){
                                    //Execute this in case of error

                                    Log.d(TAG, "signInWithEmail:success");

                                    Intent intent = new Intent(Login.this, Insert_Data_Activity.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Log.d(TAG, "singInWithEmail:Fail");
                                    Toast.makeText(Login.this, "Sorry,Internet connection is poor but you can proceed. ", Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(Login.this, Insert_Data_Activity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Login.this, Insert_Data_Activity.class));
                }
            }
        };


//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


    }
}
