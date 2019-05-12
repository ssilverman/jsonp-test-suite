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
package org.leadpony.jsonp.testsuite.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * A helper class for logging.
 *
 * @author leadpony
 */
public interface LogHelper {

    LogManager LOG_MANAGER = configureLogManager();

    static Logger getLogger(Class<?> type) {
        return Logger.getLogger(type.getName());
    }

    static LogManager configureLogManager() {
        LogManager manager = LogManager.getLogManager();
        try (InputStream ins = LogHelper.class.getResourceAsStream("logging.properties")) {
            manager.readConfiguration(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return manager;
    }
}
