package org.destinationsol.codeModuleTest.systems;

import org.destinationsol.SolApplication;
import org.destinationsol.assets.Assets;
import org.destinationsol.codeModuleTest.NUITestScreen;
import org.destinationsol.entitysystem.ComponentSystem;
import org.terasology.gestalt.assets.ResourceUrn;
import org.terasology.nui.asset.UIElement;

import javax.inject.Inject;

public class NuiTestSystem extends ComponentSystem {
    @Inject
    SolApplication solApplication;

    @Inject
    public NuiTestSystem() {
    }

    @Override
    public void preBegin() {
        solApplication.getNuiManager().pushScreen((NUITestScreen) Assets.getAssetHelper().get(
                new ResourceUrn("codeModuleTest:nuiTestScreen"), UIElement.class).get().getRootWidget());
    }
}
