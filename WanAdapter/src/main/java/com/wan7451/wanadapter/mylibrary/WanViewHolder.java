package com.wan7451.wanadapter.mylibrary;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class WanViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> mViews;

    protected WanViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>();
    }

    public <T> WanViewHolder(View itemView, final WanAdapter<T> adapter) {
        super(itemView);
        this.mViews = new SparseArray<>();
        if (adapter.getItemClickListener() != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.getItemClickListener().onItemClickListener(
                            getAdapterPosition() - adapter.getHeaderViewsCount(),
                            adapter.getItem(getAdapterPosition()));
                }
            });
        }
    }


    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        try {
            return (T) view;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }


//    public <T extends View> T findViewById(int viewId) throws ClassCastException{
//        View view = mViews.get(viewId);
//        if (view == null) {
//            view = mConvertView.findViewById(viewId);
//            mViews.put(viewId, view);
//        }
//        return (T) view;
//    }

    public WanViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    public WanViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    public WanViewHolder setImageUrl(@IdRes int viewId,
                                     @Nullable String url,
                                     @DrawableRes int placeholder) {
//        ImageView imgView = getView(viewId);
//        if (TextUtils.isEmpty(url)) {
//            imgView.setImageResource(placeholder);
//        } else {
//            Glide.with(imgView.getContext())
//                    .load(url)
//                    .dontAnimate()
//                    .placeholder(R.drawable.bg)
//                    .error(R.drawable.bg)
//                    .into(imgView);
//        }
        return this;
    }


}
