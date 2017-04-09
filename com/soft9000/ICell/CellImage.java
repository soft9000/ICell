/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The image represents a constrained location on a graphical canvas.
 * 
 * @author Randall Nagy
 */
public class CellImage {
    
    BufferedImage img = null;
    
    CellPoint logical;
    Dimension size;
    
    protected CellImage() {
        logical = new CellPoint(-1, -1, -1);
        size = new Dimension(-1, -1);
    }
    
    public CellImage(CellInfo info) {
        this();
        size.width = info.width;
        size.height = info.height;
        logical.x = info.getCellX();
        logical.y = info.getCellY();
        logical.setArrayID(info.getArrayID());
    }
    
    public CellImage(final Dimension size, final CellPoint pt) {
        this.logical = pt;
        this.size = size;
    }
    
    public Graphics2D getGraphics() {
        if (img == null) {
            Dimension dim = this.getSize();
            img = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_ARGB);
        }
        return (Graphics2D) img.getGraphics();
    }

    /**
     * @return the id
     */
    public int getId() {
        return logical.getArrayID();
    }

    /**
     * @return the logical
     */
    public CellPoint getPoint() {
        return logical;
    }

    /**
     * @return the size
     */
    public Dimension getSize() {
        return size;
    }
    
}
