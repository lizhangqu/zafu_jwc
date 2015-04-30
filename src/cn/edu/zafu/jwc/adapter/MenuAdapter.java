package cn.edu.zafu.jwc.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.edu.zafu.jwc.activity.R;
import cn.edu.zafu.jwc.model.LinkNode;
import cn.edu.zafu.jwc.util.CommonUtil;

public class MenuAdapter extends ArrayAdapter<LinkNode> {
	private int[] icon = { R.drawable.icon_air, R.drawable.icon_bus,
			R.drawable.icon_chat, R.drawable.icon_classroom,
			R.drawable.icon_curriculum, R.drawable.icon_easyipv6,
			R.drawable.icon_info, R.drawable.icon_learn,
			R.drawable.icon_lecture, R.drawable.icon_maps,
			R.drawable.icon_mportal, R.drawable.icon_news,
			R.drawable.icon_offline_map, R.drawable.icon_places,
			R.drawable.icon_pushhistory, R.drawable.icon_pushmail,
			R.drawable.icon_show, R.drawable.icon_sslvpn,
			R.drawable.icon_timecapsule };
	private int resourceId;

	public MenuAdapter(Context context, int resource, List<LinkNode> objects) {
		super(context, resource, objects);
		this.resourceId = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinkNode item = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) view.findViewById(R.id.icon);
			viewHolder.title = (TextView) view.findViewById(R.id.title);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.icon.setBackgroundResource(icon[position]);
		viewHolder.title.setText(item.getTitle());
		return view;
	}

	class ViewHolder {
		ImageView icon;
		TextView title;
	}
}
