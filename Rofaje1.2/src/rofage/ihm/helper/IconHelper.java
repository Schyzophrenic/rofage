package rofage.ihm.helper;

import java.io.File;

import javax.swing.ImageIcon;

import rofage.common.Consts;
import rofage.common.helper.GameDisplayHelper;
import rofage.common.object.Configuration;
import rofage.common.object.Game;
import rofage.common.url.URLToolkit;

public abstract class IconHelper {
	
	public static ImageIcon getLocationIcon (Game game) {
		return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/flags/"+Consts.FLAG_NAMES.get(game.getLocation())+".png"));
	}
	
	public static ImageIcon getGotRomIcon (Game game) {
		if (game.isGotRom()) {
			if (game.isGoodName()) {
				return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/rom.png")); //$NON-NLS-1$
			} else {
				return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/rom_badname.png")); //$NON-NLS-1$
			}
		}
		return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/no_rom.png")); //$NON-NLS-1$
	}
	
	public static ImageIcon getRomIcon (Game game, Configuration conf) {
		String iconName = GameDisplayHelper.constructFileName(game, URLToolkit.TYPE_ICON);
		String folderPath = Consts.HOME_FOLDER+File.separator+conf.getImageFolder()+File.separator+Consts.ICO_FOLDER+File.separator;
		File iconeFile = new File (folderPath+iconName);
		if (iconeFile.exists()) return new ImageIcon(folderPath+iconName);
		return null;
	}
	
	public static ImageIcon getCleanDumpIcon (Game game) {
		if (!game.isGotRom()) {
			return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/no_rom.png")); //$NON-NLS-1$					
		} else {
			if (game.isScannedFromSerial()) {
				return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/rom_notclean.png"));
			} else {
				return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/rom_clean.png"));
			}
		}
	}
	
	public static ImageIcon getWifiIcon (Game game) {
		if (game.getWifi()!=null) {
			if (game.getWifi()) {
				return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/wifi.png"));
			} else {
				return new ImageIcon(IconHelper.class.getClassLoader().getResource("rofage/ihm/images/no_wifi.png"));
			}
		}
		return null;
	}
}
