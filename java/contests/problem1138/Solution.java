package context.problem1138;

class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();

        int lastX = 0;
        int lastY = 0;
        for (char c : target.toCharArray()) {
            int x = (c - 'a')%5;
            int y = (c - 'a')/5;
            int delX = x - lastX;
            int delY = y - lastY;

            while (delX < 0) {
                sb.append("L");
                delX++;
            }
            while (delY < 0) {
                sb.append("U");
                delY++;
            }
            while (delX > 0) {
                sb.append("R");
                delX--;
            }

            while (delY > 0) {
                sb.append("D");
                delY--;
            }

            sb.append("!");

            lastX = x;
            lastY = y;
        }
        return sb.toString();
    }
}