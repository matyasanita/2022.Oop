package lab11_5;

import java.util.Random;

public class Matrix extends Throwable{
    double[][] data;
    final int rows;
    final int columns;

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[rows][columns];

        for (int i = 0; i < data.length ; i++){
            for ( int j = 0 ; j < data[i].length ; j++){
                this.data[i][j] = data[i][j];
            }
        }

    }

    public Matrix(Matrix m){
        rows = m.rows;
        columns = m.columns;
        this.data = new double[rows][columns];

        for (int i = 0; i < m.rows ; i++){
            for ( int j = 0 ; j < m.columns ; j++){
                data[i][j] = m.data[i][j];
            }
        }
    }

    public void fillRandom(double a, double b){
        Random rand = new Random();
        for (int i = 0; i < rows ; i++){
            for ( int j = 0 ; j < columns ; j++){
                data[i][j] = rand.nextDouble(b - a) + a;
            }
        }
    }

    public double[][] getData() {
        return data;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix(){
        for (int i = 0; i < rows ; i++){
            String row = "";
            for ( int j = 0 ; j < columns ; j++){
                row += data[i][j] + " ";
            }
            System.out.println(row);
        }
    }

    public static Matrix add (Matrix m1, Matrix m2) throws MatrixException{

        if (m1.columns != m2.columns || m1.rows != m2.rows){
            throw new MatrixException("inproper matrix dimensions");
        }

        Matrix newMatrix = new Matrix(m1.rows, m1.columns);
        for (int i = 0; i < m1.rows ; i++){
            for ( int j = 0 ; j < m1.columns ; j++){
                newMatrix.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return newMatrix;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) throws MatrixException{
        if (m1.columns != m2.rows ){
            throw new MatrixException("inproper matrix dimensions");
        }

        Matrix newMatrix = new Matrix(m1.rows, m2.columns);
        for (int i = 0; i < m1.rows ; i++){
            for ( int j = 0 ; j < m2.rows ; j++){
                newMatrix.data[i][j] = m1.data[i][j] + m2.data[j][i];
            }
        }
        return newMatrix;
    }

    public static Matrix transpose(Matrix m1){
        Matrix newMatrix = new Matrix(m1.columns, m1.rows);
        for (int i = 0; i < m1.columns ; i++){
            for ( int j = 0 ; j < m1.rows ; j++){
                newMatrix.data[i][j] = m1.data[j][i];
            }
        }
        return newMatrix;
    }

}
