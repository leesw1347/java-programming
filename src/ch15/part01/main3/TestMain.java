package ch15.part01.main3;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        //  폴더생성 - 절대경로 D:\\FileTest\\Dir1
        File file1 = new File("D:\\FileTest\\Dir1");
        if (!file1.exists()) {
            file1.mkdirs();
        }
        System.out.println("1. 폴더생성 - 존재여부 " + file1.exists());

        // 파일 생성 - 절대경로 "D:\\FileTest\\Dir1\\Dir2\\Test01.txt"
        File file2 = new File("D:\\FileTest\\Dir1\\Dir2\\Test01.txt");
        if (!file2.exists()) {
            File dir = file2.getAbsoluteFile().getParentFile();
            // Dir2가 존재하지 않으면 폴더까지 생성
//            System.out.println("dir의 절대경로 " + dir.getAbsolutePath()); // D:\\FileTest\\Dir1\\Dir2
            if (!dir.exists()) {
                dir.mkdirs();
            }

            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("2. 파일생성 - 존재여부 " + file2.exists());

            // '폴더' 변경 - "D:\\FileTest\\Dir1" -> D:\\FileTest로 변경
            File file3 = new File("D:\\FileTest2");
            file1.renameTo(file3);
            System.out.println("3. 폴더변경 - 존재여부 " + file3.exists());
            System.out.println("\t기존폴더 존재여부 " + file1.exists());

            // 파일변경
            // D:\\FileTest\\Dir1\\Dir2\\Test01.txt -> D:\\FileTest2\\Dir1\\Test01.txt
            File file4_1 = new File("D:\\FileTest2\\Dir2\\Test01.txt");
            File file4_2 = new File("D:\\FileTest2\\Test01.txt");
            file4_1.renameTo(file4_2);

            System.out.println("4. 파일변경 - 존재여부 " + file4_2.exists());
            System.out.println("\t기존파일 존재여부 " + file4_1.exists());

            // "폴더" 삭제 - D:\\FileTest2\\Dir1\\Dir2
            File file5 = new File("D:\\FileTest2\\Dir1\\Dir2");
            file5.delete();
            System.out.println("5. 폴더삭제 - 존재여부 " + file5.exists());

            // "파일" 삭제 - D:\\FileTest\\Dir1\\Test01.txt
            File file6 = new File("D:\\FileTest2\\Dir1\\Test01.txt");
            file6.delete();
            System.out.println("6. 파일삭제 - 존재여부 " + file6.exists());

            // 임시 "파일" 생성 및 시스템 종료 시 삭제 설정
            File file7 = null;
            try {
                file7 = File.createTempFile("tmp...", ".temp", new File("D:\\FileTest2"));
//                file7.deleteOnExit();
                System.out.println("7. 임시파일 생성 - 파일명 " + file7.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}