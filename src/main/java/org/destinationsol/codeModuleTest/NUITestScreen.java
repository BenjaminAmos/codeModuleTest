package org.destinationsol.codeModuleTest;

import com.badlogic.gdx.math.Vector2;
import org.destinationsol.SolApplication;
import org.destinationsol.common.In;
import org.destinationsol.ui.nui.NUIScreenLayer;
import org.terasology.nui.widgets.UILabel;

public class NUITestScreen extends NUIScreenLayer {
    @In
    private SolApplication solApplication;
    private UILabel nuiTestLabel;

    @Override
    public void initialise() {
        nuiTestLabel = find("nuiTestLabel", UILabel.class);
    }

    @Override
    public void update(float delta) {
        // TODO: NUI screens currently are not cleared when the game exits.
        if (solApplication.getGame() != null) {
            Vector2 cameraPosition = solApplication.getGame().getCam().getPosition();
            nuiTestLabel.setText("Camera Position: " + cameraPosition.toString());
        }
        super.update(delta);
    }

    @Override
    protected boolean escapeCloses() {
        return false;
    }
}
