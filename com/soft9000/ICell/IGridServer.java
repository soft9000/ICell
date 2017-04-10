/**
 * MIT License.
 */
package com.soft9000.ICell;

/**
 * A server offered (registered) with a graphical client so as to allow the
 * client to request server actions.
 *
 * @author Randall Nagy
 */
public interface IGridServer {

    /**
     * The shape used to "ghost" over grid as user moves mouse.
     *
     * @param mode
     */
    void update(ICellShape mode);

    /**
     * The upper-left, zero based offset for the grid. Used to allows same to be
     * a "window" over a much larger array.
     *
     * @return
     */
    int getArrayOrigin();

    /**
     * Set the upper-left, zero-based, integer-offset to any arbitrary number.
     * Will become the offset used to calculate the array-location of any Cell
     * in the Framework.
     *
     * @param ss
     */
    void setArrayOrigin(int ss);

}
