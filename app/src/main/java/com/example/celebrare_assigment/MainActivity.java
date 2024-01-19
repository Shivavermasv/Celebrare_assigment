package com.example.celebrare_assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button undo;
    private Button redo;
    private TextView text;
    public static Stack<Text> stack = new Stack<>();
    public static Stack<Text> redo_stack = new Stack<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        text = findViewById ( R.id.text2 );
        undo = findViewById ( R.id.undo );
        redo = findViewById ( R.id.redo );
        Toast.makeText ( this, "Click On The TextField To Edit", Toast.LENGTH_SHORT ).show ();
        text.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (MainActivity.this, text_editing.class) );
            }
        } );
        undo ();
        redo ();
    }
     public void onResume() {
         super.onResume ();
         if(!stack.isEmpty ()){
             Text text_data = stack.peek ();
             text.setText ( text_data.text );
             text.setTextColor ( text_data.color );
             text.setTextSize ( text_data.size );
             text.setTypeface ( text_data.font );
         }
         undo ();
         redo ();
     }
     private void undo(){
        undo.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if(stack.isEmpty ()){
                    Toast.makeText ( MainActivity.this, "Nothing to UnDo!!", Toast.LENGTH_SHORT ).show ();
                }
                else{
                    Text text_data = stack.pop ();
                    redo_stack.push ( text_data );
                    text.setText ( text_data.text );
                    text.setTextColor ( text_data.color );
                    text.setTextSize ( text_data.size );
                    text.setTypeface ( text_data.font );
                }
            }
        } );
     }

     private void redo(){
        redo.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if(redo_stack.isEmpty ()){
                    Toast.makeText ( MainActivity.this, "Nothing to ReDo!!", Toast.LENGTH_SHORT ).show ();
                }
                else{
                    Text text_data = redo_stack.pop ();
                    stack.push ( text_data );
                    text.setText ( text_data.text );
                    text.setTextColor ( text_data.color );
                    text.setTextSize ( text_data.size );
                    text.setTypeface ( text_data.font );
                }
            }
        } );
     }
}