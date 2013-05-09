package fascinatingFleshCrawler.Methods.sk.action.ability;

import org.powerbot.game.api.wrappers.widget.WidgetChild;

import fascinatingFleshCrawler.Methods.sk.action.Ability;
import fascinatingFleshCrawler.Methods.sk.general.Completion;
import fascinatingFleshCrawler.Methods.sk.tab.MainTabs;
import fascinatingFleshCrawler.Methods.sk.tab.Tab;

public enum Prayer implements Ability {
	;

	@Override
	public boolean show() {
		return false;
	}

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public boolean available() {
		return false;
	}

	public Tab getTab() {
		return MainTabs.PRAYER;
	}

	@Override
	public WidgetChild getChild() {
		return null;
	}

	@Override
	public Completion getChange() {
		return null;
	}

	@Override
	public int getAbilityId() {
		return 0;
	}

}
