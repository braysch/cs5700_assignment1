import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.*

// ─── Point ──────────────────────────────────────────────────────────────────

class PointTest {

    @Test
    fun constructorSetsXAndY() {
        val p = Point(3.0, 4.0)
        assertEquals(3.0, p.x)
        assertEquals(4.0, p.y)
    }

    @Test
    fun constructorAcceptsNegativeCoordinates() {
        val p = Point(-2.5, -7.0)
        assertEquals(-2.5, p.x)
        assertEquals(-7.0, p.y)
    }

    @Test
    fun constructorAcceptsZeroCoordinates() {
        val p = Point(0.0, 0.0)
        assertEquals(0.0, p.x)
        assertEquals(0.0, p.y)
    }

    @Test
    fun infiniteXThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Point(Double.POSITIVE_INFINITY, 0.0)
        }
    }

    @Test
    fun negativeInfiniteXThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Point(Double.NEGATIVE_INFINITY, 0.0)
        }
    }

    @Test
    fun infiniteYThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Point(0.0, Double.POSITIVE_INFINITY)
        }
    }

    @Test
    fun nanXThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Point(Double.NaN, 0.0)
        }
    }

    @Test
    fun nanYThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Point(0.0, Double.NaN)
        }
    }

    @Test
    fun moveUpdatesBothAxes() {
        val p = Point(1.0, 2.0)
        p.move(3.0, -1.0)
        assertEquals(4.0, p.x)
        assertEquals(1.0, p.y)
    }

    @Test
    fun moveWithZeroDeltaLeavesCoordinatesUnchanged() {
        val p = Point(5.0, 7.0)
        p.move(0.0, 0.0)
        assertEquals(5.0, p.x)
        assertEquals(7.0, p.y)
    }

    @Test
    fun moveWithNegativeDeltaDecrementsCoordinates() {
        val p = Point(5.0, 5.0)
        p.move(-2.0, -3.0)
        assertEquals(3.0, p.x)
        assertEquals(2.0, p.y)
    }

    @Test
    fun cloneReturnsSameCoordinates() {
        val p = Point(3.0, 4.0)
        val c = p.clone()
        assertEquals(p.x, c.x)
        assertEquals(p.y, c.y)
    }

    @Test
    fun movingOriginalDoesNotAffectClone() {
        val p = Point(3.0, 4.0)
        val c = p.clone()
        p.move(10.0, 10.0)
        assertEquals(3.0, c.x)
        assertEquals(4.0, c.y)
    }

    @Test
    fun movingCloneDoesNotAffectOriginal() {
        val p = Point(3.0, 4.0)
        val c = p.clone()
        c.move(10.0, 10.0)
        assertEquals(3.0, p.x)
        assertEquals(4.0, p.y)
    }
}

// ─── Line ───────────────────────────────────────────────────────────────────

class LineTest {

