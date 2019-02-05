package com.mabrouk.mohamed.lostandfound.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mabrouk.mohamed.lostandfound.R;
import com.mabrouk.mohamed.lostandfound.model.Item;



import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {
    private final static String TAG = ItemsAdapter.class.getSimpleName() + "TAGG";

    private Context mContext;
    private List<Item> itemsList;

    private RecyclerViewClickListener mListener;

    public ItemsAdapter(Context mContext, List<Item> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }


    public void setClickListener(RecyclerViewClickListener mListener) {
        this.mListener = mListener;
    }


    @NonNull
    @Override
    public ItemsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Item item = itemsList.get(position);
        holder.itemName.setText(item.getItemName());
        holder.itemLocation.setText(item.getDistrict() + " - " + item.getCity());
        holder.itemPostDate.setText(item.getPostDateTime());
        holder.itemDescription.setText(item.getItemDescription());

        /*
        holder.itemComments.setText(item.getNumOfComments()+" comments");
        holder.itemFollowers.setText(item.getNumOfFollowers()+" follower");*/

        //holder.author.setText(mContext.getResources().getString(R.string.author_str, article.getAuthor()));

        /*holder.publishDate.setText(com.example.mohamed.newsfeed.Utls.DateFormat.changeDateFormat(article.getPublishDate()
                , com.example.mohamed.newsfeed.Utls.DateFormat.articleDateFormat
                , com.example.mohamed.newsfeed.Utls.DateFormat.layoutDateFormat));*/

        // load article thumbnail image using picasso
        /*Picasso.get()
                .load(item.getImgUrl())
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);*/

        // TODO: use glide for images

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemName, itemLocation, itemPostDate, itemDescription, itemComments;
        public ImageView itemImg, saveItemImg;

        public MyViewHolder(View view) {
            super(view);
            itemName = (TextView) view.findViewById(R.id.item_name);
            itemLocation = (TextView) view.findViewById(R.id.item_location);
            itemPostDate = (TextView) view.findViewById(R.id.item_post_date);
            itemDescription = (TextView) view.findViewById(R.id.item_description);
            itemComments = (TextView) view.findViewById(R.id.item_comments);
            //itemFollowers = (TextView) view.findViewById(R.id.item_followers);

            itemImg = (ImageView) view.findViewById(R.id.item_img);
            saveItemImg = (ImageView) view.findViewById(R.id.save_item_img);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }


    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }
}
