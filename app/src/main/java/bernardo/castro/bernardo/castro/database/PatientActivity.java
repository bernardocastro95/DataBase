package bernardo.castro.bernardo.castro.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        EditText name = findViewById(R.id.bernardoPatientName);
        EditText lastName = findViewById(R.id.bernardoPatientLastName);
        Spinner department = findViewById(R.id.bernardoDepartments);

        ArrayAdapter<CharSequence> departments = ArrayAdapter.createFromResource(this, R.array.departments,
                android.R.layout.simple_spinner_item);
        departments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        department.setAdapter(departments);

        
    }
}