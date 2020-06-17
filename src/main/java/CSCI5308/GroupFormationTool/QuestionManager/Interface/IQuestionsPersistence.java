package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;

import java.util.List;

public interface IQuestionsPersistence {
    public List<Question> getQuestionsList();
    
    public boolean createQuestion(QuestionModel question);
    
    public boolean insertResponses(Responses response);
}
