package kr.ac.kw.forfun;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityRequestForFunContents extends AppCompatActivity {
    private Contents mContents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_forfun_contents);

        Intent intent = getIntent();

        mContents = (Contents) intent.getSerializableExtra("contents");

        ImageView contentImage = findViewById(R.id.rqForFunContentsImg);

        TextView bigTitle = findViewById(R.id.rqForFunContentsBigTitle);
        TextView smallTitle = findViewById(R.id.rqForFunContentsSmallTitle);
        TextView introduction = findViewById(R.id.rqForFunContentsIntroduction);
        TextView tag = findViewById(R.id.rqForFunContentsTag);
        TextView location = findViewById(R.id.rqForFunContentsLocation);

        contentImage.setImageResource(mContents.getContentImg());
        bigTitle.setText(mContents.getContentName());
        smallTitle.setText(mContents.getContentName());
        introduction.setText(mContents.getContentIntroduction());
        tag.setText(mContents.getContentTag());
        location.setText(mContents.getContentLocation());
    }
}
