package com.celine.odette.valdez.pena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MultiplicacionActivity  extends AppCompatActivity {

    private EditText editTextXM;
    private EditText editTextYM;
    private EditText editTextTotalM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion);
        editTextXM = findViewById( R.id.editTextNumberXM );
        editTextYM = findViewById( R.id.editTextNumberYM );
        editTextTotalM = findViewById( R.id.editTextNumberTotalM );
        editTextXM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus ) {
                    realizaOperacion();
                }
            }
        });
        editTextYM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        if( editTextXM.getText().toString() != null )
        {
            if( isEntero( editTextXM.getText().toString() ) )
            {
                total += getEntero( editTextXM.getText().toString() );
            }
        }
        if( editTextYM.getText().toString() != null )
        {
            if( isEntero( editTextYM.getText().toString() ) )
            {
                total *= getEntero( editTextYM.getText().toString() );
            }
        }
        editTextTotalM.setText( String.format("%d" , total ) , TextView.BufferType.SPANNABLE );
        editTextTotalM.setEnabled( false );
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