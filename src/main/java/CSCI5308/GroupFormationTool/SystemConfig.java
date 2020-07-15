package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.UserDB;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
import CSCI5308.GroupFormationTool.Courses.CourseDB;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;
import CSCI5308.GroupFormationTool.Courses.CourseUserRelationshipDB;
import CSCI5308.GroupFormationTool.Database.DefaultDatabaseConfiguration;
import CSCI5308.GroupFormationTool.Database.IDatabaseConfiguration;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionSorters;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceDeleteQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceListQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.DeleteQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.ListQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionDB;
import CSCI5308.GroupFormationTool.QuestionManager.SortingDB;
import CSCI5308.GroupFormationTool.Security.BCryptPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.DefaultPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Survey.*;


public class SystemConfig {
	private static SystemConfig uniqueInstance = null;
	private IPasswordEncryption passwordEncryption;
	private IUserPersistence userDB;
	private IDatabaseConfiguration databaseConfiguration;
	private ICoursePersistence courseDB;
	private ICourseUserRelationshipPersistence courseUserRelationshipDB;
	private IPasswordValidationConfiguration passwordValidationConfiguration;
	private IQuestionsPersistence questionDB;
	private IQuestionSorters sortersDB;
	private InterfaceListQuestionsRepo listQuestionsRepo;
	private InterfaceDeleteQuestionsRepo deleteQuestionsRepo;
	private ICreateSurveyQuestionsModel createSurveyQuestionsModel;
	private IQueryQuestionsRepo queryQuestionsRepo;
	private ISurveyExistRepo surveyExistRepo;
	private ISaveSurveyRepo saveSurveyRepo;

	public ICreateSurveyQuestionsModel getCreateSurveyQuestionsModel() {
		return createSurveyQuestionsModel;
	}

	public void setCreateSurveyQuestionsModel(ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel) {
		this.createSurveyQuestionsModel = iCreateSurveyQuestionsModel;
	}

	public ISurveyExistRepo getSurveyExistRepo() {
		return surveyExistRepo;
	}

	public void setSurveyExistRepo(ISurveyExistRepo surveyExistRepo) {
		this.surveyExistRepo = surveyExistRepo;
	}

	private SystemConfig() {
		passwordEncryption = new BCryptPasswordEncryption();
		userDB = new UserDB();
		databaseConfiguration = new DefaultDatabaseConfiguration();
		courseDB = new CourseDB();
		courseUserRelationshipDB = new CourseUserRelationshipDB();
		passwordValidationConfiguration = new DefaultPasswordValidationConfiguration();
		questionDB = new QuestionDB();
		sortersDB = new SortingDB();
		listQuestionsRepo = new ListQuestionsRepo();
		deleteQuestionsRepo = new DeleteQuestionsRepo();
		createSurveyQuestionsModel=new CreateSurveyQuestionsModel();
		queryQuestionsRepo=new QueryQuestionsRepo();
		surveyExistRepo=new SurveyExistRepo();
		saveSurveyRepo=new SaveSurveyRepo();
	}

	public ISaveSurveyRepo getSaveSurveyRepo() {
		return saveSurveyRepo;
	}

	public void setSaveSurveyRepo(ISaveSurveyRepo saveSurveyRepo) {
		this.saveSurveyRepo = saveSurveyRepo;
	}

	public IQueryQuestionsRepo getQueryQuestionsRepo() {
		return queryQuestionsRepo;
	}

	public void setQueryQuestionsRepo(IQueryQuestionsRepo queryQuestionsRepo) {
		this.queryQuestionsRepo = queryQuestionsRepo;
	}


	public static SystemConfig instance(){
		if (null == uniqueInstance) {
			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}

	public InterfaceListQuestionsRepo getListQuestionsRepo() {
		return listQuestionsRepo;
	}

	public void setListQuestionsRepo(InterfaceListQuestionsRepo listQuestionsRepo) {
		this.listQuestionsRepo = listQuestionsRepo;
	}

	public InterfaceDeleteQuestionsRepo getDeleteQuestionsRepo() {
		return deleteQuestionsRepo;
	}

	public void setDeleteQuestionsRepo(InterfaceDeleteQuestionsRepo deleteQuestionsRepo) {
		this.deleteQuestionsRepo = deleteQuestionsRepo;
	}

	public IPasswordEncryption getPasswordEncryption() {
		return passwordEncryption;
	}

	public void setPasswordEncryption(IPasswordEncryption passwordEncryption) {
		this.passwordEncryption = passwordEncryption;
	}

	public IUserPersistence getUserDB() {
		return userDB;
	}

	public void setUserDB(IUserPersistence userDB) {
		this.userDB = userDB;
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}

	public void setCourseDB(ICoursePersistence courseDB) {
		this.courseDB = courseDB;
	}

	public ICoursePersistence getCourseDB() {
		return courseDB;
	}

	public void setCourseUserRelationshipDB(ICourseUserRelationshipPersistence courseUserRelationshipDB) {
		this.courseUserRelationshipDB = courseUserRelationshipDB;
	}

	public ICourseUserRelationshipPersistence getCourseUserRelationshipDB() {
		return courseUserRelationshipDB;
	}

	public IPasswordValidationConfiguration getPasswordValidationConfiguration() {
		return passwordValidationConfiguration;
	}

	public void setPasswordValidationConfiguration(IPasswordValidationConfiguration passwordValidationConfiguration) {
		this.passwordValidationConfiguration = passwordValidationConfiguration;
	}

	public IQuestionsPersistence getQuestionDB() {
		return questionDB;
	}

	public void setQuestionDB(IQuestionsPersistence questionDB) {
		this.questionDB = questionDB;
	}

	public IQuestionSorters getSortersDB() {
		return sortersDB;
	}

	public void setSortersDB(IQuestionSorters sortersDB) {
		this.sortersDB = sortersDB;
	}

}
