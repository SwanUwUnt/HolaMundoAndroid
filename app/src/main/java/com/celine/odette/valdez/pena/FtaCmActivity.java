package com.celine.odette.valdez.pena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FtaCmActivity extends AppCompatActivity {

    private EditText editTextft;
    private EditText editTextcm;
    private Button buttonconversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftacm);
        editTextft = findViewById( R.id.editTextNumberft);
        editTextcm= findViewById( R.id.editTextNumbercm);
        editTextcm.setEnabled( false );
        buttonconversion = findViewById(R.id.buttonconversion );
        buttonconversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaOperacion( );
            }
        });
    }
    private void realizaOperacion()
    {
        double total = 0.00;
        if( editTextft.getText().toString() != null )
        {
            if( isEntero( editTextft.getText().toString() ) )
            {
                total = getEntero( editTextft.getText().toString() ) * 30.48 ;
            }
        }
        editTextcm.setText( String.valueOf(total) ,TextView.BufferType.SPANNABLE );
        editTextcm.setEnabled( false );
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