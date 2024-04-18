public class ShellSort {
public static void shellSort(int[] arr) {
int n = arr.length;
int gap = n / 2;


while (gap > 0) {
for (int i = gap; i < n; i++) {
int temp = arr[i];
int j = i;
while (j >= gap && arr[j - gap] > temp) {
arr[j] = arr[j - gap];
j -= gap;
}
arr[j] = temp;
}
gap /= 2;
}
}


public static void main(String[] args) {
// Your array B
int[] arrayB = { 80, 4, 3, 50, 30, 1, 50, 88, 2, 0, 15, 43, 11 };


// Sort arrayB using Shell Sort
shellSort(arrayB);


// Printing the sorted array
for (int num : arrayB) {
System.out.print(num + " ");
}
}
}
