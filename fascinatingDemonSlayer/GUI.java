package fascinatingDemonSlayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu Oct 25 21:49:40 WST 2012
 */



/**
 * @author guest Bhide
 */
public class GUI extends JFrame {
	
	boolean isRunning = true;
	public GUI() {
		initComponents();
	}

	private void startButtonActionPerformed(ActionEvent e) {
		


		this.setVisible(true);

		Variables.GUIFinished = true;

		isRunning = false;
		Variables.startTime = System.currentTimeMillis();
		

		dispose();
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - guest Bhide
		panel1 = new JPanel();
		label1 = new JLabel();
		foodToEat = new JComboBox();
		label2 = new JLabel();
		foodAmountText = new JTextField();
		healAtTzhaar = new JRadioButton();
		panel2 = new JPanel();
		useDungeon = new JRadioButton();
		useUpstairs = new JRadioButton();
		useDownstairs = new JRadioButton();
		label3 = new JLabel();
		panel3 = new JPanel();
		killLesser = new JRadioButton();
		killSpiders = new JRadioButton();
		panel4 = new JPanel();
		useAshes = new JCheckBox();
		panel5 = new JPanel();
		takeGold = new JCheckBox();
		takeGreen = new JCheckBox();
		takeCrimson = new JCheckBox();
		takeBlue = new JCheckBox();
		label4 = new JLabel();
		startButton = new JButton();

		//======== this ========
		setTitle("Options");
		setResizable(false);
		Container contentPane = getContentPane();

		//======== panel1 ========
		{
			panel1.setBorder(new TitledBorder("Food"));

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel1.setLayout(null);

			//---- label1 ----
			label1.setText("Food: ");
			panel1.add(label1);
			label1.setBounds(new Rectangle(new Point(10, 55), label1.getPreferredSize()));

			//---- foodToEat ----
			foodToEat.setModel(new DefaultComboBoxModel(new String[] {
				"Tuna",
				"Lobster",
				"Swordfish",
				"Monkfish",
				"Shark"
			}));
			panel1.add(foodToEat);
			foodToEat.setBounds(new Rectangle(new Point(55, 50), foodToEat.getPreferredSize()));

			//---- label2 ----
			label2.setText("withdraw: ");
			panel1.add(label2);
			label2.setBounds(new Rectangle(new Point(175, 55), label2.getPreferredSize()));
			panel1.add(foodAmountText);
			foodAmountText.setBounds(245, 50, 70, foodAmountText.getPreferredSize().height);

			//---- healAtTzhaar ----
			healAtTzhaar.setText("Heal via TzHaar City");
			panel1.add(healAtTzhaar);
			healAtTzhaar.setBounds(new Rectangle(new Point(75, 15), healAtTzhaar.getPreferredSize()));

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

		//======== panel2 ========
		{
			panel2.setBorder(new TitledBorder("Location"));
			panel2.setLayout(null);

			//---- useDungeon ----
			useDungeon.setText("Dungeon");
			useDungeon.setEnabled(false);
			panel2.add(useDungeon);
			useDungeon.setBounds(new Rectangle(new Point(30, 35), useDungeon.getPreferredSize()));

			//---- useUpstairs ----
			useUpstairs.setText("Upstairs");
			useUpstairs.setEnabled(false);
			panel2.add(useUpstairs);
			useUpstairs.setBounds(new Rectangle(new Point(125, 35), useUpstairs.getPreferredSize()));

			//---- useDownstairs ----
			useDownstairs.setText("Downstairs");
			useDownstairs.setSelected(true);
			panel2.add(useDownstairs);
			useDownstairs.setBounds(new Rectangle(new Point(215, 35), useDownstairs.getPreferredSize()));

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

		//---- label3 ----
		label3.setText("[v0.1]");

		//======== panel3 ========
		{
			panel3.setBorder(new TitledBorder("NPC [Karamja]"));
			panel3.setLayout(null);

			//---- killLesser ----
			killLesser.setText("Lesser Demons");
			panel3.add(killLesser);
			killLesser.setBounds(new Rectangle(new Point(15, 40), killLesser.getPreferredSize()));

			//---- killSpiders ----
			killSpiders.setText("Deadly Red Spiders");
			killSpiders.setEnabled(false);
			panel3.add(killSpiders);
			killSpiders.setBounds(new Rectangle(new Point(150, 40), killSpiders.getPreferredSize()));

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

		//======== panel4 ========
		{
			panel4.setBorder(new TitledBorder("Loot"));
			panel4.setLayout(null);

			//---- useAshes ----
			useAshes.setText("Scatter Accursed Ashes");
			panel4.add(useAshes);
			useAshes.setBounds(new Rectangle(new Point(80, 25), useAshes.getPreferredSize()));

			//======== panel5 ========
			{
				panel5.setBorder(new TitledBorder("Charms"));
				panel5.setLayout(null);

				//---- takeGold ----
				takeGold.setText("Gold Charm");
				takeGold.setFont(takeGold.getFont().deriveFont(takeGold.getFont().getSize() - 4f));
				panel5.add(takeGold);
				takeGold.setBounds(new Rectangle(new Point(10, 20), takeGold.getPreferredSize()));

				//---- takeGreen ----
				takeGreen.setText("Green");
				takeGreen.setFont(takeGreen.getFont().deriveFont(takeGreen.getFont().getSize() - 4f));
				panel5.add(takeGreen);
				takeGreen.setBounds(new Rectangle(new Point(100, 20), takeGreen.getPreferredSize()));

				//---- takeCrimson ----
				takeCrimson.setText("Crimson");
				takeCrimson.setFont(takeCrimson.getFont().deriveFont(takeCrimson.getFont().getSize() - 4f));
				panel5.add(takeCrimson);
				takeCrimson.setBounds(new Rectangle(new Point(160, 20), takeCrimson.getPreferredSize()));

				//---- takeBlue ----
				takeBlue.setText("Blue");
				takeBlue.setFont(takeBlue.getFont().deriveFont(takeBlue.getFont().getSize() - 4f));
				panel5.add(takeBlue);
				takeBlue.setBounds(new Rectangle(new Point(235, 20), takeBlue.getPreferredSize()));

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
			panel4.add(panel5);
			panel5.setBounds(15, 70, 295, 50);

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

		//---- label4 ----
		label4.setText("Fascinating Lesser Demon Slayer");

		//---- startButton ----
		startButton.setText("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}
		});

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label4)
							.addGap(40, 40, 40)
							.addComponent(label3))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(11, 11, 11)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
									.addGap(0, 0, Short.MAX_VALUE))))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(103, 103, 103)
							.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label3)
						.addComponent(label4))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addComponent(startButton)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - guest Bhide
	private JPanel panel1;
	private JLabel label1;
	private JComboBox foodToEat;
	private JLabel label2;
	private JTextField foodAmountText;
	private JRadioButton healAtTzhaar;
	private JPanel panel2;
	private JRadioButton useDungeon;
	private JRadioButton useUpstairs;
	private JRadioButton useDownstairs;
	private JLabel label3;
	private JPanel panel3;
	private JRadioButton killLesser;
	private JRadioButton killSpiders;
	private JPanel panel4;
	private JCheckBox useAshes;
	private JPanel panel5;
	private JCheckBox takeGold;
	private JCheckBox takeGreen;
	private JCheckBox takeCrimson;
	private JCheckBox takeBlue;
	private JLabel label4;
	private JButton startButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}


/*
 * 


		this.setVisible(true);

		Variables.GUIFinished = true;

		isRunning = false;
		Variables.startTime = System.currentTimeMillis();
		Variables.runTime = new Timer(0);

		dispose();
*/