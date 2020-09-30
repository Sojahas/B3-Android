package be.abaron.criminalintent_java.controllers;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

import be.abaron.criminalintent_java.R;
import be.abaron.criminalintent_java.models.Crime;
import be.abaron.criminalintent_java.models.CrimeLab;

//Le controleur du fragment
public class CrimeFragment extends Fragment {
    //On rend cette classe, en tant qu'une sous-classe de fragment
    public static final String CRIME_ID = "CRIME_ID";
    Crime mCrime;
    EditText mTitleField;
    Button mDatebutton;
    CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //On redéfinit la méthode onCreate afin de pouvoir initialiser le Model Crime
        //mCrime = new Crime();
        UUID crime_id = (UUID) getActivity().getIntent().getSerializableExtra("CRIME_ID");
        mCrime = CrimeLab.get().getCrime(crime_id);
    }

    //Redéfinition de la méthode onCreateView afin de pouvoir lier le controleur et la vue
    //Cad de récupérer une référence aux widgets de la vue et initialiser les listeners
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //Un inflater est un objet qui permet de passer un fichier XML à des objets java.
        // On va inflater la vue
        View v = inflater.inflate(R.layout.fragment_crime, container, false); //On demande de transformer le fichier XML avec l'identifiant R.layout.fragment_crime en objet java.
        //L'objet racine est renvoyé ==> La vue englobe le reste des widgets. Ici, c'est le LinearLayout

        //configuration de la vue
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //ne fais rien
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //ne fais rien
            }
        });

        mTitleField.setText(mCrime.getTitle()); //On assigne la valeur courante du crime dans l'editText

        //Champs pour la date, on l'initialise avec la date courante
        mDatebutton = (Button) v.findViewById(R.id.crime_date);
        mDatebutton.setText(mCrime.getDate().toString());
        mDatebutton.setEnabled(false); //readonly

        //checkBox qui représente si le crime est résolut ou non
        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        //Ajout d'un Listener pour modifier le modèle à chaque modification
        mSolvedCheckBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        mCrime.setSolved(isChecked);
                    }
                }
        );
        return v;
    }
}
