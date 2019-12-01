package kr.ac.kw.forfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SimilarContentsGridViewAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<SimilarContentsGridViewItem> gridViewItemsList = new ArrayList<SimilarContentsGridViewItem>();

    public SimilarContentsGridViewAdapter(){}

    @Override
    public int getCount() {
        return gridViewItemsList.size();
    }

    @Override
    public Object getItem(int i) {
        return gridViewItemsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_cell_similar_contents, viewGroup, false);
        }
        ImageView contentImg = view.findViewById(R.id.gridContentImg);

        TextView date = (TextView) view.findViewById(R.id.contentDate);
        TextView contentTitle = (TextView) view.findViewById(R.id.gridContentTitle);
        TextView contentLocation = (TextView) view.findViewById(R.id.girdContentLocation);

        SimilarContentsGridViewItem gridViewItem = gridViewItemsList.get(i);

        contentImg.setImageResource(gridViewItem.getImg());
        date.setText(gridViewItem.getDate());
        contentTitle.setText(gridViewItem.getContentTitle());
        contentLocation.setText(gridViewItem.getContentLocation());


        return view;
    }

    public void addItem(String date, int img,  String contentTitle, String contentLocation){
        SimilarContentsGridViewItem item = new SimilarContentsGridViewItem();

        item.setDate(date);
        item.setImg(img);
        item.setContentTitle(contentTitle);
        item.setContentLocation(contentLocation);


        gridViewItemsList.add(item);
    }
}
