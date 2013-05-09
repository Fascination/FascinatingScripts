package fascinatingMagician;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Tue Oct 02 08:53:51 WST 2012
 */

import fascinatingMagician.Variables;


/**
 * @author guest Bhide
 */
public class GUI extends JFrame {
	public GUI() {
		initComponents();
	}

private void startAlchingActionPerformed(ActionEvent e) {
		
		if(highAlc.isSelected()){
			Variables.HighAlch = true;
		}
		
		if(lowAlch.isSelected()){
			Variables.LowAlch = true;
		}
		
		String alchId = idText.getText().toString();
		Variables.idToAlch = Integer.parseInt(alchId);
		
		this.setVisible(true);
		Variables.GUIFinished = true;
		Variables.startTime = System.currentTimeMillis();
		dispose();
		
		
	}

	private void startSHActionPerformed(ActionEvent e) {
		
		
		this.setVisible(true);
		Variables.GUIFinished = true;
		Variables.startTime = System.currentTimeMillis();
		
		dispose();
	}

	private void startTeleportActionPerformed(ActionEvent e) {
		
		if(checkTele.isSelected()){
			Variables.Teleport = true;
		}
		
		this.setVisible(true);
		Variables.GUIFinished = true;
		Variables.startTime = System.currentTimeMillis();
		
		dispose();
		
	}

	private void startEnchantActionPerformed(ActionEvent e) {
		
		
		String amuletChosen = chooseAmulet.getSelectedItem().toString();
		String neckChosen = chooseNecklace.getSelectedItem().toString();
		String ringChosen = chooseRing.getSelectedItem().toString();
		String braceChosen = chooseBracelet.getSelectedItem().toString();
		
		//Amulet
	if(checkAmulet.isSelected()){
		Variables.amulet = true;
		
		if(amuletChosen.equals("Sapphire")){
			Variables.amuletToEnchant = Variables.sapAmulet;
		} else if (amuletChosen.equals("Emerald")){
			Variables.amuletToEnchant = Variables.emeAmulet;
		} else if (amuletChosen.equals("Ruby")){
			Variables.amuletToEnchant = Variables.rubAmulet;
		} else if (amuletChosen.equals("Diamond")){
			Variables.amuletToEnchant = Variables.diaAmulet;
		} else if (amuletChosen.equals("Dragonstone")){
			Variables.amuletToEnchant = Variables.draAmulet;
		} else if (amuletChosen.equals("Onyx")){
			Variables.amuletToEnchant = Variables.onyAmulet;
		}
	}		
		//Necklace
	if(checkNeck.isSelected()){	
		Variables.necklace = true;
		
		if(neckChosen.equals("Sapphire")){
			Variables.neckToEnchant = Variables.sapNecklace;
		} else if (neckChosen.equals("Emerald")){
			Variables.neckToEnchant = Variables.emeNecklace;
		} else if (neckChosen.equals("Ruby")){
			Variables.neckToEnchant = Variables.rubNecklace;
		} else if (ringChosen.equals("Diamond")){
			Variables.neckToEnchant = Variables.diaRing;
		} else if (neckChosen.equals("Dragonstone")){
			Variables.neckToEnchant = Variables.draNecklace;
		} else if (neckChosen.equals("Onyx")){
			Variables.neckToEnchant = Variables.onyNecklace;
		}
	}	
		///ring
	if(checkRing.isSelected()){	
		Variables.ring = true;
		
		if(ringChosen.equals("Sapphire")){
			Variables.ringToEnchant = Variables.sapRing;
		} else if (ringChosen.equals("Emerald")){
			Variables.ringToEnchant = Variables.emeRing;
		} else if (ringChosen.equals("Ruby")){
			Variables.ringToEnchant = Variables.rubRing;
		} else if (ringChosen.equals("Diamond")){
			Variables.ringToEnchant = Variables.diaRing;
		} else if (ringChosen.equals("Dragonstone")){
			Variables.ringToEnchant = Variables.draRing;
		} else if (ringChosen.equals("Onyx")){
			Variables.ringToEnchant = Variables.onyRing;
		}
	}	
		//Bracelets
	if(checkBrace.isSelected()){
		Variables.bracelet = true;
		
		if(braceChosen.equals("Sapphire")){
			Variables.braceToEnchant = Variables.sapBracelet;
		} else if (braceChosen.equals("Emerald")){
			Variables.braceToEnchant = Variables.emeBracelet;
		} else if (braceChosen.equals("Ruby")){
			Variables.braceToEnchant = Variables.rubBracelet;
		} else if (braceChosen.equals("Diamond")){
			Variables.braceToEnchant = Variables.diaBracelet;
		} else if (braceChosen.equals("Dragonstone")){
			Variables.braceToEnchant = Variables.draBracelet;
		} else if (braceChosen.equals("Onyx")){
			Variables.braceToEnchant = Variables.onyBracelet;
		}
	}
	
		this.setVisible(true);
		Variables.GUIFinished = true;
		Variables.startTime = System.currentTimeMillis();
		dispose();
		
	}

