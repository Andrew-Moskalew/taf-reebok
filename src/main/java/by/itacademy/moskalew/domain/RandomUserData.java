package by.itacademy.moskalew.domain;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomUserData {
    public static String getRandomValidEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getRandomInvalidEmail() {
        Faker faker = new Faker();
        return faker.name().lastName() + "@email";
    }

    public static String getRandomValidPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@!#$%&";
        String password = RandomStringUtils.random(8, characters);

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%&])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            return password;
        } else {
            return getRandomValidPassword();
        }
    }

    public static String getRandomPasswordWithoutLowerCaseChars() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@!#$%&";
        String password = RandomStringUtils.random(8, characters);

        String regex = "^(?=.*[A-Z])(?=.*[@!#$%&])(?=.*[0-9])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            return password;
        } else {
            return getRandomPasswordWithoutLowerCaseChars();
        }
    }

    public static String getRandomPasswordWithoutUpperCaseChars() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789@!#$%&";
        String password = RandomStringUtils.random(8, characters);

        String regex = "^(?=.*[a-z])(?=.*[@!#$%&])(?=.*[0-9])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            return password;
        } else {
            return getRandomPasswordWithoutUpperCaseChars();
        }
    }

    public static String getRandomPasswordWithoutDigits() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@!#$%&";
        String password = RandomStringUtils.random(8, characters);

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%&])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            return password;
        } else {
            return getRandomPasswordWithoutDigits();
        }
    }

    public static String getRandomPasswordWithoutSplChars() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String password = RandomStringUtils.random(8, characters);

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            return password;
        } else {
            return getRandomPasswordWithoutSplChars();
        }
    }

    public static String getRandomInvalidLengthPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@!#$%&";
        String password = RandomStringUtils.random(7, characters);

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%&])(?=\\S+$).{7,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            return password;
        } else {
            return getRandomInvalidLengthPassword();
        }
    }

    public static String getBodyWithValidValues() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomValidPassword() + "\"}}";
        return result;
    }

    public static String getBodyWithInvalidEmail() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomInvalidEmail() + "\",\"password\":\"" + RandomUserData.getRandomValidPassword() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutLowerCaseChars() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomPasswordWithoutLowerCaseChars() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutUpperCaseChars() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomPasswordWithoutUpperCaseChars() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutDigits() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomPasswordWithoutDigits() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutSplChars() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomPasswordWithoutSplChars() + "\"}}";
        return result;
    }

    public static String getBodyInvalidLengthPassword() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomPasswordWithoutSplChars() + "\"}}";
        return result;
    }

}
