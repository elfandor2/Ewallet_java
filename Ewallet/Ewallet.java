import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ewallet {
    private double saldo;
    private List<Transaction> transactions;
    IsiSaldo top;

    public Ewallet() {
        this.saldo = 0;
        this.transactions = new ArrayList<>();
    }

    public double getSaldo() {
        transactions.size();
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void cekSaldo() {
        System.out.println("Saldo saat ini: " + saldo);
    }

    public void topup(double nominal, String nomorReferensi, String metodePembayaran, Customer customer) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String tanggal = sdf.format(date);
        IsiSaldo topup = new IsiSaldo(nominal, tanggal, customer, nomorReferensi, metodePembayaran);
        this.saldo += nominal;
        this.transactions.add(topup);
    }

    public void transfer(double nominal, Customer penerima, Customer pengirim) {
        if (this.saldo >= nominal) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String tanggal = sdf.format(date);
            Transfer transfer = new Transfer(nominal, tanggal, pengirim, pengirim, penerima);
            this.saldo -= nominal;
            this.transactions.add(transfer);
            penerima.getEwallet().setSaldo(penerima.getEwallet().getSaldo() + nominal);
            penerima.getEwallet().getTransactions().add(transfer);
        } else {
            System.out.println("Saldo tidak cukup untuk melakukan transfer.");
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
