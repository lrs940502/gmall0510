import java.util.Scanner;

/**
 * @Author: liurs
 * @Description:
 * @Date: Creat in 2020/5/26 15:54
 * @Modified By:
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组大小");
        int i = sc.nextInt();
        String[] arr = new String[i];
        for(int j=0;j<i;j++){
            String str = sc.next();
            arr[j]=str;
        }
        String resultString = new longestCommonPrefix().longestCommonPrefixFunction(arr);
        System.out.println(resultString);
    }

    private String longestCommonPrefixFunction(String[] strs){
        if (strs.length==0){
            return "";
        }
        /**
         * 数组的第一个字符串赋值给一个新的字符串
         */
        String ans = strs[0];
        /**
         * 数组后面的串逐个ans比较
         */
        for (int i=1;i<strs.length;i++){
            if (ans.equals("")){
                //防止下面出现空异常，在此要判断为""直接返回
                return ans;
            }
            /**
             * 字符串的字符和ans的字符进行比较，将两者相同的字符复制给ans，推出本次串的遍历，换下个串，数组的下个串和ans进行比较，相同的部分复制给ans，
             */
            for (int j=0;j<strs[i].length()&&j<ans.length();j++){
                if (strs[i].charAt(j)!=ans.charAt(j)){
                    ans=ans.substring(0,j);
                    break;
                }
            }
        }
        return ans;
    }
}
