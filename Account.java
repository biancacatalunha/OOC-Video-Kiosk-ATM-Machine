// slightly revised for video kiosk - revised

class Account {
       private double balance = 100.00;

       public boolean debit(double a) {
              if((balance-a) >= 0) {
                     balance = balance -a;
                     return true;//debit successful
              }
              else {
                     return false;//insufficient funds
              }
       }

       public double getBalance() {
              return  balance;
       }
}