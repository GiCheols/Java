import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileCopy {
    String srcFileName;
    String destFileName;

    ByteFileCopy(String srcFileName, String destFileName) {
        this.srcFileName = srcFileName;
        this.destFileName = destFileName;
    }

    void copy() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFileName);
            fos = new FileOutputStream(destFileName);

            int bData;
            int cnt = 0;
            while (true) {
                // IException 발생 가능함
                bData = fis.read();
                // 유효한 데이터를 읽을 수 없다면 == 파일 끝에 도달했다면
                if (bData == -1)
                    break;
                fos.write(bData);
                cnt++;
            }

            System.out.println("복사된 바이트: " + cnt);

        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
            System.err.println(" - 복사를 취소합니다!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //예외가 발생했던 안했던 실행되는 finally 문
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ByteFileCopy bcopy = new ByteFileCopy("original.jpg"
                , "target.jpg");
        bcopy.copy();
    }
}
