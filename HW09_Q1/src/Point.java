import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Helper method to calculate the distance from the origin
    private double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public boolean equals(Object other){
        // Check for reflexivity
        if (other == this)
            return true;
        // Ensure the other object is not null
        if (other == null)
            return false;
        // Check for the right class type to ensure type compatibility
        if (getClass() != other.getClass())
            return false;
        // Type cast to Point
        Point point = (Point) other;

        // Compare distances from the origin instead of direct x and y comparison
        return Double.compare(this.distanceFromOrigin(), point.distanceFromOrigin()) == 0;
    }

    @Override
    public int hashCode(){
        // Use the computed distance for hash code
        return Objects.hash(distanceFromOrigin());
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
