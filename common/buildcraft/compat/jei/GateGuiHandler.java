package buildcraft.compat.jei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import buildcraft.api.core.BCLog;
import buildcraft.transport.gui.GuiGateInterface;

import mezz.jei.api.gui.IAdvancedGuiHandler;

public class GateGuiHandler implements IAdvancedGuiHandler<GuiGateInterface> {
    @Override
    public Class<GuiGateInterface> getGuiContainerClass() {
        return GuiGateInterface.class;
    }

    @Override
    public List<Rectangle> getGuiExtraAreas(GuiGateInterface gate) {
        List<Rectangle> rectangles = new ArrayList<>();
        BCLog.logger.info("GATE[" + gate.actionRows + "," + gate.lastActionRowSize + "]");
        int guiLeft = (gate.width - gate.getXSize()) / 2;
        int guiTop = (gate.height - gate.getYSize()) / 2;

        // Triggers
        // int triggerStartX;
        // int triggerStartY;

        // if (gate.triggerRows > 1) {

        // } else if (gate.triggerRows == 1) {
        // rectangles.add(new Rectangle(tir));
        // }

        // Actions
        int actionStartX = guiLeft + gate.getXSize();
        int actionStartY = guiTop + 6;

        if (gate.actionRows > 1) {
            int endRow = gate.actionRows * 18;
            rectangles.add(new Rectangle(actionStartX, actionStartY, 6 * 18, endRow));
            rectangles.add(new Rectangle(actionStartX, actionStartY + endRow, gate.lastActionRowSize, 18));
            BCLog.logger.info("Added 2 actionRow rectanges! " + rectangles.get(0) + ", " + rectangles.get(1));
        } else if (gate.actionRows == 1) {
            rectangles.add(new Rectangle(actionStartX, actionStartY, gate.lastActionRowSize, 18));
            BCLog.logger.info("Added 1 actionRow rectange! " + rectangles.get(0));
        }
        return rectangles;
    }
}