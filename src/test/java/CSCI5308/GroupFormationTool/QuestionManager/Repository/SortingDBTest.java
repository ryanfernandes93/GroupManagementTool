package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

class SortingDBTest {
    @Mock
    CallStoredProcedure procedure;

    @Mock
    ResultSet rs;

    @Mock
    private SortingDB sortingDB;

    private Sorters sorters;
    String bannerID;
    List<QuestionModel> questionList = new ArrayList<>();

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        assertNotNull(procedure);

        sorters = new Sorters();
        sorters.setSortField("question_title");
        sorters.setSortOrder("ASC");
        bannerID = "B999999";
        QuestionModel q1 = new QuestionModel();
        QuestionModel q2 = new QuestionModel();
        q1.setQuestionTitle("Skills");
        q2.setQuestionTitle("Credits");
        questionList.add(q1);
        questionList.add(q2);
        Collections.sort(questionList, Comparator.comparing(QuestionModel::getQuestionTitle));

        when(procedure.executeWithResults()).thenReturn(rs);
        when(sortingDB.sort(bannerID,sorters)).thenReturn(questionList);

        QuestionModel q3 = new QuestionModel();
        q3.setQuestionTitle("Project");
        questionList.add(q3);
        when(sortingDB.clearSort(bannerID)).thenReturn(questionList);

    }

    @AfterEach
    void tearDown() {
        validateMockitoUsage();
    }

    @Test
    void sort() {
        assertEquals(sortingDB.sort(bannerID,sorters),questionList);
        Mockito.verify(sortingDB).sort(bannerID,sorters);
    }

    @Test
    void clearSort() {
        assertEquals(sortingDB.clearSort(bannerID),questionList);
        Mockito.verify(sortingDB).clearSort(bannerID);
    }
}