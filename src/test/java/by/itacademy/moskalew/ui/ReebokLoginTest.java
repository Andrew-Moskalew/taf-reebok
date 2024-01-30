package by.itacademy.moskalew.ui;

import by.itacademy.moskalew.domain.RandomUserData;
import by.itacademy.moskalew.pages.ReebokLoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ReebokLoginTest extends BaseTest{

    private static final String ERROR_MESSAGE_ENTER_EMAIL = "Please enter your email";
    private static final String ERROR_MESSAGE_ENTER_PASSWORD = "Please enter your password";
    private static final String ERROR_MESSAGE_USER_NOT_FOUND = "Incorrect email/password – please check and retry";
    private static final String ERROR_MESSAGE_INVALID_EMAIL_FORMAT = "Please enter email in valid format";
    private static final String ERROR_MESSAGE_INVALID_PASSWORD_FORMAT = "Please enter password in valid format";
    ReebokLoginPage reebokLoginPage;
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void testStart() {
        reebokLoginPage = new ReebokLoginPage();
        reebokLoginPage.openLoginForm();
    }

    @Test
    public void testReebokComEmptyEmail() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.clickInputEmail();
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals(ERROR_MESSAGE_ENTER_EMAIL, reebokLoginPage.getTextErrorMessageEmail());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComEmptyPassword() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.clickInputPassword();
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals(ERROR_MESSAGE_ENTER_PASSWORD, reebokLoginPage.getTextErrorMessagePassword());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComValidValues() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.fillLoginFormAndClickSubmit(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomValidPassword());
        Assertions.assertEquals(ERROR_MESSAGE_USER_NOT_FOUND, reebokLoginPage.getTextErrorMessageLoginForm());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComInvalidEmail() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.sendKeysInputEmail(RandomUserData.getRandomInvalidEmail());
        reebokLoginPage.clickInputPassword();
        Assertions.assertEquals(ERROR_MESSAGE_INVALID_EMAIL_FORMAT, reebokLoginPage.getTextErrorMessageEmail());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComInvalidPasswordWithoutUpperCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutUpperCaseChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals(ERROR_MESSAGE_INVALID_PASSWORD_FORMAT, reebokLoginPage.getTextErrorMessagePassword());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComInvalidPasswordWithoutLowerCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutLowerCaseChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals(ERROR_MESSAGE_INVALID_PASSWORD_FORMAT, reebokLoginPage.getTextErrorMessagePassword());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComInvalidPasswordWithoutDigits() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutDigits());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals(ERROR_MESSAGE_INVALID_PASSWORD_FORMAT, reebokLoginPage.getTextErrorMessagePassword());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComInvalidPasswordWithoutSplChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomPasswordWithoutSplChars());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals(ERROR_MESSAGE_INVALID_PASSWORD_FORMAT, reebokLoginPage.getTextErrorMessagePassword());
        logger.info("Test passed \n");
    }

    @Test
    public void testReebokComInvalidLengthPassword() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        reebokLoginPage.sendKeysInputPassword(RandomUserData.getRandomInvalidLengthPassword());
        reebokLoginPage.clickInputEmail();
        Assertions.assertEquals(ERROR_MESSAGE_INVALID_PASSWORD_FORMAT, reebokLoginPage.getTextErrorMessagePassword());
        logger.info("Test passed \n");
    }

}