    @Test
    fun constructorStoresBothEndpoints() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        val pts = line.getPoints()
        assertEquals(0.0, pts[0].x); assertEquals(0.0, pts[0].y)
        assertEquals(3.0, pts[1].x); assertEquals(4.0, pts[1].y)
    }

    @Test
    fun identicalPointsThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Line(Point(1.0, 1.0), Point(1.0, 1.0))
        }
    }

    @Test
    fun getSlopeReturnsCorrectPositiveSlope() {
        val line = Line(Point(0.0, 0.0), Point(2.0, 2.0))
        assertEquals(1.0, line.getSlope(), 1e-9)
    }

    @Test
    fun getSlopeReturnsCorrectNegativeSlope() {
        val line = Line(Point(0.0, 4.0), Point(2.0, 0.0))
        assertEquals(-2.0, line.getSlope(), 1e-9)
    }

    @Test
    fun getSlopeOfHorizontalLineIsZero() {
        val line = Line(Point(0.0, 5.0), Point(3.0, 5.0))
        assertEquals(0.0, line.getSlope(), 1e-9)
    }

    @Test
    fun getSlopeOfVerticalLineIsInfinite() {
        val line = Line(Point(2.0, 0.0), Point(2.0, 4.0))
        assertTrue(line.getSlope().isInfinite())
    }

    @Test
    fun getDistanceForThreeFourFiveTriangle() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        assertEquals(5.0, line.getDistance(), 1e-9)
    }

    @Test
    fun getDistanceForHorizontalLine() {
        val line = Line(Point(1.0, 3.0), Point(7.0, 3.0))
        assertEquals(6.0, line.getDistance(), 1e-9)
    }

    @Test
    fun getDistanceForVerticalLine() {
        val line = Line(Point(4.0, 0.0), Point(4.0, 5.0))
        assertEquals(5.0, line.getDistance(), 1e-9)
    }

    @Test
    fun getDistanceIsSymmetric() {
        val d1 = Line(Point(0.0, 0.0), Point(3.0, 4.0)).getDistance()
        val d2 = Line(Point(3.0, 4.0), Point(0.0, 0.0)).getDistance()
        assertEquals(d1, d2, 1e-9)
    }

    @Test
    fun moveUpdatesBothEndpoints() {
        val line = Line(Point(0.0, 0.0), Point(2.0, 2.0))
        line.move(1.0, 3.0)
        val pts = line.getPoints()
        assertEquals(1.0, pts[0].x); assertEquals(3.0, pts[0].y)
        assertEquals(3.0, pts[1].x); assertEquals(5.0, pts[1].y)
    }

    @Test
    fun movePreservesLength() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))
        val before = line.getDistance()
        line.move(10.0, -5.0)
        assertEquals(before, line.getDistance(), 1e-9)
    }

    @Test
    fun getPointsReturnsDefensiveCopies() {
        val line = Line(Point(0.0, 0.0), Point(2.0, 2.0))
        line.getPoints()[0].move(99.0, 99.0)
        val pts = line.getPoints()
        assertEquals(0.0, pts[0].x)
        assertEquals(0.0, pts[0].y)
    }
}

// ─── Rectangle ──────────────────────────────────────────────────────────────

class RectangleTest {

    @Test
    fun constructorStoresDefiningPoints() {
        val rect = Rectangle(Point(0.0, 0.0), Point(3.0, 4.0))
        val pts = rect.getPoints()
        assertEquals(0.0, pts[0].x); assertEquals(0.0, pts[0].y)
        assertEquals(3.0, pts[1].x); assertEquals(4.0, pts[1].y)
    }

    @Test
    fun sameXCoordinatesThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(Point(2.0, 0.0), Point(2.0, 5.0))
        }
    }

    @Test
    fun sameYCoordinatesThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(Point(0.0, 3.0), Point(5.0, 3.0))
        }
    }

    @Test
    fun identicalPointsThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Rectangle(Point(1.0, 1.0), Point(1.0, 1.0))
        }
    }

    @Test
    fun getAreaReturnsWidthTimesHeight() {
        assertEquals(12.0, Rectangle(Point(0.0, 0.0), Point(3.0, 4.0)).getArea(), 1e-9)
    }

    @Test
    fun getAreaWorksRegardlessOfPointOrder() {
        assertEquals(12.0, Rectangle(Point(3.0, 4.0), Point(0.0, 0.0)).getArea(), 1e-9)
    }

    @Test
    fun getAreaWorksWithNegativeCoordinates() {
        assertEquals(16.0, Rectangle(Point(-3.0, -2.0), Point(1.0, 2.0)).getArea(), 1e-9)
    }

    @Test
    fun moveUpdatesBothPoints() {
        val rect = Rectangle(Point(0.0, 0.0), Point(3.0, 4.0))
        rect.move(2.0, 1.0)
        val pts = rect.getPoints()
        assertEquals(2.0, pts[0].x); assertEquals(1.0, pts[0].y)
        assertEquals(5.0, pts[1].x); assertEquals(5.0, pts[1].y)
    }

    @Test
    fun movePreservesArea() {
        val rect = Rectangle(Point(0.0, 0.0), Point(3.0, 4.0))
        val before = rect.getArea()
        rect.move(10.0, -7.0)
        assertEquals(before, rect.getArea(), 1e-9)
    }

    @Test
    fun getPointsReturnsDefensiveCopies() {
        val rect = Rectangle(Point(0.0, 0.0), Point(3.0, 4.0))
        rect.getPoints()[0].move(99.0, 99.0)
        val pts = rect.getPoints()
        assertEquals(0.0, pts[0].x)
        assertEquals(0.0, pts[0].y)
    }
}

