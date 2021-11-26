package com.celine.odette.valdez.pena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RestaActivity extends AppCompatActivity {

    private EditText editTextXR;
    private EditText editTextYR;
    private EditText editTextTotalR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resta);
        editTextXR = findViewById( R.id.editTextNumberXR );
        editTextYR = findViewById( R.id.editTextNumberYR );
        editTextTotalR = findViewById( R.id.editTextNumberTotalR );
        editTextXR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus ) {
                    realizaOperacion();
                }
            }
        });
        editTextYR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus ) {
                    realizaOperacion();
                }
            }
        });

    }
    private void realizaOperacion()
    {
        int total = 0;
        if( editTextXR.getText().toString() != null )
        {
            if( isEntero( editTextXR.getText().toString() ) )
            {
                total += getEntero( editTextXR.getText().toString() );
            }
        }
        if( editTextYR.getText().toString() != null )
        {
            if( isEntero( editTextYR.getText().toString() ) )
            {
                total -= getEntero( editTextYR.getText().toString() );
            }
        }
        editTextTotalR.setText( String.format("%d" , total ) , TextView.BufferType.SPANNABLE );
        editTextTotalR.setEnabled( false );
    }

    private int getEntero(String entero)
    {
        try
        {
            return Integer.parseInt( entero );
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    private boolean isEntero(String entero)
    {
        try
        {
            if( entero == null || entero.length() == 0)
            {
                return false;
            }
            Integer.parseInt( entero );
            return true;
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}