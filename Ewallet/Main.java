import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int pilihan = 0;

        do {
        System.out.println("\nEwallet App Menu:");
            System.out.println("1. Tambah Akun");
            System.out.println("2. Cek Saldo");
            System.out.println("3. Topup");
            System.out.println("4. Transfer");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahAkun();
                    break;
                case 2:
                    cekSaldo();
                    break;
                case 3:
                    topup();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Opsi tidak ada, coba lagi.");
            }
        } while (pilihan != 5);
    }

    private static void tambahAkun() {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();
        customers.add(new Customer(nama, alamat));
        System.out.println("Akun berhasil ditambahkan.");
    }

    private static void cekSaldo() {
        Customer customer = pilihCustomer();
        if (customer != null) {
            customer.getEwallet().cekSaldo();
        }
    }

    private static void topup() {
        Customer customer = pilihCustomer();
        if (customer != null) {
            System.out.print("Masukkan nominal topup: ");
            double nominal = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.print("Masukkan nomor referensi: ");
            String nomorReferensi = scanner.nextLine();
            System.out.print("Masukkan metode pembayaran: ");
            String metodePembayaran = scanner.nextLine();
            customer.getEwallet().topup(nominal, nomorReferensi, metodePembayaran, customer);
            System.out.println("Topup berhasil.");
        }
    }

    private static void transfer() {
        System.out.println("Pilih pengirim:");
        Customer pengirim = pilihCustomer();
        if (pengirim != null) {
            System.out.println("Pilih penerima:");
            Customer penerima = pilihCustomer();
            if (penerima != null && !pengirim.equals(penerima)) {
                System.out.print("Masukkan nominal transfer: ");
                double nominal = scanner.nextDouble();
                scanner.nextLine();  // consume newline
                pengirim.getEwallet().transfer(nominal, penerima, pengirim);
                System.out.println("Transfer berhasil.");
            } else {
                System.out.println("Pengirim dan penerima tidak boleh sama.");
            }
        }
    }

    private static Customer pilihCustomer() {
        if (customers.isEmpty()) {
            System.out.println("Tidak ada akun terdaftar.");
            return null;
        }

        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getNama());
        }

        System.out.print("Pilih nomor akun: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        if (pilihan > 0 && pilihan <= customers.size()) {
            return customers.get(pilihan - 1);
        } else {
            System.out.println("Pilihan tidak valid.");
            return null;
        }
    }
}
