fun main() {

    val p0 = Point(0.0, 5.6)
    val p1 = Point(0.0, 2.4)
    val square = Square(p0,5.0)
    square.printShapeDefinition()
    println(square.getArea())
    p0.move(34.7, 234.73)
    square.printShapeDefinition()
    println(square.getArea())
}