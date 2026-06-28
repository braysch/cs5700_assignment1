open class Rectangle(
    p0: Point,
    p1: Point,
    name: String = "Rectangle"
    ) : Shape(arrayOf(p0, p1), name) {

    init {
        validate(getArea() != 0.0, "$name area cannot be equal to zero")
    }

    final override fun getArea(): Double {
        val pts = getPoints()
        return kotlin.math.abs((pts[1].x - pts[0].x) * (pts[1].y - pts[0].y))
    }
}