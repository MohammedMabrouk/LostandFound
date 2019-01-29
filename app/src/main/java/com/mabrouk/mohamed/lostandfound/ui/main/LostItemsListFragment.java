package com.mabrouk.mohamed.lostandfound.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mabrouk.mohamed.lostandfound.R;
import com.mabrouk.mohamed.lostandfound.model.Item;
import com.mabrouk.mohamed.lostandfound.ui.itemDetails.ItemDetailsActivity;

import java.util.ArrayList;
import java.util.List;


public class LostItemsListFragment extends Fragment implements ItemsAdapter.RecyclerViewClickListener {

    private RecyclerView mRecyclerView;
    private ItemsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Context mContext;
    private Activity mActivity;

    private List<Item> items;


    public static final String CURRENT_ITEM = "currentItem";


    public static LostItemsListFragment newInstance(String param1, String param2) {
        LostItemsListFragment fragment = new LostItemsListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this.getContext();
        mActivity = (Activity) mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_lost_items_list, container, false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.lost_items_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        items = new ArrayList<>();
        items.add(new Item("lost bag ooioioinj hjbhjhkbhk hjhjkvhkvhjhkj hjbhjkhhvg hjkhbhbh ", "my bag was lost in ... jjkljklj kjklnjjhbhjkbhjhjh hjhbjhjkhbhj hjkbhjkbhkjbhjbhk hjkbhjhbkjhbkhkj hjbhjkbhkbkjhkj hjbhkhbjkhkbj lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll", "08/10/2018 - 5:08PM", "Saad Madjsk", "Cairo", "Helwan", "dsdsd", 5, 6));
        items.add(new Item("lost bag", "my bag was lost in ...", "08/10/2018 - 5:08PM", "Saad Madjsk", "Cairo", "Helwan hjhjhgvhvghjvghgjvghj ", "dsdsd", 5, 6));
        items.add(new Item("lost bag", "my bag was lost in ...", "08/10/2018 - 5:08PM", "Saad Madjsk", "Cairo", "Helwan", "dsdsd", 5, 6));
        items.add(new Item("lost bag", "my bag was lost in ...", "08/10/2018 - 5:08PM", "Saad Madjsk", "Cairo", "Helwan", "dsdsd", 5, 6));
        items.add(new Item("lost bag", "my bag was lost in ...", "08/10/2018 - 5:08PM", "Saad Madjsk", "Cairo", "Helwan", "dsdsd", 5, 6));

        mAdapter = new ItemsAdapter(mContext, items);
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(mActivity, ItemDetailsActivity.class);
        intent.putExtra(CURRENT_ITEM, items.get(position));
        startActivity(intent);
    }


}
