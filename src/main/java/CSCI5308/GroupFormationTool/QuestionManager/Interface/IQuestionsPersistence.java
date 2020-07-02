package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import java.util.List;

public interface IQuestionsPersistence {

    List<InterfaceQuestionModel> loadAllQuestionsByID(String bannerID);

    boolean createQuestion(InterfaceQuestionModel question);

    boolean insertResponses(InterfaceResponses response);

    boolean deleteQuestionsFromDB(long userId, String[] selectedQuestions);
}
