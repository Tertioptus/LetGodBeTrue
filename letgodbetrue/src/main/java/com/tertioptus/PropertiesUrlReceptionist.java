/**
 *  Prafet - automated cash flow (or illustration) system
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

import java.io.InputStream;
import java.util.Properties;

/**
 * TODO describe responsibility
 *
 * @assertion
 * <pre> 
 * 	TODO implement class assertion
 * </pre>
 *
 * @author Benjamin F. Paige III
 * @since Jan 14, 2019
 */
public class PropertiesUrlReceptionist implements UrlReceptionist {
	
	

	/**
	 * TODO describe
	 *
	 * @assertion
	 * <pre> 
	 * 	TODO implement method assertion
	 * </pre>
	 *
	 * @see com.tertioptus.UrlReceptionist#url()
	 */
	@Override
	public String url() throws Exception {
		Properties props = new Properties();
		InputStream inpStream = null;
		 
		try {
		 
		inpStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		 
		props.load(inpStream);
		 
		} finally {
		 
		inpStream.close();
		 
		}
		return props.getProperty("url");
	}

}
