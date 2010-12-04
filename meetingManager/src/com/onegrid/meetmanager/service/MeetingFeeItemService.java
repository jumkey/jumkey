package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.FeeItem;
import com.onegrid.meetmanager.model.MeetingFeeItem;
import com.onegrid.meetmanager.model.MeetingInfo;

public interface MeetingFeeItemService {
	public void addInstance(MeetingFeeItem meetingfeeitem);

	public void deleteInstance(MeetingFeeItem meetingfeeitem);

	public void deleteSelectInstance(Integer[] selected);

	public MeetingFeeItem updateInstance(MeetingFeeItem meetingfeeitem);

	public List<MeetingFeeItem> getAllMeetingFeeItem();

	public MeetingInfo getMeetingInfo(Integer meetingid);

	public List<FeeItem> getAllFeeItem();
}
