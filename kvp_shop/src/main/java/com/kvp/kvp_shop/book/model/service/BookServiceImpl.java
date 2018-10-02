package com.kvp.kvp_shop.book.model.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kvp.kvp_shop.book.model.vo.Book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Repository
@Service
public class BookServiceImpl implements BookService{
	
	private String json;
	private int start=1;
	
	//상세 정보 크롤링(책 설명, 저자 설명, 목차)
	@Override
	public List<String> crawling(String URL) throws Exception {
		System.out.println(URL);
		List<String> str = new ArrayList<String>();
        Document doc = Jsoup.connect(URL).get();
        String bookinfo, authorinfo, index;
        Elements elem = doc.select("div#bookIntroContent");		//내용 설명{bookInfo}
        elem.select("br").append("\\n");
        bookinfo = elem.text().replaceAll("\\\\n","\n");
        Elements elem2 = doc.select("div#authorIntroContent");		//저자 소개 ?
        elem2.select("br").append("\\n");
        authorinfo = elem2.text().replaceAll("\\\\n","\n");
        Elements elem3 = doc.select("div#tableOfContentsContent");		//목차
        elem3.select("br").append("\\n");
        index = elem3.text().replaceAll("\\\\n","\n");
        
        str.add(bookinfo);
        str.add(authorinfo);
        str.add(index);
        return str;
	}

	//api 받아오기 하단의 api 메소드에서 사용 됨
	@Override
	public void WebConnection(String c) throws Exception {
		
		int start=1;
		 String clientId = "WIIQoB4jzFiYz8IAsjl6";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "ACWgNqgb9a";//애플리케이션 클라이언트 시크릿값";
	        try {
	            String text = URLEncoder.encode(c, "UTF-8");
	            String apiURL = "https://openapi.naver.com/v1/search/book?display=100&sort=count&start="+start+"&query="+ text; 
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine.toString());
	            }
	           json = response.toString();
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	}
	
	
	
	//실질적인 검색 기능
	@Override
	public ArrayList<Book> api(String c) throws Exception {
		System.out.println(c);
		ArrayList<Book> books = new ArrayList<Book>();
		BookServiceImpl wc = new BookServiceImpl();
		wc.WebConnection(c);
		
		String json = wc.json;
		
		JSONParser parser = new JSONParser();
		
		JSONObject obj = (JSONObject)parser.parse(json);
		
		//최대 개수 검색
		long total = (long)obj.get("total");
		System.out.println(total);
			
		JSONArray item = (JSONArray)obj.get("items");
		
		int page = (int)total/100;
		
		System.out.println(total);
		
		if(total%100!=0)
			page++;
		
		if(page>10)
			page=10;
		
		System.out.println(page);
		
		for(int p=0;p<page;p++) {
			if(p!=0) {
				wc.start=p*100+1;
				wc.WebConnection(c);
				json = wc.json;
			}
			System.out.println(wc.start);
			obj = (JSONObject)parser.parse(json);
			item = (JSONArray)obj.get("items");
			for(int i =0;i<item.size();i++) {
				Book book = new Book();
				JSONObject tmp = (JSONObject)item.get(i);
				book.setBookTitle(((String)tmp.get("title")).replace("<b>","").replace("</b>",""));
				book.setBookInfo((String)tmp.get("link"));
				book.setBookImage((String)tmp.get("image"));
				book.setWriterName((String)tmp.get("author"));
				book.setBookPrice(Integer.valueOf((String) tmp.get("price")));
				if(!((String)tmp.get("discount")).equals(""))
					book.setDiscount(Integer.valueOf((String)tmp.get("discount")));
				else
					book.setDiscount(0);
				book.setBookPublisher((String)tmp.get("publisher"));
				book.setBookIssueDate((String)tmp.get("pubdate"));
				String isbn = ((String)tmp.get("isbn"));
				if(isbn.length()>13)
					isbn= isbn.substring(isbn.length()-13,isbn.length());
				book.setIsbn(isbn);
				books.add(book);
			}
		}
		return books;
	}

}
