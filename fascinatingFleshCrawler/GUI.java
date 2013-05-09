package fascinatingFleshCrawler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


import fascinatingFleshCrawler.Variables;


public class GUI extends JFrame {
	boolean isRunning = true;
	public GUI() {
		initComponents();
	}

	private void startButtonActionPerformed(ActionEvent e) {
		
		//Strength potions
		String strPotChosen = comboStrPots.getSelectedItem().toString();
		if(strPotChosen.equals("Strength Potion")){
			Variables.useStrPots = true;
			System.out.println("Using strength potion");
		} else if(strPotChosen.equals("Super Strength Potion")){
			Variables.useSuperStrPots = true;
		} else if(strPotChosen.equals("Extreme Strength Potion")){
			Variables.useExtStrPots = true;
		}
		
		String defPotChosen = comboDefPots.getSelectedItem().toString();
		if(defPotChosen.equals("Defence Potion")){
			Variables.useDefPots = true;
		} else if(defPotChosen.equals("Super Defence Potion")){
			Variables.useSuperDefPots = true;
		} else if(defPotChosen.equals("Extreme Defence Potion")){
			Variables.useExtDefPots = true;
		}
		
		String attPotChosen = comboAttPot.getSelectedItem().toString();
		if(attPotChosen.equals("Attack Potion")){
			Variables.useAttPots = true;
		} else if(attPotChosen.equals("Super Attack Potion")){
			Variables.useSuperAttPots = true;
		} else if(attPotChosen.equals("Extreme Attack Potion")){
			Variables.useExtAttPots = true;
		}
		
		String strText = strPotText.getText().toString();
		Variables.noOfStr = Integer.parseInt(strText);
		Variables.noOfDef = Integer.parseInt(defPotText.getText().toString());
		Variables.noOfAtt = Integer.parseInt(attPotText.getText().toString());
		
		
		this.setVisible(true);

		Variables.GUIFinished = true;

		isRunning = false;
		Variables.startTime = System.currentTimeMillis();
		

		dispose();
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - guest Bhide
		tabbedPane1 = new JTabbedPane();
		panel2 = new JPanel();
		strPotText = new JTextField();
		defPotText = new JTextField();
		attPotText = new JTextField();
		separator1 = new JSeparator();
		label7 = new JLabel();
		comboStrPots = new JComboBox();
		comboDefPots = new JComboBox();
		comboAttPot = new JComboBox();
		panel3 = new JPanel();
		label8 = new JLabel();
		summonCombo = new JComboBox();
		panel4 = new JPanel();
		useNorth = new JRadioButton();
		useSouth = new JRadioButton();
		useSouthEast = new JRadioButton();
		useRandom = new JRadioButton();
		panel5 = new JPanel();
		useRejuv = new JCheckBox();
		useMomentum = new JCheckBox();
		panel10 = new JPanel();
		textField1 = new JTextField();
		button1 = new JButton();
		label2 = new JLabel();
		label5 = new JLabel();
		panel1 = new JPanel();
		lootCharm = new JCheckBox();
		lootHerb = new JCheckBox();
		lootRune = new JCheckBox();
		lootGem = new JCheckBox();
		startButton = new JButton();
		tabbedPane2 = new JTabbedPane();
		panel6 = new JPanel();
		label1 = new JLabel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		checkBox1 = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		checkBox4 = new JCheckBox();
		panel9 = new JPanel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Options - Fascinating FleshCrawler v1.0");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== tabbedPane1 ========
		{

			//======== panel2 ========
			{

				// JFormDesigner evaluation mark
				panel2.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				panel2.setLayout(null);

				//---- strPotText ----
				strPotText.setText("0");
				panel2.add(strPotText);
				strPotText.setBounds(185, 20, 54, strPotText.getPreferredSize().height);

				//---- defPotText ----
				defPotText.setText("0");
				panel2.add(defPotText);
				defPotText.setBounds(185, 55, 56, defPotText.getPreferredSize().height);

				//---- attPotText ----
				attPotText.setText("0");
				panel2.add(attPotText);
				attPotText.setBounds(185, 90, 54, attPotText.getPreferredSize().height);

				//---- separator1 ----
				separator1.setOrientation(SwingConstants.VERTICAL);
				panel2.add(separator1);
				separator1.setBounds(240, 20, separator1.getPreferredSize().width, 100);

				//---- label7 ----
				label7.setText("More Coming Soon...!");
				label7.setEnabled(false);
				label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() - 2f));
				panel2.add(label7);
				label7.setBounds(new Rectangle(new Point(265, 55), label7.getPreferredSize()));

				//---- comboStrPots ----
				comboStrPots.setModel(new DefaultComboBoxModel(new String[] {
					"None",
					"Strength Potion",
					"Super Strength Potion",
					"Extreme Strength"
				}));
				panel2.add(comboStrPots);
				comboStrPots.setBounds(20, 20, 157, comboStrPots.getPreferredSize().height);

				//---- comboDefPots ----
				comboDefPots.setModel(new DefaultComboBoxModel(new String[] {
					"None",
					"Defence Potion",
					"Super Defence Potion",
					"Extreme Defence Potion"
				}));
				panel2.add(comboDefPots);
				comboDefPots.setBounds(20, 55, 155, comboDefPots.getPreferredSize().height);

				//---- comboAttPot ----
				comboAttPot.setModel(new DefaultComboBoxModel(new String[] {
					"None",
					"Attack Potions",
					"Super Attack Potions",
					"Extreme Attack Potions"
				}));
				panel2.add(comboAttPot);
				comboAttPot.setBounds(20, 90, 155, comboAttPot.getPreferredSize().height);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel2.getComponentCount(); i++) {
						Rectangle bounds = panel2.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel2.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel2.setMinimumSize(preferredSize);
					panel2.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Potions", panel2);


			//======== panel3 ========
			{

				//---- label8 ----
				label8.setText("Coming Soon...");
				label8.setEnabled(false);
				label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() - 2f));

