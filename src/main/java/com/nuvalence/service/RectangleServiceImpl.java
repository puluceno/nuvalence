package com.nuvalence.service;

import com.nuvalence.model.Rectangle;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default Implementation of the Interface {@link RectangleService}.
 */
@Service
public class RectangleServiceImpl implements RectangleService {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacentTo(Rectangle r1, Rectangle r2) {
        return r1.isAdjacentTo(r2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Rectangle r1, Rectangle r2) {
        return r1.contains(r2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean intersects(Rectangle r1, Rectangle r2) {
        return r1.intersects(r2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> intersectionPoints(Rectangle r1, Rectangle r2) {
        return r1.intersectionPoints(r2);
    }

}
