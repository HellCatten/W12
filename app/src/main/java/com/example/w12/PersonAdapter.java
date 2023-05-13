package com.example.w12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> persons;

    public PersonAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView fnameView;
        public final TextView lnameView;
        public final TextView ageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            fnameView = view.findViewById(R.id.firstName);
            lnameView = view.findViewById(R.id.lastName);
            ageView = view.findViewById(R.id.age);
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_preson,parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.fnameView.setText(person.getFirstName());
        holder.lnameView.setText(person.getLastName());
        holder.ageView.setText(String.valueOf(person.getAge()));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
