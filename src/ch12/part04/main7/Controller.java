package ch12.part04.main7;

public class Controller {

    // 외부에서 요청 시 해당 조건에 맞는 품목을 반환하는 함수 정의
    public void getSearchProductList(ParameterMap param) {
        // DataContainer에서 Service 객체조회 및 품목조회
        System.out.println(param.getInfo("[Controller] getSearchProductList()"));
        Service service = DataContainer.getBean("service", Service.class);
        service.getSearchProductList(param);
    }
}