package be.abaron.criminalintent_java.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

//Ajout d'une classe qui sera essentiellement une liste de crime avec un Design Pattern du singleton
public class CrimeLab {
    private static CrimeLab sCrimeLab; //préfixe s car les noms de champs statiques, selon la nomenclature, commencent par un s !
    private List<Crime> mCrimes;

    public static CrimeLab get() {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab();
        }
        return sCrimeLab;
    }

    public CrimeLab() {
        mCrimes = new ArrayList<>();

        //initialisation avec des crimes bidons
        for (int i = 0; i < 10000; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); //On dit qu'une sur deux est résolue
            mCrimes.add(crime);
        }
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getID().equals(id))
                return crime;
        }
        return null;
    }

    public List<Crime> getCrimes() {
        //On fait un return Collections.unmodifiableList(mCrimes); dans le but de pouvoir
        // renvoyer une vue non modifiable de la collection spécifiée, et une tentative de modification de la collection entraînera une UnsupportedOperationException.
        return Collections.unmodifiableList(mCrimes);
    }
}
