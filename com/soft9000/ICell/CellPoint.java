/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Point;

/**
 * Class designed to eliminate the confusion that often takes place when
 * switching between grid cell & point cell renderings.
 *
 * The cartesian, logical point of a cell: Nothing to do with the PHYSICAL
 * location of any cell on the screen. (i.e. When there is a "window" over a
 * scrollable set of in-view cells, the PHYSICAL location can only be specified
 * during an actual "cell" enumeration event.)
 *
 * @author Randall Nagy
 */
public class CellPoint extends Point {

    private int array_pos = -1;

    public CellPoint() {
        super();
    }

    public CellPoint(int cell_x, int cell_y, int zb_array_pos) {
        super(cell_x, cell_y);
        this.array_pos = zb_array_pos;
    }

    public int getArrayID() {
        return this.array_pos;
    }

    void setArrayID(int zbid) {
        array_pos = zbid;
    }
}
