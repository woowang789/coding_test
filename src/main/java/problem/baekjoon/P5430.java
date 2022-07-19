package problem.baekjoon;

import java.io.*;
import java.util.Arrays;

public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int round=0;round<n;round++){
            String cmd = br.readLine();
            int[] nums ={};
            int count = Integer.parseInt(br.readLine());
            String str = br.readLine();
            if(count != 0) nums = Arrays.stream(str.substring(1, str.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();

            bw.write(solve(nums,cmd)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    private static String solve(int[] nums,String cmd){
        int left = 0;
        int right = nums.length;
        int idx = 0;
        boolean flag = true;
        while(idx < cmd.length()){
            char ch = cmd.charAt(idx);
            if(ch == 'R') flag = !flag;
            else if(ch=='D'){
                if(flag) left++;
                else right --;
            }
            idx++;
        }
        if(left > right){
            return "error";
        }else{
            int[] ans = new int[right-left];
            if(flag) for(int i=left;i<right;i++) ans[i-left] = nums[i];
            else for(int i =right-1;i>=left;i--) ans[right-i-1] = nums[i];
            StringBuilder sb = new StringBuilder("[");
            for(int i =0;i< ans.length;i++){
                sb.append(ans[i]+"");
                if(i!= ans.length-1) sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
