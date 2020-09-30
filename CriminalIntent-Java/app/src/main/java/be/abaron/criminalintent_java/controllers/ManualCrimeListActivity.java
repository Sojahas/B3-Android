package be.abaron.criminalintent_java.controllers;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import be.abaron.criminalintent_java.R;
import be.abaron.criminalintent_java.models.Crime;
import be.abaron.criminalintent_java.models.CrimeLab;

public class ManualCrimeListActivity extends AppCompatActivity {
    private LinearLayout mContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_crime_list); //Transformation de l'xml en objet java
        mContainer = (LinearLayout) findViewById(R.id.crime_list); //On récupère le LinearLayout avec l'id crime_list
        /*
        //Création d'un textView avec un text "Hello !"
        TextView textView = new TextView(getApplicationContext());
        textView.setText("Hello !");
        mContainer.addView(textView); //On ajoute ce textView comme enfant du LinearLayout

         */
        updateUI();
    }

    private void updateUI() {
        mContainer.removeAllViews();
        CrimeLab lab = CrimeLab.get();
        for (final Crime crime : lab.getCrimes()) {
            View crimeView = getCrimeView(crime);
            mContainer.addView(crimeView);
        }
    }

    private View getCrimeView(Crime crime) {
        TextView textView = new TextView(getApplicationContext());
        textView.setText(crime.getTitle());
        return textView;
    }
}
