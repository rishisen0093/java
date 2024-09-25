package com.example.firebaseconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View; import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
EditText email, password; FirebaseAuth auth;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login);
email = (EditText) findViewById(R.id.email);
password = (EditText) findViewById(R.id.password);

auth = FirebaseAuth.getInstance();
}

@Override
public void onStart() {
super.onStart();
// If user logged in, go to sign-in screen
if (auth.getCurrentUser() != null) {
startActivity(new Intent(this, MainActivity.class));
finish();
}
}

public void loginButtonClicked(View view) {
String Email = email.getText().toString();
final String pass = password.getText().toString();
if (TextUtils.isEmpty(Email)) {
Toast.makeText(getApplicationContext(), "Enter email address!",
Toast.LENGTH_SHORT).show();
return;
}

if (TextUtils.isEmpty(pass)) {
Toast.makeText(getApplicationContext(), "Enter password!",
Toast.LENGTH_SHORT).show(); return;
}

//progressBar.setVisibility(View.VISIBLE);

if (pass.length() < 6) {
password.setError("Should be greater than 6");
}
//authenticate user
auth.signInWithEmailAndPassword(Email, pass) .addOnCompleteListener(login.this, new
OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
if (!task.isSuccessful()) {
// there was an error
Toast.makeText(login.this, "Authentication failed." +
task.getException(),
Toast.LENGTH_LONG).show();
Log.e("MyTag", task.getException().toString());
} else {
Intent intent = new Intent(login.this, MainActivity.class);
startActivity(intent);
finish();
}
}
});
}
public void registerRe(View view) {
Intent i = new Intent(this, register.class);
startActivity(i);
}
}
