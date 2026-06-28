open class Ellipse (
    origin: Point,
    protected val r0: Double,
    protected val r1: Double,
    name: String = "Ellipse"
) : Shape(arrayOf(origin), name) {

    init {
        validate(r0 > 0.0 && r1 > 0.0, "$name radius must be greater than zero")
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

}
