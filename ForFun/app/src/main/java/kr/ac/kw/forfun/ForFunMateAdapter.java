package kr.ac.kw.forfun;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ForFunMateAdapter extends RecyclerView.Adapter<ForFunMateAdapter.ViewHolder> {
    private ArrayList<ForFunMateItem> mData = null ;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView forfunName ;
        TextView forfunTag;

        TextView mateName;
        TextView mateTag;

        ImageView profile;
        ImageView requestBtnBg;
        ImageView contentImg;
        ImageView mateProfileBg;


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


            profile.setBackground(new ShapeDrawable(new OvalShape()));
            Context context = itemView.getContext();

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
        holder.forfunName.setText(mData.get(position).forfunName);
        holder.forfunTag.setText(mData.get(position).forfunTag);

        holder.mateName.setText(mData.get(position).mateName);
        holder.mateTag.setText(mData.get(position).mateTag);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}