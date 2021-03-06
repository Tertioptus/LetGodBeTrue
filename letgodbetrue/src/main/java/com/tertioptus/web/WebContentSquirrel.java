package com.tertioptus.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

		return rows.stream().map(r -> map(r)).filter(r -> !"".equals(r[2] + r[4] + r[6]));
	}

	private String[] map(HtmlElement row) {

		String[] sermonRecord = new String[9];

		DomNodeList<DomNode> dnl = row.getChildNodes();

		sermonRecord[0] = dnl.get(0).asText() + " " + dnl.get(1).asText();
		sermonRecord[1] = dnl.get(2).asText();
		processLink(sermonRecord, "Intro", "https://s3.amazonaws.com/letgodbetrue.audio/sermons/"
				+ generateNormalizedDate(sermonRecord[0]) + "-intro.mp3", 2);
		processLink(sermonRecord, "Psalm", "https://s3.amazonaws.com/letgodbetrue.audio/sermons/"
				+ generateNormalizedDate(sermonRecord[0]) + "-psalm.mp3", 4);
		processLink(sermonRecord, "Sermon", "https://s3.amazonaws.com/letgodbetrue.audio/sermons/"
				+ generateNormalizedDate(sermonRecord[0]) + "-sermon.mp3", 6);
		sermonRecord[8] = dnl.get(3).asText();

		return sermonRecord;
	}

	private String generateNormalizedDate(String dateMeridian) {
		String[] dMs = dateMeridian.split(" ");
		String[] date = dMs[0].split("/");
		String year = (Integer.parseInt(date[2]) > 70 ? "19" : "20") + date[2];
		return year + "/" + year + "-" + String.format("%02d", Integer.parseInt(date[0])) + "-"
				+ String.format("%02d", Integer.parseInt(date[1])) + "-" + dMs[1].toLowerCase();
	}

	private void processLink(String[] record, String title, String link, int titleIndex) {
		record[titleIndex] = "";
		record[titleIndex + 1] = "";
	     HttpURLConnection.setFollowRedirects(false);
		try {
			URL url = new URL(link);
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		    huc.setRequestMethod("HEAD");
			if (huc.getResponseCode() == HttpURLConnection.HTTP_OK) {
				record[titleIndex] = title;
				record[titleIndex + 1] = link;
			}
			huc.getInputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
