abstract class Shape (
    private val points: Array<Point>,
    val name: String
) {

    init {
        validate(points.isNotEmpty(), "$name cannot be defined using zero points")
        validate(pointsAreDistinct(points), "$name points must be distinct (area cannot be zero)")
    }

    fun getPoints(): Array<Point> {
        return points
    }

    open fun printShapeDefinition() {
        println("***$name Definition***")
        points.forEachIndexed { index, point ->
            println("p${index}: (${point.getX()}, ${point.getY()})")
        }
    }

    abstract fun getArea(): Double

    fun move(dx: Double, dy: Double) {
        points.forEachIndexed { index, point ->
            point.move(dx, dy)
        }
    }
}