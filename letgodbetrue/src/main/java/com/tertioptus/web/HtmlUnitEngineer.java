package com.tertioptus.web;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitEngineer implements WebContentEngineer<String[]> {

	private WebClient webClient;

	public HtmlUnitEngineer() {
		this.webClient = new WebClient();
	}

	@Override
	public void loadById(String url, String id, String[] container) throws Exception {
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		try {
			HtmlPage page = webClient.getPage(url);
			container[0] = page.getElementById(id).asXml();
		} catch (Exception e) {
			throw e;
		} finally {
			webClient.close();
		}
	}

}
