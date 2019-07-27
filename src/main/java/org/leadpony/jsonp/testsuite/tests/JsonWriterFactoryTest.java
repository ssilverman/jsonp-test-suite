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

import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

import org.junit.jupiter.api.Test;

/**
 * @author leadpony
 */
public class JsonWriterFactoryTest {

    @Test
    public void getConfigInUseShouldReturnEmptyMap() {
        Map<String, Object> config = new HashMap<>();
        JsonWriterFactory factory = Json.createWriterFactory(config);

        Map<String, ?> actual = factory.getConfigInUse();

        assertThat(actual).isEmpty();
    }

    @Test
    public void getConfigInUseShouldReturnPrettyPrinting() {
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, Boolean.FALSE);
        JsonWriterFactory factory = Json.createWriterFactory(config);

        Map<String, ?> actual = factory.getConfigInUse();
        assertThat(actual).containsKey(JsonGenerator.PRETTY_PRINTING);
    }

    @Test
    public void getConfigInUseShouldNotContainUnknownProperty() {
        Map<String, Object> config = new HashMap<>();
        config.put("unknown", Boolean.TRUE);
        JsonWriterFactory factory = Json.createWriterFactory(config);

        Map<String, ?> actual = factory.getConfigInUse();
        assertThat(actual).doesNotContainKey("unknown");
    }
}
