import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;

public class Main {
    JFrame frame;
    JFileChooser fileChooser = new JFileChooser();
    JTextArea textArea = new JTextArea();
    JMenuBar menuBar = new JMenuBar();
    String fileName = "";

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        buildGUI();
        newTextArea();
        newMenuBar();
        fileMenu();
        frame.setVisible(true);
    }

    public void buildGUI(){
        frame = new JFrame("Memo Program");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void newTextArea(){
        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }

    String[] menuType = { "File" };
    ArrayList<JMenu> menuBars = new ArrayList<>(5);
    public void newMenuBar(){
        frame.setJMenuBar(menuBar);

        for (String n: menuType) {
            menuBars.add(new JMenu(n));
        }
        for(int i = 0; i < menuBars.size(); i++)
            menuBar.add(menuBars.get(i));
    }

    String [] menuItem = {"File", "Open", "Save", "SaveAs", "Exit"};
    ArrayList<JMenuItem> menuItems = new ArrayList<>(5);
    public void fileMenu(){
        for (String s : menuItem) {
            menuItems.add(new JMenuItem(s));
        }

        for (int i = 0; i < menuItems.size() - 1; i++) {
            MemoActionListener memoActionListener = new MemoActionListener(this);
            menuItems.get(i).addActionListener(memoActionListener);
            frame.setJMenuBar(menuBar);
            menuBars.get(0).add(menuItems.get(i));
        }
    }

    public void newFile(){
        textArea.setText("");
    }

    public void openFile(){
        int ret = fileChooser.showOpenDialog(null);

        if(ret != JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null,
                    "파일을 선택하지 않았습니다.",
                    "경고", JOptionPane.WARNING_MESSAGE);
        } else {
            File inFile = fileChooser.getSelectedFile();
            BufferedReader in;
            try {
                in = new BufferedReader(new FileReader(inFile));
                String c;
                textArea.setText("");
                while ((c = in.readLine()) != null){
                    textArea.append(c + "\r\n");
                }
                in.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        fileName = fileChooser.getSelectedFile().toString();
        frame.setTitle(fileChooser.getSelectedFile().getName());
    }

    public void saveFile(String fileName){
        BufferedWriter bw = null;
        File file = new File(this.fileName);
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(fileName);
            frame.setTitle(file.getName());
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
