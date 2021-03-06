package org.vaadin.addon.leaflet.testbenchtests;

import org.eclipse.jetty.server.Server;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.vaadin.addon.leaflet.demoandtestapp.util.UiRunner;
import org.vaadin.addonhelpers.TServer;

/**
 * This abstract class can be used if one e.g. cannot afford TestBench license.
 *
 */
public class AbstractWebDriverCase {

    protected static final int TESTPORT = 5678;
    protected static final String BASEURL = "http://localhost:" + TESTPORT
            + "/";
    protected WebDriver driver;
    private Server server;

    public AbstractWebDriverCase() {
        super();
    }

    @Before
    public void setUp() {
        try {
            server = new UiRunner().startServer(TESTPORT);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }

    protected void startBrowser() {
        driver = new PhantomJSDriver();
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}