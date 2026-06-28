open class Rectangle(
    p0: Point,
    p1: Point
    ) : ClosedShape(arrayOf(p0, p1), "Rectangle") {

    override fun getArea(): Double {
        return getRectangleArea(getPoints()[0], getPoints()[1])
    }
}