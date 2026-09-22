class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; 
        int[] answer = new int[n]; 
        Stack<Temp> stack = new Stack<>(); 

        for (int day = 0; day < temperatures.length; day++) {
            while (!stack.isEmpty() && stack.peek().temp < temperatures[day]) {
                Temp stackTemp = stack.pop(); 
                int tempDay = stackTemp.day; 
                answer[tempDay] = day - tempDay; 
            }

            stack.push(new Temp(temperatures[day], day)); 
        }

        return answer; 
    }

    public class Temp {
        int temp; 
        int day; 

        Temp(int temp, int day) {
            this.day = day; 
            this.temp = temp; 
        }
    }
}
