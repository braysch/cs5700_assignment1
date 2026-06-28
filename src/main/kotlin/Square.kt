class Square (
    p0: Point,
    edgeLength: Double,
        ) : Rectangle(arrayOf(p0, Point(p0.getX() + edgeLength, p0.getY() + edgeLength)))