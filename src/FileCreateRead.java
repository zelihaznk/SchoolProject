import java.io.*;

public class FileCreateRead {
    public static void main(String[] args) throws IOException {
        File file = new File("kod.txt"); // kod.txt dosyası oluşturması bilgisi verilir.

        if (!file.exists()){
            file.createNewFile(); // eğer bilgideki kod.txt dosyası yoksa oluşturur.
        }

      /*
                File class'ındaki bir kaç tane method denemesi
       System.out.println("file.getName() = " + file.getName());
       System.out.println("file.canRead() = " + file.canRead());
       System.out.println("file.canWrite() = " + file.canWrite());
       System.out.println("file.toPath() = " + file.toPath());
       System.out.println("file.getPath() = " + file.getPath());
       */

        String text = "Dosya açtım ve içine yazdım";

        FileWriter fWriter = new FileWriter(file,false);
        BufferedWriter bWriter = new BufferedWriter(fWriter); // Yazma işini hızlandıran bir class'tır. Arada tampon görevini görür

        bWriter.write(text);
        bWriter.write("\nBugün dosya içine text yazmayı ve okutmayı öğrendim.");
        bWriter.close();// her yazmadan sonra dosyaya erişimi kapat

        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);// Okuma işini hızlandıran bir class'tır. Arada tampon görevini görür
        String line;

        while((line = bReader.readLine()) != null){
            System.out.println(line);
        }

        bReader.close(); // her okumadan sonra dosyaya erişimi kapat
    }
}

