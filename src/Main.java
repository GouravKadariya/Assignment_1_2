import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static double getUserInput(String message) {
        boolean input = false;
        double userInput = 0;
        while (!input) {
            try {
                System.out.print(message);
                Scanner scanner = new Scanner(System.in);
                userInput = scanner.nextDouble();
                input = true;
            } catch (Exception ex) {
                System.out.println("Invalid input");
            }
        }
        return userInput;
    }

    static void setTriangleDetails(Triangle[] triangles) {
        for (int i = 0; i < triangles.length; i++) {
            System.out.printf("Input information for Triangle %d\n", i + 1);

            Triangle triangle = new Triangle();

            double x = getUserInput("Vertex1 x:");
            double y = getUserInput("Vertex1 y:");

            triangle.setVertex1(new Point(x, y));

            x = getUserInput("Vertex2 x:");
            y = getUserInput("Vertex2 y:");

            triangle.setVertex2(new Point(x, y));

            x = getUserInput("Vertex3 x:");
            y = getUserInput("Vertex3 y:");

            triangle.setVertex3(new Point(x, y));

            triangles[i] = triangle;
            System.out.println();
            calculatePerimeterAndCheckIsosceles(triangle);
        }
    }

    public static double getDistanceBetweenVertex(Point point1, Point point2) {
        return Math.sqrt(
                Math.pow(point2.getX() - point1.getX(), 2)
                        +
                        Math.pow(point2.getY() - point1.getY(), 2)
        );
    }

    public static void calculatePerimeterAndCheckIsosceles(Triangle triangle) {
        double side1Length = getDistanceBetweenVertex(triangle.getVertex1(), triangle.getVertex2());
        double side2Length = getDistanceBetweenVertex(triangle.getVertex2(), triangle.getVertex3());
        double side3Length = getDistanceBetweenVertex(triangle.getVertex3(), triangle.getVertex1());
        double perimeter = side1Length + side2Length + side3Length;

        boolean isIsosceles = side1Length == side2Length || side2Length == side3Length || side1Length == side3Length;

        String isoscelesMessage = isIsosceles ? "Triangle is isosceles." : "Triangle is not isosceles.";

        System.out.printf("Perimeter: %f %s\n", perimeter, isoscelesMessage);
    }

    static int getTotalTriangleInputNum() {
        System.out.println("How many triangle?");
        boolean input = false;
        int count = 0;
        while (!input) {
            try {
                System.out.print("How many triangle?(min required 3):");
                Scanner scanner = new Scanner(System.in);
                count = scanner.nextInt();
                if (count < 3) {
                    System.out.println("Required minimum 3!!!");
                } else {
                    input = true;
                }
            } catch (Exception ex) {
                System.out.println("Invalid input!");
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int size = getTotalTriangleInputNum();
        Triangle[] triangles = new Triangle[size];
        setTriangleDetails(triangles);
    }
}