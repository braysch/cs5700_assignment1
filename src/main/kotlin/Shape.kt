abstract class Shape(points: Array<Point>, protected val name: String) {
    private val points: Array<Point>

    init {
        validate(points.isNotEmpty(), "$name must have at least one point")
        this.points = Array(points.size) { i -> points[i].clone() }
    }

    abstract fun getArea(): Double

    fun getPoints(): Array<Point> = Array(points.size) { i -> points[i].clone() }

    fun move(dx: Double, dy: Double) {
        points.forEach { it.move(dx, dy) }
    }

    open fun displayDefinition() {
        printPoints(name, points)
    }
}
