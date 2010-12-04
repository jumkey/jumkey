package meetmanager.service;

import java.util.List;

import meetmanager.model.FeeItem;
import meetmanager.model.MeetingFeeItem;
import meetmanager.model.MeetingInfo;


public interface MeetingFeeItemService {
	public void addInstance(MeetingFeeItem meetingfeeitem);

	public void deleteInstance(MeetingFeeItem meetingfeeitem);

	public void deleteSelectInstance(Integer[] selected);

	public MeetingFeeItem updateInstance(MeetingFeeItem meetingfeeitem);

	public List<MeetingFeeItem> getAllMeetingFeeItem();

	public MeetingInfo getMeetingInfo(Integer meetingid);

	public List<FeeItem> getAllFeeItem();
}
