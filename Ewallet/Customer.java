public class Customer{
    String nama;
    String alamat;
    Ewallet ewallet;

    public Customer(String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;
        this.ewallet = new Ewallet();
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setEwallet(Ewallet ewallet) {
        this.ewallet = ewallet;
    }
    
    public Ewallet getEwallet(){
        return ewallet;
    }
}