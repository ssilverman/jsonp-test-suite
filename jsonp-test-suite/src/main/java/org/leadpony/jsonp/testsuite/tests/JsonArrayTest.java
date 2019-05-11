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

import java.util.stream.Stream;

import javax.json.JsonArray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * A test type to test {@link JsonArray}.
 *
 * @author leadpony
 */
public class JsonArrayTest {

    public static Stream<JsonValueTestCase> toStringShouldReturnStringAsExpected() {
        return JsonValueTestCase.getArraysAsStream();
    }

    @ParameterizedTest
    @MethodSource
    public void toStringShouldReturnStringAsExpected(JsonValueTestCase test) {

        JsonArray sut = (JsonArray) test.getJsonValue();
        String actual = sut.toString();

        assertThat(actual).isEqualTo(test.getString());
    }
}
