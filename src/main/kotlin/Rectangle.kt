open class Rectangle(
    p0: Point,
    p1: Point
    ) : ClosedShape(arrayOf(p0, p1), "Rectangle") {

    init {
        validate(getArea() != 0.0, "$name area cannot be equal to zero")
    }

    override fun getArea(): Double {
        return getRectangleArea(getPoints()[0], getPoints()[1])
    }
}