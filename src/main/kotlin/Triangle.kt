class Triangle (
    p0: Point,
    p1: Point,
    p2: Point
) : Shape(arrayOf(p0, p1, p2), "Triangle") {

    init {
        validate(getArea() != 0.0, "$name area cannot be equal to zero")
    }

    override fun getArea(): Double {
        val pts = getPoints()
        return kotlin.math.abs(
            pts[0].x * (pts[1].y - pts[2].y) +
                    pts[1].x * (pts[2].y - pts[0].y) +
                    pts[2].x * (pts[0].y - pts[1].y)
        ) / 2.0
    }
}