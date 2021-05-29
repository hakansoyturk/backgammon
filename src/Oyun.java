import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.Math.abs;


public class Oyun {
    static String kaynakKareSecimi;
    static String hedefKareSecimi;
    static int xKirilanZar;
    static int yKirilanZar;
    static Scanner kareSecimiScanner = new Scanner(System.in);
    static File file = new File("Table.txt");
    static FileWriter fwriter;
    public static String alanCizimi = "";

    static {
        try {
            fwriter = new FileWriter(file, false);
        } catch (IOException e) {

        }
    }

    static BufferedWriter bWriter = new BufferedWriter(fwriter);
    static String siraKimde;

    public Oyun() {
    }


    public static HashMap<String, String> alan;

    public static void pullariDiz() {
        alan = new HashMap<>();
        alan.put("YA", "1,5,Y");
        alan.put("YB", "2, , ");
        alan.put("YC", "3, , ");
        alan.put("YD", "4, , ");
        alan.put("YE", "5,3,X");
        alan.put("YF", "6, , ");
        alan.put("YG", "7,5,X");
        alan.put("YH", "8, , ");
        alan.put("YI", "9, , ");
        alan.put("YJ", "10, , ");
        alan.put("YK", "11, , ");
        alan.put("YL", "12,2,Y");

        alan.put("XA", "0,5,X");
        alan.put("XB", "23, , ");
        alan.put("XC", "22, , ");
        alan.put("XD", "21, , ");
        alan.put("XE", "20,3,Y");
        alan.put("XF", "19, , ");
        alan.put("XG", "18,5,Y");
        alan.put("XH", "17, , ");
        alan.put("XI", "16, , ");
        alan.put("XJ", "15, , ");
        alan.put("XK", "14, , ");
        alan.put("XL", "13,2,X");
    }

    public static void main(String[] args) throws IOException {
        pullariDiz();
        tahtayiCiz();
        kimBaslayacak();
        oyna(siraKimde); // x
        while (true) {
            tahtayiCiz();
            oyna(rakibiGetir(siraKimde)); // y x y x y
            siraKimde = rakibiGetir(siraKimde); // y x y x y
        }
    }

    public static void oyna(String oyuncu) throws IOException {
        System.out.println(oyuncu + " - oyuncu zarlarini atiyor...");
        int birinciZar = zarAt();
        int ikinciZar = zarAt();
        int hamleYapilanZar;
        int hamleYapilanZarBuyuklugu = 0;

        bWriter.append(oyuncu + " " + birinciZar + " " + ikinciZar);
        System.out.println("Birinci zarinizin degeri: " + birinciZar);
        System.out.println("Ikinci zarinizin degeri: " + ikinciZar);
        System.out.println("Hangi zarla hamle yapmak istersiniz?(Birinci zar icin 1, Ikinci zar icin 2'ye basınız");
        hamleYapilanZar = kareSecimiScanner.nextInt();
        if (hamleYapilanZar == 1)
            hamleYapilanZarBuyuklugu = birinciZar;
        else if (hamleYapilanZar == 2)
            hamleYapilanZarBuyuklugu = ikinciZar;
        else
            System.out.println("Yanlis girdi");
        for (int i = 0; i < 2; i++) {
            System.out.println("OYNANAN ZAR " + hamleYapilanZarBuyuklugu);
            System.out.println("Hangi koordinattaki pulunuzu oynamak istersiniz?");
            kaynakKareSecimi = kareSecimiScanner.next();
            if (gecerliKareMi(oyuncu, kaynakKareSecimi)) {
                System.out.println("Hangi kareye oynamak istersiniz?");
                hedefKareSecimi = kareSecimiScanner.next();
                String rakip = rakibiGetir(oyuncu);
                if (oynanacakKareGecerliMi(hamleYapilanZarBuyuklugu, rakip,oyuncu)) {
                    alaniAzalt(kaynakKareSecimi, oyuncu);
                    alaniArttir(hedefKareSecimi, oyuncu);
                }
                if (hamleYapilanZarBuyuklugu == birinciZar) {
                    hamleYapilanZarBuyuklugu = ikinciZar;
                } else {
                    hamleYapilanZarBuyuklugu = birinciZar;
                }
            } else {
                i--;
                System.out.println("Gecersiz Kare!");
            }
        }
    }

    public static void alaniAzalt(String adres, String oyuncu) {
        String hucre = alan.get(adres); // 1,5,Y
        String[] parcaliAlan = hucre.split(",");
        int deger = Integer.parseInt(parcaliAlan[1]);
        --deger;
        parcaliAlan[1] = String.valueOf(deger);
        parcaliAlan[2] = oyuncu;
        hucre = "";
        // elemanlari birbirine bagladim 1,2,3 seklinde
        for (int i = 0; i < 3; i++) {
            hucre += parcaliAlan[i];
            if (i != 2) {
                // son elemandan sonra virgul olmamali
                hucre += ",";
            }
        }// guncelleme icin put yapmak gerekli
        alan.put(adres, hucre);
    }

