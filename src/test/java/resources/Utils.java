package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import resources.enums.DeviceTypeResources;
import resources.enums.TenantResources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
    private static RequestSpecification requestSpecification;

    public static String getConfigFileValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/config.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    public RequestSpecification requestSpecification(String deviceType, String tenant) throws IOException {
        DeviceTypeResources deviceTypeResources = DeviceTypeResources.valueOf(deviceType);
        TenantResources tenantResources = TenantResources.valueOf(tenant);
        if (requestSpecification == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logs/log.txt"));
            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(getConfigFileValue("baseUrl"))
                    .setContentType(ContentType.JSON)
                    .addHeader("Sae-Device-Type", deviceTypeResources.getDeviceType())
                    .addPathParam("tenant", tenantResources.getTenant())
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build()
                    .log()
                    .all();
        }
        return requestSpecification;
    }

}
