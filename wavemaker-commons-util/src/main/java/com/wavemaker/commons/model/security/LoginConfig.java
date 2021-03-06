/**
 * Copyright (C) 2020 WaveMaker, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wavemaker.commons.model.security;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by ArjunSahasranam on 13/1/16.
 */
public class LoginConfig {
    private LoginType type;
    private String pageName;
    private int cookieMaxAge;
    private SessionTimeoutConfig sessionTimeout;
    private SessionConcurrencyConfig sessionConcurrencyConfig;

    public LoginType getType() {
        return type;
    }

    public void setType(final LoginType type) {
        this.type = type;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(final String pageName) {
        this.pageName = pageName;
    }

    public SessionTimeoutConfig getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(final SessionTimeoutConfig sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public int getCookieMaxAge() {
        return cookieMaxAge;
    }

    public void setCookieMaxAge(int cookieMaxAge) {
        this.cookieMaxAge = cookieMaxAge;
    }

    public SessionConcurrencyConfig getSessionConcurrencyConfig() {
        return sessionConcurrencyConfig;
    }

    public void setSessionConcurrencyConfig(SessionConcurrencyConfig sessionConcurrencyConfig) {
        this.sessionConcurrencyConfig = sessionConcurrencyConfig;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final LoginConfig that = (LoginConfig) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .append(pageName, that.pageName)
                .append(cookieMaxAge, that.cookieMaxAge)
                .append(sessionTimeout, that.sessionTimeout)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(pageName)
                .append(cookieMaxAge)
                .append(sessionTimeout)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "LoginConfig{" +
                "type=" + type +
                ", page='" + pageName + '\'' +
                ", cookieMaxAge=" + cookieMaxAge +
                ", sessionTimeout=" + sessionTimeout +
                '}';
    }
}
