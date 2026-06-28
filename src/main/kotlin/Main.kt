fun main() {

    // --- Point ---
    val p = Point(1.0, 2.0)
    p.displayDefinition()
    p.move(3.0, 4.0)
    p.displayDefinition()

    val squareAgain = Square(p, Double.NaN)
    squareAgain.displayDefinition()
    println(squareAgain.getArea())

    // --- Line ---
    val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
    line.displayDefinition()
    println("Line area: ${line.getArea()}")
    println("Line slope: ${line.getSlope()}")
    println("Line distance: ${line.getDistance()}")
    line.move(1.0, 1.0)
    line.getArea()
    line.displayDefinition()

    // invalid: duplicate points
    try {
        Line(Point(1.0, 1.0), Point(1.0, 1.0))
        println("ERROR: should have thrown")
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }

    // --- Triangle ---
    val tri = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
    tri.displayDefinition()
    println("Triangle area: ${tri.getArea()}")
    tri.move(1.0, 1.0)
    tri.displayDefinition()

    // invalid: collinear points (zero area)
    try {
        Triangle(Point(0.0, 0.0), Point(1.0, 1.0), Point(2.0, 2.0))
        println("ERROR: should have thrown")
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }

    // --- Rectangle ---
    val rect = Rectangle(Point(0.0, 0.0), Point(5.0, 3.0))
    rect.displayDefinition()
    println("Rectangle area: ${rect.getArea()}")
    rect.move(2.0, 2.0)
    rect.displayDefinition()

    // invalid: zero area (points share a coordinate)
    try {
        Rectangle(Point(0.0, 0.0), Point(5.0, 0.0))
        println("ERROR: should have thrown")
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }

    // --- Square ---
    val sq = Square(Point(0.0, 0.0), 4.0)
    sq.displayDefinition()
    println("Square area: ${sq.getArea()}")
    sq.move(-1.0, -1.0)
    sq.displayDefinition()

    // invalid: zero edge length
    try {
        Square(Point(0.0, 0.0), 0.0)
        println("ERROR: should have thrown")
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }

    // --- Ellipse ---
    val ellipse = Ellipse(Point(0.0, 0.0), 3.0, 5.0)
    ellipse.displayDefinition()
    println("Ellipse area: ${ellipse.getArea()}")
    ellipse.move(1.0, 1.0)
    ellipse.displayDefinition()

    // invalid: zero radius
    try {
        Ellipse(Point(0.0, 0.0), 0.0, 5.0)
        println("ERROR: should have thrown")
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }

    // --- Circle ---
    val circle = Circle(Point(0.0, 0.0), 4.0)
    circle.displayDefinition()
    println("Circle area: ${circle.getArea()}")
    circle.move(3.0, 3.0)
    circle.displayDefinition()

    // invalid: negative radius
    try {
        Circle(Point(0.0, 0.0), -1.0)
        println("ERROR: should have thrown")
    } catch (e: IllegalArgumentException) {
        println("Caught expected: ${e.message}")
    }
}
