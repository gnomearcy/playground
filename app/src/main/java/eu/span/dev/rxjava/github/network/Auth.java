package eu.span.dev.rxjava.github.network;

public class Auth
{
    /**
     * Requests that require authentication will return 404 Not Found, instead of 403 Forbidden, in
     * some places. This is to prevent the accidental leakage of private repositories to unauthorized
     * users.
     * source:
     * https://developer.github.com/v3/
    */
    public static final int AUTH_REQUIRED = 404;

    public static final int INVALID_CREDENTIALS = 401;
}
