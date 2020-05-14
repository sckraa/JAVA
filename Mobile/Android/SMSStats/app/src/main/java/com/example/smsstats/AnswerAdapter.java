package com.example.smsstats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder>{
    private ArrayList<AutomaticAnswer> listData;

    public AnswerAdapter(ArrayList<AutomaticAnswer> listData) {
        this.listData = listData;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fragment_settings_item, parent, false);
        
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final AutomaticAnswer answer = listData.get(position);

        holder.textView.setText(answer.getReceiveMessage());
        holder.textAnswer.setText(answer.getAnswer());
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textAnswer;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.textView_settings_message);
            this.textAnswer = (TextView) itemView.findViewById(R.id.textView_settings_answer);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayout);
        }
    }
}