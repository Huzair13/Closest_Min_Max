import java.util.Scanner;

public class Closest_MinMax{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size of the array !!!");
        int size=scanner.nextInt();

        int array[]=new int[size];
        System.out.println("Enter the Array Elements !!!");
        for(int i=0;i<size;i++){
            array[i]=scanner.nextInt();
        }

        int minMax[] = MinAndMax(array,size);
        int max=minMax[1];
        int min=minMax[0];

        int Result=closestMinMax(array,size,min,max);
        System.out.println("Length of smallest subArray which contains both max and min is :"+Result);
    }

    private static int closestMinMax(int[] array, int size, int min, int max) {
        int latestMinIndex=-1;
        int latestMaxIndex=-1;
        int result=size;

        for(int i=0;i<size;i++){
            if(array[i]==min){
                latestMinIndex=i;
                if (latestMaxIndex>=0){
                    result=Math.min(result,i-latestMaxIndex+1);
                }
            }
            if(array[i]==max){
                latestMaxIndex=i;
                if(latestMinIndex>=0){
                    result=Math.min(result,i-latestMinIndex+1);
                }
            }
        }
        return result;
    }

    private static int[] MinAndMax(int[] array, int size) {

        int minMax[]=new int[2];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(min>array[i]){
                min=array[i];
            }
            if(max<array[i]){
                max=array[i];
            }
        }
        minMax[0]=min;
        minMax[1]=max;
        return minMax;
    }
}