package healing.ann.healinghospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.navigation.NavigationBarView;

import java.util.Calendar;
import java.util.Locale;

import healing.ann.healinghospital.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {

   ActivityHomeBinding binding;
    EditText etDate;
    EditText etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new CategorisFragment());
        etDate = findViewById(R.id.et_date);


        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menu_item_id = item.getItemId();
                if (menu_item_id == R.id.home){
                    replaceFragment(new CategorisFragment());

                }


                return true;
            }
        });




    }

    public void startOthopedic(View view) {
        replaceFragment(new LiterateFragment());
    }

    public void startCardiac(View view) {
        replaceFragment(new LiterateFragment());
    }

    public void startNeuroscience(View view) {
        replaceFragment(new LiterateFragment());
    }

    public void startCancer(View view) {
        replaceFragment(new LiterateFragment());
    }

    public void startBillPay(View view) {
        replaceFragment(new LiterateFragment());
    }

    public void startFindADoctor(View view) {
        replaceFragment(new GetSpecialistFragment());
    }

    private  void replaceFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();



    }


    // Function to show the DatePickerDialog
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // This callback is triggered when the user selects a date
                // You can capture the selected year, month, and day and set it in the EditText
                String selectedDate = year + "-" + (month + 1) + "-" + day;
                etDate.setText(selectedDate);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // This callback is triggered when the user selects a time
                // You can capture the selected hour and minute and set it in the EditText
                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                etTime.setText(selectedTime);
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }

    public void startSymptomChecker(View view) {
        replaceFragment(new SymptomCheckFragment());
    }

    public void startInformationViewer(View view) {
        replaceFragment(new InformationFragment());
    }

    public void startGetSpecialist(View view) {
        replaceFragment(new GetSpecialistFragment());
    }

}