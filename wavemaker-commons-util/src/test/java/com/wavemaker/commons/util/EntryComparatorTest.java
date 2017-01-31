/**
 * Copyright © 2013 - 2017 WaveMaker, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wavemaker.commons.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wavemaker.commons.util.WMTestUtils;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * @author Matt Small
 */
public class EntryComparatorTest {

    @Test
    public void comparatorTest() throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        map.put("c", "foobar");
        map.put("a", "foobar");

        Entry<String, String> entryC = null;
        Entry<String, String> entryA = null;
        for (Entry<String, String> entry : map.entrySet()) {
            if ("a".equals(entry.getKey())) {
                entryA = entry;
            } else if ("c".equals(entry.getKey())) {
                entryC = entry;
            }
        }
        assertNotNull(entryC);
        assertNotNull(entryA);

        EntryComparator ec = new EntryComparator();
        assertTrue(ec.compare(entryA, entryC) < 0);
        assertTrue(ec.compare(entryC, entryA) > 0);
    }
}