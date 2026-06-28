class Square (
    p0: Point,
    edgeLength: Double,
        ) : Rectangle(p0, Point(p0.getX() + edgeLength, p0.getY() + edgeLength))