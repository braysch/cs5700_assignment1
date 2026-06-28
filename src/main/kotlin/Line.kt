import kotlin.math.sqrt
import kotlin.math.pow

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
        return sqrt((p1.getX()-p0.getX()).pow(2.0) + (p1.getY()-p0.getY()).pow(2.0))
    }
}
