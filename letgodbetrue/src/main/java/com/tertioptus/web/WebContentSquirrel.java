package com.tertioptus.web;

import java.util.List;
import java.util.stream.Stream;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
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
	private WebContentEngineer<HtmlElement> webContentEngineer;
	

	public WebContentSquirrel(UrlReceptionist urlReceptionist) {
		this(urlReceptionist, new HtmlUnitEngineer());
	}
	
	public WebContentSquirrel(UrlReceptionist urlReceptionist, WebContentEngineer<HtmlElement> webContentEngineer) {
		this.urlReceptionist = urlReceptionist;
		this.webContentEngineer = webContentEngineer;
	}

	@Override
	public Stream<String[]> sermons() throws Exception { 
		List<HtmlElement> rows = webContentEngineer.stream(urlReceptionist.url(), "content");
		
		return rows
		.stream()
		.map(r -> map(r))
		.filter(r -> !"".equals(r[2]+r[4]+r[6]));
	}
	
	private String[] map(HtmlElement row) {
		
		String[] sermonRecord = new String[9];
		
		DomNodeList<DomNode> dnl = row.getChildNodes();
		
		sermonRecord[0] = dnl.get(0).asText() + " " + dnl.get(1).asText();
		sermonRecord[1] = dnl.get(2).asText();
		sermonRecord[2] ="";
		sermonRecord[3] ="";
		sermonRecord[4] ="";
		sermonRecord[5] ="";
		sermonRecord[6] =dnl.get(2).asText();
		sermonRecord[7] ="https://s3.amazonaws.com/letgodbetrue.audio/sermons/" 
				+ generateNormalizedDate(sermonRecord[0]) + "-sermon.mp3";
		sermonRecord[8] = dnl.get(3).asText();
			
		return sermonRecord;
	}
	
	private String generateNormalizedDate(String dateMeridian) {
		String[] dMs = dateMeridian.split(" ");
		String[] date = dMs[0].split("/");
		String year = (Integer.parseInt(date[2])>70?"19":"20") + date[2];
		return year + "/" + year
				+ "-" + String.format("%02d", Integer.parseInt(date[0])) 
				+ "-" + String.format("%02d", Integer.parseInt(date[1])) 
				+ "-" + dMs[1].toLowerCase();
	}
}
