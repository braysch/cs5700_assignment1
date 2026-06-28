fun main() {

    val p0 = Point(0.0, 0.0)
    val p1 = Point(0.0, 1.0)

    println(p0.getX())
    println(p0.getY())
    println(p1.getX())
    println(p1.getY())

    val line = Line(p0, p1)

    println(line.getDistance())
    println("SLOPE:")
    println(line.getSlope())

    val rectangle = Rectangle(arrayOf(p0, p1))
    println(rectangle.getArea())
    rectangle.printShapeDefinition()
    rectangle.move(34.6, 28.5)
    rectangle.printShapeDefinition()

    val square = Square(p0, 5.0)
    square.printShapeDefinition()
    println(square.getArea())
    square.move(3.5, 28.6)
    println(square.getArea())

    val squareagain = Square(p0, 234.5)

    val triangle = Triangle(arrayOf(Point(0.0,0.0), Point(1.0,1.0), Point(0.0, 1.0)))
    println(triangle.getArea())

    val elipse = Elipse(arrayOf(p0), 5.5, 2.0)
    println(elipse.getArea())
    elipse.move(34.5, 23.6)
    elipse.printShapeDefinition()

    val circle = Circle(arrayOf(p0), 3.0)
    circle.printShapeDefinition()
}