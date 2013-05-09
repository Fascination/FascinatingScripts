package fascinatingFleshCrawler.combat.AbilityNode;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import fascinatingFleshCrawler.Variables;
import fascinatingFleshCrawler.Methods.sk.action.ActionBar;

public class UseAbilities extends Node {

	@Override
	public boolean activate() {
		
		return Players.getLocal().getInteracting() != null;
	}

	@Override
	public void execute() {
		if ((Settings.get(689) & 0x400) != 0x400) {
			for (int i = 0; i < 12; i++) {
				if (ActionBar.isReady(i) && ActionBar.getAbilityInSlot(i).available()) {
					ActionBar.useSlot(i);
					break;
				}
			}
		} else {
			ensureActionBar(false);
		}
	}

	// Credits to HarryNoob :)
	private void ensureActionBar(boolean flag) {
		if (flag) {
			WidgetChild actionbar = Widgets.get(640, 6);
			if (actionbar != null && !actionbar.isOnScreen()) {
				WidgetChild abToggle = Widgets.get(640, 28);
				if (abToggle != null) {
					abToggle.interact("Expand");
				}
			}
		} else {
			WidgetChild actionbar = Widgets.get(640, 6);
			if (actionbar != null && actionbar.isOnScreen()) {
				WidgetChild abToggle = Widgets.get(640, 30);
				if (abToggle != null) {
					abToggle.interact("Minimise");
				}
			}
		}
	}
}