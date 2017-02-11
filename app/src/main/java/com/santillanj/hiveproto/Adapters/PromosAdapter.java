package com.santillanj.hiveproto.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.santillanj.hiveproto.Model.CateringServices;
import com.santillanj.hiveproto.R;

import java.util.List;

/**
 * Created by Jeremy on 2/11/2017.
 */

public class PromosAdapter extends RecyclerView.Adapter<PromosAdapter.ViewHolder>{

    private static final String TAG = "PromosAdapter";
    private Context context;
    private List<CateringServices> mPromoList;
    private PromosAdapter.ViewHolder holder;

    public PromosAdapter(List<CateringServices> mPromoList) {
        this.mPromoList = mPromoList;
    }

    @Override
    public PromosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.promos_card, parent, false);
        context = parent.getContext();
        final View itemLayoutView = LayoutInflater.from(context)
                .inflate(R.layout.promos_card, null);
        holder = new PromosAdapter.ViewHolder(itemLayoutView);
        return holder;
    }

    @Override
    public void onBindViewHolder(PromosAdapter.ViewHolder holder, int position) {


        final CateringServices item = mPromoList.get(position);
        if (item != null) {
            switch (item.getImagenum()){
                case 1:
                    holder.mImage.setImageResource(R.drawable.promo_card1);
                    break;
                case 2:
                    holder.mImage.setImageResource(R.drawable.promo_card2);
                    break;
                case 3:
                    holder.mImage.setImageResource(R.drawable.promo_card3);
                    break;
                case 4:
                    holder.mImage.setImageResource(R.drawable.promo_card4);
                    break;
            }
        }


    }

    @Override
    public int getItemCount() {
      return mPromoList.size();
    }

    public void addAll(List<CateringServices> itemList) {
        for (CateringServices item : itemList) {
            this.mPromoList.add(item);
            notifyDataSetChanged();
        }
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        CardView mCard;
        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.mPromoImage);
            mCard = (CardView) itemView.findViewById(R.id.mPromoCard);
        }
    }



}
