/*
 * Copyright 2019 the JSON-P Test Suite Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.leadpony.jsonp.testsuite.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringWriter;
import java.util.function.Consumer;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * A test type to test {@link JsonWriter}.
 *
 * @author leadpony
 */
public class JsonWriterTest {

    private static JsonWriterFactory factory;

    @BeforeAll
    public static void setUpOnce() {
        factory = Json.createWriterFactory(null);
    }

    @ParameterizedTest
    @EnumSource(JsonValueFixture.class)
    public void writeShouldWriteJsonValueAsExpected(JsonValueFixture fixture) {

        String actual = write(writer->{
            writer.write(fixture.getJsonValue());
        });

        assertThat(actual).isEqualTo(fixture.getString());
    }

    @ParameterizedTest
    @MethodSource("org.leadpony.jsonp.testsuite.tests.JsonValueFixture#getStructuresAsStream")
    public void writeShouldWriteJsonStructureAsExpected(JsonValueFixture fixture) {

        String actual = write(writer->{
            writer.write((JsonStructure)fixture.getJsonValue());
        });

        assertThat(actual).isEqualTo(fixture.getString());
    }

    @ParameterizedTest
    @MethodSource("org.leadpony.jsonp.testsuite.tests.JsonValueFixture#getArraysAsStream")
    public void writeArrayShouldWriteJsonArrayAsExpected(JsonValueFixture fixture) {

        String actual = write(writer->{
            writer.writeArray((JsonArray)fixture.getJsonValue());
        });

        assertThat(actual).isEqualTo(fixture.getString());
    }

    @ParameterizedTest
    @MethodSource("org.leadpony.jsonp.testsuite.tests.JsonValueFixture#getObjectsAsStream")
    public void writeObjectShouldWriteJsonObjectAsExpected(JsonValueFixture fixture) {

        String actual = write(writer->{
            writer.writeObject((JsonObject)fixture.getJsonValue());
        });

        assertThat(actual).isEqualTo(fixture.getString());
    }

    private String write(Consumer<JsonWriter> consumer) {
        StringWriter stringWriter = new StringWriter();
        try (JsonWriter jsonWriter = factory.createWriter(stringWriter)) {
            consumer.accept(jsonWriter);
        }
        return stringWriter.toString();
    }
}