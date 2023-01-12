import java.util.Objects;
import java.util.UUID;

public class ICICIUser implements BankInterface {

    ///attributes
    private String name;
    private String accountNo;
    private String password;
    private double balance;
    private double rateOfInterest;

    public ICICIUser(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;

        //its been bank part
        this.rateOfInterest = 7;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
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

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override // Its called Annotation
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance + amount;
        return "Your Updated Balance is: "+balance;
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
