abstract class Shape (
    points: Array<Point>,
    val name: String
) {
    // Make a copy of points so that someone can't define a square and then move its points around so its no longer a square
    private val points: Array<Point> = Array(points.size) { i -> points[i].clone() }

    init {
        validate(points.isNotEmpty(), "$name cannot be defined using zero points")
        validate(pointsAreDistinct(points), "$name points must be distinct")
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

    fun move(dx: Double, dy: Double) {
        points.forEach { point -> point.move(dx, dy) }
    }
}