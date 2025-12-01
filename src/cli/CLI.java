package cli;

import sistem.RestaurantSystem;
import akun.Customer;
import transaksi.Meja;
import menu.*;
import database.DatabaseManager;
import pembayaran.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CLI {
    private static void usage() {
        System.out.println("Penggunaan: java cli.CLI [perintah] [opsi]\n");
        System.out.println("Perintah yang tersedia:");
        System.out.println("  help                          Tampilkan bantuan ini");
        System.out.println("  interactive                   Jalankan mode interaktif (sama seperti RestaurantDriver)");
        System.out.println("  session                       Jalankan session CLI (REPL); state tersimpan selama proses berjalan");
        System.out.println("  list-menu                     Tampilkan daftar menu (makanan & minuman)");
        System.out.println("  list-tables                   Tampilkan daftar meja");
        System.out.println("  start-order --customer <nama> --table <nomor>   Mulai pesanan baru untuk customer di meja");
        System.out.println("  add-item --customer <nama> --item <nama_item> --qty <jumlah> [--note <catatan>]  Tambah item ke pesanan");
        System.out.println("  confirm --customer <nama>     Konfirmasi pesanan (masuk ke dapur)");
        System.out.println("  show-order --customer <nama>  Tampilkan pesanan customer");
        System.out.println("  pay --customer <nama> --method cash|card [--cardno <nomor>]  Proses pembayaran");
        System.out.println("  process-kitchen               Proses antrian dapur (koki)");
        System.out.println("  process-delivery              Proses antrian antar (pelayan)");
    }

    private static void replLoop(RestaurantSystem sistem) {
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
        System.out.println("Memulai session CLI. Ketik 'help' untuk bantuan, 'exit' untuk keluar.");
        while (true) {
            System.out.print("> ");
            String line = sc.nextLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;
            if (line.equalsIgnoreCase("exit")) break;
            if (line.equalsIgnoreCase("help")) { usage(); continue; }
            // Tokenize line into args
            String[] args = tokenizeLine(line);
            if (args.length == 0) continue;
            // reuse main processing by calling processCommand
            processCommand(args, sistem);
        }
    }
    }

    private static String[] tokenizeLine(String line) {
        java.util.List<String> tokens = new java.util.ArrayList<>();
        boolean inQuotes = false;
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
                continue;
            }
            if (Character.isWhitespace(c) && !inQuotes) {
                if (cur.length() > 0) {
                    tokens.add(cur.toString());
                    cur.setLength(0);
                }
            } else {
                cur.append(c);
            }
        }
        if (cur.length() > 0) tokens.add(cur.toString());
        return tokens.toArray(new String[0]);
    }

    private static void processCommand(String[] args, RestaurantSystem sistem) {
        // reuse the same main processing logic but on supplied sistem
        String cmd = args.length > 0 ? args[0] : "";
        Map<String, String> opts = parseOptions(args);
        switch (cmd) {
            case "help": usage(); break;
            case "list-menu": sistem.lihatMenu(); break;
            case "list-tables": sistem.tampilkanDaftarMeja(); break;
            case "start-order": {
                String name = opts.get("--customer");
                String table = opts.get("--table");
                if (name == null || table == null) {
                    System.err.println("Opsional hilang: --customer atau --table");
                    break;
                }
                Customer c = findCustomerByName(name);
                if (c == null) {
                    System.err.println("Customer tidak ditemukan: " + name);
                    break;
                }
                try {
                    int nomor = Integer.parseInt(table);
                    sistem.mulaiPesanan(c, new Meja(nomor, "tersedia"));
                } catch (NumberFormatException e) {
                    System.err.println("Nomor meja tidak valid: " + table);
                }
            } break;
            case "add-item": {
                String name = opts.get("--customer");
                String item = opts.get("--item");
                String qty = opts.get("--qty");
                String note = opts.get("--note");
                if (name == null || item == null || qty == null) {
                    System.err.println("Opsi wajib hilang: --customer --item --qty");
                    break;
                }
                Customer c = findCustomerByName(name);
                if (c == null) { System.err.println("Customer tidak ditemukan: " + name); break; }
                MenuItem menuItem = findMenuItemByName(item);
                if (menuItem == null) { System.err.println("Menu tidak ditemukan: " + item); break; }
                try {
                    int jumlah = Integer.parseInt(qty);
                    sistem.tambahItemKePesanan(c, menuItem, jumlah, note == null ? "" : note);
                } catch (NumberFormatException e) {
                    System.err.println("Jumlah tidak valid: " + qty);
                }
            } break;
            case "confirm": {
                String name = opts.get("--customer");
                if (name == null) { System.err.println("Opsional hilang: --customer"); break; }
                Customer c = findCustomerByName(name);
                if (c == null) { System.err.println("Customer tidak ditemukan: " + name); break; }
                sistem.konfirmasiPesanan(c);
            } break;
            case "show-order": {
                String name = opts.get("--customer");
                if (name == null) { System.err.println("Opsional hilang: --customer"); break; }
                Customer c = findCustomerByName(name);
                if (c == null) { System.err.println("Customer tidak ditemukan: " + name); break; }
                sistem.tampilkanPesananCS(c);
            } break;
            case "process-kitchen": sistem.prosesDapur(); break;
            case "process-delivery": sistem.prosesAntarPesanan(); break;
            case "pay": {
                String name = opts.get("--customer");
                String method = opts.get("--method");
                String cardno = opts.get("--cardno");
                if (name == null || method == null) { System.err.println("Opsional hilang: --customer atau --method"); break; }
                Customer c = findCustomerByName(name);
                if (c == null) { System.err.println("Customer tidak ditemukan: " + name); break; }
                Pembayaran metode = null;
                if (method.equalsIgnoreCase("cash") || method.equalsIgnoreCase("tunai")) {
                    metode = new CashPayment(c.getId());
                } else if (method.equalsIgnoreCase("card") || method.equalsIgnoreCase("kartu")) {
                    if (cardno == null) { System.err.println("Opsional hilang: --cardno untuk pembayaran kartu"); break; }
                    try { int nomor = Integer.parseInt(cardno); metode = new CardPayment(c.getId(), nomor); } catch (NumberFormatException e) { System.err.println("Nomor kartu tidak valid: " + cardno); break; }
                } else { System.err.println("Metode pembayaran tidak dikenali: " + method + " (gunakan cash/tunai atau card/kartu)"); break; }
                sistem.prosesTransaksi(c, metode);
            } break;
            default: System.err.println("Perintah tidak dikenal: " + cmd); break;
        }
    }

    public static void main(String[] args) {
        RestaurantSystem sistem = new RestaurantSystem();

        if (args.length == 0) {
            // default to interactive
            System.out.println("Tidak ada perintah. Memulai mode interaktif (sama dengan aplikasi asli).\n");
                try {
                    Class<?> driver = Class.forName("RestaurantDriver");
                    java.lang.reflect.Method m = driver.getMethod("main", String[].class);
                    m.invoke(null, (Object) new String[]{});
                } catch (Exception ex) {
                    System.err.println("Gagal menjalankan mode interaktif: " + ex.getMessage());
                    ex.printStackTrace();
                }
            return;
        }

        String cmd = args[0];
        Map<String, String> opts = parseOptions(args);

        switch (cmd) {
            case "help":
                usage();
                break;
            case "interactive":
                    try {
                        Class<?> driver = Class.forName("RestaurantDriver");
                        java.lang.reflect.Method m = driver.getMethod("main", String[].class);
                        m.invoke(null, (Object) new String[]{});
                    } catch (Exception ex) {
                            System.err.println("Gagal menjalankan mode interaktif: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                break;
            case "session":
                replLoop(sistem);
                break;
            case "list-menu":
                sistem.lihatMenu();
                break;
            case "list-tables":
                sistem.tampilkanDaftarMeja();
                break;
            case "start-order": {
                String name = opts.get("--customer");
                String table = opts.get("--table");
                if (name == null || table == null) {
                    System.err.println("Opsional hilang: --customer atau --table");
                    break;
                }
                Customer c = findCustomerByName(name);
                if (c == null) {
                    System.err.println("Customer tidak ditemukan: " + name);
                    break;
                }
                try {
                    int nomor = Integer.parseInt(table);
                    sistem.mulaiPesanan(c, new Meja(nomor, "tersedia"));
                } catch (NumberFormatException e) {
                    System.err.println("Nomor meja tidak valid: " + table);
                }
            }
            break;
            case "add-item": {
                String name = opts.get("--customer");
                String item = opts.get("--item");
                String qty = opts.get("--qty");
                String note = opts.get("--note");
                if (name == null || item == null || qty == null) {
                    System.err.println("Opsi wajib hilang: --customer --item --qty");
                    break;
                }
                Customer c = findCustomerByName(name);
                if (c == null) {
                    System.err.println("Customer tidak ditemukan: " + name);
                    break;
                }
                MenuItem menuItem = findMenuItemByName(item);
                if (menuItem == null) {
                    System.err.println("Menu tidak ditemukan: " + item);
                    break;
                }
                try {
                    int jumlah = Integer.parseInt(qty);
                    sistem.tambahItemKePesanan(c, menuItem, jumlah, note == null ? "" : note);
                } catch (NumberFormatException e) {
                    System.err.println("Jumlah tidak valid: " + qty);
                }
            }
            break;
            case "confirm": {
                String name = opts.get("--customer");
                if (name == null) {
                    System.err.println("Opsional hilang: --customer");
                    break;
                }
                Customer c = findCustomerByName(name);
                if (c == null) {
                    System.err.println("Customer tidak ditemukan: " + name);
                    break;
                }
                sistem.konfirmasiPesanan(c);
            }
            break;
            case "show-order": {
                String name = opts.get("--customer");
                if (name == null) {
                    System.err.println("Opsional hilang: --customer");
                    break;
                }
                Customer c = findCustomerByName(name);
                if (c == null) {
                    System.err.println("Customer tidak ditemukan: " + name);
                    break;
                }
                sistem.tampilkanPesananCS(c);
            }
            break;
            case "process-kitchen":
                sistem.prosesDapur();
                break;
            case "process-delivery":
                sistem.prosesAntarPesanan();
                break;
            case "pay": {
                String name = opts.get("--customer");
                String method = opts.get("--method");
                String cardno = opts.get("--cardno");
                if (name == null || method == null) {
                    System.err.println("Opsional hilang: --customer atau --method");
                    break;
                }
                Customer c = findCustomerByName(name);
                if (c == null) {
                    System.err.println("Customer tidak ditemukan: " + name);
                    break;
                }
                Pembayaran metode = null;
                if (method.equalsIgnoreCase("cash") || method.equalsIgnoreCase("tunai")) {
                    metode = new CashPayment(c.getId());
                } else if (method.equalsIgnoreCase("card")) {
                    if (cardno == null) {
                        System.err.println("Opsional hilang: --cardno untuk pembayaran kartu");
                        break;
                    }
                    try {
                        int nomor = Integer.parseInt(cardno);
                        metode = new CardPayment(c.getId(), nomor);
                    } catch (NumberFormatException e) {
                        System.err.println("Nomor kartu tidak valid: " + cardno);
                        break;
                    }
                } else {
                    System.err.println("Metode pembayaran tidak dikenali: " + method + " (gunakan cash/tunai atau card/kartu)");
                    break;
                }
                sistem.prosesTransaksi(c, metode);
            }
            break;
            default:
                System.err.println("Perintah tidak dikenal: " + cmd);
                usage();
                break;
        }
    }

    private static Map<String, String> parseOptions(String[] args) {
        Map<String, String> opts = new HashMap<>();
        for (int i = 1; i < args.length; i++) {
            String a = args[i];
            if (a.startsWith("--")) {
                String key = a;
                String val = null;
                if (i + 1 < args.length && !args[i + 1].startsWith("--")) {
                    val = args[i + 1];
                    i++;
                }
                opts.put(key, val);
            }
        }
        return opts;
    }

    private static Customer findCustomerByName(String name) {
        List<Customer> customers = DatabaseManager.load("Customer.json", Customer.class);
        for (Customer c : customers) {
            if (c.getNama().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    private static MenuItem findMenuItemByName(String name) {
        List<Makanan> makanan = DatabaseManager.load("MenuMakanan.json", Makanan.class);
        for (Makanan m : makanan) {
            if (m.getNama().equalsIgnoreCase(name)) return m;
        }
        List<Minuman> minuman = DatabaseManager.load("MenuMinuman.json", Minuman.class);
        for (Minuman m : minuman) {
            if (m.getNama().equalsIgnoreCase(name)) return m;
        }
        return null;
    }
}
