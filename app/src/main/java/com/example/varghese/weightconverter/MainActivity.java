package com.example.varghese.weightconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText userWeight;
    ToggleButton units;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Widgets
        TextView userWeightPrompt = (TextView) findViewById(R.id.userWeightPrompt);
        userWeight = (EditText) findViewById(R.id.userWeight);
        units = (ToggleButton) findViewById(R.id.units);
        final TextView convertPrompt = (TextView) findViewById(R.id.convertPrompt);
        Button piesButton = (Button) findViewById(R.id.piesButton);
        Button booksButton = (Button) findViewById(R.id.booksButton);
        Button benchButton = (Button) findViewById(R.id.benchButton);
        Button staplersButton = (Button) findViewById(R.id.staplersButton);
        Button goatsButton = (Button) findViewById(R.id.goatsButton);
        Button limesButton = (Button) findViewById(R.id.limesButton);

        //When Buttons are clicked
        piesButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View V){
                        convert("pies");
                    }
                }
        );

        booksButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View V){
                        convert("books");
                    }
                }
        );

        benchButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View V){
                        convert("bench");
                    }
                }
        );

        staplersButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View V){
                        convert("staplers");
                    }
                }
        );

        goatsButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View V){
                        convert("goats");
                    }
                }
        );

        limesButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View V){
                        convert("limes");
                    }
                }
        );
    }

    public void convert(String buttonType){
        double weight;
        try {
            weight = Double.parseDouble(userWeight.getText() + "");
        } catch (NumberFormatException e) {
            print("Please Enter a Valid Weight Above!");
            return;
        }

        if (buttonType.equals("pies")){
            weight /= 1.5;
        } else if (buttonType.equals("books")){
            weight /= 15.0/16.0;
        } else if (buttonType.equals("bench")){
            print("Silly Rabbit, Roy can bench any weight");
            return;
        } else if (buttonType.equals("staplers")){
            weight /= 1.37789;
        } else if (buttonType.equals("goats")){
            weight /= 255;
        } else {
            weight /= 5.0/16.0;
        }

        if (units.isChecked()){
            weight *= 2.20462;
        }

        String roundedWeight = (Math.round(weight * 1000) / 1000.0) + "";
        String unitType = units.getText() + "";
        String toPrint = userWeight.getText() + " " + unitType + " = " + roundedWeight + " " + buttonType;
        print(toPrint);
    }

    public void print(String s){
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
