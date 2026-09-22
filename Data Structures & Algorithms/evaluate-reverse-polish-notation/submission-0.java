class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    int bAdd = stack.pop();
                    int aAdd = stack.pop();
                    stack.push(aAdd + bAdd);
                    break;
                case "-":
                    int bSub = stack.pop();
                    int aSub = stack.pop();
                    stack.push(aSub - bSub);
                    break;
                case "*":
                    int bMul = stack.pop();
                    int aMul = stack.pop();
                    stack.push(aMul * bMul);
                    break;
                case "/":
                    int bDiv = stack.pop();
                    int aDiv = stack.pop();
                    stack.push(aDiv / bDiv);  // Truncates toward zero
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop(); // Final result
    }
}