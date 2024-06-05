public abstract class Transaction {
    double nominal;
    String tanggal;
    Customer customer;

    public Transaction(double nominal, String tanggal, Customer customer) {
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.customer = customer;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public abstract void informasiTransaksi();
}
