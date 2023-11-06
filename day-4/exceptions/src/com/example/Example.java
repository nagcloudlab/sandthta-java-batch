package com.example;

// checked
class AccountBalanceException extends Exception {
    public AccountBalanceException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

// unchecked
class InvalidAmountException extends RuntimeException{}

//----------------------------------------------------------------
// Payments module : Team-2
//----------------------------------------------------------------

class Payment {
    public void transfer(double amount, String src, String target) throws AccountNotFoundException, AccountBalanceException {
        // Load source account
        if (src.equals("13"))
            throw new AccountNotFoundException(src);
        // Load target account
        // source account balance>=amount
        double sourceAccountBalance = 1000.00;
        if (sourceAccountBalance >= amount) {
            //...
            return;
        } else {
            throw new AccountBalanceException("Source account balance " + sourceAccountBalance);
        }
    }
}


//----------------------------------------------------------------
// Booking module : Team-1
//----------------------------------------------------------------

class Booking {
    Payment payment = new Payment();

    public void bookTicket(double ticketAmount) {
        try {
            payment.transfer(ticketAmount, "", "2");
            //...
            // ticket not able allocate...
            if(true){
                throw new IllegalStateException("seat allocation failed");
            }
            System.out.println("booking confirmed");
        } catch (AccountBalanceException | AccountNotFoundException e) {
            System.out.println("booking failed :" + e.getMessage());
        }
        catch (IllegalStateException e){
            // ...
        }
        catch (Throwable t) {
            System.out.println("Ex:" + t.getMessage());
        }
    }
}


public class Example {
    public static void main(String[] args) {

        Booking booking = new Booking();
        booking.bookTicket(10000.00);

    }
}
