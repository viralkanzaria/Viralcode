/**
 * Copyright (C) 2014 WaveMaker, Inc. All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wavemaker.studio.common.util.utils;

import com.wavemaker.studio.common.classloader.ClassLoaderUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;

import static org.testng.Assert.*;

/**
 * @author Matt Small
 */
public class ClassLoaderUtilsTest {
    @Test
    public void tempClassLoader_getClassTest() throws Exception {

        File sourceJar = new ClassPathResource("com/wavemaker/studio/common/foojar.jar").getFile();
        File jar = File.createTempFile("tempClassLoader_getClassTest", ".jar");
        jar.deleteOnExit();
        FileUtils.copyFile(sourceJar, jar);

        try {
            ClassLoader cl = ClassLoaderUtils.getTempClassLoaderForFile(jar);
            Class<?> klass = ClassLoaderUtils.loadClass("foo.bar.baz.JarType", cl);
            assertNotNull(klass);
        } finally {
            jar.delete();
        }
    }

    @Test
    public void tempClassLoader_getResourceTest() throws Exception {

        File sourceJar = new ClassPathResource("com/wavemaker/studio/common/foojar.jar").getFile();
        File jar = File.createTempFile("tempClassLoader_getClassTest", ".jar");
        jar.deleteOnExit();
        FileUtils.copyFile(sourceJar, jar);

        try {
            ClassLoader cl = ClassLoaderUtils.getTempClassLoaderForFile(jar);
            InputStream is = ClassLoaderUtils.getResourceAsStream("foo/bar/baz/JarType.java", cl);
            assertNotNull(is);
            assertTrue(is.available() > 0);
            is.close();
        } finally {
            jar.delete();
        }
    }



    @Test
    public void getClassLoaderTest() throws ClassNotFoundException {
        ClassLoader loader = ClassLoaderUtils.getClassLoader();
        Class aClass = loader.loadClass("com.wavemaker.studio.common.util.utils.Car");
        assertNotNull(aClass);
        assertEquals(aClass, Car.class);
    }


}