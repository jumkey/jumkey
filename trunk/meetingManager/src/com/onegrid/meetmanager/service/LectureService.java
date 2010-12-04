package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Lecture;


public interface LectureService {

	public void addInstance(Lecture lecture);
	public List<Lecture> findLectureByMeetingId(Integer meetingId);
	public void deleteInstance(Lecture lecture) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public Lecture updateInstance(Lecture lecture) throws Exception;

}
