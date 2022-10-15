import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame {

    class ShowBtnTextOnField implements ActionListener {

        private JTextField field;

        public ShowBtnTextOnField(JTextField field) {
            this.field = field;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            this.field.setText(this.field.getText() + btn.getText());
            this.field.setEditable(false);
        }
    }

    private JPanel mainPanel;
    private JPanel btnPanel;
    private JTextField field;
    private Font font;
    private ShowBtnTextOnField btnAction;
    private String[][] BUTTON_TEXT = {
            { "1", "2", "3" },
            { "4", "5", "6" },
            { "7", "8", "9" },
            { "+", "0", "-" },
            { "x", "=", "÷" }
    };

    public Calculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");

        this.field = new JTextField(8);
        this.field.setHorizontalAlignment(SwingConstants.RIGHT);
        this.field.setEditable(false);
        this.font = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        this.field.setFont(this.font.deriveFont(Font.PLAIN, (float) 42.0));

        this.btnPanel = new JPanel();
        this.btnPanel.setLayout(new GridLayout(BUTTON_TEXT.length, BUTTON_TEXT[0].length, 5, 5));
        this.btnAction = new ShowBtnTextOnField(this.field);
        for (String[] row : BUTTON_TEXT) {
            for (String btnText : row) {
                JButton btn = new JButton(btnText);
                btn.setFont(this.font);
                btn.addActionListener(this.btnAction);
                this.btnPanel.add(btn);
            }
        }

        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BorderLayout());
        this.mainPanel.add(this.field, BorderLayout.PAGE_START);
        this.mainPanel.add(this.btnPanel, BorderLayout.CENTER);
        this.mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

public class W5_HW {
    public static void main(String[] args) {
        new Calculator();
    }
}
