package AlgorithmTest;

import Jama.Matrix;

public class MatrixTest {
    public static void main(String[] args) {
        double [][] arr={
                {1,6,3},
                {4,5,6},
        };
        Matrix matrix=new Matrix(arr);
        matrix.set(0,0,12);
//        matrix.print(6,1);
        matrix.getMatrix(0,1,0,0).print(1,1);
//        matrix.print(1,1);
//        Matrix Inverse=matrix.;
//        Inverse.print(2,1);
    }
}
