/**
 * Copyright © 2013 - 2017 WaveMaker, Inc.
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
package com.wavemaker.commons.servicedef.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 27/11/15
 */
public class WMServiceOperationInfo {

    private String name;
    private String methodType;
    private String relativePath;
    private String directPath;
    private String httpMethod;
    private List<Parameter> parameters;
    private Map<String, List<Parameter>> definitions;
    private List<String> produces;
    private List<String> consumes;
    private String authorization;
    private RuntimeProxySettings proxySettings;

    @JsonIgnore
    public static synchronized WMServiceOperationInfo getNewInstance() {
        return new WMServiceOperationInfo();
    }


    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public WMServiceOperationInfo addHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(final String relativePath) {
        this.relativePath = relativePath;
    }

    public WMServiceOperationInfo addRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    public String getDirectPath() {
        return directPath;
    }

    public void setDirectPath(final String directPath) {
        this.directPath = directPath;
    }

    public WMServiceOperationInfo addDirectPath(String directPath) {
        this.directPath = directPath;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WMServiceOperationInfo addName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<String> consumes) {
        this.consumes = consumes;
    }

    public WMServiceOperationInfo addConsumes(List<String> consumes) {
        this.consumes = consumes;
        return this;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public WMServiceOperationInfo addParameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public WMServiceOperationInfo addMethodType(String methodType) {
        this.methodType = methodType;
        return this;
    }

    public List<String> getProduces() {
        return produces;
    }

    public void setProduces(final List<String> produces) {
        this.produces = produces;
    }

    public WMServiceOperationInfo addProduces(final List<String> produces) {
        this.produces = produces;
        return this;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(final String authorization) {
        this.authorization = authorization;
    }

    public WMServiceOperationInfo addAuthorization(final String authorization) {
        this.authorization = authorization;
        return this;
    }

    public RuntimeProxySettings getProxySettings() {
        return proxySettings;
    }

    public void setProxySettings(RuntimeProxySettings proxySettings) {
        this.proxySettings = proxySettings;
    }

    public WMServiceOperationInfo addProxySettings(RuntimeProxySettings proxySettings) {
        this.setProxySettings(proxySettings);
        return this;
    }

    public Map<String, List<Parameter>> getDefinitions() {
        if (definitions == null) {
            return new HashMap<>();
        }
        return definitions;
    }

    public void setDefinitions(final Map<String, List<Parameter>> definitions) {
        this.definitions = definitions;
    }

    public WMServiceOperationInfo addDefinitions(final Map<String, List<Parameter>> definitions) {
        this.setDefinitions(definitions);
        return this;
    }

    @Override
    public String toString() {
        return "WMServiceOperationInfo{" +
                "name='" + name + '\'' +
                ", methodType='" + methodType + '\'' +
                ", relativePath='" + relativePath + '\'' +
                ", directPath='" + directPath + '\'' +
                ", proxySettings=" + proxySettings +
                ", httpMethod='" + httpMethod + '\'' +
                ", parameters=" + parameters +
                ", produces=" + produces +
                ", consumes=" + consumes +
                ", authorization='" + authorization + '\'' +
                '}';
    }
}
