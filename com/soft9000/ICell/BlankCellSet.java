/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * Demonstration (and default) graphical client.
 * 
 * @author Randall Nagy
 */
public class BlankCellSet implements IGridClient {

    BlankCell bcell = new BlankCell();
    private Shape shape = null;
    private IGridServer server;

    @Override
    public boolean onDrawCell(final CellImage cell) {
        return bcell.onDrawCell(cell);
    }

    @Override
    public void onClear(Graphics2D gr, final Dimension dim) {
        gr.fillRect(0, 0, dim.width, dim.height);
    }

    @Override
    public void onClicked(CellImage cell) {
        Graphics2D gr = cell.getGraphics();
        if (gr == null) {
            return;
        }
        Color clr = gr.getColor();
        gr.setColor(gr.getBackground());
        gr.fillRect(1, 1, cell.size.width, cell.size.height);
        gr.setColor(clr);
    }

    @Override
    public Shape getShape(CellInfo info) {
        if (shape == null) {
            shape = new Rectangle(info);
        }
        return shape;
    }

    @Override
    public void onRegister(IGridServer server) {
        this.server = server;
    }

}
