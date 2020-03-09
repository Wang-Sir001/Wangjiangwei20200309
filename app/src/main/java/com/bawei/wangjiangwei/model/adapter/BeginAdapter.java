package com.bawei.wangjiangwei.model.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.model.entity.BeginEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class BeginAdapter extends RecyclerView.Adapter<BeginAdapter.VH> {


    public Context mContext;
    public List<BeginEntity.ResultBean> mResult;

    public BeginAdapter(Context context, List<BeginEntity.ResultBean> result) {
        mContext = context;
        mResult = result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.beging_item_fragment, parent, false);
        View inflate = View.inflate(mContext, R.layout.beging_item_fragment, null);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext)
                .load(holder.img)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
        Log.i("xxx",mResult.get(position).getName());
        holder.name.setText(mResult.get(position).getName());
        holder.director.setText(mResult.get(position).getDirector());
        holder.starring.setText(mResult.get(position).getStarring());
        holder.score.setText((int) mResult.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return mResult.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.director)
        TextView director;
        @BindView(R.id.starring)
        TextView starring;
        @BindView(R.id.score)
        TextView score;
        @BindView(R.id.but)
        Button but;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
