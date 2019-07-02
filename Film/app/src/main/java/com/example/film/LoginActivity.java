package com.example.film;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_email, et_password;
    SharedPreferences prefs;
    TextView tv_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs = getSharedPreferences(getString(R.string.prefs_name), Context.MODE_PRIVATE);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        tv_url = findViewById(R.id.tv_url);
    }

    public void LoginPressed(View view) {
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        if (checkFields(email, password)) {
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("email", et_email.getText().toString());
            editor.putString("password", et_password.getText().toString());

            editor.commit();
            finish();
        }
    }

    private boolean checkFields(String email, String password) {
        boolean result = true;

        if ("".equals(email)) {
            Toast.makeText(this,R.string.emptyLogin,Toast.LENGTH_LONG).show();
            result = false;
        }
        if ("".equals(password)) {
            Toast.makeText(this,R.string.emptyLogin,Toast.LENGTH_LONG).show();
            result = false;
        }
        return result;
    }

    public void openBrowserPressed(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.abc.es/play/cine/peliculas"));
        startActivity(intent);
    }
}
