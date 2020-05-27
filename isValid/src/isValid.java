import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: liurs
 * @Description: 有效的括号
 * @Date: Creat in 2020/5/26 16:54
 * @Modified By:
 */
public class isValid {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        Boolean isValid = new isValid().isValid(next);
        System.out.println(isValid);
    }

    private HashMap<Character,Character> mappings;

    private void Solution(){
        this.mappings.put(')','(');
        this.mappings.put(']','[');
        this.mappings.put('}','{');
    }

    private boolean isValid(String s) {

        HashMap<Character,Character> mappings = new HashMap<>();

        mappings.put(')','(');
        mappings.put(']','[');
        mappings.put('}','{');

        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (mappings.containsKey(c)){

                /**
                 * 如果栈空了，而字符串还有值，肯定是无效字符串，所以这次'#'，表示第一个字符串时如果是右括号的处理。
                 */

                char top = stack.empty() ? '#' : stack.pop();
                if (top!=mappings.get(c)){
                    return false;
                }
            }else {
                /**
                 *  左括号 和 引号 需要加入栈
                 */
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
