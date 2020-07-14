package CSCI5308.GroupFormationTool.MyGroupFormation;

import java.util.List;

public interface IGroup {
	public int getGroupSize();
	public void setGropuSize(int groupSize);
	public int getGroupNumber();
	public void setGroupNumber(int groupNumber);
	public List<ISurveyResponse> getGroupMembers();
	public void addGroupMember(ISurveyResponse member);
}
