package com.mabrouk.mohamed.lostandfound.ui.itemDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mabrouk.mohamed.lostandfound.R;
import com.mabrouk.mohamed.lostandfound.model.Comment;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
    private final static String TAG = CommentsAdapter.class.getSimpleName() + "TAG";

    private Context mContext;
    private List<Comment> commentList;

    private CommentLikeDislikeClickListener likeDislikeListener;

    public CommentsAdapter(Context mContext, List<Comment> commentList) {
        this.mContext = mContext;
        this.commentList = commentList;
    }


    public void setLikeDislikeListener(CommentLikeDislikeClickListener likeDislikeListener) {
        this.likeDislikeListener = likeDislikeListener;
    }


    @NonNull
    @Override
    public CommentsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.comment_layout, viewGroup, false);

        return new CommentsAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.commentOwnerName.setText(comment.getCommentOwnerName());
        holder.commentText.setText(comment.getCommentText());
        holder.numLikes.setText(Integer.toString(comment.getNumLikes()));
        holder.numDislikes.setText(Integer.toString(comment.getNumDislikes()));

        // check if last comment (remove line separator)
        if(position == getItemCount()-1){
            holder.lineSeparator.setVisibility(View.GONE);
        }

        holder.likeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeDislikeListener.onLikeClick(position);
            }
        });

        holder.dislikeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeDislikeListener.onDislikeClick(position);
            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView commentOwnerName, commentText, numLikes, numDislikes;
        public ImageView likeImg, dislikeImg;
        public View lineSeparator;

        public MyViewHolder(View view) {
            super(view);
            commentOwnerName = (TextView) view.findViewById(R.id.comment_owner_name_tv);
            commentText = (TextView) view.findViewById(R.id.comment_text_tv);
            numLikes = (TextView) view.findViewById(R.id.num_likes_tv);
            numDislikes = (TextView) view.findViewById(R.id.num_dislikes_tv);

            likeImg = (ImageView) view.findViewById(R.id.like_iv);
            dislikeImg = (ImageView) view.findViewById(R.id.dislike_iv);

            lineSeparator = (View) view.findViewById(R.id.line_separator);

            //likeImg.setOnClickListener(this);
        }

    }


    @Override
    public int getItemCount() {
        return commentList.size();
    }


    public interface CommentLikeDislikeClickListener{
        void onLikeClick(int commentPosition);
        void onDislikeClick(int commentPosition);
    }

}
