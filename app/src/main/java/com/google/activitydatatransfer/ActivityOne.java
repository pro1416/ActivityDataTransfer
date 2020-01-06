package com.google.activitydatatransfer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {
    private EditText edtName, edtAge, edtPro;
    Button btnNext;
    private final int requestcode = 1;
    String enteredName, enteredAge, enteredProfession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        edtName = findViewById(R.id.edtOneName);
        edtAge = findViewById(R.id.edtOneAge);
        edtPro = findViewById(R.id.edtOnePro);
        btnNext = findViewById(R.id.btnOneNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtName.getText() != null && edtAge.getText() != null && edtPro.getText() != null) {//check if all fields are filled

                    //get text from all fields
                    String name = edtName.getText().toString().trim();
                    String age = edtAge.getText().toString().trim();
                    String profession = edtPro.getText().toString().trim();

                    Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                    intent.putExtra("name", name);
                    intent.putExtra("age", age);
                    intent.putExtra("profession", profession);
                    startActivityForResult(intent, requestcode);

                } else {
                    Toast.makeText(ActivityOne.this, "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    //To recieve data from activity Two
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestcode) {
            if (data != null) {
                enteredName = data.getStringExtra("name_entered");
                enteredAge = data.getStringExtra("age_entered");
                enteredProfession = data.getStringExtra("pro_entered");

            }
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        edtName.setText(enteredName);
        edtAge.setText(enteredAge);
        edtPro.setText(enteredProfession);
    }
}
