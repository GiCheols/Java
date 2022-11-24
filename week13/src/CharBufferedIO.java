import java.io.*;

public class CharBufferedIO {
    static void write() {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("charBIO.txt");
            bw = new BufferedWriter(fw);

            String str1 = "BufferedWriter 테스트입니다.";

            bw.write(str1);
            bw.newLine();

            bw.write("안녕하세요" + System.getProperty("line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void read() {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("charBIO.txt");
            br = new BufferedReader(fr);

            String msg;

            // 줄 단위로 파일 읽어오기
            while ((msg = br.readLine()) != null)
                System.out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
