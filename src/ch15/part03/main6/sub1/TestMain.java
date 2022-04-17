package ch15.part03.main6.sub1;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TestMain {
    public static void main(String[] args) {
        // 임의의 저장경로 지정 (부모경로는 반드시 존재해야함)
        String path = "D:\\IO\\IO.txt";

        DataOutputStream dos = null;

        try {
            // DataOutputStream 객체생성
            dos = new DataOutputStream(new FileOutputStream(path));

            // 기존방식의 자료 입력
            byte[] by1 = "한글1".getBytes();
            dos.write(by1);

            // 기본형 자료 입력
            dos.writeByte(1); // byte 타입
            dos.writeShort(2); // short 타입
            dos.writeInt(3); // int 타입
            dos.writeLong(4); // long 타입
            dos.writeFloat(0.1F); // float 타입
            dos.writeDouble(0.2); // double 타입
            dos.writeChar('가'); // char 타입
            dos.writeBoolean(true); // boolean 타입

            // String 자료 입력
            dos.writeUTF("DataOutputStream 연습"); // String 타입
            dos.writeUTF("쓰기"); // String 타입

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 종료작업
        try {
            if (dos != null) {
                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 운영시스템으로 해당 파일실행
        try {
            File file = new File(path);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}