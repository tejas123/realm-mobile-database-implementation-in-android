package com.example.tag.realofflineexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.tag.realofflineexample.models.PersonDetailsModel;
import com.example.tag.realofflineexample.R;

public class PersonDetailsActivity extends AppCompatActivity {

    private TextView tvPersonDetailId,tvPersonDetailName,tvPersonDetailEmail,tvPersonDetailAddress,tvPersonDetailAge;
    private PersonDetailsModel personDetailsModel=new PersonDetailsModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getAllWidgets();
        getDataFromPreviousActivity();
        setDataInWidgets();
    }

    private void getAllWidgets()
    {
        tvPersonDetailId= (TextView) findViewById(R.id.tvPersonDetailID);
        tvPersonDetailName= (TextView) findViewById(R.id.tvPersonDetailName);
        tvPersonDetailEmail= (TextView) findViewById(R.id.tvPersonDetailEmail);
        tvPersonDetailAddress= (TextView) findViewById(R.id.tvPersonDetailAddress);
        tvPersonDetailAge= (TextView) findViewById(R.id.tvPersonDetailAge);
    }

    private void getDataFromPreviousActivity()
    {
        int personID = getIntent().getIntExtra("PersonID", -1);
        personDetailsModel=MainActivity.getInstance().searchPerson(personID);
    }

    private void setDataInWidgets()
    {
        tvPersonDetailId.setText(getString(R.string.person_id,String.valueOf(personDetailsModel.getId())));
        tvPersonDetailName.setText(getString(R.string.person_name,personDetailsModel.getName()));
        tvPersonDetailEmail.setText(getString(R.string.person_email,personDetailsModel.getEmail()));
        tvPersonDetailAddress.setText(getString(R.string.person_address,personDetailsModel.getAddress()));
        tvPersonDetailAge.setText(getString(R.string.person_age, String.valueOf(personDetailsModel.getAge())));
    }
}
