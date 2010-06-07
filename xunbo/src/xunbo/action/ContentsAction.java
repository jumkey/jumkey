package xunbo.action;

import java.util.Date;
import java.util.List;

import xunbo.pojo.Contents;
import xunbo.service.IContentsService;

public class ContentsAction {
	private IContentsService contentsservice;

	public IContentsService getContentsservice() {
		return contentsservice;
	}

	public void setContentsservice(IContentsService contentsservice) {
		this.contentsservice = contentsservice;
	}
	public String add(){
		Date d=new Date();
		if(contents.getCreated()==null){
			contents.setCreated(d);
		}
		contents.setModified(contents.getCreated());
		contentsservice.addText(contents);
		contentss=contentsservice.getAllText();
		return "success";
	}
	private Contents contents;
	private List<Contents> contentss;

	public Contents getContents() {
		return contents;
	}

	public void setContents(Contents contents) {
		this.contents = contents;
	}

	public List<Contents> getContentss() {
		return contentss;
	}

	public void setContentss(List<Contents> contentss) {
		this.contentss = contentss;
	}
}
