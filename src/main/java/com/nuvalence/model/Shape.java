package com.nuvalence.model;

import java.util.List;

public interface Shape {

    /**
     * Checks if the comparing {@link Rectangle} is adjacent to the specified {@link Rectangle} r.
     *
     * @param r the specified {@link Rectangle}
     * @return true if the specified {@link Rectangle} r is adjacent to the comparing {@link Rectangle}; false otherwise
     */
    boolean isAdjacentTo(Rectangle r);

    /**
     * Checks if the comparing {@link Rectangle} entirely contains the specified {@link Rectangle} r.
     *
     * @param r the specified {@link Rectangle}
     * @return true if the specified {@link Rectangle} is contained entirely inside the comparing {@link Rectangle}; false otherwise
     */
    boolean contains(Rectangle r);

    /**
     * Checks if the comparing {@link Rectangle} intersects the specified {@link Rectangle} r.
     *
     * @param r the specified {@link Rectangle}
     * @return true if the specified {@link Rectangle} intersects the comparing {@link Rectangle}; false otherwise
     */
    boolean intersects(Rectangle r);

    /**
     * Produces the coordinates where the comparing {@link Rectangle} intersects the specified {@link Rectangle} r.
     *
     * @param r the specified {@link Rectangle}
     * @return a {@link List} containing the coordinates in the form of x0,y0, x1, y1 where the specified {@link Rectangle} intersects the comparing {@link Rectangle}
     */
    List<Integer> intersectionPoints(Rectangle r);
}
