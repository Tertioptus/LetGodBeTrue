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

import com.tertioptus.properties.PropertiesMapEngineer;
import com.tertioptus.properties.PropertiesResourceStreamEngineer;
import com.tertioptus.web.HtmlUnitEngineer;
import com.tertioptus.web.Squirrel;
import com.tertioptus.web.WebContentSquirrel;
import com.tertioptus.web.url.ApacheUrlValidatorEngineer;
import com.tertioptus.web.url.PropertiesUrlReceptionist;
import com.tertioptus.web.url.QualifyingUrlReceptionist;
import com.tertioptus.web.url.UrlReceptionist;

/**
 * Default dependency assignments.
 *
 * @author Benjamin F. Paige III
 * @since Jan 14, 2019
 */
public class Default {

	public static PropertiesMapEngineer PropertiesMapEngineer(String propertiesFile) {
		return new PropertiesMapEngineer(propertiesFile, new PropertiesResourceStreamEngineer());
	}
	
	public static UrlReceptionist UrlReceptionist(MapEngineer<String,String> mapEngineer) {
		return new QualifyingUrlReceptionist(new ApacheUrlValidatorEngineer(), new PropertiesUrlReceptionist(mapEngineer));
	}
	
	public static Squirrel Squirrel(UrlReceptionist urlReceptionist){
		return new WebContentSquirrel(urlReceptionist, new HtmlUnitEngineer());
	}
}
