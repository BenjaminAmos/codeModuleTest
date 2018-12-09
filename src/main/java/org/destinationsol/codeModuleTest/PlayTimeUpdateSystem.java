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

import com.badlogic.gdx.graphics.Color;
import org.destinationsol.SolApplication;
import org.destinationsol.game.SolGame;
import org.destinationsol.game.UpdateAwareSystem;
import org.destinationsol.game.attributes.RegisterUpdateSystem;
import org.destinationsol.game.screens.MainGameScreen;
import org.destinationsol.ui.FontSize;
import org.destinationsol.ui.SolUiBaseScreen;
import org.destinationsol.ui.SolUiScreen;
import org.destinationsol.ui.UiDrawer;

@RegisterUpdateSystem(priority = 1)
public class PlayTimeUpdateSystem implements UpdateAwareSystem {
    private final PlayTimeLabelScreen playTimeLabelScreen;
    private float totalPlayTime;

    public PlayTimeUpdateSystem() {
        playTimeLabelScreen = new PlayTimeLabelScreen();
    }

    @Override
    public void update(SolGame game, float timeStep) {
        SolApplication application = game.getSolApplication();
        if (!application.getInputManager().isScreenOn(playTimeLabelScreen)) {
            SolUiScreen topScreen = application.getInputManager().getTopScreen();
            if (topScreen.getClass() == MainGameScreen.class) {
                //HACK: The MainGameScreen relies on being the top screen displayed
                application.getInputManager().setScreen(application, playTimeLabelScreen);
                application.getInputManager().addScreen(application, topScreen);
            } else {
                application.getInputManager().addScreen(application, playTimeLabelScreen);
            }
        }

        totalPlayTime += timeStep;
    }

    private class PlayTimeLabelScreen extends SolUiBaseScreen {
        @Override
        public void drawText(UiDrawer uiDrawer, SolApplication solApplication) {
            uiDrawer.drawString("Game duration: " + Float.toString(totalPlayTime) + "s", 0.005f, 0, FontSize.HUD, UiDrawer.TextAlignment.LEFT, false, Color.WHITE);
        }
    }
}
