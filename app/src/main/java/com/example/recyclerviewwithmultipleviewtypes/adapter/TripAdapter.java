package com.example.recyclerviewwithmultipleviewtypes.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwithmultipleviewtypes.MainActivity;
import com.example.recyclerviewwithmultipleviewtypes.R;
import com.example.recyclerviewwithmultipleviewtypes.Welcome;
import com.example.recyclerviewwithmultipleviewtypes.models.Ads;
import com.example.recyclerviewwithmultipleviewtypes.models.Item;
import com.example.recyclerviewwithmultipleviewtypes.models.News;
import com.example.recyclerviewwithmultipleviewtypes.models.Trip;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public List<Item> items;
    Context mContext;

    //this.mContext = getActivity();


    public TripAdapter(List<Item> items,Context context) {
        this.items = items;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // return null;
        if(viewType == 0){
            View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_trip,parent,false);
            TripViewHolders tripViewHolders = new TripViewHolders(view);
            return tripViewHolders;
        }else if(viewType == 1){
            return  new AdsViewHolders(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cintainer_ads,parent,false));
        }else
            return  new NewsViewHolders(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_news,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if(getItemViewType(position)==0){
            Trip trip= (Trip) items.get(position).getObject();
            ((TripViewHolders) holder).setTripData(trip);
        }else if(getItemViewType(position)==1){
            Ads ads= (Ads) items.get(position).getObject();
            ((AdsViewHolders) holder).setAdsData(ads);
        }else{
            News news= (News) items.get(position).getObject();
            ((NewsViewHolders) holder).setNewsData(news);

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

     class TripViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageTrip;
        private TextView textTripTitle, textTrip;

        public TripViewHolders(@NonNull View itemView) {
            super(itemView);
            imageTrip = itemView.findViewById(R.id.imageTrip);
            textTripTitle = itemView.findViewById(R.id.textTripTitle);
            textTrip = itemView.findViewById(R.id.textTrip);
            Log.i("TripViewHolders", "inside holder");
            itemView.setOnClickListener(this);

        }
        void setTripData(Trip trip){
           imageTrip.setImageResource(trip.getTripImage());
           textTripTitle.setText(trip.getTripTitle());
           textTrip.setText(trip.getTrip());
        }

        @Override
        public void onClick(View view) {
            Log.i("TripViewHolders", "inside click");
            int position = getLayoutPosition();
            Trip trip= (Trip) items.get(position).getObject();
            Toast.makeText(view.getContext()," Clicked  "+trip.getTripTitle(),Toast.LENGTH_LONG).show();
            //items.get(getAdapterPosition()).getObject()
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
           builder.setMessage("Click OK to grab your offer for "+trip.getTripTitle()+" Trip").setPositiveButton("Ok", dialogClickListener)
                   .setNegativeButton("No", dialogClickListener).show();
        }
    }
    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                   // Toast.makeText(mContext,"ok Clicked",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(mContext, Welcome.class);
                   mContext.startActivity(intent);

                    //Yes button clicked
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    dialog.dismiss();
                    //No button clicked
                    break;
            }
        }
    };

    class AdsViewHolders extends RecyclerView.ViewHolder {
        private TextView textAdsTitle,textAds;

       public AdsViewHolders(@NonNull View itemView) {
           super(itemView);
           textAdsTitle = itemView.findViewById(R.id.textAdsTitle);
           textAds = itemView.findViewById(R.id.textAds);
       }
       void setAdsData(Ads ads){
           textAdsTitle.setText(ads.getAdsTitle());
           textAds.setText(ads.getAds());
       }
   }
    class NewsViewHolders extends RecyclerView.ViewHolder{
        private TextView textNewsTitle,textNews;

       public NewsViewHolders(@NonNull View itemView) {
           super(itemView);
           textNewsTitle = itemView.findViewById(R.id.textNewsTitle);
           textNews = itemView.findViewById(R.id.textNews);
       }
       void setNewsData(News news){
           textNewsTitle.setText(news.getNewTitle());
           textNews.setText(news.getNews());
       }
   }


}
