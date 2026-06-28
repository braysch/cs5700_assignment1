import kotlin.math.sqrt

class Line(
    val p0: Point,
    val p1: Point
) {
    init {
        validate(p0.getX() != p1.getX() || p0.getY() != p1.getY(), "Line points must be unique")
    }

    fun getPoints(): Array<Point> {
        return arrayOf(p0, p1)
    }

    fun getSlope(): Double {
        return (p1.getY() - p0.getY()) / (p1.getX() - p0.getX())
    }

    fun getDistance(): Double {
        return sqrt(Math.pow((p1.getX()-p0.getX()), 2.0)+Math.pow((p1.getY()-p0.getY()), 2.0))
    }
}
