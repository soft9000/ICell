/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 * We do NOT want graphical clients to be able to change associated CellImage
 * information. This mutator allows servers to do so, then to return the parent
 * class back to a graphical client. Like the client, we may also re-cast if and
 * whenever an instance is posted back to us. Results is faster same-instance
 * enumerations (etc.)
 *
 * @author Randall Nagy
 */
public class CellImageMutator extends CellImage {

    public CellImageMutator() {
        super();
    }

    public CellImageMutator(final Dimension size, final CellPoint pt) {
        super(size, pt);
    }

    public CellImageMutator(final CellInfo info) {
        super(info);
    }

    void setID(int zbid) {
        this.logical.setArrayID(zbid);
    }

    void setCell(int cell_x, int cell_y) {
        this.logical.x = cell_x;
        this.logical.y = cell_y;
    }

    void setSize(int pixel_x, int pixel_y) {
        this.size.width = pixel_x;
        this.size.height = pixel_y;
    }

    void setImage(BufferedImage img) {
        this.img = img;
    }

}
