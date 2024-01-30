package by.itacademy.moskalew.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReebokApiPage {
    private static final String URL = "https://www.reebok.com/graphql";
    private static final String CONTENT_TYPE = "application/json";
    private static final String SEARCH_REQUEST = "Spyder x Reebok Zig Kinetica 2.5 Edge Shoes";
    private static final String ERROR_MESSAGE_INCORRET_VALUES = "Incorrect email/password – please check and retry";
    private static final String ERROR_MESSAGE_EMAIL_NULL = "Variable \"$email\" of non-null type \"String!\" must not be null.";
    private static final String ERROR_MESSAGE_PASSWORD_NULL = "Variable \"$password\" of non-null type \"String!\" must not be null.";
    private static final String ERROR_MESSAGE_EMAIL_KEY_INVALID = "Variable \"$email\" of required type \"String!\" was not provided.";
    private static final String ERROR_MESSAGE_PASSWORD_KEY_INVALID = "Variable \"$password\" of required type \"String!\" was not provided.";
    private static final Logger logger = LogManager.getLogger();

    public static String getUrl() {
        return URL;
    }

    public static String getContentType() {
        return CONTENT_TYPE;
    }

    public static String getSearchRequest() {
        return SEARCH_REQUEST;
    }

    public static String getErrorMessageIncorretValues() {
        logger.info("Expected error message is: " + ERROR_MESSAGE_INCORRET_VALUES);
        return ERROR_MESSAGE_INCORRET_VALUES;
    }

    public static String getErrorMessageEmailNull() {
        logger.info("Expected error message is: " + ERROR_MESSAGE_EMAIL_NULL);
        return ERROR_MESSAGE_EMAIL_NULL;
    }

    public static String getErrorMessagePasswordNull() {
        logger.info("Expected error message is: " + ERROR_MESSAGE_PASSWORD_NULL);
        return ERROR_MESSAGE_PASSWORD_NULL;
    }

    public static String getErrorMessageEmailKeyInvalid() {
        logger.info("Expected error message is: " + ERROR_MESSAGE_EMAIL_KEY_INVALID);
        return ERROR_MESSAGE_EMAIL_KEY_INVALID;
    }

    public static String getErrorMessagePasswordKeyInvalid() {
        logger.info("Expected error message is: " + ERROR_MESSAGE_PASSWORD_KEY_INVALID);
        return ERROR_MESSAGE_PASSWORD_KEY_INVALID;
    }

    public static String getExpectedResultIntEmail(int email) {
        String expectedResult = "Variable \"$email\" got invalid value " + email + "; Expected type String. String cannot represent a non string value: " + email;
        logger.info("Expected error message is: " + expectedResult);
        return expectedResult;

    }

    public static String getExpectedResultIntPassword(int password) {
        String expectedResult = "Variable \"$password\" got invalid value " + password + "; Expected type String. String cannot represent a non string value: " + password;
        logger.info("Expected error message is: " + expectedResult);
        return expectedResult;
    }

}
