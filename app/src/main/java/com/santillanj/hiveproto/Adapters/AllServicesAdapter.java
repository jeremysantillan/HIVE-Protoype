package com.santillanj.hiveproto.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.santillanj.hiveproto.Model.CateringServices;
import com.santillanj.hiveproto.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 2/10/2017.
 */

public class AllServicesAdapter extends RecyclerView.Adapter<AllServicesAdapter.ViewHolder>{

    private static final String TAG = "AllServicesAdapter";
    private Context context;
    private List<CateringServices> mCateringList;
    private ViewHolder holder;


    public AllServicesAdapter(List<CateringServices> mCateringList) {
        this.mCateringList = mCateringList;
    }


    @Override
    public AllServicesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_services_card, parent, false);
        context = parent.getContext();
        final View itemLayoutView = LayoutInflater.from(context)
                .inflate(R.layout.all_services_card, null);
        holder = new ViewHolder(itemLayoutView);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllServicesAdapter.ViewHolder holder, int position) {

        final CateringServices item = mCateringList.get(position);
        if (item != null) {
            switch (item.getImagenum()){
                case 1:
                    holder.mImage.setImageResource(R.drawable.services_card1);
                    break;
                case 2:
                    holder.mImage.setImageResource(R.drawable.services_card2);
                    break;
                case 3:
                    holder.mImage.setImageResource(R.drawable.services_card3);
                    break;
                case 4:
                    holder.mImage.setImageResource(R.drawable.services_card4);
                    break;
            }
        }
    }

    public void addAll(List<CateringServices> itemList) {
        for (CateringServices item : itemList) {
            this.mCateringList.add(item);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
       return mCateringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        CardView mCard;
        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.mCateringImage);
            mCard = (CardView) itemView.findViewById(R.id.mCard);
        }
    }
}
