package com.example.firebaseconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult; import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

EditText email, pass;
FirebaseAuth auth;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.activity_register);
email = (EditText) findViewById(R.id.username);
pass = (EditText) findViewById(R.id.password);
auth = FirebaseAuth.getInstance();
}
@Override
public void onStart(){
super.onStart();

if(auth.getCurrentUser() != null){ startActivity(new Intent(this, MainActivity.class));
finish();
}
}

public void registerDB(View v){
String useremail = email.getText().toString().trim();
String password = pass.getText().toString().trim();

if (TextUtils.isEmpty(useremail)){
Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_LONG).show();
return;
}

if (TextUtils.isEmpty(useremail)){
Toast.makeText(getApplicationContext(), "Enter Password",
Toast.LENGTH_LONG).show();
return;
}
if (password.length() < 6){
Toast.makeText(getApplicationContext(), "Password too Short",
Toast.LENGTH_LONG).show();
return;
}

auth.createUserWithEmailAndPassword(useremail, password)
.addOnCompleteListener(register.this,
new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
Toast.makeText(register.this,
"createUserWithEmail:onComplete" +
task.isSuccessful(),
Toast.LENGTH_SHORT).show();

if (!task.isSuccessful()){
Toast.makeText(register.this,
"Authentication Failed" +
task.getException(),
Toast.LENGTH_LONG).show();
Log.e("MyTag", task.getException().toString());
}else{
startActivity(new Intent(register.this,
MainActivity.class));
finish();
}
}
});
}
public void loginPage(View v){
startActivity(new Intent(this, login.class));
}
}
