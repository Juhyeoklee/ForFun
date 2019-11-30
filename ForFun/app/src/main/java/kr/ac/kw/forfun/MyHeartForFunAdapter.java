package kr.ac.kw.forfun;

import android.content.Context;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyHeartForFunAdapter extends RecyclerView.Adapter<MyHeartForFunAdapter.ViewHolder> {
    private ArrayList<Group> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView forfunTag;
        TextView forfunName;
        TextView forfunPostUser;
        ImageView profile;
        ImageView groupImg;
        ImageView icParInUser;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            forfunTag = itemView.findViewById(R.id.myheartforfunTag);
            forfunName = itemView.findViewById(R.id.myheartforfunName);
            forfunPostUser = itemView.findViewById(R.id.forfunPostUserName);
            groupImg = itemView.findViewById(R.id.groupImg);

            profile = itemView.findViewById(R.id.forfunPostUserProfileImg);
            profile.setBackground(new ShapeDrawable(new OvalShape()));
            if(Build.VERSION.SDK_INT >= 21) {
                profile.setClipToOutline(true);
            }

        }
    }
    public MyHeartForFunAdapter(ArrayList<Group> list){
        mData = list;
    }

    @NonNull
    @Override
    public MyHeartForFunAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.myheartforfun_recyclerview_item, parent, false) ;
        MyHeartForFunAdapter.ViewHolder vh = new MyHeartForFunAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.forfunTag.setText(mData.get(position).getTag());
        holder.forfunName.setText(mData.get(position).getTitle());
        holder.forfunPostUser.setText(mData.get(position).getHostName());
        holder.groupImg.setImageResource(mData.get(position).getContents().getContentImg());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

/*

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<String> mData = null ;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1 ;
        ImageView profile;
        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            textView1 = itemView.findViewById(R.id.storyName) ;
            profile = itemView.findViewById(R.id.storyImgView);
            profile.setBackground(new ShapeDrawable(new OvalShape()));
            if(Build.VERSION.SDK_INT >= 21) {
                profile.setClipToOutline(true);
            }

        }
    }

    public StoryAdapter(ArrayList<String> list){
        this.mData = list;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.story_recyclerview_item, parent, false) ;
        StoryAdapter.ViewHolder vh = new StoryAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = mData.get(position) ;
        holder.textView1.setText(text) ;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

 */