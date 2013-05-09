package fascinatingMagician.Enchantment.nodes.Rings;

import java.awt.event.KeyEvent;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingMagician.Variables;

public class ringBanker extends Node{

	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		return Variables.ring;
	}

	@Override
	public void execute() {
		if(Variables.ring){
			
			if(Inventory.getItem(Variables.ringToEnchant) == null){
				if(!Bank.isOpen()){
					Bank.open();
				} else {
					
					if(Inventory.contains(new int[] {Variables.eSapRing})){
						Bank.deposit(Variables.eSapRing, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eEmeRing})){
						Bank.deposit(Variables.eEmeRing, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eRubRing})){
						Bank.deposit(Variables.eRubRing, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eDiaRing})){
						Bank.deposit(Variables.eDiaRing, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eDraRing})){
						Bank.deposit(Variables.eDraRing, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eOnyRing})){
						Bank.deposit(Variables.eOnyRing, 0);
						Task.sleep(500, 750);
					}
				
				
					if(Inventory.getItem(Variables.COSMIC_RUNE) == null){
						Bank.withdraw(Variables.COSMIC_RUNE, 0);
					}
					Bank.withdraw(Variables.ringToEnchant, 27); //232
					
					Bank.close();
					
					Keyboard.sendKey((char) KeyEvent.VK_ESCAPE, 50, 50);
					Keyboard.sendKey((char) KeyEvent.VK_ESCAPE, 25);
					System.out.println("OUT!");
					
					Task.sleep(1000, 2000);
				}
			}
			
		}
		
	}

}
