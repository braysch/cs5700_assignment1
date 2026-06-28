abstract class Shape(points: Array<Point>, val name: String) {
    private val points: Array<Point>

    init {
        validate(points.isNotEmpty(), "$name must have at least one point")
        this.points = Array(points.size) { i -> points[i].clone() }
    }

    abstract fun getArea(): Double

    open fun getPoints(): Array<Point> = Array(points.size) { i -> points[i].clone() }

    open fun move(dx: Double, dy: Double) {
        points.forEach { it.move(dx, dy) }
    }

    open fun displayDefinition() {
        printPoints(name, points)
    }
}
