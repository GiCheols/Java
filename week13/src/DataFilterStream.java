import java.io.*;

public class DataFilterStream {

    static void save() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        //파일에 저장
        try {
            fos = new FileOutputStream("data.bin");
            dos = new DataOutputStream(fos);

            dos.writeInt(123);
            dos.writeDouble(3.14);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) dos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void load() {
        FileInputStream fis = null;
        DataInputStream dis = null;

        //파일로부터 읽어 들임
        try {
            // 만약 세개의 스트림 객체를 사용한다고 할 때 가장 종단에 있는 객체는 무엇?
            // A. 데이터의 타입으로 사용자에게 보여주고 싶을테니, 데이터스트림객체!
            fis = new FileInputStream("data.bin");
            dis = new DataInputStream(fis);

            int n = dis.readInt();
            double pi = dis.readDouble();

            System.out.println("> " + n);
            System.out.println("> " + pi);
        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dis != null) dis.close();
                if(fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void bufferedSave() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;

        // 파일에 저장
        try {
            fos = new FileOutputStream("data.bin");
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            dos.writeInt(123);
            dos.writeDouble(3.14);

            dos.flush();
        } catch (FileNotFoundException e){
            System.err.print(e.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dos != null) dos.close();
                if(bos != null) bos.close();
                if(fos != null) fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static void bufferedLoad() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("data.bin");
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            int n = dis.readInt();
            double pi = dis.readDouble();

            System.out.println("> " + n);
            System.out.println("> " + pi);
        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis!=null) dis.close();
                if(dis != null) dis.close();
                if(fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //save();
        //load();

        bufferedSave();
        bufferedLoad();
    }
}
