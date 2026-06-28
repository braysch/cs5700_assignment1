class Triangle (
    points: Array<Point>
) : Shape(points, "Triangle") {

    init {
        validate(points.size == 3, "$name must be defined with three points")
    }

    override fun getArea(): Double {
        return Math.abs(
            getPoints()[0].getX() * (getPoints()[1].getY() - getPoints()[2].getY()) + 
                    getPoints()[1].getX() * (getPoints()[2].getY() - getPoints()[0].getY()) +
                    getPoints()[2].getX() * (getPoints()[0].getY() - getPoints()[1].getY())
        ) / 2.0
    }
}