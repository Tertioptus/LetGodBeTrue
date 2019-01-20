/**
 *  LetGodBeTrue.com Podcast
 *  Copyright (C) 2019 Benjamin F. Paige III (benpaigeiii@hotmail.com)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.tertioptus;

import java.util.logging.Logger;

/**
 * Handles incoming URL from local properties.
 *
 * @author Benjamin F. Paige III
 * @since Jan 14, 2019
 */
public class PropertiesUrlReceptionist implements UrlReceptionist {
	
	private final static Logger LOGGER =  
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 	
	
	private MapEngineer<String,String> mapEngineer;
	
	public PropertiesUrlReceptionist(MapEngineer<String, String> mapEngineer) {
		this.mapEngineer = mapEngineer;
	}

	/**
	 * @see com.tertioptus.UrlReceptionist#url()
	 */
	@Override
	public String url() throws Exception {

		LOGGER.info(this.getClass().getName() + ": acquiring url value from properites map.");
		return this.mapEngineer.value("url");
	}

}