				//---- summonCombo ----
				summonCombo.setModel(new DefaultComboBoxModel(new String[] {
					"Terrorbird",
					"Bull ant",
					"War tortoise",
					"Yak"
				}));

				GroupLayout panel3Layout = new GroupLayout(panel3);
				panel3.setLayout(panel3Layout);
				panel3Layout.setHorizontalGroup(
					panel3Layout.createParallelGroup()
						.addGroup(panel3Layout.createSequentialGroup()
							.addGroup(panel3Layout.createParallelGroup()
								.addGroup(panel3Layout.createSequentialGroup()
									.addGap(166, 166, 166)
									.addComponent(label8))
								.addGroup(panel3Layout.createSequentialGroup()
									.addGap(147, 147, 147)
									.addComponent(summonCombo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(186, Short.MAX_VALUE))
				);
				panel3Layout.setVerticalGroup(
					panel3Layout.createParallelGroup()
						.addGroup(panel3Layout.createSequentialGroup()
							.addGap(34, 34, 34)
							.addComponent(summonCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label8)
							.addContainerGap(45, Short.MAX_VALUE))
				);
			}
			tabbedPane1.addTab("Summoning", panel3);


			//======== panel4 ========
			{
				panel4.setLayout(null);

				//---- useNorth ----
				useNorth.setText("North");
				useNorth.setSelected(true);
				panel4.add(useNorth);
				useNorth.setBounds(new Rectangle(new Point(25, 35), useNorth.getPreferredSize()));

				//---- useSouth ----
				useSouth.setText("South");
				useSouth.setEnabled(false);
				panel4.add(useSouth);
				useSouth.setBounds(new Rectangle(new Point(120, 35), useSouth.getPreferredSize()));

				//---- useSouthEast ----
				useSouthEast.setText("South/East");
				useSouthEast.setEnabled(false);
				panel4.add(useSouthEast);
				useSouthEast.setBounds(new Rectangle(new Point(210, 35), useSouthEast.getPreferredSize()));

				//---- useRandom ----
				useRandom.setText("Random");
				useRandom.setEnabled(false);
				panel4.add(useRandom);
				useRandom.setBounds(new Rectangle(new Point(340, 35), useRandom.getPreferredSize()));

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel4.getComponentCount(); i++) {
						Rectangle bounds = panel4.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel4.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel4.setMinimumSize(preferredSize);
					panel4.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Area", panel4);


			//======== panel5 ========
			{
				panel5.setLayout(null);

				//---- useRejuv ----
				useRejuv.setText("Rejevunate");
				useRejuv.setEnabled(false);
				panel5.add(useRejuv);
				useRejuv.setBounds(new Rectangle(new Point(135, 25), useRejuv.getPreferredSize()));

				//---- useMomentum ----
				useMomentum.setText("Momentum");
				useMomentum.setEnabled(false);
				panel5.add(useMomentum);
				useMomentum.setBounds(new Rectangle(new Point(135, 50), useMomentum.getPreferredSize()));

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel5.getComponentCount(); i++) {
						Rectangle bounds = panel5.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel5.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel5.setMinimumSize(preferredSize);
					panel5.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Ability Options", panel5);


			//======== panel10 ========
			{
				panel10.setLayout(null);

				//---- textField1 ----
				textField1.setEditable(false);
				textField1.setHorizontalAlignment(SwingConstants.LEFT);
				panel10.add(textField1);
				textField1.setBounds(10, 10, 270, 100);

				//---- button1 ----
				button1.setText("Refresh List");
				button1.setEnabled(false);
				panel10.add(button1);
				button1.setBounds(new Rectangle(new Point(310, 40), button1.getPreferredSize()));

				//---- label2 ----
				label2.setText("Coming later on..");
				label2.setEnabled(false);
				label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() - 2f));
				panel10.add(label2);
				label2.setBounds(new Rectangle(new Point(340, 65), label2.getPreferredSize()));

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel10.getComponentCount(); i++) {
						Rectangle bounds = panel10.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel10.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel10.setMinimumSize(preferredSize);
					panel10.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("NPC Retrieval", panel10);

		}
		contentPane.add(tabbedPane1);
		tabbedPane1.setBounds(15, 25, 470, 170);

		//---- label5 ----
		label5.setText("Fascinating FleshCrawler");
		label5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 28));
		contentPane.add(label5);
		label5.setBounds(new Rectangle(new Point(130, 0), label5.getPreferredSize()));

