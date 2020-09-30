package be.abaron.criminalintent_java.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import be.abaron.criminalintent_java.R;
import be.abaron.criminalintent_java.models.Crime;

public class CrimeHolder extends RecyclerView.ViewHolder {
    private Crime mCrime;
    private TextView mTitleTextView;
    private TextView mDateTextView;

    public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.list_item_crime, parent, false));
        mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
        mTitleTextView = (TextView) itemView.findViewById(R.id.crime_date);
    }
}
