package com.pratik.roomdatabasedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomViewHolder> {
    List<UserModel> users;
    Context mContext;
    onClickListnerCallBack mClickListner;

    public UserAdapter(List<UserModel> users,Context mContext,onClickListnerCallBack mClickListner) {
        this.users = users;
        this.mContext = mContext;
        this.mClickListner = mClickListner;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new CustomViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvName.setText(users.get(position).getName());
        holder.tvNumber.setText(""+users.get(position).getNumber());
        holder.tvEmail.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvNumber,tvEmail;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvNumber = (TextView) itemView.findViewById(R.id.tvNumber);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListner.onclick(getAdapterPosition());
                }
            });
        }
    }
}
