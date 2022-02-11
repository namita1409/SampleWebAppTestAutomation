package com.hart.beat.pages.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

@Before
public void beforeTest(){
    System.out.println("dsgsgsgdsgsgsdgshdshsh");
    Utils.openBrowser();
}

@After
public void afterTest(){
     Utils.closeBrowser();
}
}
