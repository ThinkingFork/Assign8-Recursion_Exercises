public class Recursion {
    public static void main(String[] args) {

        int[] sumMe = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        System.out.printf("Array Sum: %d\n", arraySum(sumMe, 0));

        int[] minMe = { 0, 1, 1, 2, 3, 5, 8, -42, 13, 21, 34, 55, 89 };
        System.out.printf("Array Min: %d\n", arrayMin(minMe, 0));

        String[] amISymmetric =  {
                "You can cage a swallow can't you but you can't swallow a cage can you",
                "I still say cS 1410 is my favorite class"
        };
        for (String test : amISymmetric) {
            String[] words = test.toLowerCase().split(" ");
            System.out.println();
            System.out.println(test);
            System.out.printf("Is word symmetric: %b\n", isWordSymmetric(words, 0, words.length - 1));
        }

        double weights[][] = {
                { 51.18 },
                { 55.90, 131.25 },
                { 69.05, 133.66, 132.82 },
                { 53.43, 139.61, 134.06, 121.63 }
        };
        System.out.println();
        System.out.println("--- Weight Pyramid ---");
        for (int row = 0; row < weights.length; row++) {
            for (int column = 0; column < weights[row].length; column++) {
                double weight = computePyramidWeights(weights, row, column);
                System.out.printf("%.2f ", weight);
            }
            System.out.println();
        }

        char image[][] = {
                {'*','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ','*','*',' ',' '},
                {' ','*',' ',' ','*','*','*',' ',' ',' '},
                {' ','*','*',' ','*',' ','*',' ','*',' '},
                {' ','*','*',' ','*','*','*','*','*','*'},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ','*','*','*',' ',' ','*',' '},
                {' ',' ',' ',' ',' ','*',' ',' ','*',' '}
        };
        int howMany = howManyOrganisms(image);
        System.out.println();
        System.out.println("--- Labeled Organism Image ---");
        for (char[] line : image) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.printf("There are %d organisms in the image.\n", howMany);

    }


    //----------------------------------------------------------------------------------------

    public static boolean isWordSymmetric(String[] words, int start, int end) {
        boolean isSymmetric = true;

        if (start < end) {
            if (words[start].equalsIgnoreCase(words[end])) {
                isWordSymmetric(words, start + 1, end - 1);
            }
            else {
                isSymmetric = false;
            }
        }
        return isSymmetric;
    }

    //-----------------------------------------------------------------------------------------

    public static long arraySum(int[] data, int position) {
        return arraySum(data, position, 0);
    }

    public static long arraySum(int[] data, int position, long sum) {
        if (position > data.length -1) {
            return sum;
        }
        else {
            return arraySum(data, position + 1, sum + data[position]);
        }

    }

    //------------------------------------------------------------------------------------------

    public static int arrayMin(int[] data, int position) {
        return arrayMin(data, position, data[position]);
    }

    public static int arrayMin(int[] data, int position, int min) {
        if (position > data.length -1) {
            return min;
        }

        if (data[position] < min) {
            min = data[position];
            return arrayMin(data, position + 1, min);
        }
        else {
            return arrayMin(data, position + 1, min);
        }
    }

    //-----------------------------------------------------------------------------------------


//    Compute the weights supported at each object in a pyramid.
//
//    Signature: public static double computePyramidWeights(double[][] weights, int row, int column)
//    Description:  Consider the following pyramid of objects...
//
//    A
//    B C
//    D E F
//    G H I J
//
//    The weight supported at each object is the weight of the object itself, plus half of the supported weight of the objects above it.
//    The weight supported by A is the weight of A itself.
//    The weight supported by B is the weight of B plus 1/2 the weight of A.
//    The weight supported by C is the weight of C plus 1/2 the weight of A.
//    The weight supported by E is the weight of E itself, plus 1/2 of the weight supported by B and 1/2 of the weight supported by C.
//    The method must be able to handle incorrect row or column arguments
//    The method should never leave the bounds of each row or column
//    The data is given to you in the following format (there may be any number of rows, this example shows only 4).
//
//            0  1  2  3 (col)
//            0  A
//        1  B, C
//        2  D, E, F
//        3  G, H, I, J
//            (row)


    public static double computePyramidWeights(double[][] weights, int row, int column) {

        if (row == 0 && column == 0) {
            return weights[row][column];
        }
        else if ((row < 0 || row > weights.length) ||
                (column < 0 || column > weights[row].length)) {
            return 0.0;
        }
        else {
            return computePyramidWeights(weights, row, column, weights[row][column]);
        }
    }

    public static double computePyramidWeights(double[][] weights, int row, int column, double weightSum) {



        return 0.0;
    }

    //-----------------------------------------------------------------------------------------

    public static int howManyOrganisms(char[][] image) {
        return 1;
    }
}
