open class Ellipse (
    origin: Point,
    protected val r0: Double,
    private val r1: Double,
    name: String = "Ellipse"
) : Shape(arrayOf(origin), name) {

    init {
        validate(r0.isFinite() && r0 > 0.0, "$name r0 must be a finite positive number")
        validate(r1.isFinite() && r1 > 0.0, "$name r1 must be a finite positive number")
    }

    override fun getArea(): Double {
        return kotlin.math.PI * r0 * r1
    }

    protected open fun displayRadii() {
        println("radius_0: $r0")
        println("radius_1: $r1")
    }

    override fun displayDefinition() {
        super.displayDefinition()
        displayRadii()
    }

    open fun getRadii(): Array<Double> {
        return arrayOf(r0, r1)
    }

}
