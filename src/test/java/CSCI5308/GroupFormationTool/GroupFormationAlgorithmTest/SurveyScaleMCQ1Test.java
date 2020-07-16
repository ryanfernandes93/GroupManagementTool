package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyResponse;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyScale;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyScaleMCQ1;

class SurveyScaleMCQ1Test {

	@Test
	public void distanceTest() {
		ISurveyResponse sr1 = new SurveyResponseMock1();
		ISurveyResponse sr2 = new SurveyResponseMock4();
		ISurveyScale sc = new SurveyScaleMock1();
		
		assertEquals(0.0, sc.distance(sr1, sr1, 0));
		assertEquals(0.0, sc.distance(sr2, sr2, 0));
		assertEquals(1.0, sc.distance(sr1, sr2, 0));
		assertEquals(1.0, sc.distance(sr2, sr1, 0));
	}
	
	@Test
	void converValueTest() {
		assertEquals(0b0001, SurveyScaleMCQ1.convertValue("1"));
		assertEquals(0b1000, SurveyScaleMCQ1.convertValue("4"));
	}
	
	@Test
	void distanceSimilarTest() {
		assertEquals(0b0000, SurveyScaleMCQ1.distanceSimilar(0, 0));
		assertEquals(0b0000, SurveyScaleMCQ1.distanceSimilar(4, 4));
		assertEquals(0b0001, SurveyScaleMCQ1.distanceSimilar(8, 2));
	}
	
	@Test
	void distanceDissimilar() {
		assertEquals(0b0000, SurveyScaleMCQ1.distanceDissimilar(8, 0));
		assertEquals(0b0001, SurveyScaleMCQ1.distanceDissimilar(8, 8));
	}
}
	