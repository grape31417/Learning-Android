package com.example.user.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by USER on 2017/11/2.
 */


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>  {
    private List<String> mListString;

public ItemAdapter(List<String> ListString)
{
    mListString=ListString;
}

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item,parent,false);

        ViewHolder viewHolder =new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        holder.mImgView.setImageResource(android.R.drawable.star_on);
        holder.mTxt.setText(mListString.get(position));
    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImgView;
        public TextView mTxt;
        public ViewHolder(View itemView) {
            super(itemView);
            mImgView=(ImageView)itemView.findViewById(R.id.imgView);
            mTxt =(TextView)itemView.findViewById(R.id.txt);

            itemView.setOnClickListener(this);
        }

        public void onClick(View v) {
            Toast.makeText(v.getContext(),mListString.get(getAdapterPosition()),Toast.LENGTH_LONG).show();
        }
    }
}

