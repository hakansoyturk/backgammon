import com.sun.deploy.nativesandbox.NativeSandboxOutputStream;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

import static java.lang.Math.abs;


public class Oyun {
    static String kaynakKareSecimi;
    static String hedefKareSecimi;
    static int xKirilanZar;
    static int yKirilanZar;
    static Scanner kareSecimiScanner = new Scanner(System.in);
    static File file = new File("Table.txt");
    static FileWriter fwriter;

    static {
        try {
            fwriter = new FileWriter(file, false);
        } catch (IOException e) {

        }
    }

    static BufferedWriter bWriter = new BufferedWriter(fwriter);
    static String siraKimde;

    public Oyun() throws IOException {
    }

    static boolean gecerliKareMi(String oyuncu,String kare) {
        if((!alan.get(kare).split(",")[1].equals(" ")) && (alan.get(kare).split(",")[2].equals(oyuncu))) {
                return true;
        }
        else
            return false;

    }
    static boolean oynanacakKareGecerliMi(int zar,String rakipOyuncu){
        if(((abs(Integer.valueOf(alan.get(hedefKareSecimi).split(",")[0]) -(Integer.valueOf(alan.get(kaynakKareSecimi).split(",")[0])))< zar)
                &&(alan.get(hedefKareSecimi).split(",")[1]==" "))) {

            return true;
        }
        else if(((abs(Integer.valueOf(alan.get(hedefKareSecimi).split(",")[0]) -(Integer.valueOf(alan.get(kaynakKareSecimi).split(",")[0])))< zar)
                &&(alan.get(hedefKareSecimi).split(",")[2]==1+rakipOyuncu))) {
            yKirilanZar++;
            return true;
        }
        else
            return false;
    }

    static void tahtayiCiz() {
        String xa = alan.get("XA");
        String xb = alan.get("XB");
        String xc = alan.get("XC");
        String xd = alan.get("XD");
        String xe = alan.get("XE");
        String xf = alan.get("XF");
        String xg = alan.get("XG");
        String xh = alan.get("XH");
        String xi = alan.get("XI");
        String xj = alan.get("XJ");
        String xk = alan.get("XK");
        String xl = alan.get("XL");

        String ya = alan.get("YA");
        String yb = alan.get("YB");
        String yc = alan.get("YC");
        String yd = alan.get("YD");
        String ye = alan.get("YE");
        String yf = alan.get("YF");
        String yg = alan.get("YG");
        String yh = alan.get("YH");
        String yi = alan.get("YI");
        String yj = alan.get("YJ");
        String yk = alan.get("YK");
        String yl = alan.get("YL");


        String[] dizi = ya.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }

        }


        dizi = yb.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yc.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yd.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = ye.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yf.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yg.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yh.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yi.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yj.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.print("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yk.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.println("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }
        dizi = yl.split(",");
        for (int m = 1; m < 3; m++) {
            if (dizi[m] == " ") {
                System.out.println("    ");
                break;
            } else {
                System.out.print(dizi[m]);
                if (m == 2) {
                    System.out.print("    ");
                }
            }


        }

    }

    static int zarAt() {
        Random rand = new Random();
        return (rand.nextInt(6) + 1);
    }

    static boolean oyunBittiMi() {
        if ((alan.get("XG").split(",")[1] == " " && alan.get("XH").split(",")[1] == " " && alan.get("XI").split(",")[1] == " " && alan.get("XJ").split(",")[1] == " " && alan.get("XK").split(",")[1] == " " && alan.get("XL").split(",")[1] == " ") ||
                ((alan.get("YG").split(",")[1] == " " && alan.get("YH").split(",")[1] == " " && alan.get("YI").split(",")[1] == " " && alan.get("YJ").split(",")[1] == " " && alan.get("YK").split(",")[1] == " " && alan.get("YL").split(",")[1] == " "))) {
            return true;
        }
        return false;
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
            } else if (zar1 == zar2) {
                System.out.println("Birinci oyuncunun zari: " + zar1);
                System.out.println("Ikinci oyuncunun zari: " + zar2);
                System.out.println("Zarlar esit... Zarlar tekrar atiliyor...");
                kimBaslayacak();
            }
        }
        return 0;
    }

    public static HashMap<String, String> alan;

    public static void main(String[] args) throws IOException {
        int sayac=0;
        alan = new HashMap<>();
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
        kimBaslayacak();
        //  while(oyunBittiMi()==false){
        if(sayac==0) {
            if (siraKimde == "X") {
                System.out.println("Birinci oyuncu zarlarini atiyor...");
                int xBirinciZari = zarAt();
                int xIkinciZari = zarAt();
                int hamleYapilanZar;
                int hamleYapilanZarBuyuklugu = 0;
                int azaltilanKare;
                int artirilanKare;
                bWriter.append("X");
                bWriter.append(" ");
                bWriter.append(String.valueOf(xBirinciZari));
                bWriter.append(" ");
                bWriter.append(String.valueOf(xIkinciZari));
                System.out.println("Birinci zarinizin degeri: " + xBirinciZari);
                System.out.println("Ikinci zarinizin degeri: " + xIkinciZari);
                System.out.println("Hangi zarla hamle yapmak istersiniz?(Birinci zar icin 1, Ikinci zar icin 2'ye basınız");
                hamleYapilanZar = kareSecimiScanner.nextInt();
                if (hamleYapilanZar == 1) {
                    hamleYapilanZarBuyuklugu = xBirinciZari;
                } else if (hamleYapilanZar == 2)
                    hamleYapilanZarBuyuklugu = xIkinciZari;
                else
                    System.out.println("Yanlis girdi");

                System.out.println("Hangi koordinattaki pulunuzu oynamak istersiniz?");
                kaynakKareSecimi = kareSecimiScanner.next();
                if (gecerliKareMi("X", kaynakKareSecimi)==true) {
                    System.out.println("Hangi kareye oynamak istersiniz?");
                    hedefKareSecimi = kareSecimiScanner.next();
                    if (oynanacakKareGecerliMi(hamleYapilanZarBuyuklugu, "Y") == true) {
                        azaltilanKare = Integer.parseInt(alan.get(kaynakKareSecimi).split(",")[1]);
                        azaltilanKare--;
                        alan.get(kaynakKareSecimi).split(",")[1] = String.valueOf(azaltilanKare);

                        artirilanKare = Integer.parseInt(alan.get(hedefKareSecimi).split(",")[1]);
                        artirilanKare++;
                        alan.get(hedefKareSecimi).split(",")[1] = String.valueOf(artirilanKare);
                        sayac++;
                    }
                } else
                    System.out.println("Gecersiz Kare!");
            }
        }else if(sayac==1) {
            int yBirinciZari = zarAt();
            int yIkinciZari = zarAt();
            bWriter.append("Y");
            bWriter.append(" ");
            bWriter.append(String.valueOf(yBirinciZari));
            bWriter.append(" ");
            bWriter.append(String.valueOf(yIkinciZari));

        }

    }

    //  }
}
