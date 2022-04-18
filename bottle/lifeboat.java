import java.util.*;

public class lifeboat {
    public static void main(String[] args) {
        int[] people = { 70, 80, 50 };
        int limit = 100;

        int answer = 0;
        int i = 0;
        int max = people.length - 1;
        // 40, 40, 50, 50, 70, 80
        // 50, 70, 80
        Arrays.sort(people);
        while (true) {
            if (people[i] + people[max] > limit) {
                max--;
                answer++; // 배열 sort후 양쪽 끝 값 비교 -> limit 보다 크면 오른쪽 값 인덱스만 1감소
            } else {
                i++;
                max--;
                answer++;
            } // 배열 sort후 양쪽 끝 값 비교 -> limit 보다 작으면 왼쪽 인덱스 1증가, 오른쪽 값 인덱스 1감소

            if (i - max == 1) {
                break;
            } // people 배열이 짝수개

            if (i == max) {
                answer++;
                break;
            } // people 배열이 홀수개
        }
        System.out.println(answer);
    }
}
