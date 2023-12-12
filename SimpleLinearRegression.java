public class SimpleLinearRegression {
    public static void main(String[] args) {
        
        double[] X = {1, 2, 3, 4, 5};
        double[] Y = {2, 4, 6, 8, 10};

        
        double m = 0;
        double b = 0;

        
        double learningRate = 0.01;
        int iterations = 1000;

    
        for (int i = 0; i < iterations; i++) {
            double[] predictedY = predict(X, m, b);
            double cost = costFunction(Y, predictedY);
            double dm = derivativeM(X, Y, predictedY);
            double db = derivativeB(Y, predictedY);

            m -= learningRate * dm;
            b -= learningRate * db;

            if (i % 100 == 0) {
                System.out.println("Iteration " + i + ": Cost = " + cost);
            }
        }

        System.out.println("\nFinal slope (m): " + m);
        System.out.println("Final y-intercept (b): " + b);
    }

    public static double[] predict(double[] X, double m, double b) {
        double[] predictedY = new double[X.length];
        for (int i = 0; i < X.length; i++) {
            predictedY[i] = m * X[i] + b;
        }
        return predictedY;
    }

    public static double costFunction(double[] Y, double[] predictedY) {
        double sum = 0;
        for (int i = 0; i < Y.length; i++) {
            sum += Math.pow((predictedY[i] - Y[i]), 2);
        }
        return sum / (2 * Y.length);
    }

    public static double derivativeM(double[] X, double[] Y, double[] predictedY) {
        double sum = 0;
        for (int i = 0; i < X.length; i++) {
            sum += (predictedY[i] - Y[i]) * X[i];
        }
        return sum / X.length;
    }

    public static double derivativeB(double[] Y, double[] predictedY) {
        double sum = 0;
        for (int i = 0; i < Y.length; i++) {
            sum += (predictedY[i] - Y[i]);
        }
        return sum / Y.length;
    }
}
