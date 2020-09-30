package be.abaron.criminalintent_java.controllers;

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

    private void updateUI() {
        mContainer.removeAllViews();
        CrimeLab lab = CrimeLab.get();
        for (final Crime crime : lab.getCrimes()) {
            View crimeView = getCrimeView(crime);
            mContainer.addView(crimeView);
        }
    }

    private View getCrimeView(final Crime crime) {
        //création d'un LinearLayout vertical avec un padding de 8
        LinearLayout columnForCrime = new LinearLayout(getApplicationContext());
        columnForCrime.setOrientation(LinearLayout.VERTICAL);
        columnForCrime.setPadding(8, 8, 8, 8);

        //creation des TextViews
        TextView titleView = getTextView(crime.getTitle());
        TextView dateView = getTextView(crime.getDate().toString());

        //Ajout des TextViews dans le LinearLayout
        columnForCrime.addView(titleView);
        columnForCrime.addView(dateView);
        return columnForCrime;
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
