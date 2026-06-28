class Point (
    private var x: Double,
    private var y: Double,
) {
    fun move(dx: Double, dy: Double) {
        x += dx
        y += dy
    }

    fun clone(): Point {
        return Point(x, y)
    }

    fun getX(): Double {
        return x
    }

    fun getY(): Double {
        return y
    }


}