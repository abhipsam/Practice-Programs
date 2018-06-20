public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
       int sumremaning=0;
       int total =0;
       int start=0;

        for(int i=0;i<gas.length;i++){
            int remaining=gas[i]-cost[i];

            if(sumremaning>=0){
                sumremaning=sumremaning+remaining;
            }else{
                sumremaning=remaining;
                start=i;
            }
            total=total+remaining;
        }

        if(total>=0){
            return start;
        }
        return -1;
    }
}
