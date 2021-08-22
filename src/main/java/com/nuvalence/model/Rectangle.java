package com.nuvalence.model;

import java.util.List;
import java.util.Objects;

/**
 * A Rectangle specifies an area in a coordinate space that is enclosed by the Rectangle object's
 * bottom-left point (x,y) in the coordinate space, its width, and its height.
 *
 * @author Thiago Puluceno <puluceno@gmail.com>
 */
public class Rectangle implements Shape {
    private final int x;
    private final int y;
    private final int height;
    private final int width;

    /**
     * Default constructor.
     *
     * @param x      the bottom left X coordinate
     * @param y      the bottom left Y coordinate
     * @param width  the rectangle width
     * @param height the rectangle height
     */
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacentTo(Rectangle r) {
        return verifyAdjacentOnTopOrBottom(r) || verifyAdjacentOnLeftOrRight(r);
    }

    /**
     * Verifies if a given {@link Rectangle} is adjacent to the left or right of the current {@link Rectangle}
     *
     * @param r the {@link Rectangle} to be tested for adjacency.
     * @return true if adjacent to the left or right, false otherwise.
     */
    private boolean verifyAdjacentOnLeftOrRight(Rectangle r) {
        int beginR = r.getY();
        int endR = beginR + r.getHeight();
        int end0 = this.getY() + this.getHeight();
        int begin0 = this.getY();

        return ((begin0 <= beginR && beginR <= end0)
                ||
                (begin0 <= endR && endR <= end0)
                ||
                (beginR <= begin0 && endR >= end0))
                &&
                (r.getX() == this.getX() + this.getWidth())
                ||
                (r.getX() + r.getWidth() == this.getX());
    }

    /**
     * Verifies if a given {@link Rectangle} is adjacent to the top or bottom of the current {@link Rectangle}
     *
     * @param r the {@link Rectangle} to be tested for adjacency.
     * @return true if adjacent to the top or bottom, false otherwise.
     */
    private boolean verifyAdjacentOnTopOrBottom(Rectangle r) {
        int beginR = r.getX();
        int endR = beginR + r.getWidth();
        int end0 = this.getX() + this.getWidth();
        int begin0 = this.getX();

        return ((begin0 <= beginR && beginR <= end0)
                ||
                (begin0 <= endR && endR <= end0)
                ||
                (beginR <= begin0 && endR >= end0))
                &&
                (r.getY() == this.getY() + this.getHeight())
                ||
                (r.getY() + r.getHeight() == this.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Rectangle r) {
        return (r.getX() > this.getX())
                &&
                (r.getY() > this.getY())
                &&
                (r.getX() + r.getWidth() < this.getX() + this.getWidth())
                &&
                (r.getY() + r.getHeight() < this.getY() + this.getHeight());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> intersectionPoints(Rectangle r) {

        int x0 = Math.max(this.getX(), r.getX());
        int y0 = Math.max(this.getY(), r.getY());
        int x1 = Math.min(this.getX() + this.getWidth(), r.getX() + r.getWidth());
        int y1 = Math.min(this.getY() + this.getHeight(), r.getY() + r.getHeight());

        int currX0 = this.getX();
        int currX1 = this.getX() + this.getWidth();
        int currY0 = this.getY();
        int currY1 = this.getY() + this.getHeight();
        int otherX0 = r.getX();
        int otherX1 = r.getX() + r.getWidth();
        int otherY0 = r.getY();
        int otherY1 = r.getY() + r.getHeight();

        if ((currX0 > otherX0 && currY0 > otherY0 && currX1 > otherX1 && currY1 < otherY1)
                || (currX0 < otherX0 && currY0 < otherY0 && currX1 < otherX1 && currY1 > otherY1)) {
            return List.of(x1, y0, x1, y1);
        } else if ((currX0 < otherY0 && currY0 > otherY0 && currX1 < otherX1 && currY1 < otherY1)
                || (currX0 > otherX0 && currY0 < otherY0 && currY1 > otherY1 && currX1 > otherX1)) {
            return List.of(x0, y0, x0, y1);
        } else if ((currX0 < otherX0 && currY0 > otherY0 && currX1 > otherX1 && currY1 > otherY1)
                || (currX0 > otherX0 && currY0 < otherY0 && currX1 < otherX1 && currY1 < otherY1)) {
            return List.of(x0, y0, x1, y0);
        } else if ((currX0 > otherX0 && currY0 > otherY0 && currX1 < otherX1 && currY1 > otherY1)
                || (currX0 < otherX0 && currY0 < otherY0 && currX1 > otherX1 && currY1 < otherY1)) {
            return List.of(x0, y1, x1, y1);
        } else if ((currX0 > otherX0 && currY0 < otherY0 && currX1 > otherX1 && currY1 < otherY1)
                || (currX0 < otherX0 && currY0 > otherY0 && currX1 < otherX1 && currY1 > otherY1)) {
            return List.of(x0, y0, x1, y1);
        } else if ((currX0 > otherX0 && currY0 > otherY0 && currX1 > otherX1 && currY1 > otherY1)
                || (currX0 < otherX0 && currY0 < otherY0 && currY1 < otherY1 && currX1 < otherX1)) {
            return List.of(x1, y0, x0, y1);
        } else {
            return List.of(x0, y0, x1, y0, x1, y1, x0, y1);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean intersects(Rectangle r) {
        int currW = this.getWidth();
        int currH = this.getHeight();
        int otherW = r.getWidth();
        int otherH = r.getHeight();
        if (otherW <= 0 || otherH <= 0 || currW <= 0 || currH <= 0) {
            return false;
        }
        int currX0 = this.getX();
        int currY0 = this.getY();
        int currX1 = currX0 + currW;
        int currY1 = currY0 + currH;
        int otherX0 = r.getX();
        int otherY0 = r.getY();
        int otherX1 = otherX0 + otherW;
        int otherY1 = otherY0 + otherH;

        return ((otherX1 < otherX0 || otherX1 > currX0) &&
                (otherH < otherY0 || otherY1 > currY0) &&
                (currX1 < currX0 || currX1 > otherX0) &&
                (currY1 < currY0 || currY1 > otherY0));
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return getX() == rectangle.getX() && getY() == rectangle.getY() && getHeight() == rectangle.getHeight() && getWidth() == rectangle.getWidth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getHeight(), getWidth());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

}
