package ch15.part01.main2;

import java.io.File;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException {
        // 상대경로를 이용하여 File 객체생성
        File file1 = new File("./a.jpg"); // 현재 경로에 a.jpg 파일 접근
        File file2 = new File("a.jpg"); // ./a.jpg와 같음
        File file3 = new File("../a.jpg"); // 상위경로에 a.jpg 파일 접근
        File file4 = new File("/a.jpg"); // 최상위경로에 a.jpg 파일 접근

        // 생성자로 입력된 경로의 값을 반환
        System.out.println("file1.getPath() = " + file1.getPath());
        System.out.println("file2.getPath() = " + file2.getPath());
        System.out.println("file3.getPath() = " + file3.getPath());
        System.out.println("file4.getPath() = " + file4.getPath());

        // 최상위 경로를 기준으로 해당 절대경로를 반환
        System.out.println("file1.getAbsolutePath() = " + file1.getAbsolutePath());
        System.out.println("file2.getAbsolutePath() = " + file2.getAbsolutePath());
        System.out.println("file3.getAbsolutePath() = " + file3.getAbsolutePath());
        System.out.println("file4.getAbsolutePath() = " + file4.getAbsolutePath());

        // 최상위 경로를 기준으로 해당 절대경로를 반환
        System.out.println("file1.getCanonicalPath() = " + file1.getCanonicalPath());
        System.out.println("file2.getCanonicalPath() = " + file2.getCanonicalPath());
        System.out.println("file3.getCanonicalPath() = " + file3.getCanonicalPath());
        System.out.println("file4.getCanonicalPath() = " + file4.getCanonicalPath());

        // getParentFile(), getParent() 함수를 이용하여 부모 경로에 접근하기
        String canonicalPath = file2.getCanonicalPath();
        File absoluteFile = file2.getAbsoluteFile();
        String parent = absoluteFile.getParent();
        String parentCanonicalPath = absoluteFile.getParentFile().getCanonicalPath();

        System.out.println("현재경로 file2.getCanonicalPath() = " + canonicalPath);
        System.out.println("부모경로 file2.getParent() = " + file2.getParent());
        System.out.println("부모파일 file2.getParentFile() = " + file2.getParentFile());
        System.out.println("부모경로 file2.getAbsoluteFile().getParent() = " + parent);
        String msg = "부모파일 file2.getAbsoluteFile().getParentFile().getCanonicalPath()";
        System.out.println(msg + " = " + parentCanonicalPath);

        // 패키지명이 ch15.part01.main1일때 해당 자바파일에 접근
        File file5 = new File("./bin/ch15/part01/main1/File01.java");
        System.out.println("해당경로 getCanonicalPath() = " + file5.getCanonicalPath());
        System.out.println("파일존재여부 exists() = " + file5.exists());
        System.out.println("파일여부 isFile() = " + file5.isFile());
        System.out.println("폴더여부 isDirectory() = " + file5.isDirectory());
    }
}
