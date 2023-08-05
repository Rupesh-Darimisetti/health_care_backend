package tech.hospital.healthcare.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CustomLocalTimeDeserializer extends JsonDeserializer<List<LocalTime>> {
    @Override
    public List<LocalTime> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws  IOException {
        String timeString = jsonParser.getText();
        String[] timeStrings = timeString.split(",");
        List<LocalTime> localTimes = new ArrayList<>();

        for (String time : timeStrings) {
            localTimes.add(LocalTime.parse(time.trim()));
        }

        return localTimes;
         }
}
