import java.awt.Color;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	
	/**
	 * Crates main frame where all main functions are, it is converting Latin into Cyrillic
	 * Creator Andrea 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextArea textAreaLatin;
	private JTextArea textAreaCyrillic;



  //Creates main frame with all components
	public Frame() {
		setTitle("Latin to Cyrillic Converter");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 407);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		panel.setLayout(null);
		panel.setBackground(new Color(181, 192, 208));
		setContentPane(panel);
		
		//text area with placeholder and listener for placeholder and color of the text, scroll pane for text area, it has sroll for length, text is 
		//wrapped for width it is line and word wrapped 
		JScrollPane scrollPaneLatin = new JScrollPane();
		scrollPaneLatin.setBounds(10, 53, 323, 247);
		panel.add(scrollPaneLatin);
		
		//text area with placeholder and listener for placeholder and color of the text
		String latinPlaceHolder = "Enter text in Latin";
		textAreaLatin = new JTextArea(latinPlaceHolder);
		textAreaLatin.setForeground(Color.LIGHT_GRAY);
		textAreaLatin.setLineWrap(true);
		textAreaLatin.setWrapStyleWord(true);
		Insets margin = new Insets(10, 10, 10, 10);
		textAreaLatin.setMargin(margin);
		textAreaLatin.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(textAreaLatin.getText().equals(latinPlaceHolder) ) {
				textAreaLatin.setText("");
				textAreaLatin.setForeground(Color.BLACK);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(textAreaLatin.getText().equals(latinPlaceHolder) ) {
				textAreaLatin.setText("");
				textAreaLatin.setForeground(Color.BLACK);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		scrollPaneLatin.setViewportView(textAreaLatin);
		

		
		//text area with placeholder and listener for placeholder and color of the text, scroll pane for text area, it has sroll for length, text is 
		//wrapped for width it is line and word wrapped 
		JScrollPane scrollPaneCyrillic = new JScrollPane();
		scrollPaneCyrillic.setBounds(360, 53, 323, 247);
		panel.add(scrollPaneCyrillic);
		
		String cyrilicPlaceHolder = "Cyrillic output text";
		textAreaCyrillic = new JTextArea(cyrilicPlaceHolder);
		textAreaCyrillic.setForeground(Color.LIGHT_GRAY);
		textAreaCyrillic.setLineWrap(true);
		Insets marginCyrillic = new Insets(10, 10, 10, 10);
		textAreaCyrillic.setMargin(marginCyrillic);
		textAreaCyrillic.setWrapStyleWord(true);
		textAreaCyrillic.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(textAreaCyrillic.getText().equals(cyrilicPlaceHolder)) {
					textAreaCyrillic.setText("");
					textAreaCyrillic.setForeground(Color.BLACK);
					}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(textAreaCyrillic.getText().equals(cyrilicPlaceHolder)) {
				textAreaCyrillic.setText("");
				textAreaCyrillic.setForeground(Color.BLACK);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}

		});
		textAreaCyrillic.setWrapStyleWord(true);
		scrollPaneCyrillic.setViewportView(textAreaCyrillic);
		
		JButton buttonConvertToCyrillic = new JButton("Convert to cyrillic");
		buttonConvertToCyrillic.setFocusable(false);
		buttonConvertToCyrillic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertText();
			}
		});
		buttonConvertToCyrillic.setBounds(10, 322, 151, 23);
		panel.add(buttonConvertToCyrillic);
		
		JButton buttonUserManual = new JButton("User instructions");
		buttonUserManual.setFocusable(false);
		buttonUserManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManual.callConstructorUserManual();
			}
		});
		buttonUserManual.setBounds(182, 322, 151, 23);
		panel.add(buttonUserManual);
		
		JButton buttonCopyToClipboard = new JButton("Copy to clipboard");
		buttonCopyToClipboard.setFocusable(false);
		buttonCopyToClipboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyToClipboard();
			}
		});
		buttonCopyToClipboard.setBounds(532, 322, 151, 23);
		panel.add(buttonCopyToClipboard);
		
		JLabel lblLatin = new JLabel("Latin input:");
		lblLatin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLatin.setVerticalAlignment(SwingConstants.CENTER);
		lblLatin.setBounds(10, 22, 323, 14);
		panel.add(lblLatin);
		
		JLabel lblCyrillic = new JLabel("Cyrillic output:");
		lblCyrillic.setHorizontalAlignment(SwingConstants.CENTER);
		lblCyrillic.setVerticalAlignment(SwingConstants.CENTER);
		lblCyrillic.setBounds(360, 22, 323, 14);
		panel.add(lblCyrillic);
		
		JButton buttonClearText = new JButton("Clear text");
		buttonClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaLatin.setText("");
				textAreaLatin.setForeground(Color.BLACK);
				textAreaCyrillic.setText("");
				textAreaCyrillic.setForeground(Color.BLACK);
			}
		});
		buttonClearText.setBounds(360, 322, 151, 23);
		panel.add(buttonClearText);
		
		
		setVisible(true);
	}
	
	//method that converts latin into cyrillic
    private void convertText() {
    	textAreaCyrillic.setForeground(Color.BLACK);
        String latinText = textAreaLatin.getText();
        String cyrillicText = convertLatinToCyrillic(latinText);
        textAreaCyrillic.setText(cyrillicText);
    }
  //method that converts latin into cyrillic , submethod of converText(), it is mapping all the letters and values for conversion and builds new cyrilic string
    private String convertLatinToCyrillic(String latinText) {
        // Define a simple mapping between Latin and Cyrillic characters
        Map<Character, Character> conversionMap = new HashMap<>();
        conversionMap.put('A', 'А');
        conversionMap.put('B', 'Б');
        conversionMap.put('C', 'Ц');
        conversionMap.put('D', 'Д');
        conversionMap.put('E', 'Е');
        conversionMap.put('F', 'Ф');
        conversionMap.put('G', 'Г');
        conversionMap.put('H', 'Х');
        conversionMap.put('I', 'И');
        conversionMap.put('J', 'Ј');
        conversionMap.put('K', 'К');
        conversionMap.put('L', 'Л');
        conversionMap.put('M', 'М');
        conversionMap.put('N', 'Н');
        conversionMap.put('O', 'О');
        conversionMap.put('P', 'П');
        conversionMap.put('Q', 'Ћ');
        conversionMap.put('R', 'Р');
        conversionMap.put('S', 'С');
        conversionMap.put('T', 'Т');
        conversionMap.put('U', 'У');
        conversionMap.put('V', 'В');
        conversionMap.put('W', 'В');
        conversionMap.put('Y', 'Ј');
        conversionMap.put('Z', 'З');


        StringBuilder cyrillicText = new StringBuilder();
        for (char c : latinText.toCharArray()) {
            if (Character.isUpperCase(c)) {
                cyrillicText.append(conversionMap.getOrDefault(c, c));
            } else {
                cyrillicText.append(Character.toLowerCase(conversionMap.getOrDefault(Character.toUpperCase(c), c)));
            }
        }
        return cyrillicText.toString();
    }
    
    //method that holds converted text copied to clipboard for the yuser to be able to paste 
    private String copyToClipboard() {
    	String text = textAreaCyrillic.getText();
    	 StringSelection stringSelection = new StringSelection(text);
         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
         clipboard.setContents(stringSelection, null);
    	return text;
    }
    
   
}
