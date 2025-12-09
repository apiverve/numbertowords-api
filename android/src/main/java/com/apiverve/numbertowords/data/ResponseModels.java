// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     NumbertoWordsData data = Converter.fromJsonString(jsonString);

package com.apiverve.numbertowords.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static NumbertoWordsData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(NumbertoWordsData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(NumbertoWordsData.class);
        writer = mapper.writerFor(NumbertoWordsData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// NumbertoWordsData.java

package com.apiverve.numbertowords.data;

import com.fasterxml.jackson.annotation.*;

public class NumbertoWordsData {
    private double number;
    private String words;
    private String ordinal;
    private long numberOfDigitsNumeric;
    private String numberOfDigitsWords;
    private String[] eachNumber;
    private AfterDecimal afterDecimal;
    private String locale;

    @JsonProperty("number")
    public double getNumber() { return number; }
    @JsonProperty("number")
    public void setNumber(double value) { this.number = value; }

    @JsonProperty("words")
    public String getWords() { return words; }
    @JsonProperty("words")
    public void setWords(String value) { this.words = value; }

    @JsonProperty("ordinal")
    public String getOrdinal() { return ordinal; }
    @JsonProperty("ordinal")
    public void setOrdinal(String value) { this.ordinal = value; }

    @JsonProperty("numberOfDigits_numeric")
    public long getNumberOfDigitsNumeric() { return numberOfDigitsNumeric; }
    @JsonProperty("numberOfDigits_numeric")
    public void setNumberOfDigitsNumeric(long value) { this.numberOfDigitsNumeric = value; }

    @JsonProperty("numberOfDigits_words")
    public String getNumberOfDigitsWords() { return numberOfDigitsWords; }
    @JsonProperty("numberOfDigits_words")
    public void setNumberOfDigitsWords(String value) { this.numberOfDigitsWords = value; }

    @JsonProperty("eachNumber")
    public String[] getEachNumber() { return eachNumber; }
    @JsonProperty("eachNumber")
    public void setEachNumber(String[] value) { this.eachNumber = value; }

    @JsonProperty("afterDecimal")
    public AfterDecimal getAfterDecimal() { return afterDecimal; }
    @JsonProperty("afterDecimal")
    public void setAfterDecimal(AfterDecimal value) { this.afterDecimal = value; }

    @JsonProperty("locale")
    public String getLocale() { return locale; }
    @JsonProperty("locale")
    public void setLocale(String value) { this.locale = value; }
}

// AfterDecimal.java

package com.apiverve.numbertowords.data;

import com.fasterxml.jackson.annotation.*;

public class AfterDecimal {
    private String number;
    private String[] words;
    private long numberOfDigitsNumeric;
    private String numberOfDigitsWords;

    @JsonProperty("number")
    public String getNumber() { return number; }
    @JsonProperty("number")
    public void setNumber(String value) { this.number = value; }

    @JsonProperty("words")
    public String[] getWords() { return words; }
    @JsonProperty("words")
    public void setWords(String[] value) { this.words = value; }

    @JsonProperty("numberOfDigits_numeric")
    public long getNumberOfDigitsNumeric() { return numberOfDigitsNumeric; }
    @JsonProperty("numberOfDigits_numeric")
    public void setNumberOfDigitsNumeric(long value) { this.numberOfDigitsNumeric = value; }

    @JsonProperty("numberOfDigits_words")
    public String getNumberOfDigitsWords() { return numberOfDigitsWords; }
    @JsonProperty("numberOfDigits_words")
    public void setNumberOfDigitsWords(String value) { this.numberOfDigitsWords = value; }
}