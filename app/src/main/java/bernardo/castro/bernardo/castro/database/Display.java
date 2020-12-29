package bernardo.castro.bernardo.castro.database;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.FrameLayout;

public class Display extends AppCompatActivity {

    boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.display_fragment, new DisplayFragment());
        ft.commit();

        final FloatingActionButton main = findViewById(R.id.fab);
        final FloatingActionButton test = findViewById(R.id.bernardoFabTest);
        final FloatingActionButton patient = findViewById(R.id.bernardoFabPatient);

        main.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                if(clicked){
                    main.animate().rotation(45);
                    test.setVisibility(View.VISIBLE);
                    test.animate().translationY(-500);
                    patient.setVisibility(View.VISIBLE);
                    patient.animate().translationY(-300);
                }
                else {
                    main.animate().rotation(0);
                    test.animate().translationY(0);
                    patient.animate().translationY(0);
                    test.setVisibility(View.INVISIBLE);
                    patient.setVisibility(View.INVISIBLE);
                }
                clicked = !clicked;
            }
        });

    }
}