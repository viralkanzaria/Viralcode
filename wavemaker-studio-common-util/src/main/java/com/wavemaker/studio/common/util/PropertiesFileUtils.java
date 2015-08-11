package com.wavemaker.studio.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.wavemaker.studio.common.WMRuntimeException;

/**
 * @author Uday Shankar
 */
public class PropertiesFileUtils {

    public static Properties loadFromXml(File file) {
        try {
            return loadFromXml(new BufferedInputStream(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            throw new WMRuntimeException("File:" + file.getAbsolutePath() + " not found", e);
        }
    }

    public static Properties loadFromXml(InputStream is) {
        try {
            Properties properties = new Properties();
            properties.loadFromXML(is);
            return properties;
        } catch (IOException e) {
            throw new WMRuntimeException("Failed to read properties input stream", e);
        } finally {
            IOUtils.closeSilently(is);
        }
    }

    public static void storeToXml(Properties properties, File file, String comment) {
        try {
            storeToXml(properties, new BufferedOutputStream(new FileOutputStream(file)), comment);
        } catch (FileNotFoundException e) {
            throw new WMRuntimeException("File:" + file.getAbsolutePath() + " not found", e);
        }
    }

    public static void storeToXml(Properties properties, OutputStream os, String comment) {
        try {
            properties.storeToXML(os, comment, "UTF-8");
        } catch (IOException e) {
            throw new WMRuntimeException("Failed to write properties file to output stream", e);
        } finally {
            IOUtils.closeSilently(os);
        }
    }

    public static Properties loadProperties(File file) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            return loadProperties(is);
        } catch (FileNotFoundException e) {
            throw new WMRuntimeException("File:" + file.getAbsolutePath() + " not found", e);
        }
    }

    public static Properties loadProperties(InputStream stream) {
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new WMRuntimeException("Failed to load properties.", e);
        } finally {
            IOUtils.closeByLogging(stream);
        }
        return properties;
    }

    public static void storeProperties(Properties props, File file) {
        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
            storeProperties(props, os);
        } catch (FileNotFoundException e) {
            throw new WMRuntimeException("File:" + file.getAbsolutePath() + " not found", e);
        }
    }

    public static void storeProperties(Properties props, OutputStream outputStream) {
        try {
            props.store(outputStream, null);
        } catch (IOException e) {
            throw new WMRuntimeException("Failed to store properties.", e);
        } finally {
            IOUtils.closeByLogging(outputStream);
        }
    }
}
