package resources.enums;

public enum APIResources {

    LoginAPI("/auth/v2/{tenant}/login");

    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
