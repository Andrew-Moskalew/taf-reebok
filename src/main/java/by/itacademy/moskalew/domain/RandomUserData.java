package by.itacademy.moskalew.domain;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomUserData {

    private static final Logger logger = LogManager.getLogger();

    public static String getRandomValidEmail() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        logger.info("email: " + email);
        return email;
    }

    public static String getRandomInvalidEmail() {
        Faker faker = new Faker();
        String email = faker.name().lastName() + "@email";
        logger.info("email: " + email);
        return email;
    }

    public static int getRandomIntEmail() {
        Faker faker = new Faker();
        int email = Integer.parseInt(faker.number().digits(8));
        logger.info("email: " + email);
        return email;
    }

    public static int getRandomIntPassword() {
        Faker faker = new Faker();
        int password = Integer.parseInt(faker.number().digits(8));
        logger.info("password: " + password);
        return password;
    }

    public static String getRandomValidPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@!#$%&";
        String password = RandomStringUtils.random(8, characters);

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%&])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            logger.info("password: " + password);
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
            logger.info("password: " + password);
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
            logger.info("password: " + password);
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
            logger.info("password: " + password);
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
            logger.info("password: " + password);
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
            logger.info("password: " + password);
            return password;
        } else {
            return getRandomInvalidLengthPassword();
        }
    }

}
