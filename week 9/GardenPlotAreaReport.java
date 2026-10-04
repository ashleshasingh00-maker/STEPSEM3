import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();
    abstract String getShapeName();

    public String getOwner() {
        return owner;
    }
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShapeName() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length, width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShapeName() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base, height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShapeName() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String shape = tokens[0];
            String owner = tokens[1];

            if (shape.equals("CIRCLE")) {
                double radius = Double.parseDouble(tokens[2]);
                plots[i] = new CirclePlot(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = Double.parseDouble(tokens[2]);
                double width = Double.parseDouble(tokens[3]);
                plots[i] = new RectanglePlot(owner, length, width);
            } else if (shape.equals("TRIANGLE")) {
                double base = Double.parseDouble(tokens[2]);
                double height = Double.parseDouble(tokens[3]);
                plots[i] = new TrianglePlot(owner, base, height);
            }
        }

        double totalArea = 0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShapeName(), area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}
