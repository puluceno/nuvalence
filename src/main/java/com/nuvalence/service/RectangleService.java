package com.nuvalence.service;

import com.nuvalence.model.Rectangle;

import java.util.List;

/**
 * Interface describing the available operations between two {@link Rectangle}.
 */
public interface RectangleService {

    /**
     * Checks if {@link Rectangle} r1 is adjacent to the specified {@link Rectangle} r2.
     *
     * @param r1 the first specified {@link Rectangle}
     * @param r2 the second specified {@link Rectangle}
     * @return true if the specified {@link Rectangle} r1 is adjacent to the {@link Rectangle} r2; false otherwise
     */
    boolean isAdjacentTo(Rectangle r1, Rectangle r2);

    /**
     * Checks if {@link Rectangle} r1 entirely contains the specified {@link Rectangle} r2.
     *
     * @param r1 the first specified {@link Rectangle}
     * @param r2 the second specified {@link Rectangle}
     * @return true if the specified {@link Rectangle} r2 is contained entirely inside the {@link Rectangle} r1; false otherwise
     */
    boolean contains(Rectangle r1, Rectangle r2);

    /**
     * Produces a {@link Rectangle} data, created by the intersection between {@link Rectangle} r1 and {@link Rectangle} r2
     *
     * @param r1 the first specified {@link Rectangle}
     * @param r2 the second specified {@link Rectangle}
     * @return the intersected {@link Rectangle} data, created by the intersection between {@link Rectangle} r1 and {@link Rectangle} r2
     */
    boolean intersects(Rectangle r1, Rectangle r2);

    /**
     * Produces the coordinates where the comparing {@link Rectangle} intersects the specified {@link Rectangle} r.
     *
     * @param r1 the first specified {@link Rectangle}
     * @param r2 the second specified {@link Rectangle}
     * @return a {@link List} containing the coordinates in the form of x0,y0, x1, y1 where the specified {@link Rectangle} r1 intersects the comparing {@link Rectangle} r2
     */
    List<Integer> intersectionPoints(Rectangle r1, Rectangle r2);
}
