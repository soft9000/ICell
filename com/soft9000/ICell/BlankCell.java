/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * Default cell for graphical client demonstration.
 * 
 * @author Randall Nagy
 */
public class BlankCell implements ICellDraw {

    @Override
    public boolean onDrawCell(CellImage info) {
        Graphics2D gr = info.getGraphics();
        if (gr == null) {
            return false;
        }
        Dimension sz = info.getSize();
        Color clr = gr.getColor();
        gr.setColor(Color.GREEN);
        gr.drawRect(1, 1, sz.width, sz.height);
        gr.setColor(clr);
        return true;
    }

}
