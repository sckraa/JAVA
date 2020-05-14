package com.example.smsstats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.ViewHolder>{
    private ArrayList<Sms> listData;

    public SmsAdapter(ArrayList<Sms> listData) {
        this.listData = listData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fragment_sms_item, parent, false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Sms sms = listData.get(position);

        holder.textView.setText(sms.getAuthor());
        holder.messageView.setText(sms.getMessage());
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView messageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.textView_sms_item);
            this.messageView = (TextView) itemView.findViewById(R.id.textView_sms_message);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}