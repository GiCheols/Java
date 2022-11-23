import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAndFileDialogEx extends JFrame {
    JLabel imageLabel = new JLabel();

    public MenuAndFileDialogEx(){
        super("Menu와 JFileChooser 활용 예제");

        add(imageLabel);
        createMenu();

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void createMenu(){
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new OpenActionListener());

        fileMenu.add(openItem);
        mb.add(fileMenu);
    }

    class OpenActionListener implements ActionListener{
        JFileChooser chooser;
        
        OpenActionListener(){
            chooser = new JFileChooser();   // 파일 다이얼로그 생성
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    // 파일 이름에 창에 출력될 문자열
                    "JPF & Images",
                    // 파일 필터로 사용되는 확장자. *.jpg *.gif만 나열 됨
                    "jpg", "gif"
            );
            
            chooser.setFileFilter(filter);  //파일 다이얼로그에 파일 필터 생성
            
            // 파일 다이얼로그 출력
            int ret = chooser.showOpenDialog(MenuAndFileDialogEx.this);
            if(ret != JFileChooser.APPROVE_OPTION){
                //사용자가 창을 강제로 닫았거나 취소 버튼을 누른 경우
                JOptionPane.showMessageDialog(MenuAndFileDialogEx.this, 
                        "파일을 선택하지 않았습니다.");
                return;
            }
            
            // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
            String filePath = chooser.getSelectedFile().getPath();
            //파일 경로명을 알아옴
            imageLabel.setIcon(new ImageIcon(filePath));
            // 파일을 로딩하여 이미지 레이블에 출력

            pack();
        }
    }
}
