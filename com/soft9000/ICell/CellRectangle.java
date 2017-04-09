/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Rectangle;

/**
 * Class designed to eliminate the confusion that often takes place when
 * switching between grid cell & point cell renderings.
 *
 * @author Randall Nagy
 */
public class CellRectangle extends Rectangle {

    public CellRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

}
