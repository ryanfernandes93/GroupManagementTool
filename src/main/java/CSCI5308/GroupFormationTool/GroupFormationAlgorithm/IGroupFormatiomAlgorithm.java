package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.List;
import java.util.Set;

public interface IGroupFormatiomAlgorithm {
	List<IGroup> formGroup(List<ISurveyResponse> surveryResults, 
			List<ISurveyScale> surveyScales, int groupSize); 
}