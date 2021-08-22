## Nuvalence test

Problem Description:
You are required to write code in the language of your choice implementing certain algorithms that analyze rectangles
and features that exist among rectangles. Your implementation is required to cover the following:

1. Intersection: You must be able to determine whether two rectangles have one or more intersecting lines and produce a
   result identifying the points of intersection. For your convenience, the scenario is diagrammed in Appendix 1.
2. Containment: You must be able to determine whether a rectangle is wholly contained within another rectangle. For your
   convenience, the scenario is diagrammed in Appendix 2.
3. Adjacency: Implement the ability to detect whether two rectangles are adjacent. Adjacency is defined as the sharing
   of at least one side. Side sharing may be proper, sub-line or partial. A sub-line share is a share where one side of
   rectangle A is a line that exists as a set of points wholly contained on some other side of rectangle B, where
   partial is one where some line segment on a side of rectangle A exists as a set of points on some side of Rectangle
   B. For your convenience, these scenarios are diagrammed in Appendix 3.

Your Submission Must Include:

1. An implementation of the rectangle entity as well as implementations for the algorithms that define the operations
   listed above.
2. Appropriate documentation
3. Test cases/unit tests Feel free to expand on this problem as you wish. Document any expansion and provide it as part
   of your submission. Your submitted source code must compile (if necessary) and the resulting executable must run on
   Linux. Please document any library or framework dependencies.

-------------------------

# Project details:

- Java 11
- Spring Boot
- JUnit

## Requirement

You will need to have Java version 11 or above installed in your machine.

## How to run

Navigate to the project folder and run the following command:

``./gradlew bootRun``

This should start the application, and it will be ready to use within a few seconds, and when running the application in
the local machine, under the default port, it can be accessed at:

### http://localhost:8080

## Endpoints

##### [GET] ``/contains``

Entrypoint for checking if a valid Rectangle r1 contains another valid Rectangle r2. Takes a JSON containing a list with
exactly 2 valid Rectangles. Ex:

``[{"x": 0,"y": 0,"width": 3,"height": 3}, {"x": 1,"y": -1,"width": 1,"height": 2}]``

#### [GET] ``/adjacent``

Entrypoint for checking if a valid Rectangle r1 is adjacent another valid Rectangle r2. Takes a JSON containing a list
with exactly 2 valid Rectangles. Ex:

``[{"x": 0,"y": 0,"width": 3,"height": 3}, {"x": 1,"y": -1,"width": 1,"height": 2}]``

#### [GET] ``/intersects``

Entrypoint for checking if a valid Rectangle r1 intersects another valid Rectangle r2. Takes a JSON containing a list
with exactly 2 valid Rectangles. Ex:

``[{"x": 0,"y": 0,"width": 3,"height": 3}, {"x": 1,"y": -1,"width": 1,"height": 2}]``

#### [GET] ``/intersection``

Entrypoint for calculating the coordinates where a valid Rectangle r1 intersects another valid Rectangle r2. Takes a
JSON containing a list with exactly 2 valid Rectangles. Ex:

``[{"x": 0,"y": 0,"width": 3,"height": 3}, {"x": 1,"y": -1,"width": 1,"height": 2}]``

## Swagger

For the user convenience, a Swagger documentation is included under the following URL, when running the application in
the local machine, under the default port:

### http://localhost:8080/swagger-ui/

There you can find more in depth details about each endpoint available in the application.

## Running tests

Navigate to the project folder and run the following command:

``./gradlew clean test``

This will run all the tests and output if they succeeded or failed.