package fascinatingFleshCrawler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.util.Random;

import fascinatingFleshCrawler.banking.WithdrawFood;
import fascinatingFleshCrawler.banking.StrengthPotions.WithdrawStrPot;
import fascinatingFleshCrawler.banking.StrengthPotions.WithdrawSuperStrPot;
import fascinatingFleshCrawler.banking.edgeville.BankingAll;
import fascinatingFleshCrawler.combat.KillMonster;

import fascinatingFleshCrawler.combat.AbilityNode.UseAbilities;
import fascinatingFleshCrawler.combat.foodCheck.EatFood;
import fascinatingFleshCrawler.looting.LootValuables;
import fascinatingFleshCrawler.traverse.PathToDungeon;
import fascinatingFleshCrawler.traverse.Edgeville.PathFromBankToDung;
import fascinatingFleshCrawler.traverse.Edgeville.TeleportTo;
import fascinatingFleshCrawler.traverse.Edgeville.WalkToBank;
import fascinatingFleshCrawler.traverse.inDungeon.ClickEntrance;
import fascinatingFleshCrawler.traverse.inDungeon.WalkingThroughMaze;
import fascinatingFleshCrawler.GUI;


@Manifest(authors = { "Fascination" }, name = "[v0.25] Fascinating FleshCrawler", description = "Fights Flesh crawlers for herbs, gems and combat exp", hidden = true )
public class FascinatingFleshCrawler extends ActiveScript implements PaintListener, MouseListener{

private final Node[] array = new Node[] {
		
		//traverse
		//new ClickEntrance(), new WalkingThroughMaze(),
		//new WalkToBank(), new TeleportTo(), new PathFromBankToDung(),
		
		
		//banking
		new WithdrawFood(), new BankingAll(), new WithdrawStrPot(), new WithdrawSuperStrPot()
		
		//combat
		//new KillMonster(), new EatFood(), new UseAbilities(),
		
		//looting
		//new LootValuables()
		
}; //add classes here
	
	@Override
    public int loop() {

            for (final Node node : array) {
                    if (node.activate()) {
                            node.execute();
                    }
            }
            return Random.nextInt(10, 50);
    }

