package com.example.manol_000.baseconverter2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*EditText userText = (EditText) findViewById(R.id.textView);
    String inputVar = userText.getText().toString();*/
    String decConv;
    String octConv;
    String hexConv;
    String biConv;

   /* public void read(View v)
    {
        EditText userText = (EditText) findViewById(R.id.textView);
        String inputVar = userText.getText().toString();
    }*/
    boolean checked;
    int radioId=0;//initialize value for
    public void radioCheck(View v)
    {
        radioId=v.getId();
         checked = ((RadioButton)v).isChecked();
       // Toast.makeText(MainActivity.this,checked+"", Toast.LENGTH_LONG).show();
        EditText typeVar=(EditText)findViewById(R.id.textView);
        switch(radioId){
            case(R.id.radio_bi):case(R.id.radio_dec):
                typeVar.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            default:
                typeVar.setInputType(InputType.TYPE_CLASS_TEXT);
        }

    }
    public void converter(View v) {
        //Toast.makeText(MainActivity.this,"testmessage1", Toast.LENGTH_LONG).show();
        TextView dTV = (TextView) findViewById(R.id.decimalValue);
        TextView oTV = (TextView) findViewById(R.id.octalValue);
        TextView hTV = (TextView) findViewById(R.id.hexValue);
        TextView bTV = (TextView) findViewById(R.id.binaryValue);

        EditText userText = (EditText) findViewById(R.id.textView);
        String inputVar = userText.getText().toString();
        //Toast.makeText(MainActivity.this, v.getId() + "," + R.id.convertButton, Toast.LENGTH_LONG).show();

        switch (radioId) {
            case 0:
                Toast.makeText(MainActivity.this, "Please select a base", Toast.LENGTH_LONG).show();
            case R.id.radio_bi:

               // Toast.makeText(MainActivity.this, checked + "", Toast.LENGTH_LONG).show();
                if (checked) {
                   // Toast.makeText(MainActivity.this, "testmessage2", Toast.LENGTH_LONG).show();
                    biConv = inputVar;
                    try {
                        decConv = Integer.toString(Integer.parseInt(inputVar, 2), 10);//convert from binary to dec
                        octConv = Integer.toString(Integer.parseInt(inputVar, 2), 8);//convert from binary to oct
                        hexConv = Integer.toString(Integer.parseInt(inputVar, 2), 16);//convert from binary to hex//
                        // Toast.makeText(MainActivity.this,decConv, Toast.LENGTH_LONG).show();
                        dTV.setText(decConv);
                        bTV.setText(biConv);
                        oTV.setText(octConv);
                        hTV.setText(hexConv);
                    }//      
                    catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Please input a valid number.", Toast.LENGTH_LONG).show();
                        dTV.setText("");
                        bTV.setText("");
                        oTV.setText("");
                        hTV.setText("");

                    }
                }
                break;
            case R.id.radio_oct:
                if (checked) //  check for octal button
                {
                    octConv = inputVar;
                    try {
                        decConv = Integer.toString(Integer.parseInt(inputVar, 8), 10);//convert from oct to dec
                        biConv = Integer.toString(Integer.parseInt(inputVar, 8), 2);//convert from oct to bi
                        hexConv = Integer.toString(Integer.parseInt(inputVar, 8), 16);//convert from oct to hex////          
                        dTV.setText(decConv);
                        bTV.setText(biConv);
                        oTV.setText(octConv);
                        hTV.setText(hexConv);
                    }
                    catch(Exception e) {
                        Toast.makeText(MainActivity.this, "Please input a valid number.", Toast.LENGTH_LONG).show();
                        dTV.setText("");
                        bTV.setText("");
                        oTV.setText("");
                        hTV.setText("");
                }
                }

                break;
            case R.id.radio_dec:
                if (checked)//check for decimal button
                {
                    decConv = inputVar;
                    try {
                        biConv = Integer.toString(Integer.parseInt(inputVar, 10), 2);//convert from decimal to binary
                        octConv = Integer.toString(Integer.parseInt(inputVar, 10), 8);//convert from decimal to oct
                        hexConv = Integer.toString(Integer.parseInt(inputVar, 10), 16);//convert from binary to hex//
                        //Toast.makeText(MainActivity.this, decConv + " " + biConv + " " + octConv, Toast.LENGTH_LONG).show();
                        dTV.setText(decConv);
                        bTV.setText(biConv);
                        oTV.setText(octConv);
                        hTV.setText(hexConv);
                    }
                    catch(Exception e) {
                        Toast.makeText(MainActivity.this, "Please input a valid number.", Toast.LENGTH_LONG).show();
                        dTV.setText("");
                        bTV.setText("");
                        oTV.setText("");
                        hTV.setText("");
                    }
                }
                break;
            case R.id.radio_hex:
                if (checked)//is hex checked
                {
                    hexConv = inputVar;
                    try {
                        decConv = Integer.toString(Integer.parseInt(inputVar, 16), 10);//convert from hex to dec
                        octConv = Integer.toString(Integer.parseInt(inputVar, 16), 8);//convert from hex to oct
                        biConv = Integer.toString(Integer.parseInt(inputVar, 16), 2);
                        dTV.setText(decConv);
                        bTV.setText(biConv);
                        oTV.setText(octConv);
                        hTV.setText(hexConv);
                    }
                    catch(Exception e) {
                        Toast.makeText(MainActivity.this, "Please input a valid number.", Toast.LENGTH_LONG).show();
                        dTV.setText("");
                        bTV.setText("");
                        oTV.setText("");
                        hTV.setText("");
                    }
                }
                break;
        }
    }
      public void closer(View v)
    {
        this.finish();
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.manol_000.baseconverter/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);*/
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       /* Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.manol_000.baseconverter/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();*/
    }
}

