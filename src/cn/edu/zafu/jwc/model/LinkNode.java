package cn.edu.zafu.jwc.model;

import org.litepal.crud.DataSupport;

/**
 * 首页菜单实体类
 * @author lizhangqu
 * @date 2015-2-1
 */
public class LinkNode extends DataSupport{
	private int id;
	private String title;
	private String link;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "LinkNode [id=" + id + ", title=" + title + ", link=" + link
				+ "]";
	}

	
}
