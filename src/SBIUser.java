import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{

    private String name;
    private String accountNo;
    private String password;
    private double balance;
    private double rateOfInterest;

    public SBIUser(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;

        this.rateOfInterest = 7.05;
        this.accountNo = String.valueOf(UUID.randomUUID());
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance=balance+amount;
         return "Current Balance: "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword,password)){
            if(amount>balance){
                return "Insufficient  Balance";
            }else{
                balance=balance-amount;
                return "Please collect Cash";
            }

        }else{
            return "Wrong Password !!";
        }
    }

    @Override
    public double calculateInterest(int years) {
        double percentage= (balance*years*rateOfInterest)/100;
        return percentage;
    }
}
