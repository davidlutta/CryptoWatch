package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.CryptoWatchTextView) TextView mLogoName;
    @Bind(R.id.emailEditText) EditText mEmail;
    @Bind(R.id.passwordEditText) EditText mPassword;
    @Bind(R.id.loginButton) Button mLogin;
    @Bind(R.id.RegisterTextView) TextView mRegister;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private ProgressDialog mAuthProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        ButterKnife.bind(this);
        Typeface cool = Typeface.createFromAsset(getAssets(),"fonts/coolvetica.ttf");
        mLogoName.setTypeface(cool);
        mEmail.setTypeface(cool);
        mPassword.setTypeface(cool);
        mLogin.setTypeface(cool);
        mRegister.setTypeface(cool);

        mRegister.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        createAuthProgressDialog();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(Login_Activity.this, FeedActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        };
    }

    private void createAuthProgressDialog(){
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading.....");
        mAuthProgressDialog.setMessage("Authenticating...");
        mAuthProgressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.RegisterTextView:
                Intent intent1 = new Intent(Login_Activity.this, CreateAccount.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.loginButton:
                loginWithPassword();
                break;

        }

    }


    private void loginWithPassword(){
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if (email.equals("")){
            mEmail.setError("Please Enter your Email");
            return;
        }

        if (password.equals("")){
            mPassword.setError("Please Enter a password");
            return;
        }

        mAuthProgressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(Login_Activity.this,"Authentification Failed.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if (mAuthStateListener != null){
            mAuth.addAuthStateListener(mAuthStateListener);
        }
    }

}
