import java.io.FileWriter;
import java.io.IOException;

public class CariPrima {
    public static void main() throws IOException {
        // Buat berkas untuk menulis hasil. Pakai WRITER karena yang ditulis 
        // berkas text.
        FileWriter berkas = new FileWriter(NAMA_BERKAS);
        
        // Buat array dari thread
        BenarPrima[] benarPrima = new BenarPrima[JUMLAH_THREAD];
        Thread [] t = new Thread[JUMLAH_THREAD];
        // Mulai hitung dari angka 2, karena 1 otomatis bukan prima
        int angka = 2;
        // Loop sampai batas atas yang diminta
        while (angka<=ANGKA_TERBESAR) {
            for(int i = 0; i<JUMLAH_THREAD; i++) 
            {
                benarPrima[i] = new BenarPrima(angka);
                t[i] = new Thread(benarPrima[i]);
                angka++;
            }
            
            for(int c = 0; c<JUMLAH_THREAD; ++c)
                t[c].start();
                
            for(int c = 0; c<JUMLAH_THREAD; ++c)
                while(benarPrima[c].selesai() == false){
                }
                
            for(int i = 0; i<JUMLAH_THREAD; i++)
            {
                if(benarPrima[i].selesai())
                {
                    if(benarPrima[i].prima())
                    {
                        synchronized(berkas)
                        {
                            try
                            {
                                berkas.write(benarPrima[i].angka()+"\n");
                            }
                            catch(IOException kesalahan)
                            {
                                System.out.printf("Terjadi Kesalahan : %s", kesalahan);
                            }
                        }
                    }
                }
            }
        }
        
        berkas.close();
    }
    
    private final static String NAMA_BERKAS = "prima.log";
    private final static int JUMLAH_THREAD = 10;
    private final static int ANGKA_TERBESAR = 100000;
}