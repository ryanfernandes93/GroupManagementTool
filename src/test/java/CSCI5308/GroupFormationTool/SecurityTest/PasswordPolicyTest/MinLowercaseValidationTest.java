package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinLowercaseValidation;

class MinLowercaseValidationTest {

	@Test
	void isValidPasswordTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MinLowercaseValidation validator = new MinLowercaseValidation();
		
		// 3 lowercase letters 3 > 2
		assertTrue(validator.isValidPassword("RaouF", config));
		assertTrue(validator.isValidPassword("RAouf", config));
		assertTrue(validator.isValidPassword("rAOuf", config));
		assertTrue(validator.isValidPassword("rAouF", config));
		assertTrue(validator.isValidPassword("rAouF1@", config));
		// 2 lowercase letters 2 == 2
		assertTrue(validator.isValidPassword("RaOuF", config));
		assertTrue(validator.isValidPassword("RAOuf", config));
		assertTrue(validator.isValidPassword("rAOUf", config));
		assertTrue(validator.isValidPassword("rAOuF", config));
		assertTrue(validator.isValidPassword("rAoUF1@", config));
		// 0 lowercase letters 0 < 2
		assertFalse(validator.isValidPassword("RAOUF", config));
		assertFalse(validator.isValidPassword("RAOUF1@", config));
		assertFalse(validator.isValidPassword("1234", config));
		assertFalse(validator.isValidPassword("!@#$%", config));
		// Null password
		assertFalse(validator.isValidPassword(null, config));
	}
	
	@Test
	void getValidationMessageTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MinLowercaseValidation validator = new MinLowercaseValidation();
		
		// 2 lowercase letters 2=2
		assertEquals(validator.getPasswordValidationMessage("RAouf", config),
				String.format(MinLowercaseValidation.VALID_PASSWORD_MESSAGE, validator.getMinLowercase()));
		// 1 lowercase letters 1<2
		assertEquals(validator.getPasswordValidationMessage("RaOUF", config),
				String.format(MinLowercaseValidation.INVALID_PASSWORD_MESSAGE, validator.getMinLowercase()));
	}
}
