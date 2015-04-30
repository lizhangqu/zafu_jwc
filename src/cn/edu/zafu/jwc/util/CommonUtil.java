
package cn.edu.zafu.jwc.util;

import android.app.ProgressDialog;
import android.content.Context;


/**
 * 公共工具类
 * @author lizhangqu
 * @date 2015-2-1
 */
public class CommonUtil {
	
	/**获得指定范围内的随机数
	 * @param max
	 * @return int
	 */
	public static int getRandom(int max){
		return (int)(Math.random()*max);
	}
	
	/**根据中文数字一，二，三，四，五，六，日，转换为对应的阿拉伯数字
	 * @param day 
	 * @return int
	 */
	public static int getDayOfWeek(String day) {
		if (day.equals("一"))
			return 1;
		else if (day.equals("二"))
			return 2;
		else if (day.equals("三"))
			return 3;
		else if (day.equals("四"))
			return 4;
		else if (day.equals("五"))
			return 5;
		else if (day.equals("六"))
			return 6;
		else if (day.equals("日"))
			return 7;
		else
			return 0;
	}
	public static ProgressDialog getProcessDialog(Context context,String tips){
		ProgressDialog dialog = new ProgressDialog(context);
		dialog.setMessage(tips);
		dialog.setCancelable(false);
		return dialog;
	}
	
}
