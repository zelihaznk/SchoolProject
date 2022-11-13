import java.io.*;
import java.util.Scanner;

public class Ogrenci {
    //Ogrenciler icin Ad,Soyad, kimlik, dogum yili, okul no,sinif, sube bilgileri olmali
    //Soyisim veya sinif/sube bilgisi ile silme olmayacaktir

    static Scanner scan = new Scanner(System.in);

    public static void ogrenciMenu() throws InterruptedException, FileNotFoundException {
        String tercih = "";

        do {
            System.out.println("" +
                    "============= YILDIZ KOLEJI =============\n" +
                    "=========== OGRENCI MENU ============\n" +
                    "1- Ogrenciler Listesi Yazdir\n" +
                    "2- Soyisimden Ogrenci Bulma\n" +
                    "3- Okul No ile Ogrenci Bulma\n" +
                    "4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                    "5- Kimlik No Ile Kayit Silme\n" +
                    "A- ANAMENU\n" +
                    "Q- CIKIS");

            tercih = scan.nextLine();

            switch (tercih) {
                case "1": //  1- Ogrenciler Listesi Yazdir
                    ogrenciGetir();
                    break;
                case "2": //2- Soyisimden Ogrenci Bulma
                    soyisimdenOgrenciBulma();
                    break;
                case "3": // 3- Okul No ile Ogrenci Bulma
                    okulNodanOgrenciBulma();
                    break;
                case "4": // 4- Bilgilerini Girerek Ogrenci Ekleme
                    ogrenciEkle();
                    break;
                case "5": // 5- Kimlik No Ile Kayit Silme
                    tcNoIleOgrenciSil();
                    break;
                case "A":
                case "a":
                    Depo.anaMenu();
                    break;
                case "Q":
                case "q":
                    Depo.projeDurdur();
                    break;
                default:
                    System.out.println("Lutfen gecerli tercih yapiniz");


            }
        } while (!tercih.equalsIgnoreCase("q"));


        Depo.projeDurdur();


    }

    public static void tcNoIleOgrenciSil() {

        System.out.println("");
        int index = 0;
        String tempFile = "temp.txt";

        System.err.println("Lutfen silmek istediginiz tcNo giriniz");
        String removeTerm = scan.nextLine();

        File oldFile = new File("src/ogrenciler1.txt");
        File newFile = new File(tempFile);

        String currentLine;
        String data[];

        try {

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("src/ogrenciler1.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(", ");
                if (!(data[0].equalsIgnoreCase(removeTerm))) {
                    pw.println(currentLine);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            oldFile.delete();
            File dump = new File("src/ogrenciler1.txt");
            newFile.renameTo(dump);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ogrenciEkle() {
        System.out.println("Tc No");
        String tcNo = scan.nextLine();

        System.out.println("isim");
        String isim = scan.nextLine();

        System.out.println("soyisim");
        String soyisim = scan.nextLine();

        System.out.println("D.yili");
        String dYili = scan.nextLine();

        System.out.println("Okul No");
        String okulNo = scan.nextLine();

        System.out.println("Sinif");
        String sinif = scan.nextLine();

        System.out.println("Sube");
        String sube = scan.nextLine();

        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("src/ogrenciler1.txt", true));
            write.newLine();
            write.write(tcNo + ", " + isim + ", " + soyisim + ", " + dYili + ", "
                    + okulNo + ", " + sinif + ", " + sube);
            System.out.println("Dosyaya yazildi");
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void okulNodanOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogrencinin Okul No yaziniz giriniz : ");
        String arananOkulNo = scan.nextLine();


        System.out.println("============= YILDIZ KOLEJI =============\n" +
                "========== Soyisim Ile Ogrenci Arama ============\n" +
                "TC.NO     ISIM       SOYISIM     D.YILI     OkulNo    Sinif    Sube");


        File file = new File("src/ogrenciler1.txt");

        try {
            Scanner scan = new Scanner(file);

            String[] ogrenciArr;
            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                ogrenciArr = line.split(", ");
                if (arananOkulNo.equalsIgnoreCase(ogrenciArr[4])) {
                    System.out.printf("%11s %-8s %-8s %8s %8s %8s %5s\n",
                            ogrenciArr[0], ogrenciArr[1], ogrenciArr[2], ogrenciArr[3],
                            ogrenciArr[4], ogrenciArr[5], ogrenciArr[6]);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);


    }

    public static void soyisimdenOgrenciBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogrencinin soyadini giriniz : ");
        String arananSoyisim = scan.nextLine();


        System.out.println("============= YILDIZ KOLEJI =============\n" +
                "========== Soyisim Ile Ogrenci Arama ============\n" +
                "TC.NO     ISIM       SOYISIM     D.YILI     OkulNo    Sinif    Sube");


        File file = new File("src/ogrenciler1.txt");

        try {
            Scanner scan = new Scanner(file);

            String[] ogrenciArr;
            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                ogrenciArr = line.split(", ");

                if (arananSoyisim.equalsIgnoreCase(ogrenciArr[2])) {
                    System.out.printf("%11s %-8s %-8s %8s %8s %8s %5s\n",
                            ogrenciArr[0], ogrenciArr[1], ogrenciArr[2], ogrenciArr[3],
                            ogrenciArr[4], ogrenciArr[5], ogrenciArr[6]);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
    }


    public static void ogrenciGetir() {


        System.out.println("============= YILDIZ KOLEJI =============\n" +
                "=========== OGRENCI MENU ============\n" +
                "Tc No       İsim   Soyisim     D Yılı    OkulNo     Sınıf   Sube");
        File file = new File("src/ogrenciler1.txt");

        try {
            Scanner scan = new Scanner(file);

            String[] ogrenciArr;

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                ogrenciArr = line.split(", ");
                System.out.printf("%11s %-8s %-8s %8s %8s %8s %5s\n",
                        ogrenciArr[0], ogrenciArr[1], ogrenciArr[2], ogrenciArr[3],
                        ogrenciArr[4], ogrenciArr[5], ogrenciArr[6]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*

    ===> BURADAKİ KODLARLA RENKLENDİRME YAPILIR. <===

    public static final String SET_ITALIC_TEXT = "\033[0;3m";
    public static final String SET_ALTICIZILI_TEXT = "\033[0;4m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

     */
}