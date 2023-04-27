package resources.enums;

public enum DeviceTypeResources {
    browser("browser"),
    iosApp("iosApp"),
    androidApp("androidApp");
    private String deviceType;

    DeviceTypeResources(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    ;
}