// ─── Square ─────────────────────────────────────────────────────────────────

class SquareTest {

    @Test
    fun constructorPlacesSecondPointCorrectly() {
        val pts = Square(Point(1.0, 2.0), 5.0).getPoints()
        assertEquals(1.0, pts[0].x); assertEquals(2.0, pts[0].y)
        assertEquals(6.0, pts[1].x); assertEquals(7.0, pts[1].y)
    }

    @Test
    fun zeroEdgeLengthThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Square(Point(0.0, 0.0), 0.0)
        }
    }

    @Test
    fun getAreaEqualsEdgeLengthSquared() {
        assertEquals(16.0, Square(Point(0.0, 0.0), 4.0).getArea(), 1e-9)
    }

    @Test
    fun widthAndHeightAreEqual() {
        val pts = Square(Point(1.0, 1.0), 3.0).getPoints()
        assertEquals(abs(pts[1].x - pts[0].x), abs(pts[1].y - pts[0].y), 1e-9)
    }

    @Test
    fun moveUpdatesPosition() {
        val sq = Square(Point(0.0, 0.0), 3.0)
        sq.move(2.0, 2.0)
        val pts = sq.getPoints()
        assertEquals(2.0, pts[0].x); assertEquals(2.0, pts[0].y)
        assertEquals(5.0, pts[1].x); assertEquals(5.0, pts[1].y)
    }

    @Test
    fun movePreservesArea() {
        val sq = Square(Point(0.0, 0.0), 5.0)
        val before = sq.getArea()
        sq.move(10.0, 10.0)
        assertEquals(before, sq.getArea(), 1e-9)
    }

    @Test
    fun squareIsARectangle() {
        assertTrue(Square(Point(0.0, 0.0), 5.0) is Rectangle)
    }
}

// ─── Ellipse ─────────────────────────────────────────────────────────────────

class EllipseTest {

    @Test
    fun constructorStoresOrigin() {
        val pts = Ellipse(Point(1.0, 2.0), 3.0, 4.0).getPoints()
        assertEquals(1.0, pts[0].x)
        assertEquals(2.0, pts[0].y)
    }

    @Test
    fun zeroR0ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 0.0, 4.0)
        }
    }

    @Test
    fun zeroR1ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 3.0, 0.0)
        }
    }

    @Test
    fun negativeR0ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), -1.0, 4.0)
        }
    }

    @Test
    fun negativeR1ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 3.0, -1.0)
        }
    }

    @Test
    fun infiniteR0ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), Double.POSITIVE_INFINITY, 4.0)
        }
    }

    @Test
    fun infiniteR1ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 3.0, Double.POSITIVE_INFINITY)
        }
    }

    @Test
    fun nanR0ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), Double.NaN, 4.0)
        }
    }

    @Test
    fun nanR1ThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Ellipse(Point(0.0, 0.0), 3.0, Double.NaN)
        }
    }

    @Test
    fun getAreaReturnsPiTimesR0TimesR1() {
        assertEquals(PI * 3.0 * 4.0, Ellipse(Point(0.0, 0.0), 3.0, 4.0).getArea(), 1e-9)
    }

    @Test
    fun getAreaWithEqualRadiiEqualsPiRSquared() {
        assertEquals(PI * 25.0, Ellipse(Point(0.0, 0.0), 5.0, 5.0).getArea(), 1e-9)
    }

    @Test
    fun moveUpdatesOrigin() {
        val e = Ellipse(Point(1.0, 2.0), 3.0, 4.0)
        e.move(2.0, 3.0)
        val pts = e.getPoints()
        assertEquals(3.0, pts[0].x)
        assertEquals(5.0, pts[0].y)
    }

    @Test
    fun movePreservesArea() {
        val e = Ellipse(Point(0.0, 0.0), 3.0, 4.0)
        val before = e.getArea()
        e.move(10.0, 10.0)
        assertEquals(before, e.getArea(), 1e-9)
    }

    @Test
    fun getPointsReturnsDefensiveCopyOfOrigin() {
        val e = Ellipse(Point(1.0, 2.0), 3.0, 4.0)
        e.getPoints()[0].move(99.0, 99.0)
        val pts = e.getPoints()
        assertEquals(1.0, pts[0].x)
        assertEquals(2.0, pts[0].y)
    }
}

