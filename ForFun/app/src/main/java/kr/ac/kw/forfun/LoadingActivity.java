package kr.ac.kw.forfun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import kr.ac.kw.forfun.Class.Content;
import kr.ac.kw.forfun.Class.User;

public class LoadingActivity extends AppCompatActivity {
    final String TAG = "WSY";
    FirebaseFirestore firestore;
    Map<String, Boolean> contents = new HashMap<>();

    ArrayList<String> keys = new ArrayList<>();
    ArrayList<Boolean> values = new ArrayList<>();
    FirebaseStorage storage;
    StorageReference storageRef;


    Map<String, Map> data = new HashMap<>(); // image1 => ( 키, 값 )

    Map<String, String> inputContent = new HashMap<>();

    int count = 0;

    Content content;
    //  model_Content model_content = new model_Content();
    int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // 선택한 컨텐츠 가져오기
        firestore = FirebaseFirestore.getInstance();
        firestore.collection("users").document(User.userEmail)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData().keySet()); // 키만 가져오기 [연극, 영화]
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData().values()); // 값만 가져오기 [true, true]

                                Iterator iterator = document.getData().entrySet().iterator();

                                while (iterator.hasNext()) {
                                    Map.Entry entry = (Map.Entry) iterator.next();

                                    keys.add((String) entry.getKey());
                                    values.add((Boolean) entry.getValue());
                                }

                                for (int i = 0; i < values.size(); i++) {
                                    if (values.get(i)) {
                                        Log.d(TAG, "MainActivity : " + keys.get(i));
                                        // 유저가 선택한 컨텐츠 저장
                                        User.contents.add(keys.get(i));
                                    }
                                } // 컨텐츠 User.contents 에 저장 끝!!!

                                // 컨텐츠에 대한 이미지 이미지 경로, 이미지 제목 가져오기
                                Log.i(TAG, "크기 : " + User.contents.size());
                                for (k = 0; k < User.contents.size(); k++) { // 컨텐츠 갯수에 맞춰 반복
                                    Log.d(TAG, "컨텐츠는?? : " + User.contents.get(k));
                                    firestore.collection("image").document(User.contents.get(k)) // 선택한 컨텐츠가 순서대로 들어감
                                            .get()
                                            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                    if (task.isSuccessful()) {

                                                        DocumentSnapshot document = task.getResult();
                                                        if (document.exists()) {
                                                            Log.d(TAG, "DocumentSnapshot data: " + document.getData().keySet()); // 키만 가져오기 image1, image2 ...
                                                            Log.d(TAG, "DocumentSnapshot data: " + document.getData().values()); // 값만 가져오기  {imageName=오백에삼십, imageUri=/연극/image/0400011808_129710_0554.gif} ...
                                                            //Log.i(TAG, "onComplete: " + );

                                                            Iterator iterator = document.getData().entrySet().iterator();

                                                            while (iterator.hasNext()) {
                                                                Map.Entry entry = (Map.Entry) iterator.next();
                                                                Log.i(TAG, "onComplete: " + entry.getKey());
                                                                Log.i(TAG, "onComplete: " + entry.getValue());

                                                                data.put((String) entry.getKey(), (Map) entry.getValue()); // 각각 키와 값의 자료형
                                                            }

                                                            for (int j = 1; j <= data.size(); j++) {
                                                                Log.i(TAG, "Uri만 가져옴 : " + data.get("image" + j).get("imageUri").toString()); // uri만 가져옴
                                                                Uri uri = Uri.parse(data.get("image" + j).get("imageUri").toString());

                                                                Log.i(TAG, "제목 : " + data.get("image" + j).get("imageName").toString()); // uri만 가져옴
                                                                String title = data.get("image" + j).get("imageName").toString();

                                                                Log.i(TAG, "타입 : " + data.get("image" + j).get("type"));
                                                                String type = data.get("image" + j).get("type").toString();

                                                                content = new Content(uri,title);
                                                                content.setType(type);
                                                                UserContent.contents.add(content);
                                                            }

                                                        } else {
                                                            Log.d(TAG, "No such document");
                                                        }
                                                    } else {
                                                        Log.d(TAG, "get failed with ", task.getException());
                                                    }
                                                    inputContent.clear();
                                                    count = 0;
                                                    Log.d(TAG, User.userEmail);
                                                    Log.i(TAG, "onComplete: ");
                                                }

                                            });
                                }
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                        Log.d(TAG, "오잉?" + User.userEmail);
                    }
                });




        startLoading();
    }

    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2000);
    }
}
