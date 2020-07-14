package CSCI5308.GroupFormationTool.MyGroupFormation;

import java.util.ArrayList;
import java.util.List;

public class Group implements IGroup {

	private int groupSize;
	private int groupNumber;
	private List<ISurveyResponse> groupList;
	
	public Group() {
		this.groupSize = 0;
		groupList = new ArrayList<ISurveyResponse>(); 
	}
	
	@Override
	public int getGroupSize() {
		return this.groupSize;
	}

	@Override
	public void setGropuSize(int groupSize) {
		this.groupSize = groupSize;
	}

	@Override
	public int getGroupNumber() {
		return this.groupNumber;
	}

	@Override
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	@Override
	public List<ISurveyResponse> getGroupMembers() {
		return this.groupList;
	}

	@Override
	public void addGroupMember(ISurveyResponse member) {
		groupList.add(member);
		this.groupSize++;
	}
}
