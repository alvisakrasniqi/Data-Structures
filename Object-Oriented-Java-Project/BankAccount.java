//implementing a simple bank account class
public class BankAccount{

    private String accountNumber;
    private double balance;

    //constructor to intialize account number and balance
    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    //method to deposit money into account
    public void deposit(double amount){

        // ensures amount being deposited is not a negative number or 0
        if(amount > 0){
        this.balance = balance + amount;
        }
        else {
            System.out.println("invalid amount to deposit");
        }
    }


    //method to withdraw money from account
    public void withdraw(double amount){
     
        //ensures that the money being withdrwan is more than zero and that is less than the momeny in the account
        if (amount > 0 && amount<= balance){
        this.balance = balance - amount; 
        }
        else{
            System.out.println("invalid amount to withdraw");
        }
    }

    //method to get the account balance
    public double getBalance(){
       return balance;
    }


    // test class for BankAccount
    public static void main(String[] args) {
        BankAccount account = new BankAccount("85932782938", 2000);
        
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(500.0);
        System.out.println("Balance after depoisting 500 dollars:  " + account.getBalance());

        account.withdraw(300.0);
        System.out.println("Balance after withrawing 300 dollars: " + account.getBalance());

        account.deposit(-100);

        System.out.println("Final Balance: " + account.getBalance());
    }

}
