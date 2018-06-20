import java.util.Stack;

public class MinStack {
        /** initialize your data structure here. */

       static Stack<Integer> stack1;
       static Stack<Integer> stack2;
        public MinStack() {
           stack1=new Stack<>();
           stack2=new Stack<>();
        }

        public void push(int x) {
            if(!stack2.empty()){
                if(stack2.peek()>x){
                    stack2.push(x);
                }else{
                    stack2.push(stack2.peek());
                }
            }else{
                stack2.push(x);
            }
            stack1.push(x);
        }

        public void pop() {
            if(!stack2.empty() && stack1.peek()==stack2.peek()){
                stack2.pop();
            }
            if(!stack1.empty()){
                stack1.pop();
            }
        }

        public int top() {
          return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }

        public static void main(String args[]){
            MinStack minStack = new MinStack();
            minStack.push(2);
            minStack.push(0);
            minStack.push(3);
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.getMin());

        }
    }

