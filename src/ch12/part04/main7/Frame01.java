package ch12.part04.main7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame01 extends JFrame {
    // 지역변수를 전역변수로 분리
    private JTextArea textArea = new JTextArea();

    // 생성자 함수
    public Frame01() {
        // 화면기본구성
        this.setTitle("Frame01");
        this.setLayout(null);
        this.setBounds(new Rectangle(10, 50, 500, 500));

        // 컴포넌트(텍스트 Area) 생성
        textArea.setBounds(new Rectangle(10, 50, 400, 300));
        this.add(textArea);

        // 컴포넌트(버튼) 생성
        JButton btn = new JButton("자료가져오기");
        btn.setBounds(new Rectangle(10, 10, 140, 30));
        this.add(btn);

        // 버튼클릭 이벤트 함수 정의
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. 검색조건 설정
                ParameterMap param = new ParameterMap();
                param.put("searchMinPrice", 4000);
                param.put("searchMaxPrice", 5000);
                System.out.println(param.getInfo("[Frame01] 이벤트 조회조건"));

                // 2. Controller에 검색요청
                Controller controller = DataContainer.getBean("controller", Controller.class);
                controller.getSearchProductList(param);
                System.out.println(param.getInfo("[Frame01 이벤트 조회결과]"));

                // 3. 검색결과를 화면에 반영
                /*
                List<ProductVo> list = param.get("resultList", List.class);
                String msg = "";
                if (list != null) {
                    for (ProductVo v : list) {
                        msg += v.toString() + "\r\n";
                    }
                }
                textArea.setText(msg);
                 */
            }
        });
    }
}
