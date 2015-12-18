import java.net.Socket; 
2 import java.net.UnknownHostException; 
3 
 
4 import java.io.IOException; 
5 import java.io.InputStreamReader; 
6 import java.io.Reader; 
7 import java.io.BufferedReader; 
8 
 
9 import java.io.OutputStreamWriter; 
10 import java.io.Writer; 
11 import java.io.BufferedWriter; 
12 
 
13 import java.util.Scanner; 
14 
 
15 public class Client { 
16     public void chat()  
17                 throws UnknownHostException, IOException { 
18         Socket socket = new Socket("localhost", 33333); 
19          
20         try { 
21             // Ketik 
22             Scanner keyboard = new Scanner(System.in); 
23             System.out.print("Pesan: "); 
24             String ketikanSatuBaris = keyboard.nextLine(); 
25                      
26             // Tulis ke socket 
27             Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream());  
28             BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter); 
29             keluaranBuff.write(ketikanSatuBaris); 
30             keluaranBuff.write("\n"); 
31             keluaranBuff.flush(); 
32                  
33             // Baca dari Server 
34             System.out.print("Dari server: "); 
35             Reader masukan = new InputStreamReader(socket.getInputStream());  
36             BufferedReader masukanBuff = new BufferedReader(masukan); 
37             String baris = masukanBuff.readLine(); 
38             System.out.println(baris);              
39              
40             // Mengupperkan apa yang dituliskan oleh server 
41             String diupperkan; 
42             diupperkan = baris.toUpperCase();             
43             keluaranBuff.write(diupperkan); 
44             keluaranBuff.flush();             
45             System.out.println("Pesan server yang telah diupperkan sudah terkirim"); 
46         } 
47         catch(IOException salah) { 
48             System.out.println(salah); 
49         } 
50         finally { 
51             if (socket != null) 
52             socket.close(); 
53         } 
54     } 
55 } 
import java.net.Socket; 
2 import java.net.UnknownHostException; 
3 
 
4 import java.io.IOException; 
5 import java.io.InputStreamReader; 
6 import java.io.Reader; 
7 import java.io.BufferedReader; 
8 
 
9 import java.io.OutputStreamWriter; 
10 import java.io.Writer; 
11 import java.io.BufferedWriter; 
12 
 
13 import java.util.Scanner; 
14 
 
15 public class Client { 
16     public void chat()  
17                 throws UnknownHostException, IOException { 
18         Socket socket = new Socket("localhost", 33333); 
19          
20         try { 
21             // Ketik 
22             Scanner keyboard = new Scanner(System.in); 
23             System.out.print("Pesan: "); 
24             String ketikanSatuBaris = keyboard.nextLine(); 
25                      
26             // Tulis ke socket 
27             Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream());  
28             BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter); 
29             keluaranBuff.write(ketikanSatuBaris); 
30             keluaranBuff.write("\n"); 
31             keluaranBuff.flush(); 
32                  
33             // Baca dari Server 
34             System.out.print("Dari server: "); 
35             Reader masukan = new InputStreamReader(socket.getInputStream());  
36             BufferedReader masukanBuff = new BufferedReader(masukan); 
37             String baris = masukanBuff.readLine(); 
38             System.out.println(baris);              
39              
40             // Mengupperkan apa yang dituliskan oleh server 
41             String diupperkan; 
42             diupperkan = baris.toUpperCase();             
43             keluaranBuff.write(diupperkan); 
44             keluaranBuff.flush();             
45             System.out.println("Pesan server yang telah diupperkan sudah terkirim"); 
46         } 
47         catch(IOException salah) { 
48             System.out.println(salah); 
49         } 
50         finally { 
51             if (socket != null) 
52             socket.close(); 
53         } 
54     } 
55 } 
qweeeeeeee