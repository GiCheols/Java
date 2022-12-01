import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JStopWatch extends JFrame {
    int mm, ss, ms;
    Thread p_display, t_display;
    JButton start, pause, reset;
    JLabel watchMin, watchSec, watchMilliSec;
    int timeSet = 0;

    JStopWatch(){
        super("Stop Watch");

        buildGUI();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
    }

    private void buildGUI(){
        JPanel guiPanel = new JPanel(new BorderLayout());
        JPanel watchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel slashOne = new JLabel(" : ");
        JLabel slashTwo = new JLabel(" : ");
        watchMin = new JLabel("00");
        watchSec = new JLabel("00");
        watchMilliSec = new JLabel("0");

        start = new JButton("START");
        pause = new JButton("PAUSE");
        reset = new JButton("RESET");

        buttonPanel.add(start);
        buttonPanel.add(pause);
        buttonPanel.add(reset);

        watchPanel.add(watchMin);
        watchPanel.add(slashOne);
        watchPanel.add(watchSec);
        watchPanel.add(slashTwo);
        watchPanel.add(watchMilliSec);

        guiPanel.add(watchPanel,BorderLayout.CENTER);
        guiPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(guiPanel);

        start.setFont(new Font("Serif", Font.BOLD, 30));
        pause.setFont(new Font("Serif", Font.BOLD, 30));
        reset.setFont(new Font("Serif", Font.BOLD, 30));

        pause.setEnabled(false);
        reset.setEnabled(false);

        start.addActionListener(handler);
        pause.addActionListener(handler);
        reset.addActionListener(handler);
    }

    private ActionListener handler = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();

            if (s.equals("START")){
                start.setEnabled(false);
                pause.setEnabled(true);
                reset.setEnabled(false);

                p_display = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mm = Integer.parseInt(watchMin.getText());
                        ss = Integer.parseInt(watchSec.getText());
                        ms = Integer.parseInt(watchMilliSec.getText());

                        while (p_display == Thread.currentThread()){
                            mm = timeSet % (1000*60) / 100 / 60;
                            ss = timeSet % (1000*60) / 100 % 60;
                            ms = timeSet % 100;
                            
                            try {
                                Thread.sleep(10);
                                
                                watchMin.setText(String.format("%02d", mm));
                                watchSec.setText(String.format("%02d", ss));
                                watchMilliSec.setText(String.format("%d",ms));
                                
                                timeSet++;
                            } catch (InterruptedException e1){ }
                        }
                    }
                });
                p_display.start();
            } else if (s.equals("PAUSE")) {
                start.setEnabled(true);
                pause.setEnabled(false);
                reset.setEnabled(true);

                p_display = null;
            } else if (s.equals("RESET")) {
                start.setEnabled(true);
                pause.setEnabled(false);
                pause.setEnabled(false);

                timeSet = 0;
            }
        }
    };

    public static void main(String[] args) {
        new JStopWatch();
    }
}
