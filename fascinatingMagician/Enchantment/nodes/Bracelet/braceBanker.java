package fascinatingMagician.Enchantment.nodes.Bracelet;

import java.awt.event.KeyEvent;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import fascinatingMagician.Variables;

public class braceBanker extends Node{

	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		return Variables.bracelet;
	}

	@Override
	public void execute() {
		if(Variables.bracelet){
			
			if(Inventory.getItem(Variables.braceToEnchant) == null){
				if(!Bank.isOpen()){
					Bank.open();
				} else {
					
					if(Inventory.contains(new int[] {Variables.eSapBrace})){
						Bank.deposit(Variables.eSapBrace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eEmeBrace})){
						Bank.deposit(Variables.eEmeBrace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eRubBrace})){
						Bank.deposit(Variables.eRubBrace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eDiaBrace})){
						Bank.deposit(Variables.eDiaBrace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eDraBrace})){
						Bank.deposit(Variables.eDraBrace, 0);
						Task.sleep(500, 750);
					} else if(Inventory.contains(new int[] {Variables.eOnyBrace})){
						Bank.deposit(Variables.eOnyBrace, 0);
						Task.sleep(500, 750);
					}
				
				
					if(Inventory.getItem(Variables.COSMIC_RUNE) == null){
						Bank.withdraw(Variables.COSMIC_RUNE, 0);
					}
					Bank.withdraw(Variables.braceToEnchant, 27); //232
					
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
