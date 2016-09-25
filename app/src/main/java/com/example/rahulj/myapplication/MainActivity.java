package com.example.rahulj.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        CharSequence text = "Welcome!!!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        //testing
        toast.show();
    }

    public void location(View view){
        EditText loc = (EditText)findViewById(R.id.editText);
        String location = loc.getText().toString();
        String location_s = location.replace(' ','+');

        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+location_s);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            Context context = getApplicationContext();
            CharSequence text = "Opening location";
            int duration = Toast.LENGTH_SHORT;
            startActivity(mapIntent);
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void browser(View view){
        EditText brow = (EditText)findViewById(R.id.editText2);
        String browser_url = brow.getText().toString();
        Uri webpage = Uri.parse("https:"+browser_url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Context context = getApplicationContext();
            CharSequence text = "Opening browser";
            int duration = Toast.LENGTH_SHORT;
            startActivity(intent);
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }

    public void text_send(View view){
        EditText Ed_message = (EditText)findViewById(R.id.editText3);
        String message = Ed_message.getText().toString();
        Uri number = Uri.parse("tel:"+message);
        Intent intent = new Intent(Intent.ACTION_DIAL, number);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Context context = getApplicationContext();
            CharSequence text = "Opening dialler";
            int duration = Toast.LENGTH_SHORT;
            startActivity(intent);
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }



}
