package com.example.giveback;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView orgNameText;
        public MyViewHolder (View itemView){
            super (itemView);
            orgNameText=itemView.findViewById(R.id.orgNameOfficial);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.org_list_item, parent, false);
        return new MyViewHolder(root);

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OrganizationRecord item = OrganizationHolderFile.getInstance().getFilteredOrgData().get(position);
        holder.orgNameText.setText(item.getOrgNameOfficial());

    }
    @Override
    public int getItemCount() {
        return OrganizationHolderFile.getInstance().getFilteredOrgData().size();
    }
}
