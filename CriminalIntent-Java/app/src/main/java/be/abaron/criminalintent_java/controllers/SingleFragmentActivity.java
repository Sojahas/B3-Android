package be.abaron.criminalintent_java.controllers;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import be.abaron.criminalintent_java.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager(); //La gestion des fragments, de leur ajout ou de leur retrait de la vue se fait grace à la classe FragmentManager
        Fragment fragment = fm.findFragmentById(R.id.fragment_container); //Demande de trouver le fragment hébérgé dans l'activité courante avec un vue avec l'id R.id.fragment_container
        if (fragment == null) { //S'il n'y a pas encore de fragment chargé
            fragment = createFragment(); //Alors on en crée un
            //On l'ajoute en précisant l'identifiant du container hébergeur et le fragment à ajouter
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit(); //l'appel des commit va rendre effectif les changements
        }
    }

    protected abstract Fragment createFragment();
}
