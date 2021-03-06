package be.abaron.criminalintent_java.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

    @Override
    protected void onResume() {
        super.onResume();
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
        View columnForCrime = getLayoutInflater().inflate(R.layout.list_item_crime, null);
        ((TextView) columnForCrime.findViewById(R.id.crime_title)).setText(crime.getTitle());
        ((TextView) columnForCrime.findViewById(R.id.crime_date)).setText(crime.getDate().toString());
        setClickOnCrimeView(crime, columnForCrime);
        return columnForCrime;
    }

    private void setClickOnCrimeView(final Crime crime, View columnForCrime) {
        columnForCrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        CrimeActivity.class);
                intent.putExtra(CrimeFragment.CRIME_ID, crime.getID());
                startActivity(intent);
            }
        });
    }

    //Renvoie un textView avec le texte text
    private TextView getTextView(String text) {
        TextView textView = new TextView(getApplicationContext());
        textView.setText(text);
        textView.setLayoutParams(new
                FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return textView;
    }
}
