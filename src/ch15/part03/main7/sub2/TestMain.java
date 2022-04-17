package ch15.part03.main7.sub2;

import ch15.part03.main7.sub1.ProductVo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestMain {
    public static void main(String[] args) {

        // ObjectOutputStrea으로 쓰기작업 한 파일을 읽는다
        String path = "D:\\IO\\IO.txt";
        ObjectInputStream ois = null;

        try {
            // ObjectInputStream 객체생성
            ois = new ObjectInputStream(new FileInputStream(path));

            // 기존방식으로 자료 읽기
            byte[] by = new byte["한글".getBytes().length];
            int read = ois.read(by);
            if (read != -1) {
                System.out.println(new String(by));
            }

            /**
             * 기본형 타입의 자료 일긱
             * ObjectOutputStream으로 보낸 순서와 같이 readXXX() 사용
             */
            System.out.println(ois.readByte());
            System.out.println(ois.readShort());
            System.out.println(ois.readInt());
            System.out.println(ois.readLong());
            System.out.println(ois.readFloat());
            System.out.println(ois.readDouble());
            System.out.println(ois.readChar());
            System.out.println(ois.readChar());
            System.out.println(ois.readChar());
            System.out.println(ois.readChar());
            System.out.println(ois.readUTF());
            System.out.println(ois.readUTF());

            // 참조형 타입의 자료 읽기
            ProductVo p1 = (ProductVo) ois.readObject();
            ProductVo p2 = (ProductVo) ois.readObject();
            ProductVo p3 = (ProductVo) ois.readObject();

            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 종료작업
        try {
            if (ois != null) {
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}