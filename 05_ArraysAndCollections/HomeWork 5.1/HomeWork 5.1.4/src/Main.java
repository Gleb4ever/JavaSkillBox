public class Main {

    public static void main(String[] args) {
        // создадим массив масивов matrix
        int [][] matrix = {
                {4, 5, 1},
                {3, 4, 2},
                {3, 2, 1}
        };

        // распечатаем текущую матрицу
        System.out.println(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2]);
        System.out.println(matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2]);
        System.out.println(matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2]);
        System.out.println();

        //получим значаения для первой половины
        for(int i = 0; i < matrix.length / 2; i++){

            // объявим переменную n необходимую для разворота мартицы по часовой стрелки
            int n = matrix.length - 1;

            //получим значения второго массива
            for(int j = 0; j < matrix.length - i - 1; j++){

                // объявим переменную temp для хранения значения преобразования
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }

        // распечатаем матрицу после преобразований
        System.out.println(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2]);
        System.out.println(matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2]);
        System.out.println(matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2]);

    }
}
