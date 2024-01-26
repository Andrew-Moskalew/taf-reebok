package by.itacademy.moskalew.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BodyGenerator {
    private static final Logger logger = LogManager.getLogger();

    public static String getBody(String email, String password) {
        if (email == null) {
            logger.info("email is null");
            return "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                    " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                    " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                    "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                    ":{\"email\":null,\"password\":\"" + password + "\"}}";
        } else if (password == null) {
            logger.info("password is null");
            return "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                    " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                    " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                    "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                    ":{\"email\":\"" + email + "\",\"password\":null}}";
        } else
            return "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                    " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                    " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                    "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                    ":{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}}";
    }

    public static String getBody(int email, String password) {
        return "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":" + email + ",\"password\":\"" + password + "\"}}";
    }

    public static String getBody(String email, int password) {
        return "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + email + "\",\"password\":" + password + "}}";
    }

    public static String getExpectedResultIntEmail(int email) {
        return String.format("Variable \"$email\" got invalid value %1$d; Expected type String. String cannot represent a non string value: %1$d", email);
    }

    public static String getExpectedResultIntPassword(int password) {
        return String.format("Variable \"$password\" got invalid value %1$d; Expected type String. String cannot represent a non string value: %1$d", password);
    }

    public static String getBodyWithInvalidEmailKey() {
        return "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"EMAIL\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomValidPassword() + "\"}}";
    }

    public static String getBodyWithInvalidPasswordKey() {
        return "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"PASSWORD\":\"" + RandomUserData.getRandomValidPassword() + "\"}}";
    }

    public static String getBodySearch(String searchRequest) {
        return "{\"query\":\"query productSearch($category: String, $productType: String, $offset: Int, $limit: Int, $fetchType: String," +
                " $keyword: String, $facets: [String], $sortBy: String, $sortOrder: String, $locationCode: String, $bruid: String, $deviceType: String," +
                " $offerDate: String) {\\n  productSearch(\\n    category: $category\\n    productType: $productType\\n    offset: $offset\\n" +
                "    limit: $limit\\n    fetchType: $fetchType\\n    keyword: $keyword\\n    facets: $facets\\n    sortBy: $sortBy\\n    " +
                "sortOrder: $sortOrder\\n    locationCode: $locationCode\\n    bruid: $bruid\\n    deviceType: $deviceType\\n    offerDate: $offerDate\\n  ) " +
                "{\\n    query {\\n      keyword\\n      productType\\n      offset\\n      limit\\n      fetchType\\n      categoryName\\n" +
                "      categoryPageDetails {\\n        categoryTitle\\n        crumbId\\n        crumbFullId\\n        crumbData\\n        " +
                "crumbSlug\\n        robots\\n        __typename\\n      }\\n      total\\n      locationCode\\n      bruid\\n      deviceType\\n" +
                "      __typename\\n    }\\n    results {\\n      ...SearchResultProductFragment\\n      __typename\\n    }\\n    filters {\\n " +
                "     id\\n      label\\n      facets {\\n        id\\n        label\\n        count\\n        slug\\n        __typename\\n      " +
                "}\\n      __typename\\n    }\\n    sliderPrice {\\n      min\\n      max\\n      __typename\\n    }\\n    seoCategory\\n    " +
                "keywordRedirect\\n    redirectCategory\\n    __typename\\n  }\\n}\\n\\nfragment SearchResultProductFragment on SearchResultProduct " +
                "{\\n  productDiscountPercentage\\n  salePrice\\n  reqularPrice\\n  newProductName\\n  categoryMarketingLine\\n  modelName\\n  " +
                "productGroup\\n  productId\\n  thumbImage\\n  color\\n  colorGroup\\n  altImage\\n  priceType\\n  division\\n  sport\\n  " +
                "productType\\n  productLine\\n  productFamily\\n  marketPlaceList\\n  rating\\n  reviewCount\\n  brand\\n  brandAsset\\n  " +
                "gender\\n  slug\\n  variants {\\n    discountPercentage\\n    variantTitle\\n    regularPrice\\n    salePrice\\n    variantSlug\\n    " +
                "memberPrice\\n    skuid\\n    variant_thumb_image\\n    badge_text\\n    memberOnly\\n    memberEarly\\n    variant_color_group\\n   " +
                " __typename\\n  }\\n  __typename\\n}\",\"variables\":{\"category\":null,\"keyword\": \" " + searchRequest + " \"," +
                "\"facets\":[],\"offset\":0,\"limit\":49,\"fetchType\":\"bloomreach\",\"sortBy\":null,\"sortOrder\":null,\"locationCode\":\"VI\"," +
                "\"bruid\":\"uid=3979741989024:v=15.0:ts=1706212428942:hc=12\",\"deviceType\":\"desktop\"}}";
    }
}
