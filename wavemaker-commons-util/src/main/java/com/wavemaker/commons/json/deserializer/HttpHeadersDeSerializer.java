package com.wavemaker.commons.json.deserializer;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author Uday Shankar
 */
public class HttpHeadersDeSerializer extends JsonDeserializer<HttpHeaders> {

    @Override
    public HttpHeaders deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = jp.getCodec();
        ObjectNode root = codec.readTree(jp);
        Map<String, Object> map = ((ObjectMapper) codec).readValue(root.toString(), new TypeReference<LinkedHashMap<String, Object>>() {
        });
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                httpHeaders.add(entry.getKey(), (String) entry.getValue());
            } else if (value instanceof List) {
                httpHeaders.put(entry.getKey(), (List<String>) value);
            }
        }
        return httpHeaders;
    }
}