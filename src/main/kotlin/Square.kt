class Square(
    p0: Point,
    edgeLength: Double,
) : Rectangle(p0, Point(p0.x + edgeLength, p0.y + edgeLength), "Square") {
    init {
        validate(edgeLength.isFinite() && edgeLength > 0.0, "$name edge length must be a finite positive number")
    }
}
