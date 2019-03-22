package com.febatis.bustop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.febatis.bustop.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void goNextActivity(View view) {

        EditText et = findViewById(R.id.editText);

        Intent i = new Intent(this, BoasVindasActivity.class);
        i.putExtra("username",et.getText().toString());
        startActivity(i);
        finish();
    }
}
