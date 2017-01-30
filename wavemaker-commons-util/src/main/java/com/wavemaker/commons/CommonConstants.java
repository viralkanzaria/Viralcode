/**
 * Copyright © 2013 - 2016 WaveMaker, Inc.
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
package com.wavemaker.commons;

/**
 * @author Matt Small
 */
public abstract class CommonConstants {

    public static final String WM_SYSTEM_PROPERTY_PREFIX = "wm.";

    public static final String APP_PROPERTY_FILE = "app.properties";

    public static final String SECURITY_SERVICE_CONTROLLER_CLAZZ = "com.wavemaker.runtime.security.controller.SecurityController";

    public static final String FEED_SERVICE_CONTROLLER_CLAZZ = "com.wavemaker.runtime.feed.controller.FeedServiceController";

    public static final String UTF8 = "UTF-8";

    public static final String SYSTEM_PARAM_PREFIX = "_SYSTEM_";

    //hibernate sql type codes
    public static final Integer DATE_TIME_WM_TYPE_CODE = -777;
    public static final Integer TIMESTAMP_WITH_TIMEZONE_SQL_CODE = -101;
    public static final Integer TIMESTAMP_WITH_LOCAL_TIMEZONE_SQL_CODE = -102;

    private CommonConstants() {
    }
}