package com.tertioptus;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * 
 * Provides html.
 *
 * @assertion
 * <pre> 
 * 	TODO implement class assertion
 * </pre>
 *
 * @author Benjamin F. Paige III
 * @author Amaryssa M. Paige
 * @since Jan 15, 2019
 */
public class HtmlUnitSquirrel extends WebClient implements Squirrel {
	
	private static final long serialVersionUID = 1L;

	private UrlReceptionist urlReceptionist;
	
	public HtmlUnitSquirrel(UrlReceptionist urlReceptionist) {
		this.urlReceptionist = urlReceptionist;
	}

	@Override
	public String html() throws Exception { 
		String html = "";
		getOptions().setCssEnabled(false);  
		getOptions().setJavaScriptEnabled(false);  
		try {  
		  HtmlPage page = getPage(urlReceptionist.url());
		  html = page.getElementById("content").asXml();
		}catch(Exception e){
		  throw e;
		} finally {
			close();
		}
		
		return html;
	}

}
