package exhaustivesearch;

import java.util.*;

public class Solution {
    public  class Student {
        int grade;
        Queue<Integer> answerType = new LinkedList<>();

        Student(int[] answers) {
            grade = 0;
            for (int answer : answers) {
                answerType.add(answer);
            }
        }

        public void checkAnswer(int answer) {
            int myAnswer = answerType.poll();
            if (answer == myAnswer) {
                grade++;
            }
            answerType.add(myAnswer);
        }
    }

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        Student s1 = new Student(new int[]{1, 2, 3, 4, 5});
        Student s2 = new Student(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        Student s3 = new Student(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
        for (int a : answers) {
            s1.checkAnswer(a);
            s2.checkAnswer(a);
            s3.checkAnswer(a);
        }

        getAnswer(answer, new ArrayList<>(Arrays.asList(s1, s2, s3)));

        return answer.stream().mapToInt(i->i).toArray();
    }

    private void getAnswer(List<Integer> answer, ArrayList<Student> students) {
        int max = 0;
        for (Student student : students) {
            if (max < student.grade) {
                max = student.grade;
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).grade == max) {
                answer.add(i + 1);
            }
        }
    }
}
