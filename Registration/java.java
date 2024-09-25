package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class register extends AppCompatActivity {

    EditText ed1,ed2;
    RadioButton r1,r2;
    CheckBox c1,c2,c3;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerData(View v){
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phno);
        r1 = findViewById(R.id.male);
        r2 = findViewById(R.id.female);
        c1 = findViewById(R.id.cricket);
        c2 = findViewById(R.id.kabbadi);
        c3 = findViewById(R.id.read);
        t1 = findViewById(R.id.tv1);


        String uname = ed1.getText().toString();

        String phn = ed2.getText().toString();

        String selectedGender = "";
        if (r1.isChecked()){
            selectedGender = "Male";
        } else if (r2.isChecked()) {
            selectedGender = "Female";
        } else {
            selectedGender = "Nothing Selected";
        }

        String selectedHobbies = "";
        if (c1.isChecked()){
            selectedHobbies += "Cricket ";
        }
        if (c2.isChecked()){
            selectedHobbies += "Kabbaddi ";
        }
        if (c3.isChecked()){
            selectedHobbies += "Reading ";
        }

        String Message = "Your Name Is : "+ uname +"\nYour Phone Number IS : "+ phn +"\nYour Gender is "+ selectedGender +"\nYour Selected Hobbies are "+ selectedHobbies;
        t1.setText(Message);
    }
}
