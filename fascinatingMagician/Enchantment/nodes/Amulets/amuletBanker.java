package fascinatingMagician.Enchantment.nodes.Amulets;

import java.awt.event.KeyEvent;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingMagician.Variables;

public class amuletBanker extends Node{

	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		return Variables.amulet;
	}

	@Override
	public void execute() {
		if(Variables.amulet){
			
			if(Inventory.getItem(Variables.amuletToEnchant) == null){
				if(!Bank.isOpen()){
					Bank.open();
				} else {
					
				if(Inventory.contains(new int[] {Variables.eSapAmulet})){
					Bank.deposit(Variables.eSapAmulet, 0);
					Task.sleep(500, 750);
				} else if(Inventory.contains(new int[] {Variables.eEmeAmulet})){
					Bank.deposit(Variables.eEmeAmulet, 0);
					Task.sleep(500, 750);
				} else if(Inventory.contains(new int[] {Variables.eRubAmulet})){
					Bank.deposit(Variables.eRubAmulet, 0);
					Task.sleep(500, 750);
				} else if(Inventory.contains(new int[] {Variables.eDiaAmulet})){
					Bank.deposit(Variables.eDiaAmulet, 0);
					Task.sleep(500, 750);
				} else if(Inventory.contains(new int[] {Variables.eDraAmulet})){
					Bank.deposit(Variables.eDraAmulet, 0);
					Task.sleep(500, 750);
				} else if(Inventory.contains(new int[] {Variables.eOnyAmulet})){
					Bank.deposit(Variables.eOnyAmulet, 0);
					Task.sleep(500, 750);
				}
				
					if(Inventory.getItem(Variables.COSMIC_RUNE) == null){
						Bank.withdraw(Variables.COSMIC_RUNE, 0);
					}
					Bank.withdraw(Variables.amuletToEnchant, 27); //232
					
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
