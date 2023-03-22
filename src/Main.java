import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//  w ww.  j av  a2  s .  co m
public class Main {
    public static void main(String[] args) {
        JTextField nField = new JTextField(5);
        JTextField cField = new JTextField(5);
        JTextField mField = new JTextField(8);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("name:"));
        myPanel.add(nField);
        myPanel.add(new JLabel("mobile:"));
        myPanel.add(mField);
        myPanel.add(new JLabel("coid:"));
        myPanel.add(cField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter name and mobile,coid Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("name value: " + nField.getText());
            System.out.println("mobile value: " + mField.getText());
            System.out.println("coid value: " + cField.getText());
        }

    }
}