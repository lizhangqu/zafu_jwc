
package cn.edu.zafu.jwc.application;

import org.litepal.LitePalApplication;

import cn.edu.zafu.jwc.service.CourseService;
import cn.edu.zafu.jwc.service.LinkService;

/**
 * Ã·π©service
 * @author lizhangqu
 * @date 2015-2-1
 */
public class JWCApplication extends LitePalApplication {
	private CourseService courseService;
	private LinkService linkService;
	@Override
	public void onCreate() {
		super.onCreate();
		courseService=new CourseService();
		linkService=new LinkService();
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public LinkService getLinkService() {
		return linkService;
	}
	
	

}
