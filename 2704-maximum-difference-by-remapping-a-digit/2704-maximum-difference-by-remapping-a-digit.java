class Solution {
    public int minMaxDifference(int num) {
    int len = 0;
    int temp = num;
    while(temp>0){
        len++;temp/=10;
    }  
    temp = num;
    int max[] = new int[len];
    int min[] = new int[len];
    for(int i = 0; i<len ; i++){
        max[len-1-i] = temp%10;
        min[len-1-i] = temp%10;
        temp/=10;
    }
    int stepMax = -1;
    int stepMin = -1;
    for(int i = 0;i<len;i++){
        if(max[i]!=9){
            if(stepMax==-1){
                stepMax=max[i];
                max[i]=9;
            }else if(max[i]==stepMax){
                max[i]=9;
            }else{
                //No changes
            }
        }
        if(min[i]!=0){
            if(stepMin==-1){
                stepMin=min[i];
                min[i]=0;
            }else if(min[i]==stepMin){
                min[i]=0;
            }else{
                //No changes
            }
        }   
    }
    temp = 0;
    for(int i = 0;i<len;i++){
        if(min[i]>max[i]){
            max[i+1]--;
            max[i]+=10;
        }
        temp = temp * 10 +( max[i] - min[i] );
    }
    return temp;
    }
}