	private void startGateActionPerformed(ActionEvent e) {
		
		if(checkGatestone.isSelected()){
			Variables.gatestone = true;
		}
		
		this.setVisible(true);
		Variables.GUIFinished = true;
		Variables.startTime = System.currentTimeMillis();
		dispose();
		
	}

	private void startStunAlchingActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void startHumidActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void button2ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void startStringingActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void startPlankActionPerformed(ActionEvent e) {
		if(choosePlank.isSelected()){
			Variables.plankmake = true;
		}
		
		String chosenPlank = selectPlanks.getSelectedItem().toString();
		if(chosenPlank.equals("Normal")){
			Variables.logsToPlank = Variables.normal;
		} else if(chosenPlank.equals("Oak")){
			Variables.logsToPlank = Variables.oak;
		} else if(chosenPlank.equals("Teak")){
			Variables.logsToPlank = Variables.teak;
		} else if(chosenPlank.equals("Mahogany")){
			Variables.logsToPlank = Variables.mahogany;
		}
		
		this.setVisible(true);
		Variables.GUIFinished = true;
		Variables.startTime = System.currentTimeMillis();
		dispose();
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - guest Bhide
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		highAlc = new JRadioButton();
		lowAlch = new JRadioButton();
		idText = new JTextField();
		label2 = new JLabel();
		panel2 = new JPanel();
		checkTele = new JRadioButton();
		label1 = new JLabel();
		label3 = new JLabel();
		panel3 = new JPanel();
		barToHeat = new JComboBox();
		coalBag = new JRadioButton();
		checkSuperheat = new JRadioButton();
		label6 = new JLabel();
		panel4 = new JPanel();
		checkEnchantBolts = new JRadioButton();
		chooseBolts = new JComboBox();
		checkAmulet = new JRadioButton();
		chooseAmulet = new JComboBox();
		checkBrace = new JRadioButton();
		chooseBracelet = new JComboBox();
		checkNeck = new JRadioButton();
		chooseNecklace = new JComboBox();
		checkRing = new JRadioButton();
		chooseRing = new JComboBox();
		panel8 = new JPanel();
		label11 = new JLabel();
		checkGatestone = new JRadioButton();
		label12 = new JLabel();
		label13 = new JLabel();
		panel6 = new JPanel();
		label5 = new JLabel();
		checkStun = new JRadioButton();
		chooseStun = new JCheckBox();
		chooseCurse = new JCheckBox();
		chooseEnfeeble = new JCheckBox();
		chooseVuln = new JCheckBox();
		panel10 = new JPanel();
		checkString = new JRadioButton();
		label16 = new JLabel();
		chooseAmuletToString = new JComboBox();
		label18 = new JLabel();
		panel9 = new JPanel();
		checkHumidify = new JRadioButton();
		label14 = new JLabel();
		label15 = new JLabel();
		label17 = new JLabel();
		panel7 = new JPanel();
		choosePlank = new JRadioButton();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label10 = new JLabel();
		selectPlanks = new JComboBox();
		panel5 = new JPanel();
		startAlching = new JButton();
		startSH = new JButton();
		startTeleport = new JButton();
		startEnchant = new JButton();
		label4 = new JLabel();
		startGate = new JButton();
		startStunAlching = new JButton();
		startHumid = new JButton();
		startStringing = new JButton();
		startPlank = new JButton();

		//======== this ========
		setBackground(new Color(51, 51, 51));
		setResizable(false);
		setTitle("Fascinating Magician Options");
		Container contentPane = getContentPane();

		//======== tabbedPane1 ========
		{

			//======== panel1 ========
			{

				// JFormDesigner evaluation mark
				panel1.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				panel1.setLayout(null);

				//---- highAlc ----
				highAlc.setText("High Alching?");
				highAlc.setForeground(Color.BLACK);
				panel1.add(highAlc);
				highAlc.setBounds(new Rectangle(new Point(15, 25), highAlc.getPreferredSize()));

				//---- lowAlch ----
				lowAlch.setText("Low Alching?");
				lowAlch.setForeground(Color.BLACK);
				panel1.add(lowAlch);
				lowAlch.setBounds(new Rectangle(new Point(165, 25), lowAlch.getPreferredSize()));

				//---- idText ----
				idText.setText("Enter ID Here");
				panel1.add(idText);
				idText.setBounds(95, 60, 105, idText.getPreferredSize().height);

				//---- label2 ----
				label2.setText("By Fascination");
				label2.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label2.setForeground(Color.BLACK);
				panel1.add(label2);
				label2.setBounds(new Rectangle(new Point(270, 160), label2.getPreferredSize()));

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
			tabbedPane1.addTab("Alching", panel1);


			//======== panel2 ========
			{
				panel2.setLayout(null);

				//---- checkTele ----
				checkTele.setText("You need to teleport somewhere?");
				checkTele.setForeground(Color.BLACK);
				panel2.add(checkTele);
				checkTele.setBounds(new Rectangle(new Point(40, 35), checkTele.getPreferredSize()));

				//---- label1 ----
				label1.setText("Have your desired teleport spell in slot 2");
				label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() - 2f));
				label1.setForeground(Color.BLACK);
				panel2.add(label1);
				label1.setBounds(new Rectangle(new Point(45, 75), label1.getPreferredSize()));

				//---- label3 ----
				label3.setText("By Fascination");
				label3.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label3.setForeground(Color.BLACK);
				panel2.add(label3);
				label3.setBounds(270, 160, 75, 19);

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
			tabbedPane1.addTab("Teleporting", panel2);


			//======== panel3 ========
			{
				panel3.setLayout(null);

				//---- barToHeat ----
				barToHeat.setModel(new DefaultComboBoxModel(new String[] {
					"Bar to superheat?",
					"Iron",
					"Steel",
					"Silver",
					"Gold",
					"Mithril",
					"Adamant",
					"Runite"
				}));
				panel3.add(barToHeat);
				barToHeat.setBounds(new Rectangle(new Point(80, 55), barToHeat.getPreferredSize()));

				//---- coalBag ----
				coalBag.setText("Coal Bag");
				coalBag.setForeground(Color.BLACK);
				panel3.add(coalBag);
				coalBag.setBounds(new Rectangle(new Point(115, 90), coalBag.getPreferredSize()));

				//---- checkSuperheat ----
				checkSuperheat.setText("Lets superheat!");
				checkSuperheat.setForeground(Color.BLACK);
				panel3.add(checkSuperheat);
				checkSuperheat.setBounds(new Rectangle(new Point(90, 10), checkSuperheat.getPreferredSize()));

				//---- label6 ----
				label6.setText("By Fascination");
				label6.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label6.setForeground(Color.BLACK);
				panel3.add(label6);
				label6.setBounds(270, 160, 75, 19);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel3.getComponentCount(); i++) {
						Rectangle bounds = panel3.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel3.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel3.setMinimumSize(preferredSize);
					panel3.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Superheat", panel3);


			//======== panel4 ========
			{
				panel4.setFont(panel4.getFont().deriveFont(panel4.getFont().getSize() - 2f));
				panel4.setLayout(null);

				//---- checkEnchantBolts ----
				checkEnchantBolts.setText("Enchanting Bolts?");
				checkEnchantBolts.setForeground(Color.BLACK);
				checkEnchantBolts.setFont(checkEnchantBolts.getFont().deriveFont(checkEnchantBolts.getFont().getSize() - 2f));
				panel4.add(checkEnchantBolts);
				checkEnchantBolts.setBounds(new Rectangle(new Point(5, 10), checkEnchantBolts.getPreferredSize()));

				//---- chooseBolts ----
				chooseBolts.setModel(new DefaultComboBoxModel(new String[] {
					"Choose your bolts!",
					"Jade",
					"Pearl",
					"Opal",
					"Sapphire",
					"Dragonstone",
					"Red Topaz",
					"Emerald",
					"Ruby",
					"Diamond",
					"Onyx"
				}));
				panel4.add(chooseBolts);
				chooseBolts.setBounds(new Rectangle(new Point(130, 10), chooseBolts.getPreferredSize()));

				//---- checkAmulet ----
				checkAmulet.setText("Enchanting -> Amulet?");
				checkAmulet.setForeground(Color.BLACK);
				checkAmulet.setFont(checkAmulet.getFont().deriveFont(checkAmulet.getFont().getSize() - 2f));
				panel4.add(checkAmulet);
				checkAmulet.setBounds(5, 45, 160, 23);

				//---- chooseAmulet ----
				chooseAmulet.setModel(new DefaultComboBoxModel(new String[] {
					"Sapphire",
					"Emerald",
					"Ruby",
					"Diamond",
					"Dragonstone",
					"Onyx"
				}));
				panel4.add(chooseAmulet);
				chooseAmulet.setBounds(new Rectangle(new Point(165, 45), chooseAmulet.getPreferredSize()));

				//---- checkBrace ----
				checkBrace.setText("Enchanting -> Bracelet?");
				checkBrace.setForeground(Color.BLACK);
				checkBrace.setFont(checkBrace.getFont().deriveFont(checkBrace.getFont().getSize() - 2f));
				panel4.add(checkBrace);
				checkBrace.setBounds(5, 80, 160, 23);

				//---- chooseBracelet ----
				chooseBracelet.setModel(new DefaultComboBoxModel(new String[] {
					"Sapphire",
					"Emerald",
					"Ruby",
					"Diamond",
					"Dragonstone",
					"Onyx"
				}));
				panel4.add(chooseBracelet);
				chooseBracelet.setBounds(165, 80, 137, 27);

				//---- checkNeck ----
				checkNeck.setText("Enchanting -> Necklace?");
				checkNeck.setForeground(Color.BLACK);
				checkNeck.setFont(checkNeck.getFont().deriveFont(checkNeck.getFont().getSize() - 2f));
				panel4.add(checkNeck);
				checkNeck.setBounds(5, 115, 160, 23);

				//---- chooseNecklace ----
				chooseNecklace.setModel(new DefaultComboBoxModel(new String[] {
					"Sapphire",
					"Emerald",
					"Ruby",
					"Diamond",
					"Dragonstone",
					"Onyx"
				}));
				panel4.add(chooseNecklace);
				chooseNecklace.setBounds(165, 115, 137, 27);

				//---- checkRing ----
				checkRing.setText("Enchanting -> Ring?");
				checkRing.setForeground(Color.BLACK);
				checkRing.setFont(checkRing.getFont().deriveFont(checkRing.getFont().getSize() - 2f));
				panel4.add(checkRing);
				checkRing.setBounds(5, 150, 160, 23);

				//---- chooseRing ----
				chooseRing.setModel(new DefaultComboBoxModel(new String[] {
					"Sapphire",
					"Emerald",
					"Ruby",
					"Diamond",
					"Dragonstone",
					"Onyx"
				}));
				panel4.add(chooseRing);
				chooseRing.setBounds(new Rectangle(new Point(165, 150), chooseRing.getPreferredSize()));

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
			tabbedPane1.addTab("Enchanting", panel4);


			//======== panel8 ========
			{
				panel8.setLayout(null);

				//---- label11 ----
				label11.setText("Gatestone Creator");
				label11.setFont(new Font("Optima", Font.BOLD, 14));
				panel8.add(label11);
				label11.setBounds(new Rectangle(new Point(100, 5), label11.getPreferredSize()));

				//---- checkGatestone ----
				checkGatestone.setText("Make sure to tick this If you're using gatestone\ncreator\n");
				checkGatestone.setFont(checkGatestone.getFont().deriveFont(checkGatestone.getFont().getSize() - 2f));
				panel8.add(checkGatestone);
				checkGatestone.setBounds(new Rectangle(new Point(0, 35), checkGatestone.getPreferredSize()));

				//---- label12 ----
				label12.setText("Have Cosmic runes binded");
				panel8.add(label12);
				label12.setBounds(new Rectangle(new Point(80, 75), label12.getPreferredSize()));

				//---- label13 ----
				label13.setText("By Fascination");
				label13.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label13.setForeground(Color.BLACK);
				panel8.add(label13);
				label13.setBounds(270, 160, 75, 19);

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
			tabbedPane1.addTab("Gatestone..", panel8);


			//======== panel6 ========
			{
				panel6.setLayout(null);

				//---- label5 ----
				label5.setText("By Fascination");
				label5.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label5.setForeground(Color.BLACK);
				panel6.add(label5);
				label5.setBounds(270, 160, 75, 19);

				//---- checkStun ----
				checkStun.setText("Using Stun Alching?");
				panel6.add(checkStun);
				checkStun.setBounds(new Rectangle(new Point(115, 15), checkStun.getPreferredSize()));

				//---- chooseStun ----
				chooseStun.setText("Stun");
				panel6.add(chooseStun);
				chooseStun.setBounds(new Rectangle(new Point(15, 60), chooseStun.getPreferredSize()));

				//---- chooseCurse ----
				chooseCurse.setText("Curse");
				panel6.add(chooseCurse);
				chooseCurse.setBounds(new Rectangle(new Point(100, 60), chooseCurse.getPreferredSize()));

				//---- chooseEnfeeble ----
				chooseEnfeeble.setText("Enfeeble");
				panel6.add(chooseEnfeeble);
				chooseEnfeeble.setBounds(new Rectangle(new Point(180, 60), chooseEnfeeble.getPreferredSize()));

				//---- chooseVuln ----
				chooseVuln.setText("Vulnerability");
				panel6.add(chooseVuln);
				chooseVuln.setBounds(new Rectangle(new Point(25, 95), chooseVuln.getPreferredSize()));

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
			tabbedPane1.addTab("Stun Alching", panel6);


			//======== panel10 ========
			{
				panel10.setLayout(null);

				//---- checkString ----
				checkString.setText("Using Stringer?");
				panel10.add(checkString);
				checkString.setBounds(new Rectangle(new Point(110, 15), checkString.getPreferredSize()));

				//---- label16 ----
				label16.setText("Amulet to String: ");
				panel10.add(label16);
				label16.setBounds(15, 60, label16.getPreferredSize().width, 15);

				//---- chooseAmuletToString ----
				chooseAmuletToString.setModel(new DefaultComboBoxModel(new String[] {
					"Gold Amulet",
					"Sapphire Amulet",
					"Emerald Amuet",
					"Ruby Amulet",
					"Diamond Amulet",
					"Dragonstone Amulet",
					"Onyx Amulet"
				}));
				panel10.add(chooseAmuletToString);
				chooseAmuletToString.setBounds(135, 60, 160, chooseAmuletToString.getPreferredSize().height);

				//---- label18 ----
				label18.setText("By Fascination");
				label18.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label18.setForeground(Color.BLACK);
				panel10.add(label18);
				label18.setBounds(270, 160, 75, 19);

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
			tabbedPane1.addTab("Stringing", panel10);


			//======== panel9 ========
			{
				panel9.setLayout(null);

				//---- checkHumidify ----
				checkHumidify.setText("Humidify Vials");
				panel9.add(checkHumidify);
				checkHumidify.setBounds(new Rectangle(new Point(110, 15), checkHumidify.getPreferredSize()));

				//---- label14 ----
				label14.setText("- Have all the items required and start");
				panel9.add(label14);
				label14.setBounds(new Rectangle(new Point(65, 60), label14.getPreferredSize()));

				//---- label15 ----
				label15.setText("- Have Humidify binded to \"6\"");
				panel9.add(label15);
				label15.setBounds(new Rectangle(new Point(85, 85), label15.getPreferredSize()));

				//---- label17 ----
				label17.setText("By Fascination");
				label17.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label17.setForeground(Color.BLACK);
				panel9.add(label17);
				label17.setBounds(270, 160, 75, 19);

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
			tabbedPane1.addTab("Humidify", panel9);


			//======== panel7 ========
			{
				panel7.setLayout(null);

				//---- choosePlank ----
				choosePlank.setText("Do dem' Planks ya boy'");
				choosePlank.setForeground(Color.BLACK);
				panel7.add(choosePlank);
				choosePlank.setBounds(new Rectangle(new Point(65, 10), choosePlank.getPreferredSize()));

				//---- label7 ----
				label7.setText("By Fascination");
				label7.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label7.setForeground(Color.BLACK);
				panel7.add(label7);
				label7.setBounds(240, 160, 75, 19);

				//---- label8 ----
				label8.setText("Have earth staff wielded");
				label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() - 2f));
				label8.setForeground(Color.BLACK);
				panel7.add(label8);
				label8.setBounds(new Rectangle(new Point(90, 45), label8.getPreferredSize()));

				//---- label9 ----
				label9.setText("Have Plank Make spell binded to slot 1");
				label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() - 2f));
				label9.setForeground(Color.BLACK);
				panel7.add(label9);
				label9.setBounds(new Rectangle(new Point(55, 60), label9.getPreferredSize()));

				//---- label10 ----
				label10.setText("Plank Selection:");
				label10.setForeground(Color.BLACK);
				panel7.add(label10);
				label10.setBounds(new Rectangle(new Point(25, 95), label10.getPreferredSize()));

				//---- selectPlanks ----
				selectPlanks.setModel(new DefaultComboBoxModel(new String[] {
					"Normal",
					"Oak",
					"Teak",
					"Mahogany"
				}));
				panel7.add(selectPlanks);
				selectPlanks.setBounds(new Rectangle(new Point(135, 95), selectPlanks.getPreferredSize()));

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
			tabbedPane1.addTab("Plank Make", panel7);


			//======== panel5 ========
			{
				panel5.setLayout(null);

				//---- startAlching ----
				startAlching.setText("Alching");
				startAlching.setFont(startAlching.getFont().deriveFont(startAlching.getFont().getSize() - 2f));
				startAlching.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startAlchingActionPerformed(e);
					}
				});
				panel5.add(startAlching);
				startAlching.setBounds(new Rectangle(new Point(115, 10), startAlching.getPreferredSize()));

				//---- startSH ----
				startSH.setText("Superheat");
				startSH.setFont(startSH.getFont().deriveFont(startSH.getFont().getSize() - 2f));
				startSH.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startSHActionPerformed(e);
					}
				});
				panel5.add(startSH);
				startSH.setBounds(5, 10, 115, 29);

