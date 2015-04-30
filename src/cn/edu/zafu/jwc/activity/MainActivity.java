package cn.edu.zafu.jwc.activity;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.Header;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import cn.edu.zafu.jwc.adapter.MenuAdapter;
import cn.edu.zafu.jwc.application.JWCApplication;
import cn.edu.zafu.jwc.model.LinkNode;
import cn.edu.zafu.jwc.service.CourseService;
import cn.edu.zafu.jwc.service.LinkService;
import cn.edu.zafu.jwc.util.CommonUtil;
import cn.edu.zafu.jwc.util.FileUtil;
import cn.edu.zafu.jwc.util.HttpUtil;
import cn.edu.zafu.jwc.util.HttpUtil.QueryCallback;
import cn.edu.zafu.jwc.util.LinkUtil;
import cn.edu.zafu.jwc.util.SharedPreferenceUtil;

import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * @author lizhangqu
 * @date 2015-2-1
 */
public class MainActivity extends Activity {

	private GridView gridView;
	private LinkService linkService;
	private CourseService courseService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initValue();// 变量初始化
		initView();// 视图初始话
		initEvent();// 事件初始化

	}

	private void initValue() {
		JWCApplication application = ((JWCApplication) getApplicationContext());
		linkService = application.getLinkService();
		courseService = application.getCourseService();
	}

	/**
	 * 初始化View
	 */
	private void initView() {
		gridView = (GridView) findViewById(R.id.gridview);
		List<LinkNode> objects = linkService.findAll();
		gridView.setAdapter(new MenuAdapter(getApplicationContext(),
				R.layout.item_linknode_layout, objects));
	}

	/**
	 * 初始事件
	 */
	private void initEvent() {
		// 一些列点击事件的初始化
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView temp = (TextView) view.findViewById(R.id.title);
				String title = temp.getText().toString();
				if (title.equals(LinkUtil.XSGRKB)) {
					jump2Kb(false);
				} else if (title.equals(LinkUtil.JWGG)) {
					HttpUtil.getQuery(MainActivity.this, linkService, LinkUtil.JWGG, callback);
				} else {
					Toast.makeText(getApplicationContext(), title,
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	private QueryCallback callback=new QueryCallback() {
		
		@Override
		public String handleResult(String result) {
			FileUtil util=new FileUtil(getApplicationContext());
			util.save("ceshi", result);
			return null;
		}
	};
	

	/**
	 * 跳到课表页面
	 */
	private void jump2Kb(boolean flag) {
		SharedPreferenceUtil util = new SharedPreferenceUtil(
				getApplicationContext(), "flag");
		if (flag) {
			util.setKeyData(LinkUtil.XSGRKB, "TRUE");
			Intent intent = new Intent(MainActivity.this, CourseActivity.class);
			startActivity(intent);
		} else {
			String keyData = util.getKeyData(LinkUtil.XSGRKB);
			if (keyData.equals("TRUE")) {
				Intent intent = new Intent(MainActivity.this,
						CourseActivity.class);
				startActivity(intent);
			} else {
				getKB();
			}
		}

	}

	/**
	 * 获取课表，存入数据库
	 */
	private void getKB() {
		final ProgressDialog dialog = CommonUtil.getProcessDialog(
				MainActivity.this, "正在获取课表！！！");
		dialog.show();

		String link = linkService.getLinkByName(LinkUtil.XSGRKB);
		if (link != null) {
			HttpUtil.URL_QUERY = HttpUtil.URL_QUERY.replace("QUERY", link);
		} else {
			Toast.makeText(getApplicationContext(), "链接出现错误",
					Toast.LENGTH_SHORT).show();
			return;
		}
		HttpUtil.getClient().addHeader("Referer", HttpUtil.URL_MAIN);
		HttpUtil.getClient().setURLEncodingEnabled(true);
		HttpUtil.get(HttpUtil.URL_QUERY, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				dialog.dismiss();
				String resultContent;
				try {
					resultContent = new String(arg2, "gb2312");
					String ret = courseService.parseCourse(resultContent);
					Toast.makeText(getApplicationContext(), "课表获取成功！！！",
							Toast.LENGTH_SHORT).show();
					jump2Kb(true);

				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2,
					Throwable arg3) {
				dialog.dismiss();
				Toast.makeText(getApplicationContext(), "课表获取失败！！！",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
