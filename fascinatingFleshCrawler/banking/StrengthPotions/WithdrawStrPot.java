package fascinatingFleshCrawler.banking.StrengthPotions;

import javax.swing.JOptionPane;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.bot.Context;

import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.traverse.Misc;

public class WithdrawStrPot extends Node {

	@Override
	public boolean activate() {
		return Variables.useStrPots;
	}

	@Override
	public void execute() {
		if (Variables.useStrPots) {
			if (!Inventory.contains(Variables.strengthPots)) {
				if (Misc.edgeBankArea
						.contains(Players.getLocal().getLocation())) {
					if(Inventory.contains(Variables.food_monk)){
					if (Bank.isOpen()) {

						if (Bank.getItemCount(Variables.strPot_4) >= 1) {
							Bank.withdraw(Variables.strPot_4, Variables.noOfStr);
								if(Inventory.contains(Variables.food_monk)){
									Bank.close();
								}
						} else {
							if (Bank.getItem(Variables.strPot_4) == null
									&& Bank.getItemCount(Variables.strPot_3) >= 1) {
								Bank.withdraw(Variables.strPot_3,
										Variables.noOfStr);
								if(Inventory.contains(Variables.food_monk)){
									Bank.close();
								}
							} else {
								if (Bank.getItem(Variables.strPot_4) == null
										&& Bank.getItem(Variables.strPot_3) == null
										&& Bank.getItemCount(Variables.strPot_2) >= 1) {
									Bank.withdraw(Variables.strPot_2,
											Variables.noOfStr);
									if(Inventory.contains(Variables.food_monk)){
										Bank.close();
									}
								} else {
									if (Bank.getItem(Variables.strPot_4) == null
											&& Bank.getItem(Variables.strPot_3) == null
											&& Bank.getItem(Variables.strPot_2) == null
											&& Bank.getItemCount(Variables.strPot_1) >= 1) {
										Bank.withdraw(Variables.strPot_1,
												Variables.noOfStr);
										if(Inventory.contains(Variables.food_monk)){
											Bank.close();
										}
									} else {
										JOptionPane
												.showMessageDialog(
														null,
														"Stopped. Reason: Don't have strength potions or else start the script again without strength potions.");
										Context.get().getScriptHandler()
												.shutdown();
									}
								}
							}
						}

					} else {
						Bank.open();
					}

				}

			}
		}

		if (Variables.useSuperStrPots) {
			if (!Inventory.contains(Variables.superStrengthPots)) {
				if (Misc.edgeBankArea
						.contains(Players.getLocal().getLocation())) {
					if (Bank.isOpen()) {

						if (Bank.getItemCount(Variables.superStrPot_4) >= 1) {
							Bank.withdraw(Variables.superStrPot_4,
									Variables.noOfStr);
						}
						if (Bank.getItem(Variables.superStrPot_4) == null
								&& Bank.getItemCount(Variables.superStrPot_3) >= 5) {
							Bank.withdraw(Variables.superStrPot_3,
									Variables.noOfStr);
						}

						if (Bank.getItem(Variables.superStrPot_4) == null
								&& Bank.getItem(Variables.superStrPot_3) == null
								&& Bank.getItemCount(Variables.superStrPot_2) >= 1) {
							Bank.withdraw(Variables.superStrPot_2,
									Variables.noOfStr);
						}

						if (Bank.getItem(Variables.superStrPot_4) == null
								&& Bank.getItem(Variables.superStrPot_3) == null
								&& Bank.getItem(Variables.superStrPot_2) == null
								&& Bank.getItemCount(Variables.superStrPot_1) >= 1) {
							Bank.withdraw(Variables.superStrPot_1,
									Variables.noOfStr);
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											"Stopped. Reason: Don't have super strength potions or else start the script again without super strength potions.");
							Context.get().getScriptHandler().shutdown();
						}
					} else {
						Bank.open();
					}
				}
			}
		}

	}
}
}
