import kotlin.math.sqrt
import kotlin.math.pow

class Line(p0: Point, p1: Point) : Shape(arrayOf(p0, p1), "Line") {

    init {
        validate(pointsAreDistinct(arrayOf(p0, p1)), "$name points must be distinct")
    }
    override fun getArea(): Double = 0.0

    fun getSlope(): Double {
        val points = getPoints()
        return (points[1].y - points[0].y) / (points[1].x - points[0].x)
    }

    fun getLength(): Double {
        val points = getPoints()
        return sqrt((points[1].x - points[0].x).pow(2.0) + (points[1].y - points[0].y).pow(2.0))
    }

    private fun pointsAreDistinct(points: Array<Point>): Boolean {
        return points.distinctBy { Pair(it.x, it.y) }.size == points.size
    }
}
