public class Struk {
    
    public static void Cetak(Transaksi transaksi) {
        Pesanan p = transaksi.getPesanan();
        
        System.out.println("\n==================================");
        System.out.println("          STRUK TRANSAKSI");
        System.out.println("==================================");
        System.out.println("ID Transaksi: " + transaksi.getIdTransaksi());
        System.out.println("Meja: " + p.getMeja().getNomor() + " (" + p.getMeja().getStatus() + ")");
        System.out.println("----------------------------------");
        
        double subtotalItem = 0;
        
        for (DetailPesanan detail : p.getDaftarItem()) {
            double itemSubtotal = detail.hitungSubtotal();
            
            System.out.printf("%s (x%d) \tRp%,.0f\n", 
                              detail.getItem().getNama(), 
                              detail.getJumlah(), 
                              itemSubtotal);
            
            if (detail.getCatatan() != null && !detail.getCatatan().isEmpty()) {
                System.out.println("   Catatan: " + detail.getCatatan());
            }
            
            subtotalItem += itemSubtotal;
        }

        double totalFinal = transaksi.getTotalBayar();
        double pajakLayanan = totalFinal - subtotalItem;

        System.out.println("----------------------------------");
        System.out.printf("SUBTOTAL ITEM\t\tRp%,.0f\n", subtotalItem);
        
        if (pajakLayanan > 0) {
             System.out.printf("Pajak/Layanan\t\tRp%,.0f\n", pajakLayanan);
        }
        
        System.out.println("----------------------------------");
        System.out.printf("TOTAL BAYAR\t\tRp%,.0f\n", totalFinal);
        System.out.println("Metode Bayar: " + transaksi.getMetodePembayaran().getClass().getSimpleName());
        System.out.println("==================================");
        System.out.println("   Terima Kasih Atas Kunjungan Anda!");
        System.out.println("==================================");
    }
}
