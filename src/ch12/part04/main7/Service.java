package ch12.part04.main7;

import java.util.ArrayList;
import java.util.List;

public class Service {
    // 외부에서 요청 시 해당 조건에 맞는 품목을 반환하는 서비스 함수 정의
    public void getSearchProductList(ParameterMap param) {
        // 파라미터 검색조건 조회
        System.out.println(param.getInfo("[Service] getSearchProductList()"));
        System.out.println(param.getInfo("[Service] 조회조건"));

        // 데이터베이스에 자료조회를 한다 - 향후 학습예정
        List<ProductVo> list = new ArrayList<>();
        list.add(new ProductVo("a001", "아메리카노", 4000));
        list.add(new ProductVo("a002", "카페라떼", 4300));
        list.add(new ProductVo("a003", "까페모카", 4500));

        // 검색결과를 파라미터에 저장한다
        param.put("resultList", list);
        System.out.println(param.getInfo("[Service] 조회결과"));
    }
}
