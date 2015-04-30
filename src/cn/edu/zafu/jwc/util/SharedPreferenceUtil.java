package cn.edu.zafu.jwc.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreference工具类
 * @author lizhangqu
 * @date 2015-2-1
 */
public class SharedPreferenceUtil {
    private Context mContext;
    private String mFileName;
    public SharedPreferenceUtil(Context context,String fileName){
        mContext = context;
        this.mFileName=fileName;
    }
    /**保存键值对
     * @param key
     * @param value
     */
    public void setKeyData(String key,String value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    /**
     * 根据键得到值，如果为空返回""
     * @param key
     * @return
     */
    public String getKeyData(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mFileName, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, "");//第二个参数为默认值
        return value;
    }

}
