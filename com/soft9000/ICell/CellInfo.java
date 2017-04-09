/**
 * MIT License.
 */
package com.soft9000.ICell;

/**
 * The place to store "soft" (Not graphical!) image information. (Handy for
 * lighter-weight enumeration, queries, database storage, etc.)
 *
 * @author Randall Nagy
 */
public class CellInfo extends CellRectangle {

    private CellPoint logical = new CellPoint();

    public CellInfo(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    void setArrayID(int zbid) {
        this.logical.setArrayID(zbid);
    }

    void setCell(int logical_x, int logical_y) {
        logical.x = logical_x;
        logical.y = logical_y;
    }

    public int getArrayID() {
        return logical.getArrayID();
    }

    public CellPoint getCellPoint() {
        return logical;
    }

    public int getCellX() {
        return logical.x;
    }

    public int getCellY() {
        return logical.y;
    }

}
