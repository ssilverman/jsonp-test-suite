/*
 * Copyright 2019-2020 the JSON-P Test Suite Authors.
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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import jakarta.json.Json;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParserFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author leadpony
 */
public class JsonParserFactoryTest {

    @Test
    public void getConfigInUseShouldReturnEmptyMap() {
        Map<String, Object> config = new HashMap<>();
        JsonParserFactory factory = Json.createParserFactory(config);

        Map<String, ?> actual = factory.getConfigInUse();

        assertThat(actual).isEmpty();
    }

    @Test
    public void getConfigInUseShouldNotContainUnknownProperty() {
        Map<String, Object> config = new HashMap<>();
        config.put("unknown", Boolean.TRUE);
        JsonParserFactory factory = Json.createParserFactory(config);

        Map<String, ?> actual = factory.getConfigInUse();

        assertThat(actual).doesNotContainKey("unknown");
    }

    public static class InputStreamTest extends AbstractJsonParserTest {

        private static JsonParserFactory sut;

        @BeforeAll
        public static void setUpOnce() {
            sut = Json.createParserFactory(null);
        }

        @Override
        protected JsonParser createJsonParser(String json) {
            Charset charset = StandardCharsets.UTF_8;
            InputStream in = new ByteArrayInputStream(json.getBytes(charset));
            return sut.createParser(in, charset);
        }
    }

    public static class ReaderTest extends AbstractJsonParserTest {

        private static JsonParserFactory sut;

        @BeforeAll
        public static void setUpOnce() {
            sut = Json.createParserFactory(null);
        }

        @Override
        protected JsonParser createJsonParser(String json) {
            Reader reader = new StringReader(json);
            return sut.createParser(reader);
        }
    }
}
