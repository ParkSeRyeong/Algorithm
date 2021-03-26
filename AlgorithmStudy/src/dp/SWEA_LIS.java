package dp;

import java.util.Scanner;

public class SWEA_LIS {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int[] arr = new int[N]; // 원소를 저장
      int[] LIS = new int[N]; // 각 원소를 마지막에 세웠을 때의 최장 길이

      // 입력받은 원소 저장
      for (int i = 0; i < N; i++) {
         arr[i] = sc.nextInt();
      }

      // 23번째 줄 안쓰고 이렇게 해도 됨.
      //Arrays.fill(LIS, 1);

      int max = 0;
      for (int i = 0; i < N; i++) {
         LIS[i] = 1; // 자기 혼자 세웠을 때의 길이로 초기화

         for (int j = 0; j < i; j++) { // 맨 앞부터 자신의 직전 원소들과 비교
            if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
               LIS[i] = LIS[j] + 1;
            }
         }
         if(max < LIS[i])
            max = LIS[i];
      }
      System.out.println(max);
   }
}