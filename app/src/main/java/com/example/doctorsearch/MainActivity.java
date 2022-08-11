package com.example.doctorsearch;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ///date picker
    private DatePickerDialog datePickerDialog;
    private Button datepickerbtn;
    int week;
    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ///date picker
        initDatePicker();
        datepickerbtn = findViewById(R.id.datepicker);
        ///find all autocomplete view and imageview

        final AutoCompleteTextView doctor = (AutoCompleteTextView) findViewById(R.id.doctor);
        final AutoCompleteTextView specialization = (AutoCompleteTextView) findViewById(R.id.specialization);
        final AppCompatButton btn = (AppCompatButton) findViewById(R.id.btn);
        final ImageView image2 = (ImageView) findViewById(R.id.imag2);
        final ImageView image3 = (ImageView) findViewById(R.id.imag3);
        final TextView rofiq=(TextView)findViewById(R.id.rofiq);
        final TextView mehedi=(TextView)findViewById(R.id.mehedi);
        final TextView shariar=(TextView)findViewById(R.id.shariar);
        final TextView aminul=(TextView)findViewById(R.id.aminul);
        final AppCompatButton btn1=(AppCompatButton)findViewById(R.id.btn1);
        final AppCompatButton btn2=(AppCompatButton)findViewById(R.id.btn2);
        final AppCompatButton btn3=(AppCompatButton)findViewById(R.id.btn3);
        final AppCompatButton btn4=(AppCompatButton)findViewById(R.id.btn4);

        final TextView viewmore = (TextView) findViewById(R.id.viewmore);


        doctor.setThreshold(2);
        specialization.setThreshold(1);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, MainActivity.doctor);
        doctor.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, MainActivity.specialization);
        specialization.setAdapter(adapter2);


        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctor.showDropDown();
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                specialization.showDropDown();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Doctor = doctor.getText().toString();
                String Specialization = specialization.getText().toString();
                String fullDate = datepickerbtn.getText().toString();
                String dateToday = res;
                String check="clickbtn";

                Intent intentDoctorList = new Intent(MainActivity.this, DoctorListActivity.class);
                intentDoctorList.putExtra("keydoctor", Doctor);
                intentDoctorList.putExtra("keyspecialization", Specialization);
                intentDoctorList.putExtra("fullDate", fullDate);
                intentDoctorList.putExtra("day", dateToday);
                intentDoctorList.putExtra("clickbtn",check);
                intentDoctorList.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentDoctorList);
            }
        });

        viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DoctorListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doctorName=rofiq.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String fullDate=formatter.format(date);
                Intent intent=new Intent(MainActivity.this,AppointmentComplete.class);
                intent.putExtra("doctor",doctorName);
                intent.putExtra("fullDate",fullDate);
                startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doctorName=mehedi.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String fullDate=formatter.format(date);
                Intent intent=new Intent(MainActivity.this,AppointmentComplete.class);
                intent.putExtra("doctor",doctorName);
                intent.putExtra("fullDate",fullDate);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doctorName=shariar.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String fullDate=formatter.format(date);
                Intent intent=new Intent(MainActivity.this,AppointmentComplete.class);
                intent.putExtra("doctor",doctorName);
                intent.putExtra("fullDate",fullDate);
                startActivity(intent);
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doctorName=aminul.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date date = new Date();
                String fullDate=formatter.format(date);
                Intent intent=new Intent(MainActivity.this,AppointmentComplete.class);
                intent.putExtra("doctor",doctorName);
                intent.putExtra("fullDate",fullDate);
                startActivity(intent);
            }
        });

    }


    ///init of date picker
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE");
                Date dayy = new Date(year, month, day - 1);
                res = simpledateformat.format(dayy);
                month = month + 1;
                String date = makeDateString(day, month, year);
                datepickerbtn.setText(date);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        //style of Calendar with alertdialog box
        int style = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);

    }

    private String makeDateString(int day, int month, int year) {
        return month + "/ " + day + "/ " + year;
    }


    private static final String[] doctor = new String[]{"Dr.Rofiqul Islam", "Dr.Kashem Tipu", "Dr.Mohsin Hossain", "Dr.Akram Hossain", "Dr.Abdul Aziz", "Dr.Shariar"};
    private static final String[] specialization = new String[]{"Neurology", "Gastrology", "psychiatrist", "Cardiology", "Oncology", "Eye Specialist"};


    //open datepicker dialog to show the result
    public void openDatePicker(View view) {

        datePickerDialog.show();
    }
}
