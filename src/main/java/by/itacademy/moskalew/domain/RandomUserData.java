package by.itacademy.moskalew.domain;

import com.github.javafaker.Faker;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import static org.passay.DigestDictionaryRule.ERROR_CODE;

public class RandomUserData {
    public static String getRandomValidEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getRandomInvalidEmail() {
        Faker faker = new Faker();
        return faker.name().lastName() + "@email";
    }


    public static String generateValidPassword() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(8, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }

    public static String generatePasswordWithoutLowerCaseChars() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(4);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(8, splCharRule,
                upperCaseRule, digitRule);
        return password;
    }

    public static String generatePasswordWithoutUpperCaseChars() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(4);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(8, splCharRule, lowerCaseRule,
                digitRule);
        return password;
    }

    public static String generatePasswordWithoutDigits() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(4);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(8, splCharRule, lowerCaseRule,
                upperCaseRule);
        return password;
    }

    public static String generatePasswordWithoutSplChars() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(4);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(8, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }

    public static String generateInvalidLengthPassword() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(1);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(7, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }

    public static String getBodyWithRandomValidValuesAPI() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.generateValidPassword() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutLowerCaseChars() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.generatePasswordWithoutLowerCaseChars() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutUpperCaseChars() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.generatePasswordWithoutUpperCaseChars() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutDigits() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.generatePasswordWithoutDigits() + "\"}}";
        return result;
    }

    public static String getBodyPasswordWithoutSplChars() {
        String result = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.generatePasswordWithoutSplChars() + "\"}}";
        return result;
    }

}
