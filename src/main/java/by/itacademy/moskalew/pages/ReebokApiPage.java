package by.itacademy.moskalew.pages;

public class ReebokApiPage {
    public static final String URL = "https://www.reebok.com/graphql";
    public static final String CONTENT_TYPE = "application/json";
    public static final String SEARCH_REQUEST = "Spyder x Reebok Zig Kinetica 2.5 Edge Shoes";
    public static final String ERROR_MESSAGE_INCORRET_VALUES = "Incorrect email/password – please check and retry";
    public static final String ERROR_MESSAGE_EMAIL_NULL = "Variable \"$email\" of non-null type \"String!\" must not be null.";
    public static final String ERROR_MESSAGE_PASSWORD_NULL = "Variable \"$password\" of non-null type \"String!\" must not be null.";
    public static final String ERROR_MESSAGE_EMAIL_KEY_INVALID = "Variable \"$email\" of required type \"String!\" was not provided.";
    public static final String ERROR_MESSAGE_PASSWORD_KEY_INVALID = "Variable \"$password\" of required type \"String!\" was not provided.";

    public static String getExpectedResultIntEmail(int email) {
        return "Variable \"$email\" got invalid value " + email + "; Expected type String. String cannot represent a non string value: " + email;
    }

    public static String getExpectedResultIntPassword(int password) {
        return "Variable \"$password\" got invalid value " + password + "; Expected type String. String cannot represent a non string value: " + password;
    }

}
