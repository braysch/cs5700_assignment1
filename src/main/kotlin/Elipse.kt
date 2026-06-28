open class Elipse (
    points: Array<Point>,
    private val r0: Double,
    private val r1: Double
) : Shape(points, "Elipse") {

    init {
        validate(r0 != 0.0 && r1 != 0.0, "$name radius cannot be zero")
    }

    override fun getArea(): Double {
        return Math.PI * r0 * r1
    }

    override fun printShapeDefinition() {
        super.printShapeDefinition()
        println("r0: $r0")
        if (r1 != r0) { println("r1: $r1") }
    }

}