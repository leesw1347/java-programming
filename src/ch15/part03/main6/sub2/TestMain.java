package ch15.part03.main6.sub2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        // DataOutputStream에서 쓰기작업을 한 파일을 대상으로 함
        String path = "D:\\IO\\IO.txt";

        DataInputStream dis = null;
        try {
            // DataInputStream 객체생성
            dis = new DataInputStream(new FileInputStream(path));

            // 기존방식의 입력된 자료 읽기
            // dos.write("한글1".getBytes()));
            byte[] by = new byte["한글1".getBytes().length];
            int read = dis.read(by);
            System.out.println(new String(by, 0, read));

            // 기본형의 입력된 자료 읽기
            // dos.writeByte() -> dis.readByte()
            System.out.println("readByte() = " + dis.readByte());

            // dos.writeShort(2) -> dis.readShort()
            System.out.println("readShort() = " + dis.readShort());

            // dos.writeInt(3); -> dis.readInt()
            System.out.println("readInt() = " + dis.readInt());

            // dos.writeLong(4) -> dis.readLong()
            System.out.println("readLong() = " + dis.readLong());

            // dos.writeFloat(0.1F) -> dos.readFloat()
            System.out.println("readFloat() = " + dis.readFloat());

            // dos.writeDouble(0.2) -> dos.readDouble()
            System.out.println("readDouble() = " + dis.readDouble());

            // dos.writeChar("가") -> dos.readChar()
            System.out.println("readChar() = " + dis.readChar());

            // dos.writeBoolean(true) -> dos.readBoolean()
            System.out.println("readBoolean() = " + dis.readBoolean());

            // String 타입으로 입력된 자료 읽기
            // dos.writeUTF("DataOutputStream 연습") - >dis.readUTF()
            System.out.println("readUTF() = " + dis.readUTF());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (dis != null) {
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
