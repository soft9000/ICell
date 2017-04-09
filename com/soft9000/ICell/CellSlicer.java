/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Dimension;

/**
 * Class designed to eliminate the confusion that often takes place when
 * switching between grid cell & point cell renderings.
 *
 *
 * @author Randall Nagy
 */
public class CellSlicer extends Dimension {

    public CellSlicer(int width, int height) {
        super(width, height);
    }

}
