package kr.ac.kw.forfun;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ForFunMateAdapter extends RecyclerView.Adapter<ForFunMateAdapter.ViewHolder> {
    private ArrayList<ForFunMateItem> mData = null ;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position, boolean isUser);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Contents contents;
        User user;

        TextView forfunName ;
        TextView forfunTag;

        TextView mateName;
        TextView mateTag;

        ImageView profile;
        ImageView requestBtnBg;
        ImageView contentImg;
        ImageView mateProfileBg;

        Button requestBtn;
        Context context;

        ViewHolder(View itemView) {
            super(itemView) ;
            forfunName = itemView.findViewById(R.id.forfunName);
            forfunTag = itemView.findViewById(R.id.forfunTag);

            mateName = itemView.findViewById(R.id.mateName);
            mateTag = itemView.findViewById(R.id.mateTag);

            profile = itemView.findViewById(R.id.mateProfile);
            requestBtnBg = itemView.findViewById(R.id.requestBtnImg);
            contentImg = itemView.findViewById(R.id.contentImg);
            mateProfileBg = itemView.findViewById(R.id.mateProfileBgImg);

            requestBtn = itemView.findViewById(R.id.forfunMateRcyViewRequestBtn);

            profile.setBackground(new ShapeDrawable(new OvalShape()));
            context = itemView.getContext();

            GradientDrawable round = (GradientDrawable) itemView.getContext().getDrawable(R.drawable.round_button);
            GradientDrawable leftCornerRadius = (GradientDrawable) itemView.getContext().getDrawable(R.drawable.left_corner_radius);
            GradientDrawable rightCornerRadius = (GradientDrawable) itemView.getContext().getDrawable(R.drawable.right_corner_radius);

            requestBtnBg.setBackground(round);
            requestBtnBg.setClipToOutline(true);

            contentImg.setBackground(round);
            contentImg.setClipToOutline(true);

            mateProfileBg.setBackground(round);
            mateProfileBg.setClipToOutline(true);

            if(Build.VERSION.SDK_INT >= 21) {
                profile.setClipToOutline(true);
            }

            contentImg.setOnClickListener(this);
            mateProfileBg.setOnClickListener(this);
            requestBtn.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            Intent intent;

            if(view.getId() == contentImg.getId()){
                intent = new Intent(context, ActivityRequestForFunContents.class);
                intent.putExtra("contents",contents);
                context.startActivity(intent);

            }else if(view.getId() == mateProfileBg.getId()){
                intent = new Intent(context, ActivityRequestForFunContents.class);
                intent.putExtra("user", user);
                context.startActivity(intent);

            }else if(view.getId() == requestBtn.getId()){
                intent = new Intent(context, RequestForFunActivity.class);
                intent.putExtra("contents", contents);
                intent.putExtra("user", user);
                context.startActivity(intent);

            }else{
                return;
            }


        }
    }
    public ForFunMateAdapter(ArrayList<ForFunMateItem> list){
        mData = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.forfunmate_recyclerview_item, parent, false) ;
        ForFunMateAdapter.ViewHolder vh = new ForFunMateAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ForFunMateAdapter.ViewHolder viewHolder = (ForFunMateAdapter.ViewHolder)holder;
        viewHolder.contents = mData.get(position).getContents();
        viewHolder.user = mData.get(position).getUser();

        holder.mateProfileBg.setImageResource(mData.get(position).getUser().getUserProfileBgImg());
        holder.profile.setImageResource(mData.get(position).getUser().getUserProfileImg());
        holder.contentImg.setImageResource(mData.get(position).getContents().getContentImg());

        holder.forfunName.setText(mData.get(position).getContents().getContentName());
        holder.forfunTag.setText(mData.get(position).getContents().getContentTag());

        holder.mateName.setText(mData.get(position).getUser().getUserName());
        holder.mateTag.setText(mData.get(position).getUser().getUserTag());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}