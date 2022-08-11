package com.example.doctorsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppointmentComplete extends AppCompatActivity {

    //appointmentComplete data
    EditText name, email, phone, address, age, date;
    CheckBox male, female;
    Button button;
    DatabaseReference appReff;
    Appointment appointment;
    // end of activity_home
    String DoctorName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointmentcomplete);


        ///getting date from patient selection

        String fullDate = getIntent().getStringExtra("fullDate");
        DoctorName = getIntent().getStringExtra("doctor");

        /// for passing data into the firebase

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        date = findViewById(R.id.date);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        button = findViewById(R.id.btn);

        //setting the date.
        date.setText(fullDate);
        //end of date


        appReff = FirebaseDatabase.getInstance().getReference().child("Appointment");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertAppointmentData();
            }
        });


    }


    private void insertAppointmentData() {
        String Name = name.getText().toString().trim();
        String Email = email.getText().toString().trim();
        int Phone = Integer.parseInt(phone.getText().toString().trim());
        String Address = address.getText().toString().trim();
        int Age = Integer.parseInt(age.getText().toString().trim());
        String Date = date.getText().toString().trim();

        String Male = male.getText().toString().trim();
        String Female = female.getText().toString().trim();

        appointment = new Appointment();
        appointment.setName(Name);
        appointment.setAddress(Address);
        appointment.setAge(Age);
        appointment.setDate(Date);
        appointment.setMale(Male);
        appointment.setPhone(Phone);
        appointment.setEmail(Email);
        appointment.setDoctor(DoctorName);

        appReff.push().setValue(appointment);
        Toast.makeText(AppointmentComplete.this, "Data Insert Successfully!", Toast.LENGTH_LONG).show();


    }


}

