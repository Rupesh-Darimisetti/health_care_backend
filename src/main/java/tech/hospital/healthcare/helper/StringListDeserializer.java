package tech.hospital.healthcare.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListDeserializer extends JsonDeserializer<List<String>> {
@Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException{
        String stringValue = p.getValueAsString();
        if (stringValue == null ||stringValue.isEmpty()){
            return new ArrayList<>();
        }
    return Arrays.asList(stringValue.split(","));
}
}
