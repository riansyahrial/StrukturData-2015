public class Profil {
    private String nama = "Rian Syahrial";
    private String nim = "1408107010061";
    
    public Profil () {
        
        
    }
    
    
    public Profil (String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    
    public String getNama () {
        return nama;
    }
    
    public String getNim () {
        return nim;
    }
}