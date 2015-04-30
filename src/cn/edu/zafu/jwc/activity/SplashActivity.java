package cn.edu.zafu.jwc.activity;

import cn.edu.zafu.jwc.util.SharedPreferenceUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		((ImageView) findViewById(R.id.bg)).postDelayed(new Runnable() {

			@Override
			public void run() {
				SharedPreferenceUtil util = new SharedPreferenceUtil(
						getApplicationContext(), "accountInfo");
				String isLogin = util.getKeyData("isLogin");
				if (isLogin.equals("TRUE")) {
					Intent intent = new Intent(SplashActivity.this,
							MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Intent intent = new Intent(SplashActivity.this,
							LoginActivity.class);
					startActivity(intent);
					finish();
				}
			}
		}, 3000);
	}
}
