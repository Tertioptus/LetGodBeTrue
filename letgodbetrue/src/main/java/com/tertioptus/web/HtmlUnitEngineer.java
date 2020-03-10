package com.tertioptus.web;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.tertioptus.Sol;

/**
 * Manages an HTML Unit {@link WebClient}.
 *
 * @author Benjamin F. Paige III
 * @since Feb 6, 2019
 * @see com.gargoylesoftware.htmlunit
 */
final class HtmlUnitEngineer extends Sol implements WebContentEngineer<HtmlElement> {

	private WebClient webClient;

	public HtmlUnitEngineer() {
		this.webClient = new WebClient();
	}

	public List<HtmlElement> stream(String url, String id) throws Exception {
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		try {
			HtmlPage page = webClient.getPage(url);
			List<HtmlElement> trs = new ArrayList<>();
			DomNodeList<DomElement> dnl = page.getElementsByTagName("tbody");
			if (dnl != null) {
				for (DomElement tbody : page.getElementsByTagName("tbody")) {
					trs.addAll(tbody.getElementsByTagName("tr"));
				}
			}
			return trs;
		} catch (Exception e) {
			throw e;
		} finally {
			webClient.close();
		}
	}

}
