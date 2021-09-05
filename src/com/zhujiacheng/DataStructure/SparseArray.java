package com.zhujiacheng.DataStructure;

/**
 * @Author Mr zhu
 * @Date 2021/8/28 22:16
 */
public class SparseArray {

    public static void main(String[] args) {

        //创建一个二维数组的棋盘
        int charArray[][] = new int[11][11];

        //黑子
        charArray[1][2] = 1;
        //白子
        charArray[2][3] = 2;

        for (int[] rows : charArray) {
            for (int item : rows) {
                System.out.println(item);
            }
            System.out.println();
        }

        //将二维数组转成稀疏数组
        int sum = 0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if(charArray[i][j]!= 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparseArr[][] = new int[1][3];
        //给稀疏数组第一行赋值(行)
        sparseArr[0][0] = charArray.length;

        //列
        sparseArr[0][1] = charArray.length;

        //有效数字的个数
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i <11 ; i++) {

            for (int j = 0; j <11 ; j++) {
                if(sparseArr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=charArray[i][j];
                }

            }

            System.out.println();
            System.out.println("稀疏数组为========");
            for (int j = 0; j <sparseArr.length ; j++) {
                System.out.println(sparseArr[i][0]+""+sparseArr[i][1]+""+sparseArr[i][2]);
            }
        }


    }

}
