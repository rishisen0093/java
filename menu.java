package com.example.helloworld;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.activity_main_menu, menu);
return true;
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {int itemId = item.getItemId();
if (itemId == R.id.new_mail) {
Toast.makeText(this,"A new mail is composed",
Toast.LENGTH_LONG).show();
} else if (itemId == R.id.reply) {
Toast.makeText(this,"A new mail is Replied",
Toast.LENGTH_LONG).show();
} else if (itemId == R.id.forward) {
Toast.makeText(this,"A new mail is forwarded",
Toast.LENGTH_LONG).show();
setContentView(R.layout.activity_main2);
}
return true;
}
}