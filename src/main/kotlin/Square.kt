class Square (
    p0: Point,
    edgeLength: Double,
        ) : Rectangle(p0, Point(p0.getX() + edgeLength, p0.getY() + edgeLength)) {
    init {
        validate(edgeLength > 0, "$name edge length must be greater than zero")
    }
        }