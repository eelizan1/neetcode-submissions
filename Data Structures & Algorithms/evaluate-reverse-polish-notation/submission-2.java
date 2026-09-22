class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>(); 

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                int num2 = Integer.valueOf(stack.pop()); 
                int num1 = Integer.valueOf(stack.pop()); 

                if (token.equals("+")) stack.push(String.valueOf(num1 + num2)); 
                if (token.equals("-")) stack.push(String.valueOf(num1 - num2)); 
                if (token.equals("*")) stack.push(String.valueOf(num1 * num2)); 
                if (token.equals("/")) stack.push(String.valueOf(num1 / num2)); 
            } else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop()); 
    }
}
