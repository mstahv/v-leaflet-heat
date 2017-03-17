package org.vaadin.addon.leaflet.testbenchtests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.vaadin.addonhelpers.TListUi;

public class SimpleTest extends AbstractTestBenchTest {

    @Test
    public void checkAllTestsOpenWithoutErrors() throws IOException, AssertionError {
        startBrowser();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		java.util.List<TListUi.TestDetails> listTestClasses = TListUi.listTestClasses();
        for (TListUi.TestDetails testDetail : listTestClasses) {
			Class clazz = testDetail.getClazz();

			driver.get(BASEURL + clazz.getName() + "?debug");
			try {
				WebElement error = driver.findElement(By.className("v-Notification-error"));
				Assert.fail("Test " + clazz.getName() + " has client side exception");
			} catch (NoSuchElementException ignored) {
			}
			
		}
        
    }

}
