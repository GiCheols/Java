import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.Vector;

public class JComboBoxTest extends JFrame { //지인들의 연락처 관리
    private Vector<PhoneInfo> mData = new Vector<PhoneInfo>();

    public JComboBoxTest(){
        super("JComboBox Test 2");

        readData();
        buildGUI();

        setBounds(120, 120, 300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildGUI(){    //화면 구성
        JComboBox<PhoneInfo> cb = new JComboBox<>(mData);
        // 제네릭 타입의 클래스
        // PhoneInfo의 벡터를 전달하게 되면, 벡터를 통해 객체들을 전달 받아 화면에 나열
        cb.setMaximumRowCount(3);   // 최대로 보여질 콤보 박스의 개수

        cb.addItemListener(choiceEventListener);
        cb.addActionListener(selectEventListener);
        /** 멤버 변수로 EventListener
         *
         *
         */

        setLayout(new FlowLayout());
        add(new JLabel("이름"));
        add(cb);
    }

    private void readData() {
        mData.add(new PhoneInfo("홍길동", "1990/0101", "010-111-2222"));
        mData.add(new PhoneInfo("일지매", "010-123-4567"));
        mData.add(new PhoneInfo("이지매", "1990/12/31", "010-999-9999"));
        mData.add(new PhoneInfo("삼지매", "010-777-6666"));
    }

    private ItemListener choiceEventListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) { 
            //ItemListener 로부터 제공된 핸들러 메서드, 상태를 포함함
            if(e.getStateChange() == ItemEvent.SELECTED)
                System.out.print("Selected...  ");
            else
                System.out.print("DeSelected... ");

            ((PhoneInfo) e.getItem()).show();
            // 이벤트를 발생시킨 객체의 show() 메서드 호출
            System.out.println();
        }
    };

    private ActionListener selectEventListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // actionListener 로부터 재공된 핸들러 메서드, 선택에 대한 이벤트
            JComboBox<PhoneInfo> cb = (JComboBox<PhoneInfo>)e.getSource();
            // 객체 값 얻어옴
            System.out.print("선택...  ");

            ((PhoneInfo)(cb.getSelectedItem())).show();
            // 다운 캐스팅

            System.out.println();
        }
    };
}

class PhoneInfo{    // 연락처를 저장하기 위한 클래스
    private String name;
    private String birthDay;
    private String phoneNumber;

    PhoneInfo(String name, String birthDay, String phoneNumber){
        this.name = name;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
    }

    PhoneInfo(String name, String phoneNumber){
        this(name, null, phoneNumber);
    }

    void show(){
        System.out.print(name);
        if(birthDay != null)
            System.out.print("(" + birthDay + ")");
        else
            System.out.print("\t");
        System.out.print("\t: " + phoneNumber + " ");
    }

    public String toString(){   // PhoneInfo 객체가 콤보박스 상에 나타났을 때 어떻게 나타낼 것인가?
        // 재정의
        return name;
    }
}
