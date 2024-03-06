package OPG4ex97;

public class AccountApp {
    public static void main(String[] args) {

        Account myAccount = new Account(1122, 20000);

        System.out.println(myAccount.getBalance());
        myAccount.withdraw(2500);
        myAccount.deposit(3000);
        System.out.println(myAccount.getBalance());
        System.out.println(myAccount.getMonthlyInterest());
    }


}
