package cn.edu.zafu.jwc.model;

import org.litepal.crud.DataSupport;

/**
 * 课程实体类
 * @author lizhangqu
 * @date 2015-2-1
 */
public class Course extends DataSupport{
	private int id;//主鍵，自增
	private int startYear=2014;//学年开始年
	private int endYear=2015;//学年结束年
	private int semester=2;//学期
	private String courseName;//课程名
	private String courseTime;//课程时间，冗余字段
	private String classsroom;//教室
	private String teacher;//老师
	private int dayOfWeek;//星期几
	private int startSection;//第几节课开始
	private int endSection;//第几节课结束
	private int startWeek;//开始周
	private int endWeek;//结束周
	private int everyWeek;//标记是否是单双周，0为每周,1单周，2双周
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEveryWeek() {
		return everyWeek;
	}
	public void setEveryWeek(int everyWeek) {
		this.everyWeek = everyWeek;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getStartSection() {
		return startSection;
	}
	public void setStartSection(int startSection) {
		this.startSection = startSection;
	}
	public int getEndSection() {
		return endSection;
	}
	public void setEndSection(int endSection) {
		this.endSection = endSection;
	}
	public int getStartWeek() {
		return startWeek;
	}
	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}
	public int getEndWeek() {
		return endWeek;
	}
	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getClasssroom() {
		return classsroom;
	}
	public void setClasssroom(String classsroom) {
		this.classsroom = classsroom;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", startYear=" + startYear + ", endYear="
				+ endYear + ", semester=" + semester + ", courseName="
				+ courseName + ", courseTime=" + courseTime + ", classsroom="
				+ classsroom + ", teacher=" + teacher + ", dayOfWeek="
				+ dayOfWeek + ", startSection=" + startSection
				+ ", endSection=" + endSection + ", startWeek=" + startWeek
				+ ", endWeek=" + endWeek + ", everyWeek=" + everyWeek + "]";
	}
	
	
	
	

}
