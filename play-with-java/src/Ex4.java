

// account = {number,balance}

class Account {
    int number;
    double balance;
    // default constructor ==> always assign default values to obj's fields
    //public Account(){}
    // custom constructor ==> creating account with valid number
    public Account(int number){
//        if(number<=0) {
//            System.out.println("Invalid Account Number");
//        }else {
//            this.number = number;
//        }
        this(number,0.0);
    }
    // custom constructor ==> creating account with valid & balance
    public Account(double balance){
//        if(balance>0 && balance < 1000) {
//            this.balance = balance;
//        }else {
//            System.out.println("Invalid Account Balance");
//        }
        this(0,balance);
    }
    // custom constructor ==> creating account with valid number & balance
    public Account(int number, double balance){
        if(number<=0) {
            System.out.println("Invalid Account Number");
        }else {
            this.number = number;
        }
        if(balance>0 && balance < 1000) {
            this.balance = balance;
        }else {
            System.out.println("Invalid Account Balance");
        }
    }
}


public class Ex4 {
    public static void main(String[] args) {


        Account a1 = new Account(123); // 32+64 = 96 bytes
        System.out.println(a1.number);
        System.out.println(a1.balance);

        //a1.number=12345;
        //a1.balance=10000.00;

        System.out.println(a1.number);
        System.out.println(a1.balance);

        // credit
        a1.balance+=10000.00;
        System.out.println(a1.balance);



    }
}
