package meetmanager.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Activities entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MeetingRoom implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private String name;
	private String address;
	private Integer number;
	private String host;
	private Integer backplane;
	private Integer scroll;
	private Integer projector;
	private Integer wired;
	private Integer wireless;
	private Integer recording;
	private Integer video;
	private Integer tea;
	private Integer fruit;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MeetingInfo getMeetingInfo() {
		return meetingInfo;
	}
	public void setMeetingInfo(MeetingInfo meetingInfo) {
		this.meetingInfo = meetingInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getBackplane() {
		return backplane;
	}
	public void setBackplane(Integer backplane) {
		this.backplane = backplane;
	}
	public Integer getScroll() {
		return scroll;
	}
	public void setScroll(Integer scroll) {
		this.scroll = scroll;
	}
	public Integer getProjector() {
		return projector;
	}
	public void setProjector(Integer projector) {
		this.projector = projector;
	}
	public Integer getWired() {
		return wired;
	}
	public void setWired(Integer wired) {
		this.wired = wired;
	}
	public Integer getWireless() {
		return wireless;
	}
	public void setWireless(Integer wireless) {
		this.wireless = wireless;
	}
	public Integer getRecording() {
		return recording;
	}
	public void setRecording(Integer recording) {
		this.recording = recording;
	}
	public Integer getVideo() {
		return video;
	}
	public void setVideo(Integer video) {
		this.video = video;
	}
	public Integer getTea() {
		return tea;
	}
	public void setTea(Integer tea) {
		this.tea = tea;
	}
	public Integer getFruit() {
		return fruit;
	}
	public void setFruit(Integer fruit) {
		this.fruit = fruit;
	}
	public MeetingRoom(Integer id, MeetingInfo meetingInfo, String name,
			String address, Integer number, String host, Integer backplane,
			Integer scroll, Integer projector, Integer wired, Integer wireless,
			Integer recording, Integer video, Integer tea, Integer fruit) {
		super();
		this.id = id;
		this.meetingInfo = meetingInfo;
		this.name = name;
		this.address = address;
		this.number = number;
		this.host = host;
		this.backplane = backplane;
		this.scroll = scroll;
		this.projector = projector;
		this.wired = wired;
		this.wireless = wireless;
		this.recording = recording;
		this.video = video;
		this.tea = tea;
		this.fruit = fruit;
	}

	public MeetingRoom(){
		
	}
	// Constructors

}