    public static void alaniArttir(String adres, String oyuncu) {
        String hucre = alan.get(adres);
        String[] parcaliAlan = hucre.split(",");
        if (parcaliAlan[1].equals(" ")) {
            parcaliAlan[1] = "1";
        } else {
            int kareDegeri = Integer.parseInt(parcaliAlan[1]);
            ++kareDegeri;
            parcaliAlan[1] = String.valueOf(kareDegeri);
        }
        parcaliAlan[2] = oyuncu;
        hucre = "";
        for (int i = 0; i < 3; i++) {
            hucre += parcaliAlan[i];
            if (i != 2) {
                hucre += ",";
            }
        }
        alan.put(adres, hucre);
    }

    public static String rakibiGetir(String kisi) {
        return (kisi.equals("Y")) ? "X" : "Y";
    }

    static void tahtayiCiz() {
        Stream<Map.Entry<String, String>> ustRaf = alan.entrySet().stream().filter(stringStringEntry -> stringStringEntry.getKey().startsWith("Y"));
        Stream<Map.Entry<String, String>> altRaf = alan.entrySet().stream().filter(stringStringEntry -> stringStringEntry.getKey().startsWith("X"));
        ustRaf.forEach(stringStringEntry -> {
            String[] parsedValue = stringStringEntry.getValue().split(",");
            if (parsedValue[1].equals(" ") && parsedValue[2].equals(" ")) {
                alanCizimi += "  ";
            } else {
                alanCizimi += (parsedValue[1] + parsedValue[2]);
            }
        });
        alanCizimi += "\n";
        altRaf.forEach(stringStringEntry -> {
            String[] parsedValue = stringStringEntry.getValue().split(",");
            if (parsedValue[1].equals(" ") && parsedValue[2].equals(" ")) {
                alanCizimi += "  ";
            } else {
                alanCizimi += (parsedValue[1] + parsedValue[2]);
            }
        });
        System.out.println(alanCizimi);
        // TODO write to file
        alanCizimi = "";
    }

    static boolean gecerliKareMi(String oyuncu, String kare) {
        return (!alan.get(kare).split(",")[1].equals(" ")) && (alan.get(kare).split(",")[2].equals(oyuncu));
    }

    static boolean oynanacakKareGecerliMi(int zar, String rakipOyuncu,String oyuncu) {
        int hedefKare = Integer.parseInt(alan.get(hedefKareSecimi).split(",")[0]);
        int kaynakKare = (Integer.parseInt(alan.get(kaynakKareSecimi).split(",")[0]));
        if (!(abs(hedefKare - kaynakKare) == zar)) {
            return false;
        }
        // oyuncu kendi alani ise de gelebilir
        if (alan.get(hedefKareSecimi).split(",")[2].equals(oyuncu)) {
            return true;
        } else if (alan.get(hedefKareSecimi).split(",")[1].equals(" ")) {
            return true;
        } else if (alan.get(hedefKareSecimi).split(",")[2].equals(1 + rakipOyuncu)) {
            yKirilanZar++;
            return true;
        } else {
            return false;
        }
    }

    static int zarAt() {
        Random rand = new Random();
        return (rand.nextInt(6) + 1);
    }

    static boolean oyunBittiMi() {
        return (alan.get("XG").split(",")[1].equals(" ") && alan.get("XH").split(",")[1].equals(" ") && alan.get("XI").split(",")[1] == " " && alan.get("XJ").split(",")[1] == " " && alan.get("XK").split(",")[1] == " " && alan.get("XL").split(",")[1] == " ") ||
            ((alan.get("YG").split(",")[1].equals(" ") && alan.get("YH").split(",")[1].equals(" ") && alan.get("YI").split(",")[1] == " " && alan.get("YJ").split(",")[1] == " " && alan.get("YK").split(",")[1] == " " && alan.get("YL").split(",")[1] == " "));
    }

    static int kimBaslayacak() throws IOException {
        System.out.print("Oyuna baslamak icin h tusuna basiniz");
        Scanner girdi = new Scanner(System.in);
        String sonuc = girdi.next();
        if (sonuc.equals("h")) {
            int zar1, zar2;
            zar1 = zarAt();
            zar2 = zarAt();
            if (zar1 > zar2) {
                System.out.println("Birinci oyuncunun zari: " + zar1);
                System.out.println("Ikinci oyuncunun zari: " + zar2);
                System.out.println("Oyuna birinci oyuncu baslayacak.");
                siraKimde = "X";
                bWriter.write(String.valueOf(zar1));
                bWriter.newLine();
                bWriter.write(String.valueOf(zar2));
                bWriter.newLine();

                return zar1;
            } else if (zar2 > zar1) {
                System.out.println("Birinci oyuncunun zari: " + zar1);
                System.out.println("Ikinci oyuncunun zari: " + zar2);
                System.out.println("Oyuna ikinci oyuncu baslayacak.");
                siraKimde = "Y";
                bWriter.write(String.valueOf(zar1));
                bWriter.newLine();
                bWriter.write(String.valueOf(zar2));
                bWriter.newLine();

                return zar2;
            } else {
                System.out.println("Birinci oyuncunun zari: " + zar1);
                System.out.println("Ikinci oyuncunun zari: " + zar2);
                System.out.println("Zarlar esit... Zarlar tekrar atiliyor...");
                kimBaslayacak();
            }
        }
        return 0;
    }

}
