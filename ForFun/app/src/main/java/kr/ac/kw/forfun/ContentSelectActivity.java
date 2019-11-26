package kr.ac.kw.forfun;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class ContentSelectActivity extends AppCompatActivity {
    final String TAG = "WSY";
    ImageView movie_content, play_content, performance_content, book_content, exhibition_content, room_escape_content;
    Boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true, flag5 = true, flag6 = true;
    int contencCount = 0;

    String userEmail = "";

    FirebaseStorage storage;
    StorageReference mStorageReference;

    FirebaseFirestore firestore;
    Map<String, Object> content = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_select);

        init();

        storage = FirebaseStorage.getInstance();
        mStorageReference = storage.getReferenceFromUrl("gs://forfun-8c46c.appspot.com");


        // 데이터 베이스
        firestore = FirebaseFirestore.getInstance();
        userEmail = getIntent().getStringExtra("USER_EMAIL");

        // Storage에 파일 저장
//
//        if(getIntent().hasExtra("USER_EMAIL")){
//            Toast.makeText(this, getIntent().getStringExtra("USER_EMAIL"), Toast.LENGTH_SHORT).show();
//        }
//
//        String dirPath = getFilesDir().getAbsolutePath();
//        File file = new File(dirPath);
//        // 일치하는 폴더가 없으면 생성
//        if( !file.exists() ) {
//            file.mkdir();
//            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
//        }
//
//        // txt 파일 생성
//        String testStr = "ABCDEFGHIJK...";
//        File savefile = new File(dirPath+"/test.txt");
//        try{
//            FileOutputStream fos = new FileOutputStream(savefile);
//            fos.write(testStr.getBytes());
//            fos.close();
//            Toast.makeText(this, "Save Success", Toast.LENGTH_SHORT).show();
//        } catch(IOException e){}
//
//        //storage 주소와 폴더 파일명을 지정해 준다.
//        mStorageReference = mStorageReference.child(userEmail+"/test");
//        //올라가거라...
//        mStorageReference.putFile( Uri.fromFile(savefile));


    }


    private void init() {
        movie_content = (ImageView) findViewById(R.id.movie_content);
        play_content = (ImageView) findViewById(R.id.play_content);
        performance_content = (ImageView) findViewById(R.id.performance_content);
        book_content = (ImageView) findViewById(R.id.book_content);
        exhibition_content = (ImageView) findViewById(R.id.exhibition_content);
        room_escape_content = (ImageView) findViewById(R.id.room_escape_content);
    }

    // 다음 버튼 클릭 시
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextText:
                // 조건 걸기 : 컨텐츠가 1개 이상 선택됫을 시 실행하도록
                firestore.collection("users").document(userEmail)
                        .set(content)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "성공");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "실패", e);
                            }
                        });


                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
        }
    }

    // 콘텐츠 클릭 이벤트
    public void contentOnClick(View v) {
        switch (v.getId()) {
            case R.id.movie_content: {
                if (flag1) {
                    if (contencCount > 3)
                        return;
                    movie_content.setColorFilter(Color.parseColor("#D99F81F7"));
                    movie_content.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_black_24dp));
                    content.put("영화", flag1);

                    flag1 = false;
                    contencCount++;
                } else {
                    movie_content.setColorFilter(null);
                    movie_content.setForeground(null);
                    content.put("영화", flag1);

                    flag1 = true;
                    contencCount--;
                }
                break;
            }
            case R.id.play_content: {
                if (flag2) {
                    if (contencCount > 3)
                        return;
                    play_content.setColorFilter(Color.parseColor("#D99F81F7"));
                    play_content.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_black_24dp));
                    content.put("연극", flag2);

                    flag2 = false;
                    contencCount++;
                } else {
                    play_content.setColorFilter(null);
                    play_content.setForeground(null);
                    content.put("연극", flag2);

                    flag2 = true;
                    contencCount--;
                }
                break;
            }
            case R.id.performance_content: {
                if (flag3) {
                    if (contencCount > 3)
                        return;
                    performance_content.setColorFilter(Color.parseColor("#D99F81F7"));
                    performance_content.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_black_24dp));
                    content.put("공연", flag3);

                    flag3 = false;
                    contencCount++;
                } else {
                    performance_content.setColorFilter(null);
                    performance_content.setForeground(null);
                    content.put("공연", flag3);

                    flag3 = true;
                    contencCount--;
                }
                break;
            }
            case R.id.book_content: {
                if (flag4) {
                    if (contencCount > 3)
                        return;
                    book_content.setColorFilter(Color.parseColor("#D99F81F7"));
                    book_content.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_black_24dp));
                    content.put("책", flag4);

                    flag4 = false;
                    contencCount++;
                } else {
                    book_content.setColorFilter(null);
                    book_content.setForeground(null);
                    content.put("책", flag4);

                    flag4 = true;
                    contencCount--;
                }
                break;
            }
            case R.id.exhibition_content: {
                if (flag5) {
                    if (contencCount > 3)
                        return;
                    exhibition_content.setColorFilter(Color.parseColor("#D99F81F7"));
                    exhibition_content.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_black_24dp));
                    content.put("전시회", flag5);

                    flag5 = false;
                    contencCount++;
                } else {
                    exhibition_content.setColorFilter(null);
                    exhibition_content.setForeground(null);
                    content.put("전시회", flag5);

                    flag5 = true;
                    contencCount--;
                }
                break;
            }
            case R.id.room_escape_content: {
                if (flag6) {
                    if (contencCount > 3)
                        return;
                    room_escape_content.setColorFilter(Color.parseColor("#D99F81F7"));
                    room_escape_content.setForeground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_black_24dp));
                    content.put("방탈출", flag6);

                    flag6 = false;
                    contencCount++;
                } else {
                    room_escape_content.setColorFilter(null);
                    room_escape_content.setForeground(null);
                    content.put("방탈출", flag6);

                    flag6 = true;
                    contencCount--;
                }
                break;
            }
        }

    }
}
