class Circle (
    origin: Point,
    r0: Double,
) : Ellipse(origin, r0, r0, "Circle") {
    override fun displayRadii() {
        println("radius: $r0")
    }
}