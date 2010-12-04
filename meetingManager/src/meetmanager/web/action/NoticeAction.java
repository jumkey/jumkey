package meetmanager.web.action;

import java.util.List;

import meetmanager.model.MeetingInfo;
import meetmanager.model.Notice;
import meetmanager.model.RoomType;
import meetmanager.model.SendNotificationPlan;
import meetmanager.model.User;
import meetmanager.service.NoticeService;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport {
	private NoticeService noticeService;
	private List<Notice> list;
	private List<User> ulist;
    private List<RoomType> rlist;
	private Notice notice;
	private MeetingInfo meetinginfo;
	private String result;// 返回ajax 结果
	private Integer[] selected;// 选择项
	private String username;
	private SendNotificationPlan snp;

	public List<RoomType> getRlist() {
        return rlist;
    }

    public void setRlist(List<RoomType> rlist) {
        this.rlist = rlist;
    }

    public MeetingInfo getMeetinginfo() {
		return meetinginfo;
	}

	public void setMeetinginfo(MeetingInfo meetinginfo) {
		this.meetinginfo = meetinginfo;
	}

	public SendNotificationPlan getSnp() {
		return snp;
	}

	public void setSnp(SendNotificationPlan snp) {
		this.snp = snp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Notice> getList() {
		return list;
	}

	public void setList(List<Notice> list) {
		this.list = list;
	}

	public List<User> getUlist() {
		return ulist;
	}

	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	@JSON(serialize = false)
	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}
	public String add(){
		try {
			noticeService.addInstance(notice);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"添加成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"添加失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String modify() {
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			notice = noticeService.updateInstance(notice);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"修改成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"修改失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String list() {
		list=noticeService.getAllNotice();
		return "list";
	}

	public String exportsended() {
		notice=noticeService.getNoticeById(notice.getId());
		return "exportsended";
	}

	public String send() {
        rlist=noticeService.getAllRoomType();
		notice=noticeService.getNoticeByMeetingId(meetinginfo.getId());
		//notice=noticeService.getNoticeById(notice.getId());
		//列出所有没被通知到的人
		ulist=noticeService.getAllUser(meetinginfo.getId());
		return "send";
	}

	public String dosend() {
		try {
			noticeService.dosend(notice,selected);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"发送成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"发送失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String doresp() {
		try {
			noticeService.doresp(snp);//result记录回执信息
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"记录成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"记录失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String checkusername() {
		try {
			username = noticeService.checkusername(notice.getId(),username);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"成功\",\"user\":"+username+"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage() + "\",\"user\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
