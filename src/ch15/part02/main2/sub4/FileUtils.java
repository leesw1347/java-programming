package ch15.part02.main2.sub4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtils {
    // 파일 대상 경로 File 객체와 목적지 경로를 부여 시 파일 복사하기 위한 copy() 함수 정의
    public static void copy(File targetFile, String destPath) throws Exception {
        File destFile = new File(destPath);

        // 복사할 결과 파일이 존재할 경우 복사하지 않기로 함
        if (destFile.exists()) {
            String msg = "복사할 결과 파일이 이미 존재하여 파일 복사가 불가능합니다";
            throw new Exception(msg);
        }

        // FileInputStream, FileOutputStream 객체생성
        FileInputStream fis = new FileInputStream(targetFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        // 읽어온 바이트 배열을 쓰기작업 함
        byte[] by = new byte[1024];
        while (true) {
            int read = fis.read(by);
            if (read == -1) {
                break;
            }
            fos.write(by, 0, read); // read(by)로 읽은 후 읽은 데이터 수만큼 쓰기
        }
        if (fis != null && fos != null) {
            fis.close();
            fos.close();
        }
    }

    // 파일 대상경로와 목적지 경로를 부여 시 파일 복사
    public static void copy(String targetPath, String destPath) throws Exception {
        copy(new File(targetPath), destPath);
    }
}
