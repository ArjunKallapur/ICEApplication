package com.example.android.iceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //TODO: Alert to set lock screen notification
    //TODO: Notification
    //TODO: Shared Preference
    final int REQUEST_CONTACT = 0xBABA;
    final int REQUEST_PROFILE = 0xABBA;

    SharedPreferences m_sharedPref;
    String m_sharedPref_file = "com.example.android.iceapp";

    String m_name, m_bloodType, m_allergies, m_contact_name, m_contact_phone, m_contact_relation;

    TextView m_name_textView, m_bloodType_textView, m_additional_textView,
            m_contactName_textView, m_contactPhone_textView, m_contactRelation_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the various TextView elements
        m_name_textView = (TextView) findViewById(R.id.name);
        m_bloodType_textView = (TextView) findViewById(R.id.blood_type);
        m_additional_textView = (TextView) findViewById(R.id.additional_information);
        m_contactName_textView = (TextView) findViewById(R.id.contact_name);
        m_contactPhone_textView = (TextView) findViewById(R.id.contact_phone);
        m_contactRelation_textView = (TextView) findViewById(R.id.relation);
        //Initialize the Shared Preference File
        m_sharedPref = getSharedPreferences(m_sharedPref_file, MODE_PRIVATE);

        //Get the Shared Preference stuff then call showAndMakeVisible()
        m_name = m_sharedPref.getString("NAME", "");
        m_bloodType = m_sharedPref.getString("BLOOD_TYPE", "");
        m_allergies = m_sharedPref.getString("ALLERGIES", "");
        showAndMakeVisible(REQUEST_PROFILE);

        m_contact_name = m_sharedPref.getString("CONTACT_NAME", "");
        m_contact_phone = m_sharedPref.getString("CONTACT_PHONE", "");
        m_contact_relation = m_sharedPref.getString("CONTACT_RELATION", "");
        showAndMakeVisible(REQUEST_CONTACT);
    }

    public void editProfile(View view) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivityForResult(intent, REQUEST_PROFILE);

    }

    public void editContact(View view) {
        Intent intent = new Intent(this, EditContactActivity.class);
        startActivityForResult(intent, REQUEST_CONTACT);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_PROFILE) {
            if (resultCode == RESULT_OK) {
                m_name = data.getStringExtra("name");
                m_bloodType = data.getStringExtra("blood_type");
                m_allergies = data.getStringExtra("allergies");
                showAndMakeVisible(REQUEST_PROFILE);
            }
        }

        if (requestCode == REQUEST_CONTACT) {
            if (resultCode == RESULT_OK) {
                //get the data
                m_contact_name = data.getStringExtra("contact_name");
                m_contact_phone = data.getStringExtra("contact_phone_number");
                m_contact_relation = data.getStringExtra("contact_relation");
                showAndMakeVisible(REQUEST_CONTACT);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = m_sharedPref.edit();
        preferencesEditor.putString("NAME", m_name);
        preferencesEditor.putString("BLOOD_TYPE", m_bloodType);
        preferencesEditor.putString("ALLERGIES", m_allergies);
        preferencesEditor.putString("CONTACT_NAME", m_contact_name);
        preferencesEditor.putString("CONTACT_PHONE", m_contact_phone);
        preferencesEditor.putString("CONTACT_RELATION", m_contact_relation);
        preferencesEditor.apply();
    }

    public void showAndMakeVisible(int requestCode){
        if(requestCode == REQUEST_PROFILE){
            m_name_textView.setText(m_name);
            m_name_textView.setVisibility(View.VISIBLE);

            m_bloodType_textView.setText(m_bloodType);
            m_bloodType_textView.setVisibility(View.VISIBLE);

            m_additional_textView.setText(m_allergies);
            m_additional_textView.setVisibility(View.VISIBLE);
        }

        if(requestCode == REQUEST_CONTACT){
            //Set the text of the TextViews and make them VISIBLE
            m_contactName_textView.setText(m_contact_name);
            m_contactName_textView.setVisibility(View.VISIBLE);

            m_contactPhone_textView.setText(m_contact_phone);
            m_contactPhone_textView.setVisibility(View.VISIBLE);

            m_contactRelation_textView.setText(m_contact_relation);
            m_contactRelation_textView.setVisibility(View.VISIBLE);
        }
    }
}
