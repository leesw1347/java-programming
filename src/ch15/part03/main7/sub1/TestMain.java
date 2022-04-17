package ch15.part03.main7.sub1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

public class TestMain {
    public static void main(String[] args) {
        // 파일경로 설정
        String path = "D:\\IO\\IO.txt";

        ObjectOutputStream oos = null;

        try {
            // ObjectOutputStream 객체생성
            oos = new ObjectOutputStream(new FileOutputStream(path));
            System.out.println("oos =" + oos);

            // 기존의 방식으로 저장
            oos.write("한글".getBytes(StandardCharsets.UTF_8));

            // 기본형 타입으로 자료 저장
            oos.writeByte(1);
            oos.writeShort(2);
            oos.writeInt(3);
            oos.writeLong(4);
            oos.writeFloat(0.1f);
            oos.writeDouble(0.2);
            oos.writeChar('가');
            oos.writeChars("나다라");
            oos.writeUTF("마바사");
            oos.writeUTF("123");

            // 참조형 타입으로 자료 저장
            ProductVo v1 = new ProductVo("a001", "아메리카노", 4000);
            ProductVo v2 = new ProductVo("a002", "카페라떼", 4300);
            ProductVo v3 = new ProductVo("a003", "카페모카", 4500);
            oos.writeObject(v1);
            oos.writeObject(v2);
            oos.writeObject(v3);

            if (oos != null) {
                oos.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
