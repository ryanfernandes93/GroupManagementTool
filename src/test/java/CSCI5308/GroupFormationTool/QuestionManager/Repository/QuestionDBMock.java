package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceQuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceResponses;
import org.junit.jupiter.api.Test;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;

public class QuestionDBMock {
	IQuestionsPersistence questionDBMock = mock(QuestionDB.class);
	InterfaceQuestionModel interfaceQuestionModelMock;
	InterfaceResponses responseMock;
	HashMap<String, String> hashMapObj = new HashMap<String, String>();
	List<InterfaceQuestionModel> questions = new ArrayList<>();
	String[] selectedQuestions = {"Rate your java skills"};

	QuestionDBMock() {
		interfaceQuestionModelMock = new QuestionModel();
		interfaceQuestionModelMock.setUserID((long) 1);
		interfaceQuestionModelMock.setQuestionTitle("General");
		interfaceQuestionModelMock.setQuestionText("How are your leadership skills");
		hashMapObj.put("mcq1", "Multiple Choice Question, Choose One");
		interfaceQuestionModelMock.setQuestionTypeList(hashMapObj);
		responseMock = new Responses();
		responseMock.setResponse_txt("Beginner");
		responseMock.setScore_txt("1");

		interfaceQuestionModelMock.setQuestionTitle("Credits");
		questions.add(interfaceQuestionModelMock);
	}

	@Test
	public void loadAllQuestionsByID(){
		when(questionDBMock.loadAllQuestionsByID("B999999")).thenReturn(questions);
		assertEquals(questionDBMock.loadAllQuestionsByID("B999999"),questions);
		verify(questionDBMock).loadAllQuestionsByID("B999999");
	}

	@Test
	public void createQuestionTest() {
		when(questionDBMock.createQuestion(interfaceQuestionModelMock)).thenReturn(true);
		assertTrue(questionDBMock.createQuestion(interfaceQuestionModelMock));
		verify(questionDBMock).createQuestion(interfaceQuestionModelMock);
	}

	@Test
	public void insertResponsesTest() {
		when(questionDBMock.insertResponses(responseMock)).thenReturn(true);
		assertTrue(questionDBMock.insertResponses(responseMock));
		verify(questionDBMock).insertResponses(responseMock);
	}

	@Test
	public void deleteQuestionsFromDB(){
		when(questionDBMock.deleteQuestionsFromDB(1,selectedQuestions)).thenReturn(true);
		assertTrue(questionDBMock.deleteQuestionsFromDB(1,selectedQuestions));
		verify(questionDBMock).deleteQuestionsFromDB(1,selectedQuestions);
	}

}
