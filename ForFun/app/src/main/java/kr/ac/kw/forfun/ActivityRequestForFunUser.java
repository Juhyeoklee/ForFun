package kr.ac.kw.forfun;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityRequestForFunUser extends AppCompatActivity {
    private User mUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_forfun_to_user);

        Intent intent = getIntent();
        mUser = (User)intent.getSerializableExtra("user");

        ImageView profileBg = findViewById(R.id.rqForFunUserProifileBgImg);
        ImageView profile = findViewById(R.id.myPageProfileImg);
        TextView userName = findViewById(R.id.rqForFunUserName);
        GridView gridView = findViewById(R.id.rqForFunUserActivityList);;

        profileBg.setImageResource(mUser.getUserProfileBgImg());
        profile.setImageResource(mUser.getUserProfileImg());
        profile.setBackground(new ShapeDrawable(new OvalShape()));
        profile.setClipToOutline(true);

        userName.setText(mUser.getUserName());

        Button backBtn = findViewById(R.id.rqForFunUserBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
