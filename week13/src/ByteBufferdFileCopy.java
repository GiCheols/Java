import java.io.*;

public class ByteBufferdFileCopy {
    String srcFileName;
    String destFileName;

    ByteBufferdFileCopy(String srcFileName, String destFileName) {
        this.srcFileName = srcFileName;
        this.destFileName = destFileName;
    }

    void copy() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            //bis & bos는 버퍼링을 이용한 형태로 입출력
            fis = new FileInputStream(srcFileName);
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream(destFileName);
            bos = new BufferedOutputStream(fos);

            int bData;
            int cnt = 0;
            while (true) {
                bData = bis.read();
                if (bData == -1)
                    break;
                bos.write(bData);
                cnt++;
            }

            //bos.flush();

            System.out.println("복사된 바이트: " + cnt);

        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
            System.err.println(" - 복사를 취소합니다!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //예외가 발생했던 안했던 실행되는 finally 문
            try {
                if (bis != null) bis.close();
                if (fis != null) fis.close();
                if (bos != null) bos.close();
                if (fos != null) fos.close();
                // 스트림 객체가 닫혀지는 순간에 알아서 flush() 됨
                // 그러므로 닫는 순서 유의할 것, fis를 먼저 닫으면 파일에 안쓰여지니까 ㅇㅇ
                // 상관 없이 하려면 flush() 사용할 것
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ByteBufferdFileCopy bcopy = new ByteBufferdFileCopy("original.jpg"
                , "target.jpg");
        bcopy.copy();
    }
}
