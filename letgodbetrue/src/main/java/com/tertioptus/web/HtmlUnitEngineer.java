package com.tertioptus.web;

import java.util.List;
import java.util.stream.Stream;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.tertioptus.Sol;

/**
 * Manages an HTML Unit {@link WebClient}.
 *
 * @author Benjamin F. Paige III
 * @since Feb 6, 2019
 * @see com.gargoylesoftware.htmlunit
 */
public class HtmlUnitEngineer extends Sol implements WebContentEngineer<HtmlTableRow> {

	private WebClient webClient;

	public HtmlUnitEngineer() {
		this.webClient = new WebClient();
	}

	public Stream<HtmlTableRow> stream(String url, String id) throws Exception {
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		try {
			HtmlPage page = webClient.getPage(url);
			List<?> trs =  page.getElementsByTagName("tr");
			return trs.stream().map(r -> (HtmlTableRow) r);
		} catch (Exception e) {
			throw e;
		} finally {
			webClient.close();
		}
	}

}
