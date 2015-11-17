package com.wavemaker.studio.common.util.utils;

import com.wavemaker.studio.common.util.PropertiesFileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

import static org.testng.Assert.assertEquals;


/**
 * Created by Prithvi Medavaram on 26/10/15.
 */
public class PropertiesFileUtilsTest {
    @Test(dataProvider = "fileProvider")
    public void loadFromXmlFileTest(File xmlFile, Properties properties) throws IOException {
        try {
            Properties actualProperties = PropertiesFileUtils.loadFromXml(xmlFile);
            assertEquals(actualProperties, properties);
        } finally {
            xmlFile.delete();
        }

    }

    @Test(dataProvider = "fileProvider")
    public void loadFromXmlStreamTest(File xmlFile, Properties properties) throws IOException {
        InputStream inputStream = new FileInputStream(xmlFile);
        try {
            Properties actualProperties = PropertiesFileUtils.loadFromXml(inputStream);
            assertEquals(actualProperties, properties);
        } finally {
            xmlFile.delete();
            inputStream.close();
        }

    }

    @Test(dataProvider = "fileProvider")
    public void storeToXmlTest(File xmlFile, Properties properties) throws IOException {
        InputStream inputStream = new FileInputStream(xmlFile);
        try {
            properties.setProperty("Name", "Uday");
            properties.setProperty("UserName", "Uday Shankar");
            properties.setProperty("Password", "pramati456");
            PropertiesFileUtils.storeToXml(properties, xmlFile, "");
            Properties actualProperties = new Properties();
            actualProperties.loadFromXML(inputStream);
            assertEquals(actualProperties.getProperty("Name").toString(), "Uday");
        } finally {
            xmlFile.delete();
            inputStream.close();
        }
    }

    @Test(dataProvider = "fileProvider")
    public void storeToXmlStreamTest(File xmlFile, Properties properties) throws IOException {
        OutputStream outputStream = new FileOutputStream(xmlFile);
        InputStream inputStream = new FileInputStream(xmlFile);
        try {
            properties.setProperty("Name", "Uday");
            properties.setProperty("UserName", "Uday Shankar");
            properties.setProperty("Password", "pramati456");
            PropertiesFileUtils.storeToXml(properties, outputStream, "");
            Properties actualProperties = new Properties();
            actualProperties.loadFromXML(inputStream);
            assertEquals(actualProperties.getProperty("Name").toString(), "Uday");
        } finally {
            xmlFile.delete();
        }
    }

    @Test(dataProvider = "fileProvider")
    public void loadPropertiesTest(File propFile, Properties properties) throws IOException {
        try {
            Properties actualProperties = PropertiesFileUtils.loadProperties(propFile);
            assertEquals(actualProperties, properties);
        } finally {
            propFile.delete();
        }
    }

    @Test(dataProvider = "fileProvider")
    public void loadPropertiesStreamTest(File propFile, Properties properties) throws IOException {
        InputStream inputStream = new FileInputStream(propFile);
        try {
            Properties actualProperties = PropertiesFileUtils.loadProperties(inputStream);
            assertEquals(actualProperties, properties);
        } finally {
            propFile.delete();
            inputStream.close();
        }
    }

    @Test(dataProvider = "fileProvider")
    public void storePropertiesTest(File propFile, Properties properties) throws IOException {
        InputStream inputStream = new FileInputStream(propFile);
        try {
            properties.setProperty("Name", "Uday");
            properties.setProperty("UserName", "Uday Shankar");
            properties.setProperty("Password", "pramati456");
            PropertiesFileUtils.storeProperties(properties, propFile, "");
            Properties actualProperties = new Properties();
            actualProperties.load(inputStream);
            assertEquals(actualProperties, properties);
        } finally {
            propFile.delete();
        }
    }

    @Test(dataProvider = "fileProvider")
    public void storePropertiesStreamTest(File propFile, Properties properties) throws IOException {
        OutputStream outputStream = new FileOutputStream(propFile);
        InputStream inputStream = new FileInputStream(propFile);
        try {
            properties.setProperty("Name", "Uday");
            properties.setProperty("UserName", "Uday Shankar");
            properties.setProperty("Password", "pramati456");
            PropertiesFileUtils.storeProperties(properties, outputStream, "");
            Properties actualProperties = new Properties();
            actualProperties.load(inputStream);
            assertEquals(actualProperties, properties);
        } finally {
            propFile.delete();
            outputStream.close();
            inputStream.close();
        }
    }

    @DataProvider
    public Object[][] fileProvider(Method name) throws IOException {
        Object[][] object = new Object[1][2];
        Properties properties = new Properties();
        File xmlFile = File.createTempFile("onlyForUsage", ".xml");
        File propFile = File.createTempFile("onlyForUsage", ".properties");
        properties.setProperty("Name", "Prithvi");
        properties.setProperty("UserName", "Prithvi Medavaram");
        properties.setProperty("Password", "pramati123");
        if (name.getName().equalsIgnoreCase("loadFromXmlFileTest") || name.getName().equalsIgnoreCase("loadFromXmlStreamTest") || name.getName().equalsIgnoreCase("storeToXmlTest") || name.getName().equalsIgnoreCase("storeToXmlStreamTest")) {
            FileOutputStream fileOutputStream = new FileOutputStream(xmlFile);
            try {
                properties.storeToXML(fileOutputStream, "");
                object[0][0] = xmlFile;
                object[0][1] = properties;
            } finally {
                fileOutputStream.close();
            }
        }
        if (name.getName().equalsIgnoreCase("loadPropertiesTest") || name.getName().equalsIgnoreCase("loadPropertiesStreamTest") || name.getName().equalsIgnoreCase("storePropertiesTest") || name.getName().equalsIgnoreCase("storePropertiesStreamTest")) {
            FileOutputStream fileOutputStream = new FileOutputStream(propFile);
            try {
                properties.store(fileOutputStream, "");
                object[0][0] = propFile;
                object[0][1] = properties;
            } finally {
                fileOutputStream.close();
            }
        }
        return object;
    }
}