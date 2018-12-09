/*
 * Copyright 2018 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.destinationsol.codeModuleTest;

import org.destinationsol.game.Console;
import org.destinationsol.game.console.ConsoleInputHandler;

public class TestCodeModuleCommand implements ConsoleInputHandler {
    private static final String COMMAND_OUTPUT_TEXT = "This is the response to the TestCodeModule command.";

    /**
     * Handles user input from console.
     *
     * @param input   User input from console
     * @param console Console from where the input originates
     */
    @Override
    public void handle(String input, Console console) {
        console.println(COMMAND_OUTPUT_TEXT);
    }
}
