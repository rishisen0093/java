package com.example.realtimedb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
//databse object
private DatabaseReference mDatabase;
EditText tName,tID,tPhone;
Button bSubmit,bcheck;

@Override
protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

//initialise Firebase Database and give the node to insert data
mDatabase = FirebaseDatabase.getInstance().getReference("/StudentDetail");


//initialise views
tName = findViewById(R.id.txt_name);
tID = findViewById(R.id.txt_id);
tPhone = findViewById( R.id.txt_phone);
bSubmit = findViewById(R.id.btn_submit);
bcheck = findViewById(R.id.btn_checkData);

bSubmit.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
//pass data to the model class (it stores data temporarily gives us getter and setter)

student_model model = new
student_model(tID.getText().toString(),tName.getText().toString(),tPhone.getText().toString());

//We are inserting in the child node of refrence giving that child node roll no. value and
then inserting other values under it
//In this code if same id is inserted again it will simply update that roll no.


mDatabase.child(model.roll_no).setValue(model).addOnSuccessListener(new
OnSuccessListener<Void>() {
@Override
public void onSuccess(Void aVoid) {
Toast.makeText(getApplicationContext(),"data added
successfully",Toast.LENGTH_SHORT).show();

//setting the views to empty again
tName.setText("");
tID.setText("");
tPhone.setText("");

}
}).addOnFailureListener(new OnFailureListener() {
@Override
public void onFailure(@NonNull Exception e) {
Toast.makeText(getApplicationContext(),"Error Could not enter
data"+e,Toast.LENGTH_SHORT).show();
}
});

}
});

//intent to go to the retrieval page

bcheck.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
startActivity(new Intent(getApplicationContext(), retreive_data.class));
}
});

}

}
