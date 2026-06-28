open class Rectangle(
    points: Array<Point>
    ) : Shape(points, "Rectangle") {

        init {
            validate(points.size == 2, "$name must be defined with two points")
        }

    override fun getArea(): Double {
        return getRectangleArea(getPoints()[0], getPoints()[1])
    }
}