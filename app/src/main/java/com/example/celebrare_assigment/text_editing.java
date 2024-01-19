package com.example.celebrare_assigment;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class text_editing extends AppCompatActivity {
    private Spinner spinner;
    private Button incSize;
    private Button decSize;
    private EditText sizeEditText;
    private int textSize;
    private Typeface typeface;
    private int font_pos;
    private int textColor;
    private int textColorpos;
    private EditText editText;
    private Spinner colorSpinner;
    private Spinner fontSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_editing);
        colorSpinner = findViewById ( R.id.colorAdjusterButton);
        fontSpinner = findViewById(R.id.fontSpinner);
        incSize = findViewById(R.id.increaseSizeButton);
        decSize = findViewById(R.id.decreaseSizeButton);
        sizeEditText = findViewById(R.id.sizeEditText);
        sizeEditText.setText(String.valueOf(textSize));
        editText = findViewById ( R.id.addTextButton );
        sizeAdjust();
        fontSpinnerAdjuster ();
        colorSpinnerAdjuster ();
        history ();
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear the text when the EditText is clicked
                editText.getText().clear();
            }
        });
    }
    private void history(){
        if(!MainActivity.stack.isEmpty ()){
            Text obj = MainActivity.stack.peek ();
            editText.setText ( obj.text );
            fontSpinner.setSelection ( obj.font_pos );
            textSize = obj.size;
            sizeEditText.setText ( String.valueOf ( obj.size ) );
            colorSpinner.setSelection ( obj.color_pos );
            colorSpinner.setBackgroundColor ( obj.color );
        }
    }

    private void sizeAdjust(){

        sizeEditText.addTextChangedListener(new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called to notify you that characters within `charSequence` are about to be replaced with new text
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called to notify you that somewhere within `charSequence` new text has been added or removed
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // This method is called to notify you that the characters within `editable` have changed
                String enteredText = editable.toString();
                if(!enteredText.equals ( "" )){
                    textSize = Integer.parseInt ( enteredText.toString () );
                }
            }
        });


        incSize.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                textSize++;
                sizeEditText.setText ( String.valueOf ( textSize ) );
            }
        } );
        decSize.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                textSize--;
                sizeEditText.setText ( String.valueOf ( textSize ) );
            }
        } );
    }

    private void fontSpinnerAdjuster(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.font_names_,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSpinner.setAdapter(adapter);


        fontSpinner.setOnItemSelectedListener ( new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                font_pos = i;
                switch(i){
                    case 0:
                        typeface = ResourcesCompat.getFont ( text_editing.this, R.font.rci );
                    case 1:
                        typeface = ResourcesCompat.getFont ( text_editing.this, R.font.rbi );
                    case 2:
                        typeface = ResourcesCompat.getFont ( text_editing.this, R.font.rc );
                    case 3:
                        typeface = ResourcesCompat.getFont ( text_editing.this, R.font.ri );
                    case 4:
                        typeface = ResourcesCompat.getFont ( text_editing.this, R.font.robotoblacitalic);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText ( text_editing.this, "Select a Font", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }

    private void colorSpinnerAdjuster(){

        ArrayAdapter<CharSequence> colourAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.colors,
                android.R.layout.simple_spinner_item
        );

        colourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(colourAdapter);

        colorSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                textColorpos = position;
                int selectedColor;
                switch (position) {
                    case 0:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorBlue);
                        break;
                    case 1:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorGreen);
                        break;
                    case 2:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorRed);
                        break;
                    // Add more cases as needed
                    case 3:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorAccent);
                        break;
                    case 4:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorOrange);
                        break;
                    case 5:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorPink);
                        break;
                    case 6:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorPurple);
                        break;
                    case 7:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorTeal);
                        break;
                    case 8:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorYellow);
                        break;
                    // Add more cases as needed
                    case 9:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);
                        break;
                    case 10:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorDivider);
                        break;
                    case 11:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorCustom1);
                        break;
                    default:
                        selectedColor = ContextCompat.getColor(getApplicationContext(), R.color.colorButtonDark);
                        break;
                }
                textColor = selectedColor;
                colorSpinner.setBackgroundColor ( selectedColor );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText ( text_editing.this, "Select a Color", Toast.LENGTH_SHORT ).show ();
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Your custom behavior goes here

        // If you want to perform the default back button action, use onBackPressedDispatcher
        super.onBackPressed ();
        String inputText = editText.getText().toString();
        if(!inputText.equals ( "" ) ){
            Text text = new Text ( textSize, inputText, typeface,font_pos, textColor, textColorpos);
            MainActivity.stack.push ( text );
            Toast.makeText ( text_editing.this, "Done", Toast.LENGTH_SHORT ).show ();
            finish ();
        }
    }
}