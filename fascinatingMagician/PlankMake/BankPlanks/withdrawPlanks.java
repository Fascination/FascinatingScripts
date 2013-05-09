package fascinatingMagician.PlankMake.BankPlanks;

import javax.swing.JOptionPane;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.bot.Context;

import fascinatingMagician.Variables;

public class withdrawPlanks extends Node{

	@Override
	public boolean activate() {
		if(!Variables.GUIFinished){
			return false;
		}
		
		
		
		return Variables.plankmake && !Inventory.contains(new int[] {Variables.logsToPlank});
	}

	@Override
	public void execute() {
		
	Mouse.setSpeed(Mouse.Speed.VERY_FAST);
		if(!Inventory.contains(new int[] {Variables.logsToPlank})){
			if(!Bank.isOpen()){
				Variables.status = "Opening Bank";
				Bank.open();
			} else {
				
				if (Inventory.contains(new int[] {Variables.normal_plank})){
					Variables.status = "Banking..";
					Bank.deposit(Variables.normal_plank, 0);
				} else if (Inventory.contains(new int[] {Variables.oak_plank})){
					Variables.status = "Banking..";
					Bank.deposit(Variables.oak_plank, 0);
				} else if (Inventory.contains(new int[] {Variables.teak_plank})){
					Variables.status = "Banking..";
					Bank.deposit(Variables.teak_plank, 0);
				} else if (Inventory.contains(new int[] {Variables.mahogany_plank})){
					Variables.status = "Banking..";
					Bank.deposit(Variables.mahogany_plank, 0);
				}
				
				
				if(Bank.getItem(Variables.logsToPlank) != null){
					
					
					if (Bank.getItemCount(Variables.logsToPlank) == 0){
						JOptionPane.showMessageDialog(null, "Stopped. Reason: Don't have any more Logs");
						Context.get().getScriptHandler().shutdown();
					} else {

							/*if (!Inventory.contains(new int[] {Variables.astral}) ){
								JOptionPane.showMessageDialog(null, "Stopped. Reason: Don't have any more astral runes");
								Context.get().getScriptHandler().shutdown();
							} else {
								Bank.withdraw(Variables.astral, 0);
							}
							*/
						
						
						/*
						 *  else  {
							if(!Inventory.contains(new int[] {Variables.NATURE_RUNE})){
								if(Bank.getItemCount(Variables.NATURE_RUNE) == 0 &&
										!Inventory.contains(new int[] {Variables.NATURE_RUNE})){
								JOptionPane.showMessageDialog(null, "Stopped. Reason: Don't have any more nature runes");
								Context.get().getScriptHandler().shutdown();
							}
						}
						 */
							
						}
						
					if(Inventory.getCount() == 2){
					
						Variables.status = "Withdrawing Logs";
						Bank.withdraw(Variables.logsToPlank, 26);
					}
					
						
					} else {
						JOptionPane.showMessageDialog(null, "Ran out of logs");
						Context.get().getScriptHandler().shutdown();
					}
				}
			} else {
				if(Bank.isOpen()){
					Bank.close();
				}
			}
			
		}
		
	}


