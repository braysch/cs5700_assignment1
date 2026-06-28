abstract class ClosedShape(
    points: Array<Point>,
    name: String
) : Shape(points, name) {
    abstract fun getArea(): Double
}