	public void onStart(){
		initiateGUI();
		
	}
	
	
	public void initiateGUI() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final GUI gui = new GUI();
				gui.setVisible(true);
				gui.setResizable(false);
			}
		});

	}


	
	public void onRepaint(Graphics g1) {
		
	if(Variables.summaryClicked){
		

		 final Color color1 = new Color(0, 0, 0, 184);
	     final Color color2 = new Color(0, 0, 0, 216);
	     final Color color3 = new Color(102, 102, 102, 52);
	     final Color color4 = new Color(0, 0, 0, 224);
	     final Color color5 = new Color(102, 102, 102);
	     final Color color6 = new Color(255, 255, 255);
	     final Color color7 = new Color(102, 204, 255);
	     final Color color8 = new Color(204, 255, 204, 44);
	     final Color color9 = new Color(255, 255, 204, 91);
	     final Color color10 = new Color(204, 204, 0);

	     final BasicStroke stroke1 = new BasicStroke(2);
	     final BasicStroke stroke2 = new BasicStroke(1);

	     final Font font1 = new Font("Arial", 0, 11);
	     final Font font2 = new Font("Arial", 1, 13);

	    
		
		
        Graphics2D g = (Graphics2D)g1;
        g.setColor(color1);
        g.fillRect(7, 395, 491, 114);
        g.setColor(color2);
        g.fillRect(14, 404, 95, 26);
        g.setColor(color3);
        g.setStroke(stroke1);
        g.drawRect(14, 404, 95, 26);
        g.setColor(color4);
        g.fillRect(340, 290, 0, 0);
        g.setColor(color5);
        g.setStroke(stroke2);
        g.drawRect(340, 290, 0, 0);
        g.setColor(color4);
        g.fillRect(14, 436, 93, 25);
        g.setFont(font1);
        g.setColor(color6);
        g.drawString("STATISTICS", 29, 422);
        g.setColor(color7);
        g.drawString("SUMMARY", 29, 451);
        g.setColor(color8);
        g.fillRect(15, 480, 465, 15);
        g.setColor(color9);
        g.fillRect(435, 285, 0, 0);
        g.setColor(color10);
        g.drawString("Status:", 22, 491);
        g.setColor(color6);
        g.drawString("" + Variables.status, 60, 491);
        g.drawString("Profit:", 135, 420);
        g.drawString("Profit P/H:", 135, 435);
        g.drawString("Foods Eaten:", 270, 420);
        g.drawString("Foods Eaten P/H:", 270, 435);
        g.drawString("Charms:", 420, 420);
        g.drawString("Charms P/H:", 420, 435);
        g.setFont(font2);
        g.drawString("Time Running:", 165, 75);
        g.setFont(font1);
        g.drawString("Kills: " + Variables.killCount, 195, 465);
        g.drawString("Kills P/H:", 300, 465);
	}
	
	if(Variables.statsClicked){
		
		  final Color color1 = new Color(0, 0, 0, 184);
		     final Color color2 = new Color(0, 0, 0, 216);
		     final Color color3 = new Color(102, 102, 102, 52);
		     final Color color4 = new Color(0, 0, 0, 224);
		     final Color color5 = new Color(102, 102, 102);
		     final Color color6 = new Color(102, 204, 255);
		     final Color color7 = new Color(255, 255, 255);
		     final Color color8 = new Color(204, 255, 204, 44);
		     final Color color9 = new Color(255, 255, 204, 91);
		     final Color color10 = new Color(204, 204, 0);

		     final BasicStroke stroke1 = new BasicStroke(2);
		     final BasicStroke stroke2 = new BasicStroke(1);

		     final Font font1 = new Font("Arial", 0, 11);

		     Graphics2D g = (Graphics2D)g1;
		        g.setColor(color1);
		        g.fillRect(7, 395, 491, 114);
		        g.setColor(color2);
		        g.fillRect(14, 404, 95, 26);
		        g.setColor(color3);
		        g.setStroke(stroke1);
		        g.drawRect(14, 404, 95, 26);
		        g.setColor(color4);
		        g.fillRect(340, 290, 0, 0);
		        g.setColor(color5);
		        g.setStroke(stroke2);
		        g.drawRect(340, 290, 0, 0);
		        g.setColor(color4);
		        g.fillRect(14, 436, 93, 25);
		        g.setFont(font1);
		        g.setColor(color6);
		        g.drawString("STATISTICS", 29, 422);
		        g.setColor(color7);
		        g.drawString("SUMMARY", 29, 451);
		        g.drawString("Attack level:", 120, 420);
		        g.drawString("Attack exp:", 120, 435);
		        g.drawString("Attack exp/h:", 120, 450);
		        g.drawString("Strength level:", 240, 420);
		        g.drawString("Defence Level:", 360, 420);
		        g.drawString("Strength exp:", 240, 435);
		        g.drawString("Strength exp/h:", 240, 450);
		        g.drawString("Defence exp:", 360, 435);
		        g.drawString("Defence exp/h:", 360, 450);
		        g.setColor(color8);
		        g.fillRect(15, 480, 465, 15);
		        g.setColor(color9);
		        g.fillRect(435, 285, 0, 0);
		        g.setColor(color10);
		        g.drawString("Status:", 22, 491);
		        g.setColor(color7);
		        g.drawString("- Status here - ", 60, 491);

		     
	}
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		final Rectangle summary = new Rectangle(14, 436, 93, 25);
		final Rectangle stats = new Rectangle(14, 404, 95, 26);
		
		if (stats.contains(e.getPoint())) {
			Variables.summaryClicked = false;
			Variables.statsClicked = true;
		} else if (summary.contains(e.getPoint())) {
			Variables.summaryClicked = true;
			Variables.statsClicked = false;

		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}