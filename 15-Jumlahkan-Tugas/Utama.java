//3456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 
public class Utama {
    public static void main(String[] args) {
        // Bangkitkan data untuk menghitung
        double[] data = new double[BANYAK_DATA];
        for (int cnt=0; cnt<data.length; ++ cnt)
            data[cnt] = cnt * 2;
        
        // Hitung dengan memakai Thread
        long start = System.currentTimeMillis(); // Start timer
        Gabung gabung = new Gabung(data);        // Hitung
        long end = System.currentTimeMillis();   // Stop timer
        // Tampilkan hasil
        System.out.printf("Hasil perhitungan paralel = %f\n", gabung.hasil());        
        System.out.printf("Waktu = %dms\n\n", end-start);        
        
        // Hitung secara manual
        start = System.currentTimeMillis();         // Start timer
        double hasil = 0;                           // Hitung
        for (int cnt = 0; cnt<BANYAK_DATA; ++cnt)   // Hitung
            hasil += data[cnt];                     // Hitung
        end = System.currentTimeMillis();           // Stop timer
        // Tampilkan hasil
        System.out.printf("Hasil perhitungan serial = %f\n", hasil);        
        System.out.printf("Waktu = %dms\n\n", end-start);        
    }
    
    // Banyaknya data yang akan dihitung
    private final static int BANYAK_DATA = 100000000;
}
