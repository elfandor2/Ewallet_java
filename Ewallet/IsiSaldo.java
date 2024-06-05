public class IsiSaldo extends Transaction{
    private String nomorReferensi;
    private String metodePembayaran;

    public IsiSaldo(double nominal, String tanggal, Customer customer, String nomorReferensi, String metodePembayaran) {
        super(nominal, tanggal, customer);
        this.nomorReferensi = nomorReferensi;
        this.metodePembayaran = metodePembayaran;
    }

    public String getNomorReferensi() {
        return nomorReferensi;
    }

    public void setNomorReferensi(String nomorReferensi) {
        this.nomorReferensi = nomorReferensi;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public void informasiTransaksi(){
        System.out.println("12313");
    };
}
