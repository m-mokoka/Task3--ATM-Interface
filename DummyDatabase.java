import java.util.HashMap;
import java.util.Map;

public class DummyDatabase {
    private static Map<String, Integer> userAccounts = new HashMap<>();

    static {
        // Dummy user details
        userAccounts.put("user1", 1234);
        userAccounts.put("user2", 5678);
    }

    public static boolean isValidUser(String username, int pin) {
        Integer storedPin = userAccounts.get(username);
        return storedPin != null && storedPin.equals(pin);
    }
}