package com.google.activitydatatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTwo extends AppCompatActivity {
    EditText edtName, edtAge, edtPro;
    Button btnPrevious;
    String name,age,profession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        edtName = findViewById(R.id.edtTwoName);
        edtAge = findViewById(R.id.edtTwoAge);
        edtPro = findViewById(R.id.edtTwoPro);
        btnPrevious = findViewById(R.id.btnPrevious);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
        name = bundle.getString("name");
        age = bundle.getString("age");
        profession = bundle.getString("profession");}

        edtName.setText(name);
        edtAge.setText(age);
        edtPro.setText(profession);
        Toast.makeText(this, "Now change the data in he fields", Toast.LENGTH_LONG).show();

        //Sending data back to activity one
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredName = edtName.getText().toString().trim();
                String enteredAge = edtAge.getText().toString().trim();
                String enteredProfession = edtPro.getText().toString().trim();

                Intent i = getIntent();
                i.putExtra("name_entered", enteredName);
                i.putExtra("age_entered", enteredAge);
                i.putExtra("pro_entered", enteredProfession);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
