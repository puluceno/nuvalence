package com.nuvalence.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    private Rectangle r1;
    private Rectangle r2;

    // ***** Start tests for Contains *****

    /**
     * Tests if rectangle 1 contains rectangle 2, not touching any borders.
     */
    @Test
    public void rectangle1_contains_rectangle2_withoutTouchingBorders() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(1, 1, 1, 1);
        assertTrue(r1.contains(r2));
        assertFalse(r2.contains(r1));
    }

    /**
     * Tests if rectangle 1 contains rectangle 2, not touching any borders (different dimensions).
     */
    @Test
    public void rectangle1_contains_rectangle2_withoutTouchingBorders_2() {
        r1 = new Rectangle(-10, -10, 5, 5);
        r2 = new Rectangle(-9, -9, 2, 3);
        assertTrue(r1.contains(r2));
        assertFalse(r2.contains(r1));
    }

    /**
     * Tests if rectangle 1 contains rectangle 2, not touching any borders (different dimensions).
     */
    @Test
    public void rectangle1_contains_rectangle2_withoutTouchingBorders_3() {
        r1 = new Rectangle(-10, -10, 10, 3);
        r2 = new Rectangle(-9, -9, 8, 1);
        assertTrue(r1.contains(r2));
        assertFalse(r2.contains(r1));
    }

    /**
     * Tests if rectangle 1 contains rectangle 2, touching a border. Note that if the 'contained rectangle'
     * touches any point of the outer rectangle, it is not considered contained.
     */
    @Test
    public void rectangle1_contains_rectangle2_touchingBorders() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(1, 1, 1, 2);
        assertFalse(r1.contains(r2));
    }

    /**
     * Tests if rectangle 1 contains rectangle 2, touching a corner. Note that if the 'contained rectangle'
     * touches any point of the outer rectangle, it is not considered contained.
     */
    @Test
    public void rectangle1_contains_rectangle2_sameBottomLeftCoordinates() {
        r1 = new Rectangle(-1, -1, 3, 3);
        r2 = new Rectangle(-1, -1, 1, 1);
        assertFalse(r1.contains(r2));
    }

    /**
     * Tests if rectangle 1 contains rectangle 2, when they intersect.
     */
    @Test
    public void rectangle1_contains_rectangle2_intersectsRectangle1() {
        r1 = new Rectangle(0, 0, 10, 5);
        r2 = new Rectangle(-1, -1, 2, 3);
        assertFalse(r1.contains(r2));
    }

    /**
     * Tests if rectangle 1 contains rectangle 2. Rectangle 2 is outside and intersects a corner.
     */
    @Test
    public void rectangle1_contains_rectangle2_internallyTouchingBorder() {
        r1 = new Rectangle(0, 0, 10, 5);
        r2 = new Rectangle(-1, -1, 1, 3);
        assertFalse(r1.contains(r2));
    }

    // ***** Start tests for Adjacency *****

    /**
     * Tests if rectangle 2 is partially adjacent on the top left of rectangle 1.
     */
    @Test
    public void rectangle2_partiallyAdjacentOnTopLeft_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-1, 3, 3, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent on the top of rectangle 1
     */
    @Test
    public void rectangle2_fullyAdjacentOnTop_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(0, 3, 5, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent on top of rectangle 1. Rectangle 2 is smaller than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnTopAndSmaller_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(1, 3, 3, 1);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is partially adjacent on the top right of rectangle 1.
     */
    @Test
    public void rectangle2_partiallyAdjacentOnTopRight_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(5, 3, 3, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent on top of rectangle 1. Rectangle 2 is larger than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnTopAndLarger_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-2, 3, 9, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is partially adjacent to the bottom left of rectangle 1.
     */
    @Test
    public void rectangle2_partiallyAdjacentOnBottomLeft_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-1, -3, 3, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the bottom of rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnBottom_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(0, -3, 5, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the bottom of rectangle 1. Rectangle 2 is smaller than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnBottomAndSmaller_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(1, -1, 3, 1);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is partially adjacent on the bottom right of rectangle 1.
     */
    @Test
    public void rectangle2_partiallyAdjacentOnBottomRight_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(5, -3, 3, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent on the bottom right of rectangle 1. Rectangle 2 is larger than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnBottomAndLarger_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-2, -3, 9, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the left of rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnLeft_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-5, 0, 5, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the left of rectangle 1. Rectangle 2 is smaller than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnLeftAndSmaller_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-3, 1, 3, 1);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the left of rectangle 1. Rectangle 2 is larger than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnLeftAndLarger_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-2, -3, 2, 9);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the right of rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnRight_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(5, 0, 5, 3);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the right of rectangle 1. Rectangle 2 is smaller than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnRightAndSmaller_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(5, 1, 1, 1);
        assertTrue(r1.isAdjacentTo(r2));
    }

    /**
     * Tests if rectangle 2 is fully adjacent to the right of rectangle 1. Rectangle 2 is larger than rectangle 1.
     */
    @Test
    public void rectangle2_fullyAdjacentOnRightAndLarger_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(5, -3, 3, 9);
        assertTrue(r1.isAdjacentTo(r2));
    }

    // ***** Start tests for Intersection *****

    /**
     * For the tests below, I'm not adding javadocs, as the test method's name is self-descriptive, just like the tests above.
     * So the fact that I added javadoc for the tests above, means that I'm fine with either using self-descriptive method names
     * or document each test individually.
     */

    @Test
    public void rectangle2_doesNotIntersect_rectangle1() {
        r1 = new Rectangle(0, 0, 5, 3);
        r2 = new Rectangle(-2, -2, 1, 1);
        assertFalse(r1.intersects(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromBottom() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(1, -1, 1, 2);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(1, 0, 2, 0), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromBottomRightCorner() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(2, -1, 2, 2);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(2, 0, 3, 1), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromRight() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(2, 1, 3, 1);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(3, 1, 3, 2), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromRightTopCorner() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(2, 2, 2, 2);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(3, 2, 2, 3), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromTop() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(1, 2, 1, 2);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(1, 3, 2, 3), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromTopLeftCorner() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(-1, 2, 2, 2);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(0, 2, 1, 3), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromLeft() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(-1, 1, 2, 1);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(0, 1, 0, 2), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromLeftBottomCorner() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(-1, -1, 2, 2);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(1, 0, 0, 1), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromTopToBottom() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(1, -1, 1, 5);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(1, 0, 2, 0, 2, 3, 1, 3), r1.intersectionPoints(r2));
    }

    @Test
    public void rectangle2_intersects_rectangle1FromLeftToRight() {
        r1 = new Rectangle(0, 0, 3, 3);
        r2 = new Rectangle(-1, 1, 5, 1);
        assertTrue(r1.intersects(r2));

        assertEquals(List.of(0, 1, 3, 1, 3, 2, 0, 2), r1.intersectionPoints(r2));
    }

}
