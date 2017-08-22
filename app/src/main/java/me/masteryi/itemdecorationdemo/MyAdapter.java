package me.masteryi.itemdecorationdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ethan Lee
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOT = 1;
    private List<String> mList = new ArrayList<>();
    private Context mContext;

    public MyAdapter(final Context context) {
        mContext = context;

        for (int i = 0; i < 11; i++) {
            String s = "item" + i;
            mList.add(s);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = null;
        if (viewType == TYPE_ITEM) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
            return new MyViewHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.foot, parent, false);
            return new MyFootViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (position < mList.size() - 1) {
            ((MyViewHolder) holder).mTextView.setText(mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return position == mList.size() - 1 ? TYPE_FOOT : TYPE_ITEM;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text);
        }
    }

    static class MyFootViewHolder extends RecyclerView.ViewHolder {
        public MyFootViewHolder(final View itemView) {
            super(itemView);
        }
    }
}
