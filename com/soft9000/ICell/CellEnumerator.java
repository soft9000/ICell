/**
 * MIT License.
 */
package com.soft9000.ICell;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Opportunity to encapsulate for re-use: Works great!
 *
 * @author Randall Nagy
 */
public class CellEnumerator {

    private int arrayOrigin = 0;

    private final Dimension dim;
    private final Dimension slicer;

    public CellEnumerator(Dimension totalSize, CellSlicer cellSize) {
        this(0, totalSize, cellSize);
    }

    public CellEnumerator(int arrayOrigin, Dimension totalSize, CellSlicer cellSize) {
        this.dim = totalSize;
        this.slicer = cellSize;
        this.arrayOrigin = arrayOrigin;
    }

    /**
     * Renders all of the images in the the viewable area to a buffered image.
     *
     * @param img Where to draw.
     * @param set Who does the drawing.
     * @return False on error.
     */
    public boolean drawAll(BufferedImage img, IGridClient set) {
        if (img == null || set == null) {
            return false;
        }

        Dimension dim_delta = new Dimension(
                dim.width / slicer.width,
                dim.height / slicer.height
        );

        set.onClear((Graphics2D) img.getGraphics(), dim);

        int zb_array_pos = this.arrayOrigin;
        int logical_x = 0;
        int logical_y = 0;
        CellImageMutator cell = new CellImageMutator();
        try {
            for (int yy = 0; yy < dim.height; yy += dim_delta.height) {

                for (int xx = 0; xx < dim.width; xx += dim_delta.width) {
                    if (xx + dim_delta.width >= dim.width) {
                        break;
                    }
                    if (yy + dim_delta.height >= dim.height) {
                        break;
                    }
                    BufferedImage icell = img.getSubimage(xx, yy, dim_delta.width, dim_delta.height);
                    cell.setID(zb_array_pos++); // zero based
                    cell.setSize(dim_delta.width, dim_delta.height);
                    cell.setCell(logical_x, logical_y); // ibid
                    cell.setImage(icell);
                    if (set.onDrawCell(cell) == false) {
                        return true; // no need to repaint
                    }
                    logical_x++;
                }
                logical_x = 0;
                logical_y++;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * Locate a cell, from a pixel_point.
     *
     * @param pixel_point - A point from a screen (pixel) event.
     *
     * @return Returns NULL if not found.
     */
    public CellInfo findCell(final Point pixel_point) {
        Dimension dim_delta = new Dimension(
                dim.width / slicer.width,
                dim.height / slicer.height
        );

        CellInfo rect = new CellInfo(0, 0, dim_delta.width, dim_delta.height);

        int zb_array_pos = this.arrayOrigin;
        int logical_x = 0;
        int logical_y = 0;

        try {
            for (int yy = 0; yy < dim.height; yy += dim_delta.height) {
                for (int xx = 0; xx < dim.width; xx += dim_delta.width) {
                    if (xx + dim_delta.width >= dim.width) {
                        break;
                    }
                    if (yy + dim_delta.height >= dim.height) {
                        break;
                    }

                    rect.x = xx;
                    rect.y = yy;
                    if (rect.contains(pixel_point)) {
                        rect.setArrayID(zb_array_pos++); // zero based
                        rect.setSize(dim_delta);
                        rect.setCell(logical_x, logical_y); // ibid
                        return rect;
                    }
                    logical_x++;
                }
                logical_x = 0;
                logical_y++;
            }
        } catch (Exception ex) {

        }
        return null;

    }

    /**
     * Locate a drawable CellImage.
     *
     * @param img
     * @param point
     * @return Results will be NULL on exception / cell not found in the bitmap
     * region...
     */
    public CellImage findCell(BufferedImage img, Point point) {
        if (Contains(img, point)) {
            CellInfo info = findCell(point);
            if (info != null) {
                CellImageMutator mut = new CellImageMutator(info);
                mut.setImage(img.getSubimage(info.x, info.y, info.width, info.height));
                return mut;
            }
        }
        return null;
    }

    /**
     * Determine if an image contains a point.
     *
     * @param img
     * @param point
     * @return
     */
    public static boolean Contains(final BufferedImage img, final Point point) {
        if (img == null
                || point == null
                || point.x >= img.getWidth()
                || point.y >= img.getHeight()) {
            return false;
        }
        return true;
    }

    public int getArrayOrigin() {
        return arrayOrigin;
    }

    public void setArrayOrigin(int ss) {
        this.arrayOrigin = ss;
    }

}
