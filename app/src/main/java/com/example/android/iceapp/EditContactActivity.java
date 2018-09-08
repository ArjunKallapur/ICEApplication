package com.example.android.iceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditContactActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    final String DEFAULT_RELATION = "Mother";

    Spinner m_relationSpinner;
    EditText m_firstName_editText, m_lastName_editText, m_phoneNumber_editText;
    String m_firstName, m_lastName, m_phoneNumber, m_relation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        //Initialize the spinner
        m_relationSpinner = (Spinner) findViewById(R.id.relation_spinner);
        m_relationSpinner.setOnItemSelectedListener(this);
        //get the relations array
        String[] relations = getResources().getStringArray(R.array.relations);
        //initialize the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,relations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //set the adapter
        m_relationSpinner.setAdapter(adapter);

        //initializing all the other elements
        m_firstName_editText = (EditText) findViewById(R.id.contact_first_name_editText);
        m_lastName_editText = (EditText) findViewById(R.id.contact_last_name_editText);
        m_phoneNumber_editText = (EditText) findViewById(R.id.contact_phone_editText);

        m_relation = DEFAULT_RELATION;

    }

    public void searchContacts(View view) {
        Toast.makeText(this,"This feature does not appear to be up yet!",Toast.LENGTH_SHORT).show();
    }

    public void endContactActivity(View view) {
        //get the various values
        m_firstName = m_firstName_editText.getText().toString();
        m_lastName = m_lastName_editText.getText().toString();
        m_phoneNumber = m_phoneNumber_editText.getText().toString();


        String full_name = m_firstName + " " + m_lastName;

        //put them into the extras

        Intent replyIntent = new Intent();
        replyIntent.putExtra("contact_name",full_name);
        replyIntent.putExtra("contact_phone_number",m_phoneNumber);
        replyIntent.putExtra("contact_relation", m_relation);

        setResult(RESULT_OK,replyIntent);

        finish();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        m_relation = m_relationSpinner.getSelectedItem().toString();
        Log.d("The relation is: ", m_relation);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
