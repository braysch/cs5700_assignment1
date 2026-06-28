fun validate(condition: Boolean, message: String) {
    require(condition) { message }
}

fun getRectangleArea(p0: Point, p1: Point): Double {
    return Math.abs((p1.getX() - p0.getX()) * (p1.getY() - p0.getY()))
}

fun pointsAreDistinct(points: Array<Point>): Boolean {
    return points.distinctBy { Pair(it.getX(), it.getY()) }.size == points.size
}
