package lesson9;

public class Main {

    public static void main(String[] args) {
        int a = 0;
        String[][] myArr = {{"5", "9", "3", "17"}, {"7", "0", "7", "12"}, {"7", "5", "9", "p"}, {"5", "7", "3", "17"},};
        try {
            a = sum(myArr);
        } catch (MyArraySizeException  e) {
            e.printStackTrace();
            System.out.println("проверьте корректность массива: нужен массив 4x4");
        } catch (MyArrayDataException  e) {
            e.printStackTrace();
            System.out.println("проверьте корректность массива: обратите внимание на элемент: "+e.i+" ,"+e.j);
        }finally {
            System.out.println(a);
        }
    }

    private static int sum(String[][] myArr) throws MyArraySizeException, MyArrayDataException {
        int counter = 0;
        if (myArr.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < myArr.length; i++) {
                for (int j = 0; j < myArr.length; j++) {
                    try {
                        counter += Integer.parseInt(myArr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
        }
        return counter;
    }
}