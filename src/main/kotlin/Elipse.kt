open class Elipse (
    origin: Point,
    private val r0: Double,
    private val r1: Double
) : ClosedShape(arrayOf(origin), "Elipse") {

    init {
        validate(r0 != 0.0 && r1 != 0.0, "$name radius cannot be zero")
    }

    override fun getArea(): Double {
        return kotlin.math.PI * r0 * r1
    }

    override fun printShapeDefinition() {
        super.printShapeDefinition()
        println("r0: $r0")
        if (r1 != r0) { println("r1: $r1") }
    }

}