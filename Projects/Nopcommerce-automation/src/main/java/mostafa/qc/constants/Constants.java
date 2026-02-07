package mostafa.qc.constants;

public class Constants {

    // Timeouts
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 15;
    public static final int PAGE_LOAD_TIMEOUT = 30;

    // Paths
    public static final String CONFIG_PATH = "src/test/resources/config.properties";

    // URLs (relative paths)
    public static final String LOGIN_PATH = "/login";
    public static final String REGISTER_PATH = "/register";
    public static final String CART_PATH = "/cart";
    public static final String CHECKOUT_PATH = "/checkout";

    private Constants() {
        // Prevent instantiation
    }
}