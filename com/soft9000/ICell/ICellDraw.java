/**
 * MIT License.
 */
package com.soft9000.ICell;

/**
 * Support any rendering server(s) need to draw the content of an arbitrary
 * client's graphical cell.
 *
 * @author Randall Nagy
 */
public interface ICellDraw {

    /**
     * A fully qualified (Graphics2D, etc) & properly constrained drawing
     * operation.
     *
     * @param info A fully-qualified cell from the server. Guaranteed to be
     * non-null.
     * @return True to continue a rendering operation, else false to stop any
     * implied iteration(s.)
     */
    boolean onDrawCell(final CellImage info);

}
