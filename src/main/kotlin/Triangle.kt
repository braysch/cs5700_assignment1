class Triangle (
    p0: Point,
    p1: Point,
    p2: Point
) : ClosedShape(arrayOf(p0, p1, p2), "Triangle") {

    init {
        validate(getArea() != 0.0, "$name area cannot be equal to zero")
    }

    override fun getArea(): Double {
        return kotlin.math.abs(
            getPoints()[0].getX() * (getPoints()[1].getY() - getPoints()[2].getY()) + 
                    getPoints()[1].getX() * (getPoints()[2].getY() - getPoints()[0].getY()) +
                    getPoints()[2].getX() * (getPoints()[0].getY() - getPoints()[1].getY())
        ) / 2.0
    }
}