		//======== panel1 ========
		{
			panel1.setBorder(new TitledBorder("Loot"));
			panel1.setLayout(null);

			//---- lootCharm ----
			lootCharm.setText("Loot Charms");
			panel1.add(lootCharm);
			lootCharm.setBounds(new Rectangle(new Point(40, 25), lootCharm.getPreferredSize()));

			//---- lootHerb ----
			lootHerb.setText("Loot Herbs");
			panel1.add(lootHerb);
			lootHerb.setBounds(new Rectangle(new Point(40, 50), lootHerb.getPreferredSize()));

			//---- lootRune ----
			lootRune.setText("Loot Runes");
			panel1.add(lootRune);
			lootRune.setBounds(new Rectangle(new Point(40, 75), lootRune.getPreferredSize()));

			//---- lootGem ----
			lootGem.setText("Loot Gems");
			panel1.add(lootGem);
			lootGem.setBounds(new Rectangle(new Point(40, 100), lootGem.getPreferredSize()));

			{ // compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel1.getComponentCount(); i++) {
					Rectangle bounds = panel1.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel1.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel1.setMinimumSize(preferredSize);
				panel1.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(panel1);
		panel1.setBounds(20, 190, 200, 140);

		//---- startButton ----
		startButton.setText("Start!");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}
		});
		contentPane.add(startButton);
		startButton.setBounds(20, 345, 455, 50);

		//======== tabbedPane2 ========
		{

			//======== panel6 ========
			{
				panel6.setLayout(null);

				//---- label1 ----
				label1.setText("Coming Soon!");
				panel6.add(label1);
				label1.setBounds(new Rectangle(new Point(70, 35), label1.getPreferredSize()));

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel6.getComponentCount(); i++) {
						Rectangle bounds = panel6.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel6.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel6.setMinimumSize(preferredSize);
					panel6.setPreferredSize(preferredSize);
				}
			}
			tabbedPane2.addTab("Loot Options", panel6);


			//======== panel7 ========
			{
				panel7.setLayout(null);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel7.getComponentCount(); i++) {
						Rectangle bounds = panel7.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel7.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel7.setMinimumSize(preferredSize);
					panel7.setPreferredSize(preferredSize);
				}
			}
			tabbedPane2.addTab("Herbs", panel7);


			//======== panel8 ========
			{
				panel8.setLayout(null);

				//---- checkBox1 ----
				checkBox1.setText("Blue");
				checkBox1.setEnabled(false);
				panel8.add(checkBox1);
				checkBox1.setBounds(new Rectangle(new Point(45, 10), checkBox1.getPreferredSize()));

				//---- checkBox2 ----
				checkBox2.setText("Gold");
				checkBox2.setEnabled(false);
				panel8.add(checkBox2);
				checkBox2.setBounds(new Rectangle(new Point(45, 35), checkBox2.getPreferredSize()));

				//---- checkBox3 ----
				checkBox3.setText("Green");
				checkBox3.setEnabled(false);
				panel8.add(checkBox3);
				checkBox3.setBounds(new Rectangle(new Point(140, 10), checkBox3.getPreferredSize()));

				//---- checkBox4 ----
				checkBox4.setText("Crimson");
				checkBox4.setEnabled(false);
				panel8.add(checkBox4);
				checkBox4.setBounds(new Rectangle(new Point(140, 35), checkBox4.getPreferredSize()));

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel8.getComponentCount(); i++) {
						Rectangle bounds = panel8.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel8.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel8.setMinimumSize(preferredSize);
					panel8.setPreferredSize(preferredSize);
				}
			}
			tabbedPane2.addTab("Charms", panel8);


			//======== panel9 ========
			{
				panel9.setLayout(null);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel9.getComponentCount(); i++) {
						Rectangle bounds = panel9.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel9.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel9.setMinimumSize(preferredSize);
					panel9.setPreferredSize(preferredSize);
				}
			}
			tabbedPane2.addTab("Gems", panel9);

		}
		contentPane.add(tabbedPane2);
		tabbedPane2.setBounds(225, 190, 260, 150);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		setSize(500, 445);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - guest Bhide
	private JTabbedPane tabbedPane1;
	private JPanel panel2;
	private JTextField strPotText;
	private JTextField defPotText;
	private JTextField attPotText;
	private JSeparator separator1;
	private JLabel label7;
	private JComboBox comboStrPots;
	private JComboBox comboDefPots;
	private JComboBox comboAttPot;
	private JPanel panel3;
	private JLabel label8;
	private JComboBox summonCombo;
	private JPanel panel4;
	private JRadioButton useNorth;
	private JRadioButton useSouth;
	private JRadioButton useSouthEast;
	private JRadioButton useRandom;
	private JPanel panel5;
	private JCheckBox useRejuv;
	private JCheckBox useMomentum;
	private JPanel panel10;
	private JTextField textField1;
	private JButton button1;
	private JLabel label2;
	private JLabel label5;
	private JPanel panel1;
	private JCheckBox lootCharm;
	private JCheckBox lootHerb;
	private JCheckBox lootRune;
	private JCheckBox lootGem;
	private JButton startButton;
	private JTabbedPane tabbedPane2;
	private JPanel panel6;
	private JLabel label1;
	private JPanel panel7;
	private JPanel panel8;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JCheckBox checkBox4;
	private JPanel panel9;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}




/*this.setVisible(true);

		Variables.GUIFinished = true;

		isRunning = false;
		Variables.startTime = System.currentTimeMillis();
		

		dispose();
*/