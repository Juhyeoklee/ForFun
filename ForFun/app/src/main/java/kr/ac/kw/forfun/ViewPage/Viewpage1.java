package kr.ac.kw.forfun.ViewPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import kr.ac.kw.forfun.Class.Content;
import kr.ac.kw.forfun.sub_Content.Book1Activity;
import kr.ac.kw.forfun.sub_Content.Book2Activity;
import kr.ac.kw.forfun.sub_Content.Movie1Activity;
import kr.ac.kw.forfun.R;
import kr.ac.kw.forfun.Class.User;
import kr.ac.kw.forfun.UserContent;
import kr.ac.kw.forfun.sub_Content.Movie2Activity;
import kr.ac.kw.forfun.sub_Content.Play1Activity;
import kr.ac.kw.forfun.sub_Content.Play2Activity;
import kr.ac.kw.forfun.sub_Content.Show1Activity;
import kr.ac.kw.forfun.sub_Content.Show2Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Viewpage1 extends Fragment {
    final String TAG = "WSY";
    //ArrayList<model_Content> C_list;

    Context context;

    UserContent userContent = new UserContent();
    ArrayList<Content> content;
    //생성된 FirebaseStorage를 참조하는 storage 생성


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User.contentCount = 0;
    }

    View view;
    TextView textView;
    ImageView movie1, movie2, play1, play2, book1, book2, show1, show2;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.viewpage1, container, false);

        context = view.getContext();

        content = userContent.getContent();

        init();

        movie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Movie1Activity.class);
                startActivity(intent);
                Toast.makeText(context, "잘가아아아아아아아", Toast.LENGTH_SHORT).show();
            }
        });

        movie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Movie2Activity.class);
                startActivity(intent);
            }
        });

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Play1Activity.class);
                startActivity(intent);
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Play2Activity.class);
                startActivity(intent);
            }
        });

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Book1Activity.class);
                startActivity(intent);
            }
        });

        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Book2Activity.class);
                startActivity(intent);
            }
        });

        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Show1Activity.class);
                startActivity(intent);
            }
        });

        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Show2Activity.class);
                startActivity(intent);
            }
        });
















//        Log.i(TAG, "rerwr : " + User.allContentList.size());


//        initializeData(context);
//
//        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewVerticalViewpage1);
//        VerticalAdapter verticalAdapter = new VerticalAdapter(getContext(), User.allContentList);
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        recyclerView.setAdapter(verticalAdapter);
//
//
//        Log.d(TAG, "onCreateView: ");

        return view;
    }

    public void init(){
        movie1 = view.findViewById(R.id.movie1);
        movie2 = view.findViewById(R.id.movie2);
        play1 = view.findViewById(R.id.play1);
        play2 = view.findViewById(R.id.play2);
        book1 = view.findViewById(R.id.book1);
        book2 = view.findViewById(R.id.book2);
        show1 = view.findViewById(R.id.show1);
        show2 = view.findViewById(R.id.show2);
    }
    public void initializeData(Context context) {
        ArrayList<Content> List1 = new ArrayList();// 전시회
        ArrayList<Content> List2 = new ArrayList(); // 연극
        ArrayList<Content> List3 = new ArrayList(); // 책
        ArrayList<Content> List4 = new ArrayList(); // 영화

        for(int i = 0; i< userContent.contentsSize(); i++){
            content.get(i).getResourceID();
            if(content.get(i).getType().equals("0") ){
                List1.add(new Content(content.get(i).getResourceID(), content.get(i).getTitle()));
            }
            else if(content.get(i).getType().equals("1")){
                List2.add(new Content(content.get(i).getResourceID(), content.get(i).getTitle()));
            }
            else if(content.get(i).getType().equals("2")){
                List3.add(new Content(content.get(i).getResourceID(), content.get(i).getTitle()));
            }
            else if(content.get(i).getType().equals("3")){
                List4.add(new Content(content.get(i).getResourceID(), content.get(i).getTitle()));
            }
        }

        Log.i(TAG, "initializeData: " + List1.size());
        Log.i(TAG, "initializeData: " + List2.size());
        Log.i(TAG, "initializeData: " + List3.size());
        Log.i(TAG, "initializeData: " + List4.size());

       if(List1.size() != 0) {
           User.allContentList.add(List1);
       }else if(List2.size() != 0) {
           User.allContentList.add(List2);
       }else if(List3.size() != 0) {
           User.allContentList.add(List3);
       }else if(List4.size() != 0) {
           User.allContentList.add(List4);
       }


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
      //  User.allContentList.clear(); // 이 작업을 안해주면 컨텐츠들이 계속 추가됨.
    }
}
