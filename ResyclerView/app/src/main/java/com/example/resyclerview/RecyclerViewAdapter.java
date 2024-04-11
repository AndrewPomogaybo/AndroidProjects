package com.example.resyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Users> userList;
    public RecyclerViewAdapter(List<Users> users) {
        userList=users;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rescycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.nameTextView.setText(String.format("%s %s", userList.get(position).getFirstName(), userList.get(position).getLastName()));
        holder.ageTextView.setText(String.valueOf(userList.get(position).getAge()));
        holder.emailTextView.setText(userList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, ageTextView, emailTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.NameView);
            ageTextView = itemView.findViewById(R.id.AgeView);
            emailTextView = itemView.findViewById(R.id.EmailView);
        }
    }
}
