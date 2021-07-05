package com.autotest;

import com.autotest.mysoft.MonkeyTest;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunCase {

    public static void main(String[] args) {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("host", "http://10.5.11.142:8006");
        XmlSuite suite = new XmlSuite();
        suite.setName("Core");
        suite.setParameters(parameters);
        suite.addListener("com.autotest.listeners.ExtentTestNGITestListener");
        XmlTest test = new XmlTest(suite);
        test.setName("Core");
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("com.autotest.mysoft.IOrganizationPublicServiceTest"));
        test.setXmlClasses(classes);
        suite.addIncludedGroup("outside");
        suite.addExcludedGroup("alter");


        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("host", "http://10.5.6.15:8007");
        XmlSuite suite2 = new XmlSuite();
        suite2.setName("Framework");
        suite2.setParameters(parameters2);
        suite2.addListener("com.autotest.listeners.ExtentTestNGITestListener");
        XmlTest test2 = new XmlTest(suite2);
        test2.setName("Framework");
        List<XmlClass> classes2 = new ArrayList<>();
        classes2.add(new XmlClass("com.autotest.mysoft.IOrganizationPublicServiceTest"));
        test2.setXmlClasses(classes2);
        suite2.addIncludedGroup("outside");
        suite2.addExcludedGroup("alter");


        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        //suites.add(suite2);



        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        //testNG.addListener("com.autotest.listeners.ExtentTestNGITestListener");
        testNG.run();

    }
}


