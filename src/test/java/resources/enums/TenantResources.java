package resources.enums;

public enum TenantResources {
    at("at"),
    ch("ch"),
    com("com"),
    fr("fr"),
    it("it");
    private String tenant;

    TenantResources(String tenant) {
        this.tenant = tenant;
    }

    public String getTenant() {
        return tenant;
    }
}
