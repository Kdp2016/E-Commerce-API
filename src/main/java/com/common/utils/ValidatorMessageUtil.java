package com.common.utils;

public class ValidatorMessageUtil {
    /* OnCreate User Validation Error Messages */
    public static final String PROVIDE_NO_ID_ON_CREATE = "No id is expected in the request payload for user creation";
    public static final String FNAME_REQUIRED_ON_CREATE = "A first name value is expected in the request payload for user creation";
    public static final String LNAME_REQUIRED_ON_CREATE = "A last name value is expected in the request payload for user creation";
    public static final String EMAIL_REQUIRED_ON_CREATE = "An email value is expected in the request payload for user creation";
    public static final String PASSWORD_REQUIRED_ON_CREATE = "A password value is expected in the request payload for user creation";
    public static final String PROVIDE_NO_ROLE_ON_CREATE = "No role is expected in the request payload for user creation";

    /** OnUpdate User Validation Error Messages */
    public static final String ID_REQUIRED_ON_UPDATE = "An id is required in the request payload for user update";

    /** General User Validation Error Messages */
    public static final String FNAME_REQUIREMENTS = "At least one character must be provided for a first name";
    public static final String LNAME_REQUIREMENTS = "At least one character must be provided for a last name";
    public static final String EMAIL_REQUIREMENTS = "A valid email must be provided";
    public static final String PASSWORD_REQUIREMENTS = "Passwords must be eight characters long";

    public static final String EMAIL_REQUIRED = "A non-null email address is required for this operation";
}
