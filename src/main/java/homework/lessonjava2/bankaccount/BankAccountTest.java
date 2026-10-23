package homework.lessonjava2.bankaccount;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setBalance(-500);
        System.out.println("Баланс: " + bankAccount.getBalance());
    }
}
