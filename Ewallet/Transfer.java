public class Transfer extends Transaction {
    private Customer pengirim;
    private Customer penerima;

    public Transfer(double nominal, String tanggal, Customer customer, Customer pengirim, Customer penerima) {
        super(nominal, tanggal, customer);
        this.pengirim = pengirim;
        this.penerima = penerima;
    }

    public Customer getPengirim() {
        return pengirim;
    }

    public void setPengirim(Customer pengirim) {
        this.pengirim = pengirim;
    }

    public Customer getPenerima() {
        return penerima;
    }

    public void setPenerima(Customer penerima) {
        this.penerima = penerima;
    }

    public void informasiTransaksi(){
        System.out.println("12313");
    };
}
