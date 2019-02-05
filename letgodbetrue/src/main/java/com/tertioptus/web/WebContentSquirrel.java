package com.tertioptus.web;

import java.util.stream.Stream;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.tertioptus.web.url.UrlReceptionist;

/**
 * 
 * Provides web content.
 *
 * @author Benjamin F. Paige III
 * @author Amaryssa M. Paige
 * @since Jan 15, 2019
 */
public class WebContentSquirrel implements Squirrel {

	private UrlReceptionist urlReceptionist;
	private WebContentEngineer<HtmlTableRow> webContentEngineer;
	
	public WebContentSquirrel(UrlReceptionist urlReceptionist, WebContentEngineer<HtmlTableRow> webContentEngineer) {
		this.urlReceptionist = urlReceptionist;
		this.webContentEngineer = webContentEngineer;
	}

	@Override
	public Stream<String[]> sermons() throws Exception { 
		return webContentEngineer
		.stream(urlReceptionist.url(), "content")
		.map(r -> map(r))
		.filter(r -> !"".equals(r[2]+r[4]+r[6]));
	}
	
	private String[] map(HtmlTableRow row) {
		
		String[] sermonRecord = new String[9];
		
		sermonRecord[0] = row.getFirstChild().getFirstChild().asText();
		sermonRecord[1] = row.getCell(1).getFirstChild().asText();
		sermonRecord[2] ="";
		sermonRecord[3] ="";
		sermonRecord[4] ="";
		sermonRecord[5] ="";
		sermonRecord[6] ="";
		sermonRecord[7] ="";
		sermonRecord[8] = row.getCell(3).getFirstChild().asText();
			
		mapAnchors(row.getCell(2).getFirstChild().getFirstChild(),sermonRecord);
		return sermonRecord;
	}
	
	void mapAnchors(DomNode firstAnchor, String[] sermonRecord) {
		DomNode cursorNode = firstAnchor;
		int index=0;
		while(cursorNode != null && cursorNode.hasAttributes())
		{
			switch(cursorNode.getTextContent().trim()) {
				case "Intro": index = 2;
				break;
				case "Psalm": index = 4;
				break;
				case "Sermon": index = 6;
				break;
			}
			sermonRecord[index] = cursorNode.getTextContent();
			sermonRecord[index+1] = cursorNode.getAttributes().getNamedItem("href").getTextContent();
			
			cursorNode = cursorNode.getNextSibling() == null? null : cursorNode.getNextSibling().getNextSibling();
		}	
	}
}
