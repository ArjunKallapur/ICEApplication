package com.example.android.iceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

public class EditProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner m_spinner;
    String m_name, m_allergies, m_bloodType;
    EditText m_firstName_editText, m_lastName_editText, m_allergies_editText;
    public final String DEFAULT_BLOOD_TYPE = "A+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        m_spinner = (Spinner) findViewById(R.id.blood_type_spinner);
        m_spinner.setOnItemSelectedListener(this);

        String[] blood_types = getResources().getStringArray(R.array.blood_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,blood_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        m_spinner.setAdapter(adapter);

        m_firstName_editText = (EditText) findViewById(R.id.first_name_editText);
        m_lastName_editText = (EditText) findViewById(R.id.last_name_editText);
        m_allergies_editText = (EditText) findViewById(R.id.additional_information_editText);

        m_bloodType = DEFAULT_BLOOD_TYPE;
    }

    public void endActivity(View view) {

        m_name = m_firstName_editText.getText().toString() + " " + m_lastName_editText.getText().toString();
        m_allergies = m_allergies_editText.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra("name", m_name);
        replyIntent.putExtra("blood_type", m_bloodType);
        replyIntent.putExtra("allergies", m_allergies);

        setResult(RESULT_OK, replyIntent);


        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        m_bloodType = m_spinner.getItemAtPosition(i).toString();
        Log.d("This is the blood type", m_bloodType);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d("WTF", "RIP");
    }
}
