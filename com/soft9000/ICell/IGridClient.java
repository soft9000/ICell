/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * That which needs to use a Graphical Server so as to draw the content of the
 * cells that it manages.
 *
 * See BlankCellSetfor the default implementation.
 *
 * @author Randall Nagy
 */
public interface IGridClient extends ICellShape, ICellDraw {

    void onRegister(final IGridServer server);

    void onClear(Graphics2D gr, final Dimension dim);

    void onClicked(final CellImage cell);

}
