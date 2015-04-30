package cn.edu.zafu.jwc.service;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.litepal.crud.DataSupport;

import cn.edu.zafu.jwc.model.Course;
import cn.edu.zafu.jwc.model.LinkNode;

/**
 * LinNode表的业务逻辑处理
 * @author lizhangqu
 * @date 2015-2-1
 */
public class LinkService {
	
	public String getLinkByName(String name){
		List<LinkNode> find = DataSupport.where("title=?",name).limit(1).find(LinkNode.class);
		if(find.size()!=0){
			return find.get(0).getLink();
		}else{
			return null;
		}
	}
	public boolean save(LinkNode linknode){
		return linknode.save();
	}
	/**
	 * 查询所有链接
	 * 
	 * @return
	 */
	public List<LinkNode> findAll() {
		return DataSupport.findAll(LinkNode.class);
	}
	public String parseMenu(String content) {
		LinkNode linkNode =null;
		StringBuilder result = new StringBuilder();
		Document doc = Jsoup.parse(content);
		Elements elements = doc.select("ul.nav a[target=zhuti]");
		for (Element element : elements) {
			result.append(element.html() + "\n" + element.attr("href") + "\n\n");
			linkNode= new LinkNode();
			linkNode.setTitle(element.text());
			linkNode.setLink(element.attr("href"));
			save(linkNode);
		}
		return result.toString();

	}
	public String isLogin(String content){
		Document doc = Jsoup.parse(content, "UTF-8");
		Elements elements = doc.select("span#xhxm");
		try{
			Element element=elements.get(0);
			return element.text();
		}catch(IndexOutOfBoundsException e){
			//e.printStackTrace();
		}
		return null;
	}
}
