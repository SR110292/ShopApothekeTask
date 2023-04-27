package resources;

public class PayloadBuilder {

    public String createUserPayload(String username, String password) {
        return "{\n" +
                "    \"username\": \"" + username + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}";
    }

}