// ─── Circle ──────────────────────────────────────────────────────────────────

class CircleTest {

    @Test
    fun constructorStoresOrigin() {
        val pts = Circle(Point(3.0, 5.0), 2.0).getPoints()
        assertEquals(3.0, pts[0].x)
        assertEquals(5.0, pts[0].y)
    }

    @Test
    fun zeroRadiusThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), 0.0)
        }
    }

    @Test
    fun negativeRadiusThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Circle(Point(0.0, 0.0), -3.0)
        }
    }

    @Test
    fun getAreaReturnsPiTimesRadiusSquared() {
        assertEquals(PI * 25.0, Circle(Point(0.0, 0.0), 5.0).getArea(), 1e-9)
    }

    @Test
    fun getAreaForUnitCircleEqualsPI() {
        assertEquals(PI, Circle(Point(0.0, 0.0), 1.0).getArea(), 1e-9)
    }

    @Test
    fun moveUpdatesOrigin() {
        val c = Circle(Point(1.0, 1.0), 3.0)
        c.move(-1.0, 4.0)
        val pts = c.getPoints()
        assertEquals(0.0, pts[0].x)
        assertEquals(5.0, pts[0].y)
    }

    @Test
    fun movePreservesArea() {
        val c = Circle(Point(0.0, 0.0), 5.0)
        val before = c.getArea()
        c.move(7.0, -3.0)
        assertEquals(before, c.getArea(), 1e-9)
    }

    @Test
    fun circleIsAnEllipse() {
        assertTrue(Circle(Point(0.0, 0.0), 5.0) is Ellipse)
    }
}

// ─── Triangle ────────────────────────────────────────────────────────────────

class TriangleTest {

    @Test
    fun constructorStoresAllThreePoints() {
        val pts = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0)).getPoints()
        assertEquals(0.0, pts[0].x); assertEquals(0.0, pts[0].y)
        assertEquals(4.0, pts[1].x); assertEquals(0.0, pts[1].y)
        assertEquals(0.0, pts[2].x); assertEquals(3.0, pts[2].y)
    }

    @Test
    fun collinearPointsOnDiagonalThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Triangle(Point(0.0, 0.0), Point(1.0, 1.0), Point(2.0, 2.0))
        }
    }

    @Test
    fun collinearPointsOnHorizontalLineThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Triangle(Point(0.0, 0.0), Point(1.0, 0.0), Point(2.0, 0.0))
        }
    }

    @Test
    fun collinearPointsOnVerticalLineThrowsException() {
        assertThrows(IllegalArgumentException::class.java) {
            Triangle(Point(0.0, 0.0), Point(0.0, 1.0), Point(0.0, 2.0))
        }
    }

    @Test
    fun getAreaForRightTriangle() {
        assertEquals(6.0, Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0)).getArea(), 1e-9)
    }

    @Test
    fun getAreaForGeneralTriangle() {
        assertEquals(12.0, Triangle(Point(0.0, 0.0), Point(6.0, 0.0), Point(3.0, 4.0)).getArea(), 1e-9)
    }

    @Test
    fun getAreaWithNegativeCoordinates() {
        assertEquals(6.0, Triangle(Point(-2.0, 0.0), Point(2.0, 0.0), Point(0.0, 3.0)).getArea(), 1e-9)
    }

    @Test
    fun moveUpdatesAllThreePoints() {
        val t = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        t.move(1.0, 2.0)
        val pts = t.getPoints()
        assertEquals(1.0, pts[0].x); assertEquals(2.0, pts[0].y)
        assertEquals(5.0, pts[1].x); assertEquals(2.0, pts[1].y)
        assertEquals(1.0, pts[2].x); assertEquals(5.0, pts[2].y)
    }

    @Test
    fun movePreservesArea() {
        val t = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        val before = t.getArea()
        t.move(10.0, -5.0)
        assertEquals(before, t.getArea(), 1e-9)
    }

    @Test
    fun getPointsReturnsDefensiveCopies() {
        val t = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        t.getPoints()[0].move(99.0, 99.0)
        val pts = t.getPoints()
        assertEquals(0.0, pts[0].x)
        assertEquals(0.0, pts[0].y)
    }
}
