import kotlin.math.sqrt
import kotlin.math.pow

class Line(
    private val p0: Point,
    private val p1: Point
) : Shape(arrayOf(p0, p1), "Line") {

    fun getSlope(): Double {
        return (p1.getY() - p0.getY()) / (p1.getX() - p0.getX())
    }

    fun getDistance(): Double {
        return sqrt((p1.getX()-p0.getX()).pow(2.0) + (p1.getY()-p0.getY()).pow(2.0))
    }
}
