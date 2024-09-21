class Solution {
    public int maximalRectangle(char[][] matrix) {
        int heights[]=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            heights[i]=matrix[0][i]=='1' ? 1 : 0;
        }
        int maxArea=calculateMaxArea1D(heights);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    heights[j]=0;
                }else{          
                    heights[j]+=1;
                }   
            }
            maxArea=Math.max(maxArea,calculateMaxArea1D(heights));
        }
        return maxArea;
    }

    int calculateMaxArea1D(int heights[]){
        int area=0;
        Stack<Integer> stack=new Stack<>();
        int pse[]=new int[heights.length];
        int nse[]=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                pse[i]=-1;
                continue;
            }
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=stack.peek();
            }
            stack.push(i);
        }
        stack=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            if(stack.isEmpty()){
                nse[i]=heights.length;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i]=heights.length;
            }else{
                nse[i]=stack.peek();
            }
            stack.push(i);
        }
        //calc area
        //nse[i]-pse[i]-1
        for(int i=0;i<heights.length;i++){
            area=Math.max(area,heights[i]*(nse[i]-pse[i]-1));
        }
        return area;
    }
}