				//---- startTeleport ----
				startTeleport.setText("Teleporting");
				startTeleport.setFont(startTeleport.getFont().deriveFont(startTeleport.getFont().getSize() - 2f));
				startTeleport.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startTeleportActionPerformed(e);
					}
				});
				panel5.add(startTeleport);
				startTeleport.setBounds(195, 10, 105, startTeleport.getPreferredSize().height);

				//---- startEnchant ----
				startEnchant.setText("Enchanting");
				startEnchant.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				startEnchant.setRolloverEnabled(true);
				startEnchant.setFont(startEnchant.getFont().deriveFont(startEnchant.getFont().getSize() - 2f));
				startEnchant.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startEnchantActionPerformed(e);
					}
				});
				panel5.add(startEnchant);
				startEnchant.setBounds(new Rectangle(new Point(25, 40), startEnchant.getPreferredSize()));

				//---- label4 ----
				label4.setText("By Fascination");
				label4.setFont(new Font("Nanum Brush Script", Font.PLAIN, 16));
				label4.setForeground(Color.BLACK);
				panel5.add(label4);
				label4.setBounds(270, 160, 75, 19);

				//---- startGate ----
				startGate.setText("Gatestone creator");
				startGate.setFont(startGate.getFont().deriveFont(startGate.getFont().getSize() - 2f));
				startGate.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startGateActionPerformed(e);
					}
				});
				panel5.add(startGate);
				startGate.setBounds(45, 70, 125, startGate.getPreferredSize().height);

				//---- startStunAlching ----
				startStunAlching.setText("Stun Alching");
				startStunAlching.setFont(startStunAlching.getFont().deriveFont(startStunAlching.getFont().getSize() - 2f));
				startStunAlching.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startStunAlchingActionPerformed(e);
					}
				});
				panel5.add(startStunAlching);
				startStunAlching.setBounds(new Rectangle(new Point(125, 40), startStunAlching.getPreferredSize()));

				//---- startHumid ----
				startHumid.setText("Humidify");
				startHumid.setFont(startHumid.getFont().deriveFont(startHumid.getFont().getSize() - 2f));
				startHumid.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startHumidActionPerformed(e);
					}
				});
				panel5.add(startHumid);
				startHumid.setBounds(new Rectangle(new Point(230, 40), startHumid.getPreferredSize()));

				//---- startStringing ----
				startStringing.setText("Stringer");
				startStringing.setFont(startStringing.getFont().deriveFont(startStringing.getFont().getSize() - 2f));
				startStringing.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startStringingActionPerformed(e);
					}
				});
				panel5.add(startStringing);
				startStringing.setBounds(new Rectangle(new Point(170, 70), startStringing.getPreferredSize()));

				//---- startPlank ----
				startPlank.setText("Plank Make");
				startPlank.setFont(startPlank.getFont().deriveFont(startPlank.getFont().getSize() - 2f));
				startPlank.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						startPlankActionPerformed(e);
					}
				});
				panel5.add(startPlank);
				startPlank.setBounds(new Rectangle(new Point(60, 100), startPlank.getPreferredSize()));

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
			tabbedPane1.addTab("Finish", panel5);

		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 11, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - guest Bhide
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JRadioButton highAlc;
	private JRadioButton lowAlch;
	private JTextField idText;
	private JLabel label2;
	private JPanel panel2;
	private JRadioButton checkTele;
	private JLabel label1;
	private JLabel label3;
	private JPanel panel3;
	private JComboBox barToHeat;
	private JRadioButton coalBag;
	private JRadioButton checkSuperheat;
	private JLabel label6;
	private JPanel panel4;
	private JRadioButton checkEnchantBolts;
	private JComboBox chooseBolts;
	private JRadioButton checkAmulet;
	private JComboBox chooseAmulet;
	private JRadioButton checkBrace;
	private JComboBox chooseBracelet;
	private JRadioButton checkNeck;
	private JComboBox chooseNecklace;
	private JRadioButton checkRing;
	private JComboBox chooseRing;
	private JPanel panel8;
	private JLabel label11;
	private JRadioButton checkGatestone;
	private JLabel label12;
	private JLabel label13;
	private JPanel panel6;
	private JLabel label5;
	private JRadioButton checkStun;
	private JCheckBox chooseStun;
	private JCheckBox chooseCurse;
	private JCheckBox chooseEnfeeble;
	private JCheckBox chooseVuln;
	private JPanel panel10;
	private JRadioButton checkString;
	private JLabel label16;
	private JComboBox chooseAmuletToString;
	private JLabel label18;
	private JPanel panel9;
	private JRadioButton checkHumidify;
	private JLabel label14;
	private JLabel label15;
	private JLabel label17;
	private JPanel panel7;
	private JRadioButton choosePlank;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JComboBox selectPlanks;
	private JPanel panel5;
	private JButton startAlching;
	private JButton startSH;
	private JButton startTeleport;
	private JButton startEnchant;
	private JLabel label4;
	private JButton startGate;
	private JButton startStunAlching;
	private JButton startHumid;
	private JButton startStringing;
	private JButton startPlank;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
