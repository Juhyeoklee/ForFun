package kr.ac.kw.forfun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kr.ac.kw.forfun.Class.Content;
import kr.ac.kw.forfun.R;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>{
    private ArrayList<Content> dataList;
    private Context context;

    public HorizontalAdapter( Context context, ArrayList<Content> data)
    {
        this.context = context;
        this.dataList = data;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        protected ImageView image;
        protected TextView title;

        public HorizontalViewHolder(View view)
        {
            super(view);
            image = view.findViewById(R.id.poster);
            title = view.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_horizontal, null);

        return new HorizontalAdapter.HorizontalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder horizontalViewHolder, int position)
    {
//        horizontalViewHolder
//                .image
//                .setImageURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/forfun-8c46c.appspot.com/o/%EC%97%B0%EA%B7%B9%2Fimage%2F0400011808_129710_0554.gif"));
////                .setImageURI(dataList.get(position).getResourceID());
               // .setImageResource(dataList.get(position).getResourceID());
        Glide.with(context).load(dataList.get(position).getResourceID()).into(horizontalViewHolder.image);
        horizontalViewHolder
                .title
                .setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
