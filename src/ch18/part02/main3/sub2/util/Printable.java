package ch18.part02.main3.sub2.util;

import java.io.ObjectInputStream;
import java.util.Map;

public class Printable {
    /**
     * @summary
     * @param name
     * @param object
     * @return
     */
    public static boolean print(String name, Object object) {
        boolean ret = false;
        if (name != null && !name.equals("")) {
            if (object instanceof Map<?, ?>) {
                ret = true;
                System.out.println("오브젝트 확인");
                System.out.println(object);
            }
        }
        return ret;
    }
}