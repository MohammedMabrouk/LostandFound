package com.mabrouk.mohamed.lostandfound.ui.itemDetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.mabrouk.mohamed.lostandfound.R;
import com.mabrouk.mohamed.lostandfound.databinding.ActivityItemDetailsBinding;
import com.mabrouk.mohamed.lostandfound.model.Comment;
import com.mabrouk.mohamed.lostandfound.model.Item;
import com.mabrouk.mohamed.lostandfound.ui.main.ItemsAdapter;

import java.util.ArrayList;
import java.util.List;


public class ItemDetailsActivity extends AppCompatActivity implements CommentsAdapter.CommentLikeDislikeClickListener{
    private final static String TAG = ItemDetailsActivity.class.getSimpleName() + "TAG";

    public static final String CURRENT_ITEM = "currentItem";
    private Item currentItem;

    private RecyclerView mRecyclerView;
    private CommentsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Comment> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityItemDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_item_details);
        if (getIntent() != null) {
            currentItem = getIntent().getParcelableExtra(CURRENT_ITEM);
            Log.i(TAG, "item title:" + currentItem.getItemName());
            binding.setItem(currentItem);
        }



        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setTitle(R.string.item_details);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.comments_rv);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        comments = new ArrayList<>();
        comments.add(new Comment("Ahmed Zaki", "I saw this item yesterday!", 8, 9));
        comments.add(new Comment("Ahmed Zaki", "I saw this item yesterday!", 8, 9));
        comments.add(new Comment("Ahmed Zaki", "I saw this item yesterday!", 8, 9));


        mAdapter = new CommentsAdapter(this, comments);
        mAdapter.setLikeDislikeListener(this);
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onLikeClick(int commentPosition) {
        Log.v(TAG, "like on comment: " + commentPosition);
    }

    @Override
    public void onDislikeClick(int commentPosition) {
        Log.v(TAG, "dislike on comment: " + commentPosition);
    }
}
