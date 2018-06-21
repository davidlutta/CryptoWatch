package com.davidlutta.galactic_ninja.cryptowatch.UI;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.logonameTextView) TextView mLogoName;
    @Bind(R.id.nameEditText) EditText mName;
    @Bind(R.id.emailEditText) EditText mEmail;
    @Bind(R.id.passwordEditText) EditText mPassword;
    @Bind(R.id.confirmEditText) EditText mConfirmPassword;
    @Bind(R.id.loginButton) Button mLoginButton;
    @Bind(R.id.loginTextView) TextView mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        Typeface cool = Typeface.createFromAsset(getAssets(),"fonts/coolvetica.ttf");
        mLogoName.setTypeface(cool);
        mLogin.setTypeface(cool);

        mLogin.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.loginTextView:
                Intent intent = new Intent(CreateAccount.this,Login_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                break;
            case R.id.loginButton:
                createNewUser();
                break;
        }
    }
}
