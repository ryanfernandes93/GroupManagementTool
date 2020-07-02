package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionSorters;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceQuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceSorters;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;

public class SortingDB implements IQuestionSorters {
	IQuestionsPersistence questionDb = new QuestionDB();

	public List<InterfaceQuestionModel> sort(String bannerID, InterfaceSorters interfaceSorters) {
		List<InterfaceQuestionModel> questions = new ArrayList<>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spGetSortedQuestions(?,?,?)");
			proc.setParameter(1, bannerID);
			proc.setParameter(2, interfaceSorters.getSortField());
			proc.setParameter(3, interfaceSorters.getSortOrder());
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					String title = results.getString(1);
					InterfaceQuestionModel interfaceQuestionModel = new QuestionModel();
					interfaceQuestionModel.setQuestionTitle(title);
					questions.add(interfaceQuestionModel);
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return questions;
	}

	public List<InterfaceQuestionModel> clearSort(String bannerID) {
		return questionDb.loadAllQuestionsByID(bannerID);
	}
}
