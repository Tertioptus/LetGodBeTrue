package com.tertioptus;

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
	private WebContentEngineer<String[]> webContentEngineer;
	
	public WebContentSquirrel(UrlReceptionist urlReceptionist, WebContentEngineer<String[]> webContentEngineer) {
		this.urlReceptionist = urlReceptionist;
		this.webContentEngineer = webContentEngineer;
	}

	@Override
	public String html() throws Exception { 
		String[] content = new String[]{""};
		webContentEngineer.loadById(urlReceptionist.url(), "content", content);
		return content[0];
	}

}
