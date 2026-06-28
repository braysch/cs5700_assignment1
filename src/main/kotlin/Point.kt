class Point(x: Double, y: Double) {
    var x: Double = x
        private set
    var y: Double = y
        private set

    fun move(dx: Double, dy: Double) {
        x += dx
        y += dy
    }
    fun clone(): Point = Point(x, y)

    fun displayDefinition() {
        printPoints("Point", arrayOf(this))
        }
    }
