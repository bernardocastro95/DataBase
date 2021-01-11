package bernardo.castro.bernardo.castro.database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import bernardo.castro.bernardo.castro.database.model.Patient;

public class PatientActivity extends AppCompatActivity {

    public static final String PATIENT_ID = "bernardo.castro.bernardo.castro.database.model.id";
    public static final String PATIENT_NAME = "bernardo.castro.bernardo.castro.database.model.name";
    public static final String PATIENT_LAST_NAME = "bernardo.castro.bernardo.castro.database.model.lastName";

    EditText editName;
    EditText editLastName;
    Spinner editDepartment;
    Button add;

    List<Patient> patients;

    DatabaseReference databasePatients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        databasePatients = FirebaseDatabase.getInstance().getReference("patients");

        editName = findViewById(R.id.bernardoPatientName);
        editLastName = findViewById(R.id.bernardoPatientLastName);
        editDepartment = findViewById(R.id.bernardoDepartments);
        add = findViewById(R.id.bernardoAddPatient);
        ArrayAdapter<CharSequence> departments = ArrayAdapter.createFromResource(this, R.array.departments,
                android.R.layout.simple_spinner_item);
        departments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        editDepartment.setAdapter(departments);

        patients = new ArrayList<>();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPatient();
            }
        });



        
    }

    @Override
    protected void onStart() {
        super.onStart();

        databasePatients.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                patients.clear();

                for(DataSnapshot postSnapshot : snapshot.getChildren()){
                    Patient patient = snapshot.getValue(Patient.class);
                    patients.add(patient);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addPatient(){
        String namePatient = editName.getText().toString().trim();
        String lastNamePatient = editLastName.getText().toString().trim();
        String departmentPatient = editDepartment.getSelectedItem().toString();

        if(!TextUtils.isEmpty(namePatient)){
            String idPatient = databasePatients.push().getKey();

            Patient patient = new Patient(idPatient, namePatient, lastNamePatient, departmentPatient);

            databasePatients.child(idPatient).setValue(patient);

            editName.setText("");

            editLastName.setText("");

            Toast.makeText(this, "Patient Added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Please Insert a Name", Toast.LENGTH_SHORT).show();
        }
    }
}