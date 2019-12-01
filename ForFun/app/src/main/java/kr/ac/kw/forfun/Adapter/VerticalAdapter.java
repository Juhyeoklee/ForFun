package kr.ac.kw.forfun.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.ac.kw.forfun.Class.Content;
import kr.ac.kw.forfun.R;
import kr.ac.kw.forfun.Class.User;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>  {
    String TAG = "WSY";
    private ArrayList<ArrayList<Content>> AllMovieList;
    private Context context;


    public VerticalAdapter(Context context, ArrayList<ArrayList<Content>> data)
    {
        this.context = context;
        this.AllMovieList = data;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        protected RecyclerView recyclerView;

        public VerticalViewHolder(View view)
        {
            super(view);

            this.recyclerView = view.findViewById(R.id.recyclerViewVertical);
        }
    }


    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_vertical, null);
        TextView textView = v.findViewById(R.id.ContentName);

        // 컨텐츠 이름 달기
//        for(int j = 0; j < User.contents.size(); j++){
//            textView.setText(User.contents.get(j));
//        }
        Log.i(TAG, "VerticalAdapter : " + User.contentCount);
        if(User.contentCount < User.contents.size())
            textView.setText(User.contents.get(User.contentCount++));
        return new VerticalAdapter.VerticalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder verticalViewHolder, int position) {
        HorizontalAdapter adapter = new HorizontalAdapter(context,AllMovieList.get(position));


        verticalViewHolder.recyclerView.setHasFixedSize(true);
        verticalViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context
                , LinearLayoutManager.HORIZONTAL
                ,false));

        verticalViewHolder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return AllMovieList.size();
    }
//    private ArrayList<String> mData = null ;
//
//    // 아이템 뷰를 저장하는 뷰홀더 클래스.
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        View view;
//
//        ViewHolder(View itemView) {
//            super(itemView) ;
//
//            // 뷰 객체에 대한 참조. (hold strong reference)
//            view = itemView.findViewById(R.id.contentItem) ;
//        }
//    }
//
//    // 생성자에서 데이터 리스트 객체를 전달받음.
//    public VerticalAdapter(ArrayList<String> list) {
//        mData = list ;
//    }
//
//    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
//    @Override
//    public VerticalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext() ;
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
//
//        View view = inflater.inflate(R.layout.recyclerview_horizontal, parent, false) ;
//        VerticalAdapter.ViewHolder vh = new VerticalAdapter.ViewHolder(view) ;
//
//        return vh ;
//    }
//
//    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
//    @Override
//    public void onBindViewHolder(VerticalAdapter.ViewHolder holder, int position) {
//        String text = mData.get(position) ;
//        holder.view.setTag(text);
//    }
//
//    // getItemCount() - 전체 데이터 갯수 리턴.
//    @Override
//    public int getItemCount() {
//        return mData.size() ;
//    }
}
