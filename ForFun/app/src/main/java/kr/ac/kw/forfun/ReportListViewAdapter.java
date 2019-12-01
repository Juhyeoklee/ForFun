package kr.ac.kw.forfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportListViewAdapter extends BaseAdapter {
    private ArrayList<ReportListViewItem> listViewItemList = new ArrayList<ReportListViewItem>();

    public ReportListViewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.report_listview_item, parent, false);
        }

        TextView reportTitle = (TextView) convertView.findViewById(R.id.reportTitleTxtView);
        TextView reportId = (TextView) convertView.findViewById(R.id.reportIdTxtView);
        TextView commentCount = (TextView) convertView.findViewById(R.id.commentCountTxtView);
        TextView viewCount = (TextView) convertView.findViewById(R.id.reportViewCountTxtView);
        TextView reportDate = (TextView) convertView.findViewById(R.id.reportDateTxtView);

        ReportListViewItem listViewItem = listViewItemList.get(position);

        reportTitle.setText(listViewItem.getReportTitle());
        reportId.setText(listViewItem.getReportId());
        commentCount.setText(listViewItem.getCommentCount());
        viewCount.setText(listViewItem.getViewCount());
        reportDate.setText(listViewItem.getReportDate());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public void addItem(String reportTitle, String reportId, String commentCount, String viewCount, String reportDate){
        ReportListViewItem item = new ReportListViewItem();

        item.setReportTitle(reportTitle);
        item.setReportId(reportId);
        item.setCommentCount(commentCount);
        item.setViewCount(viewCount);
        item.setReportDate(reportDate);

        listViewItemList.add(item);
    }
}

