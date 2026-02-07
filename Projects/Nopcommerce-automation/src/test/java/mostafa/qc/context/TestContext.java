package mostafa.qc.context;




import mostafa.qc.utils.DriverFactory;
import mostafa.qc.utils.WaitUtils;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final WaitUtils waitUtils;
    private final Map<String, Object> scenarioContext;

    public TestContext() {
        this.waitUtils = new WaitUtils(getDriver());
        this.scenarioContext = new HashMap<>();
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public WaitUtils getWaitUtils() {
        return waitUtils;
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getContext(String key) {
        return (T) scenarioContext.get(key);
    }

    public boolean containsKey(String key) {
        return scenarioContext.containsKey(key);
    }
}