class Circle (
    points: Array<Point>,
    private val r0: Double,
) : Elipse(points, r0, r0) {
    override fun getArea(): Double {
        return Math.PI * r0 * r0
    }

}