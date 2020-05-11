/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].*/

import java.util.Scanner;

public class FillColor{

    static int counter = 0;
    public static void main(String[] args){
        
        System.out.println("Check description ....");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row and col value ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] matrix = new int[row][col];

    System.out.println("Enter elements ...");
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            matrix[i][j] = sc.nextInt();
        }
    }

    System.out.println("Enter coordinates ");
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println("Enter new color ");
    int newColor = sc.nextInt();
    int[][] visited = new int[row][col];

    fillColor(matrix,x,y,matrix[x][y],newColor,visited);
    display(matrix);

    }

    static void display(int[][] matrix){

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0;i<row;i++){
            System.out.println();
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }


    }

    static void fillColor(int[][] image , int rowIndex , int colIndex ,int currentColor , int newColor,int[][] visited){
        //counter++;
        int rowLen = image.length;
        int colLen = image[0].length;
        
        // 

        // if(counter > 30){
        //     return;
        // }
        
        if(rowIndex<0 || rowIndex>=rowLen || colIndex<0  || colIndex>=colLen || image[rowIndex][colIndex]!=currentColor||
        visited[rowIndex][colIndex]==1){
            
            return;
        }
        //  System.out.println("Current value :"+image[rowIndex][colIndex]+"---"+currentColor);
        //  System.out.println(rowIndex+":::"+colIndex);
        
        image[rowIndex][colIndex] = newColor;
        visited[rowIndex][colIndex] = 1;
        fillColor(image,rowIndex-1,colIndex,currentColor,newColor,visited);
        fillColor(image,rowIndex+1,colIndex,currentColor,newColor,visited);
        fillColor(image,rowIndex,colIndex-1,currentColor,newColor,visited);
        fillColor(image,rowIndex,colIndex+1,currentColor,newColor,visited);
        
        
    }


}