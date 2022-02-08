package programmers.exhaustivesearch;

public class Solution3 {
    public int[] mySolution(int brown, int yellow) {
        return checkSquare(brown, yellow, 1);
    }

    private int[] checkSquare(int brown, int yellow, int depth) {
        int x = yellow / depth;
        int y = depth;
        int blocks = (x + 2) * (y + 2);
        if(blocks != (brown + yellow) || x < y || (yellow % depth != 0)) {
            checkSquare(brown, yellow, ++depth);
        } else {
            return new int[]{x + 2, y + 2};
        }
        return new int[]{};
    }

    public int[] bestSolution(int brown, int red) {
        for(int i = 1; i <= red; i++) {
            if(red % i == 0 && (red / i + i) * 2 + 4 == brown) {
                return new int[] {red / i+2, i+2};
            }
        }
        return null;
    }
}
