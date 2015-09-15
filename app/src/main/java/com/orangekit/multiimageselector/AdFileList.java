package com.orangekit.multiimageselector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdFileList extends BaseAdapter {
	private Context context;
	private List<FileInfo> fileInfos;
	
	public AdFileList(Context context, final List<FileInfo> fileInfos) {
			this.context = context;
	        this.fileInfos = fileInfos;
	    }
	
	@Override
	public boolean areAllItemsEnabled() {
	    return false;
	}
	 
	@Override
	public int getCount() {
		if(fileInfos!=null){
			return fileInfos.size();
		} else{
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return fileInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.layout_adapter_gridview, null);
			viewHolder.fileImage = (ImageView) convertView.findViewById(R.id.imageRowView1);
			viewHolder.fileName = (TextView) convertView.findViewById(R.id.textRowView1); 
			convertView.setTag(viewHolder);	
		} else {
			viewHolder = (ViewHolder)convertView.getTag();
		}
		viewHolder.fileName.setText(fileInfos.get(position).getFileName());
		//UtImage.setImage(context, viewHolder.fileImage, fileInfo);

		BitmapWorkerTask task = new BitmapWorkerTask(viewHolder.fileImage);
		task.execute(fileInfos.get(position).getFilePath());
		return convertView;    
        
	}

	public class ViewHolder {
		public ImageView fileImage;	
		public TextView fileName;	
	}
	
}

 
  
    
   





  