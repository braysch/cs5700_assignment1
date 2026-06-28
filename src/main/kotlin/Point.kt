class Point(x: Double, y: Double) {
    var x: Double = x
        private set
    var y: Double = y
        private set

    init {
        require(x.isFinite() && y.isFinite()) { "Definition cannot include infinite or undefined point values" }
    }

    fun move(dx: Double, dy: Double) {
        x += dx
        y += dy
    }
    fun clone(): Point = Point(x, y)

    fun displayDefinition() {
        printPoints("Point", arrayOf(this))
        }
    }
