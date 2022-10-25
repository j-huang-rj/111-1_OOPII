import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.ListIterator;

class ImgViewer extends JFrame {

    private JPanel mainPanel;
    private JPanel btnPanel;
    private JLabel imgLabel;
    private JLabel imgNameLabel;
    private JButton btnPrevious;
    private JButton btnNext;
    private Font font;

    public ImgViewer(String directory) {

        // read all images from folder
        File dir = new File(directory);
        String[] IMG_EXTS = new String[] { "png", "jpg", "jpeg", "bmp" };
        FilenameFilter imgFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String fileName) {
                for (String extName : IMG_EXTS) {
                    if (fileName.endsWith("." + extName)) {
                        return true;
                    }
                }
                return false;
            }
        };
        ArrayList<String> imgName = new ArrayList<>();
        ArrayList<String> imgPath = new ArrayList<>();
        if (dir.isDirectory()) {
            for (File img : dir.listFiles(imgFilter)) {
                imgName.add(img.getName());
                imgPath.add(img.getAbsolutePath());
            }
        }
        ListIterator<String> imgNameIter = imgName.listIterator();
        ListIterator<String> imgPathIter = imgPath.listIterator();

        // initiate panels
        this.mainPanel = new JPanel(new BorderLayout());
        this.btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // set font and buttons
        this.font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        this.btnPrevious = new JButton("Previous");
        this.btnPrevious.setFont(this.font);
        this.btnPanel.add(this.btnPrevious);
        this.btnNext = new JButton("Next");
        this.btnNext.setFont(this.font);
        this.btnPanel.add(this.btnNext);
        this.mainPanel.add(this.btnPanel, BorderLayout.PAGE_END);

        // set image and actions
        if (imgPath.size() != 0) {
            this.imgNameLabel = new JLabel(imgNameIter.next(), SwingConstants.CENTER);
            this.imgNameLabel.setFont(this.font.deriveFont((float) 18.0));
            this.mainPanel.add(this.imgNameLabel, BorderLayout.PAGE_START);
            this.imgLabel = new JLabel(new StretchIcon(imgPathIter.next(), true));
            this.imgLabel.setPreferredSize(new Dimension(400, 400));
            this.mainPanel.add(this.imgLabel, BorderLayout.CENTER);
            this.btnNext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (imgNameIter.hasNext() && imgPathIter.hasNext()) {
                        imgNameLabel.setText(imgNameIter.next());
                        imgLabel.setIcon(new StretchIcon(imgPathIter.next(), true));
                        setVisible(true);
                    } else {
                        JButton btn = (JButton) e.getSource();
                        JOptionPane.showMessageDialog(btn, "No more image to show");
                    }
                }
            });
            this.btnPrevious.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (imgNameIter.hasPrevious() && imgPathIter.hasPrevious()) {
                        imgNameLabel.setText(imgNameIter.previous());
                        imgLabel.setIcon(new StretchIcon(imgPathIter.previous(), true));
                        setVisible(true);
                    } else {
                        JButton btn = (JButton) e.getSource();
                        JOptionPane.showMessageDialog(btn, "No more image to show");
                    }
                }
            });
        }

        // set frame props
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Image Viewer");
        setContentPane(this.mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class W6_HW {
    public static void main(String[] args) {
        new ImgViewer("./");
    }
}
