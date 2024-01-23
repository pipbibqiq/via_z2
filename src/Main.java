import java.util.ArrayList;

abstract class Solution {
    // Виртуальные методы
    abstract void calculateRoots();

    abstract void display();

    // Другие общие методы или поля могут быть добавлены по необходимости
}

class Linear extends Solution {
    private double a;
    private double b;
    private double root;

    public Linear(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    void calculateRoots() {
        if (a != 0) {
            root = -b / a;
        } else {
            System.out.println("Линейное уравнение вырождено (a = 0).");
        }
    }

    @Override
    void display() {
        System.out.println("Линейное уравнение: " + a + "x + " + b + " = 0");
        System.out.println("Корень: x = " + root);
    }
}

class Square extends Solution {
    private double a;
    private double b;
    private double c;
    private double root1;
    private double root2;

    public Square(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    void calculateRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            root1 = root2 = -b / (2 * a);
        } else {
            System.out.println("Квадратное уравнение имеет комплексные корни.");
        }
    }

    @Override
    void display() {
        System.out.println("Квадратное уравнение: " + a + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Корень 1: x1 = " + root1);
        System.out.println("Корень 2: x2 = " + root2);
    }
}

class Series {
    private ArrayList<Solution> solutions;

    public Series() {
        solutions = new ArrayList<>();
    }

    public void addSolution(Solution solution) {
        solutions.add(solution);
    }

    public void displayAll() {
        for (Solution solution : solutions) {
            solution.calculateRoots();
            solution.display();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Series series = new Series();

        // Создаем линейное уравнение
        Solution linearEquation = new Linear(2, -3);
        series.addSolution(linearEquation);

        // Создаем квадратное уравнение
        Solution squareEquation = new Square(1, -3, 2);
        series.addSolution(squareEquation);

        // Выводим результаты
        series.displayAll();
    }
}