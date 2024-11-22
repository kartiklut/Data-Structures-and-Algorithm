class Solution {
    // 0 1
    // 1 0
    public int maximalRectangle(char[][] matrix) {
        int max=Integer.MIN_VALUE;
        for(int row=0;row<matrix.length;row++){
            max=Math.max(calcMaxArea(row,matrix),max);
        }
        return max;
    }

    public int calcMaxArea(int row,char matrix[][]){
        Stack<Integer> stack=new Stack<>();
        if(row!=0){
            for(int i=0;i<matrix[0].length;i++){
                int prevRowEle=matrix[row-1][i]-'0';
                if(matrix[row][i]!='0'){
                    matrix[row][i]+=prevRowEle;
                }
            }
        }
        int pse[]=calcPse(row,matrix,stack);
        stack=new Stack<>();
        int nse[]=calcNse(row,matrix,stack);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            int height=matrix[row][i]-'0';
            System.out.println(height);
            int psElement=pse[i]+1;
            int nsElement=nse[i]-1;
            int currWidth=nsElement-psElement;
            int width=currWidth+1;
            max=Math.max(max,height*width);
        }
        return max;
    }

    public int[] calcPse(int row,char matrix[][],Stack<Integer> stack){
        int pse[]=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            if(stack.isEmpty()){
                pse[i]=-1;
                stack.push(i);
            }else{
                while(!stack.isEmpty() && matrix[row][stack.peek()]>=matrix[row][i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    pse[i]=-1;
                }else{
                    pse[i]=stack.peek();
                }
                stack.push(i);
            }
        }
        return pse;
    }

    public int[] calcNse(int row,char matrix[][],Stack<Integer> stack){
        int nse[]=new int[matrix[0].length];
        for(int i=matrix[0].length-1;i>=0;i--){
            if(stack.isEmpty()){
                nse[i]=matrix[0].length;
                stack.push(i);
            }else{
                while(!stack.isEmpty() && matrix[row][stack.peek()]>=matrix[row][i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    nse[i]=matrix[0].length;
                }else{
                    nse[i]=stack.peek();
                }
                stack.push(i);
            }
        }
        return nse;
    }
}