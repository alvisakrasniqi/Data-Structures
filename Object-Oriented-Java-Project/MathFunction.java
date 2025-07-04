// MathFunction class for the 1st question
public class MathFunction{

    //exponential method
    public static int multiplyRecusrsive(int x){

        return 2 * multiplyRecusrsiveHelper(x, x); // this multiplies by two

    }

    private static int multiplyRecusrsiveHelper(int x, int y){

        if(y == 0){
            return 1; //base case, exponent is 0
        }

        return x * multiplyRecusrsiveHelper(x, y - 1); // recursive step
    }


    //the square root method
    public static int sqrtIterative(int x, int low, int high){


        //while loop that keep going whilest low <= high
        while (low <=high){
           int p = ((low+high)/2); //this calculates midpoint

            if(p *p == x){
                return p;  // case when the midpoint is the square root
            }
            
            if(p*p > x) {
                high = p-1; //searches in the lower half
            }
            else{
                low = p+1; // searches in the upper half
            }

            

        }
        return -1; // if no square root was found



    }






    public static void main(String[] args){

        System.out.println(multiplyRecusrsive(5)); //tested that this comes 6250 in the terminal

        System.out.println(sqrtIterative(121, 0, 121));// testes that this comes as 11

    }


}