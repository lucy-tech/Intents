package com.example.espiritu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText TextMessage, TextNumberHour, TextNumberMinute;
    Button ButtonSetAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref();
        ButtonSetAlarm.setOnClickListener(setAlarm);
    }

    View.OnClickListener setAlarm= new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String message=TextMessage.getText().toString();
            int hours=Integer.parseInt(TextNumberHour.getText().toString());
            int minutes=Integer.parseInt(TextNumberMinute.getText().toString());

            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_HOUR, hours);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    };

    private void ref()
    {
        TextNumberHour=findViewById(R.id.TextNumberHour);
        TextNumberMinute=findViewById(R.id.TextNumberMinute);
        TextMessage=findViewById(R.id.TextMessage);
        ButtonSetAlarm=findViewById(R.id.ButtonSetAlarm);
    }
}