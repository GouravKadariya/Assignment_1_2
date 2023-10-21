// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static double getDistanceBetweenVertex(Point point1, Point point2) {
        return Math.sqrt(
                Math.pow(point2.getX() - point1.getX(), 2)
                        +
                        Math.pow(point2.getY() - point1.getY(), 2)
        );
    }

    public static void calculatePerimeter() {

    }

    public static void main(String[] args) {

    }
}