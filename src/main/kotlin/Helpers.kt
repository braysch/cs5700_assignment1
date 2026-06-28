fun validate(condition: Boolean, message: String) {
    require(condition) { message }
}

fun pointsAreDistinct(points: Array<Point>): Boolean {
    return points.distinctBy { Pair(it.x, it.y) }.size == points.size
}

fun printPoints(name: String, points: Array<Point>) {
    println("=== $name Definition ===")
    points.forEachIndexed { index, point ->
        println("${if (points.size == 1) "origin" else "point_$index"}: (${point.x}, ${point.y})")
    }
}