/*
 * Copyright 2009, 2010
 *    Niklas Kyster Rasmussen
 *    Flaming Candle*
 *
 *  (*) Eve-Online names @ http://www.eveonline.com/
 *
 * This file is part of jEveAssets.
 *
 * jEveAssets is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * jEveAssets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jEveAssets; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package net.nikr.eve.jeveasset.gui.settings;

import java.util.Map;
import net.nikr.eve.jeveasset.Program;
import net.nikr.eve.jeveasset.data.EveAsset;
import net.nikr.eve.jeveasset.data.UserPrice;
import net.nikr.eve.jeveasset.gui.shared.JDialogCentered;
import net.nikr.eve.jeveasset.gui.shared.JUserListPanel;


public class UserPriceSettingsPanel extends JUserListPanel<Integer, UserPrice> {

	public UserPriceSettingsPanel(Program program, JDialogCentered jDialogCentered) {
		super(program, jDialogCentered, JUserListPanel.FILTER_NUMBERS_ONLY, "User Price", "Assets", "Price", "\r\nTo add new price:\r\n1. Right click a row in the table\r\n2. Select \"Set Price...\" in the popup menu");
	}

	@Override
	protected Map<Integer, UserPrice> getItems() {
		return program.getSettings().getUserPrices();
	}

	@Override
	protected void setItems(Map<Integer, UserPrice> items) {
		program.getSettings().setUserPrices(items);
	}

	@Override
	protected UserPrice newItem(UserPrice item) {
		return new UserPrice(item);
	}

	@Override
	protected UserPrice valueOf(Object o) {
		if (o instanceof UserPrice){
			return (UserPrice) o;
		}
		return null;
	}

	@Override
	protected String getDefault(UserPrice item) {
		return String.valueOf(EveAsset.getDefaultPrice(program.getSettings().getPriceData().get(item.getTypeID())));
	}

}