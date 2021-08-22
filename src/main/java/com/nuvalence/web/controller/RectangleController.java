package com.nuvalence.web.controller;

import com.nuvalence.model.Rectangle;
import com.nuvalence.service.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Class used to expose API endpoints.
 */
@RestController
public class RectangleController {

    private final RectangleService rectangleService;

    /**
     * Default Constructor.
     *
     * @param rectangleService an instance of {@link RectangleService}.
     */
    @Autowired
    public RectangleController(RectangleService rectangleService) {
        this.rectangleService = rectangleService;
    }

    /**
     * Entrypoint for checking if a valid {@link Rectangle} contains another valid {@link Rectangle}.
     *
     * @param rectangles a list containing exactly 2 valid {@link Rectangle}
     * @return true if the specified {@link Rectangle} r2 is contained entirely inside the {@link Rectangle} r1; false otherwise
     */
    @GetMapping(path = "/contains", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> oneContainsOther(@RequestBody List<Rectangle> rectangles) {
        if (rectangles != null && rectangles.size() == 2 && isValid(rectangles)) {
            return ResponseEntity.ok(rectangleService.contains(rectangles.get(0), rectangles.get(1)));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The JSON should contain exactly 2 valid Rectangles.");
        }
    }

    /**
     * Entrypoint for checking if a valid {@link Rectangle} is adjacent another valid {@link Rectangle}.
     *
     * @param rectangles a list containing exactly 2 valid {@link Rectangle}
     * @return true if the specified {@link Rectangle} r1 is adjacent to the {@link Rectangle} r2; false otherwise
     */
    @GetMapping(path = "/adjacent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> oneAdjacentToOther(@RequestBody List<Rectangle> rectangles) {
        if (rectangles != null && rectangles.size() == 2 && isValid(rectangles)) {
            return ResponseEntity.ok(rectangleService.isAdjacentTo(rectangles.get(0), rectangles.get(1)));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The JSON should contain exactly 2 valid Rectangles.");
        }
    }

    /**
     * Entrypoint for checking if a valid {@link Rectangle} intersects another valid {@link Rectangle}.
     *
     * @param rectangles a list containing exactly 2 valid {@link Rectangle}
     * @return true if the specified {@link Rectangle} r2 intersects the {@link Rectangle} r1; false otherwise
     */
    @GetMapping(path = "/intersects", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> oneIntersectsOther(@RequestBody List<Rectangle> rectangles) {
        if (rectangles != null && rectangles.size() == 2 && isValid(rectangles)) {
            return ResponseEntity.ok(rectangleService.intersects(rectangles.get(0), rectangles.get(1)));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The JSON should contain exactly 2 valid Rectangles.");
        }
    }

    /**
     * Entrypoint for calculating the coordinates where a valid {@link Rectangle} r1 intersects another valid {@link Rectangle} r2.
     *
     * @param rectangles a list containing exactly 2 valid {@link Rectangle}
     * @return a {@link List} containing the coordinates where {@link Rectangle} r1 and {@link Rectangle} r2 intersect
     */
    @GetMapping(path = "/intersection", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> getIntersectionPoints(@RequestBody List<Rectangle> rectangles) {
        if (rectangles != null && rectangles.size() == 2 && isValid(rectangles)) {
            return ResponseEntity.ok(rectangleService.intersectionPoints(rectangles.get(0), rectangles.get(1)));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The JSON should contain exactly 2 valid Rectangles.");
        }
    }

    private boolean isValid(List<Rectangle> rectangles) {
        for (Rectangle r : rectangles) {
            if (r.getWidth() <= 0 || r.getHeight() <= 0) {
                return false;
            }
        }
        return true;
    }

}
