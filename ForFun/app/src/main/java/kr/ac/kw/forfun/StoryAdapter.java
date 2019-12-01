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

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<User> mData = null ;

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

    public StoryAdapter(ArrayList<User> list){
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
        holder.profile.setImageResource(mData.get(position).getUserProfileImg());
        holder.textView1.setText(mData.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
