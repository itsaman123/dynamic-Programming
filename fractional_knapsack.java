// fractional knapsack implementation using java

public class frctionalKnapsack02 {
    public int max(int a1,int a2){
        return (a1>a2)? a1:a2;
    }
    public int maxKnapSacVal(int c,int wt[],int v[],int l){
        if(l==0 || c==0){
            return 0;
        }
        if(wt[l-1]>c){
            return maxKnapSacVal(c,wt,v,l-1);
        }
        else{
            int val1=maxKnapSacVal(c-wt[l-1],wt,v,l-1);
            int val2=maxKnapSacVal(c,wt,v,l-1);
            return max(v[l-1]+val2,val2);
        }
    }

    public static void main(String[] args) {
        int value[]={100,150,120};
        int weight[]={10,30,20};
        int c=50;
        int length=value.length;
        frctionalKnapsack02 obj=new frctionalKnapsack02();
        int maxval=obj.maxKnapSacVal(c,weight,value,length);
        System.out.println(maxval);

    }
}
