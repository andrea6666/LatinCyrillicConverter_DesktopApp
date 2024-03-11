import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class UserManual extends JFrame {

	/**
	 * Creates User instruction frame
	 * Singleton class
	 * Creator Andrea 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	/**
	 * Creates the frame
	 */
	
	
	private static UserManual userManual = null;
	private UserManual() {
		
		
		setBounds(100, 100, 497, 283);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		panel.setBackground(new Color(181, 192, 208));
		setContentPane(panel);
		
		//Creates instructions in multiple lines 
		String text = "<html>&nbsp User instructions:<br>"
		        + "<br>	&nbsp In the first empty text field, enter text in Latin and press the "
		        + "<br>&nbsp\"Convert to Cyrillic\" button, located below the field for entering Latin text."
		        + "<br> <br>&nbsp In the second text input field on the right, the text in Cyrillic will appear."
		        + " <br><br>&nbsp By pressing the \"Copy to Clipboard\" button, the text will be "
		        + "	&nbsp stored in <br>&nbsp  memory, and you can transfer it to a text document using the \"Ctrl + V\""
		        + "<br> &nbsp command or by right-clicking the mouse and selecting the \"Paste\" option.</html>";
		
		//Creates text label from text above - displays text within the label 
		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setBackground(new Color(181, 192, 208));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(22, 11, 449, 207);
		panel.add(lblNewLabel);

		
		//Takes care that class is initiated only ones, it is singleton and it may run window only one when closed it can be reopened
		//Listener decides if the window is opened 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Set the instance to null when the window is closed
				userManual = null;
			}
		});
		}
	
	public static  UserManual callConstructorUserManual() {
		if(userManual==null) {
			userManual = new UserManual();
			}
		return userManual;
	}

}
