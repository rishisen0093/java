package com.example.myapplication;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker; import java.util.Calendar;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        textview=findViewById(R.id.showtime);
        
    }
    public void onClick(View view){
        opendialog();
    }
    public void opendialog(){
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hours, int min) {
                textview.setText(String.valueOf(hours)+" : "+String.valueOf(min));
                System.out.print("hello");

            }
        }, 15, 20, true);
        dialog.show();
    }
}



