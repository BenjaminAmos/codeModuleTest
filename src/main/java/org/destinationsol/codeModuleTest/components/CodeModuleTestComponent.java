package org.destinationsol.codeModuleTest.components;

import org.terasology.gestalt.entitysystem.component.Component;

public class CodeModuleTestComponent implements Component<CodeModuleTestComponent> {
    public String testString;
    public boolean testBool;

    /**
     * Copies the values from another component. This is expected to be of the same type.
     *
     * @param other The component to copy
     */
    @Override
    public void copy(CodeModuleTestComponent other) {
        this.testString = other.testString;
        this.testBool = other.testBool;
    }
}
