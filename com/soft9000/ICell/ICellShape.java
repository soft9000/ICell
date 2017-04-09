/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Shape;

/**
 * Handy when wanting to show what shape will be drawn (on mouse tracking, etc.)
 *
 * @author Randall Nagy
 */
public interface ICellShape {

    Shape getShape(CellInfo info);
}
