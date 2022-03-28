package baekjoon.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz14891 {

  private static int time;
  private static List<Gear> gearList = new ArrayList<>();
  private static int result = 0;
  private static int score = 1;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 4; i++) {
      int[] pattern = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
      gearList.add(new Gear(pattern));
    }

    time = sc.nextInt();
    for (int i = 0; i < time; i++) {
      int start = sc.nextInt() -1;
      int direction = sc.nextInt();
      // 오른쪽 톱니바퀴로 이동하면서 시작 톱니바퀴의 값이 변경되므로 시작 톱니바퀴의 변경 전 값 미리 저장
      int previousStatus = gearList.get(start).pattern[6];

      // process(3) : 오른쪽 톱니바퀴로 이동
      // process(1) : 왼쪽 톱니바퀴로 이동
      rotate(-1, start, direction, 3);
      if (start - 1 >= 0) {
        // 오른쪽 톱니바퀴로 이동할때 시작 톱니바퀴는 회전했기 때문에 제외
        rotate(previousStatus, start-1, direction * -1, 1);
      }
    }

    for (int i = 0; i < 4; i++) {
      if (gearList.get(i).pattern[0] > 0) {
        result += score;
      }
      score *= 2;
    }

    System.out.println(result);
  }

  private static void rotate(int previousStatus, int current, int direction, int process) {
    if (current >= gearList.size() || current < 0) {
      return;
    }
    // 오른쪽으로 진행하는 재귀함수는 현재 톱니바퀴(6), 이전 톱니바퀴(2)
    // 왼쪽으로 진행하는 재귀함수는 현재 톱니바퀴(2), 이전 톱니바퀴(6)
    int currentStatus = gearList.get(current).pattern[process * 2];

    if (currentStatus == previousStatus) {
      return;
    }

    // 재귀함수로 넘겨줄 인자 값 previousStatus, 현재 톱니바퀴의 반대쪽 숫자
    if (process * 2 > 3) {
      previousStatus = gearList.get(current).pattern[2];
    } else {
      previousStatus = gearList.get(current).pattern[6];
    }

    // direction > 0 이면 오른쪽으로 회전
    // direction < 0 이면 왼쪽으로 회전
    if (direction > 0) {
      gearList.get(current).rightRotate();
    } else {
      gearList.get(current).leftRotate();
    }

    // process(3)이면 오른쪽으로 진행하는 재귀 함수이므로 현재 톱니바퀴의 인덱스 증가(current + 1)
    // process(1)이면 왼쪽으로 진행하는 재귀 함수이므로 현재 톱니바퀴의 인덱스 감소(current - 1)
    // 회전 방향은 반대(direction * -1)
    if (process == 3) {
      rotate(previousStatus, current + 1, direction * -1, process);
    } else {
      rotate(previousStatus, current - 1, direction * -1, process);
    }
  }

  protected static class Gear {
    protected int[] pattern;

    protected Gear(int[] pattern) {
      this.pattern = pattern;
    }

    protected void rightRotate() {
      pattern = new int[] {pattern[7], pattern[0], pattern[1], pattern[2], pattern[3], pattern[4], pattern[5], pattern[6]};
    }

    protected void leftRotate() {
      pattern = new int[] {pattern[1], pattern[2], pattern[3], pattern[4], pattern[5], pattern[6], pattern[7], pattern[0]};
    }
  }
}
