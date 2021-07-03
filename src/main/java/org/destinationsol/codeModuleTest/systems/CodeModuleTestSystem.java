package org.destinationsol.codeModuleTest.systems;

import org.destinationsol.assets.Assets;
import org.destinationsol.codeModuleTest.components.CodeModuleTestComponent;
import org.destinationsol.common.In;
import org.destinationsol.entitysystem.ComponentSystem;
import org.destinationsol.entitysystem.EntitySystemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.prefab.Prefab;

import java.util.Optional;

public class CodeModuleTestSystem extends ComponentSystem {
    private static final Logger logger = LoggerFactory.getLogger(CodeModuleTestSystem.class);

    @In
    private EntitySystemManager entitySystemManager;

    @Override
    public void preBegin() {
        Prefab prefab;
        try {
            prefab = Assets.getPrefab("codeModuleTest:testPrefab");
        } catch (Exception e) {
            logger.error("Failed to load codeModuleTest:testPrefab!", e);
            return;
        }

        if (entitySystemManager == null) {
            logger.error("EntitySystemManager is null! Was the system injected correctly?");
            return;
        }

        EntityRef ref = entitySystemManager.getEntityManager().createEntity(prefab);
        Optional<CodeModuleTestComponent> potentialComponent = ref.getComponent(CodeModuleTestComponent.class);
        if (potentialComponent.isPresent()) {
            CodeModuleTestComponent component = potentialComponent.get();
            logger.warn("Found CodeModuleTestComponent: {" + component.testString + ", " + component.testBool + "}");
        } else {
            logger.error("Cannot find CodeModuleTestComponent!");
        }
    }
}
