package fascinatingMagician.Alcher.misc;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.widget.Widget;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import fascinatingMagician.Variables;

public class Methods {

	public static boolean isSlotEmpty(final int slot) {
		return Inventory.getItemAt(slot) == null;
	}
	
	public static Image getImage(final String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}
	
	public static void s(final String s) {
		Variables.status = s;
		System.out.println(String.format("[Fascinating Magic] %s", s));
	}
	
	public static boolean isWidgetChildVisible(final WidgetChild wc) {
		return wc != null && wc.validate() && wc.visible() && wc.isOnScreen();
	}

	public static boolean isWidgetVisible(final Widget w) {
		return w != null && w.validate();
	}
	
	private static boolean isItemVisible(final Item i) {
		return i != null && i.getWidgetChild().validate()
				&& i.getWidgetChild().visible()
				&& i.getWidgetChild().isOnScreen();
	}
	
}
