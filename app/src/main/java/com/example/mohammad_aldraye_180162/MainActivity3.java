package com.example.mohammad_aldraye_180162;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity {
    EditText firstname, lastname, emailinput, phonenumber, userid;
    Button input, update, returnbtn, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bttnAdd = (Button) findViewById(R.id.add);
        Button bttnView = (Button) findViewById(R.id.view);
        Button bttnDelete = (Button) findViewById(R.id.delete);

        final com.example.manageemployees.DatabaseHelper myDB = new com.example.manageemployees.DatabaseHelper(this);
        employeeID = (EditText) findViewById(R.id.id);
        employeeName = (EditText) findViewById(R.id.name);
        employeeSalary = (EditText) findViewById(R.id.salary);


        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ename = employeeName.getText().toString();
                String eID = employeeID.getText().toString();
                String esalary = employeeSalary.getText().toString();
                int salary = new Integer(esalary).intValue();
                if (ename.length() != 0 || eID.length() != 0 || esalary.length() !=0) {
                    myDB.AddEmployee(eID, ename, salary);
                } else {
                    Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bttnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cur = myDB.ViewEmployees();
                StringBuffer buffer = new StringBuffer();
                while(cur.moveToFirst())
                {
                    buffer.append("id: " + cur.getString(0)+ "\n");
                    buffer.append("Name: " + cur.getString(1)+ "\n");
                    buffer.append("Salary: " + cur.getString(2)+ "\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("All Employees");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        bttnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eID = employeeID.getText().toString();
                myDB.DeleteEmployees(eID);
                Toast.makeText(MainActivity.this, "Deleted Employee", Toast.LENGTH_SHORT).show();
            }
        });
    }
}