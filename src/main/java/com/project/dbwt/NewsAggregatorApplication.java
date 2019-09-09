/**
 * @author Ashwini
 *
 */
package com.project.dbwt;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.project.dbwt.model.NewsAggregatorModel;
import com.project.dbwt.repository.NewsAggregatorRepository;

import org.hibernate.validator.internal.util.privilegedactions.GetInstancesFromServiceLoader;
import org.jdom.input.SAXBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import javax.xml.parsers.*;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import org.springframework.boot.CommandLineRunner;
import org.w3c.dom.Document;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


@SpringBootApplication
//@EnableScheduling
public class NewsAggregatorApplication {

	


    public static void main(String[] args) throws IllegalArgumentException, FeedException, IOException {
        SpringApplication.run(NewsAggregatorApplication.class, args);

    }

    //URL feedsource = new URL("https://timesofindia.indiatimes.com/rssfeeds/4719148.cms");
    //URL feedsource = new URL("http://jvm-bloggers.com/pl/rss.xml");
    //https://zapier.com/blog/feeds/latest/
    //http://www.espncricinfo.com/rss/content/story/feeds/2.xml
    //https://www.blog.google/rss/
    //https://www.perspektive-wiedereinstieg.de/Navigation/DE/Service/RSS/RSS.xml;
    //http://static.cricinfo.com/rss/livescores.xml

    @Bean
    @Scheduled(cron="*/10 * * * * *")
    public CommandLineRunner demo(NewsAggregatorRepository newsAggregatorRepository) {
        return (args) -> {
           
            URL feedsource1 = new URL("https://zapier.com/blog/feeds/latest/");
          
           
            SyndFeedInput input1 = new SyndFeedInput();
            SyndFeed feed1 = input1.build(new XmlReader(feedsource1));
            List res = feed1.getEntries();
           
            
            for(Object o : res){
               
                NewsAggregatorModel newsAggregatorModel = new NewsAggregatorModel();

                newsAggregatorModel.setTitle(((SyndEntryImpl) o).getTitle());
                newsAggregatorModel.setAuthor(((SyndEntryImpl) o).getAuthor());
                newsAggregatorModel.setLink(((SyndEntryImpl) o).getLink());
                newsAggregatorModel.setPublishedDate(((SyndEntryImpl) o).getPublishedDate());
                newsAggregatorModel.setUpdatedDate(((SyndEntryImpl) o).getUpdatedDate());
                newsAggregatorModel.setLastBuildDate(readRss("https://zapier.com/blog/feeds/latest/")[0]);
                newsAggregatorModel.setFeedProvider(readRss("https://zapier.com/blog/feeds/latest/")[1]);
              
                newsAggregatorRepository.save(newsAggregatorModel);
                }
            
            URL feedsource2 = new URL("https://www.seattletimes.com/nation-world/world/feed/");
            SyndFeedInput input2 = new SyndFeedInput();
            SyndFeed feed2 = input2.build(new XmlReader(feedsource2));
            List res2 = feed2.getEntries();
            

            for(Object o : res2){
               
                NewsAggregatorModel newsAggregatorModel = new NewsAggregatorModel();

                newsAggregatorModel.setTitle(((SyndEntryImpl) o).getTitle());
                newsAggregatorModel.setAuthor(((SyndEntryImpl) o).getAuthor());
                newsAggregatorModel.setLink(((SyndEntryImpl) o).getLink());
                newsAggregatorModel.setPublishedDate(((SyndEntryImpl) o).getPublishedDate());
                newsAggregatorModel.setUpdatedDate(((SyndEntryImpl) o).getUpdatedDate());
                newsAggregatorModel.setLastBuildDate(readRss("https://www.seattletimes.com/nation-world/world/feed/")[0]);
                newsAggregatorModel.setFeedProvider(readRss("https://www.seattletimes.com/nation-world/world/feed/")[1]);
                newsAggregatorRepository.save(newsAggregatorModel);
            }
            //============================================================
            URL feedsource3 = new URL("https://www.rand.org/topics/international-affairs.xml/feed");
            SyndFeedInput input3 = new SyndFeedInput();
            SyndFeed feed3 = input3.build(new XmlReader(feedsource3));
            List res3 = feed3.getEntries();
            

            for(Object o : res3){
               
                NewsAggregatorModel newsAggregatorModel = new NewsAggregatorModel();

                newsAggregatorModel.setTitle(((SyndEntryImpl) o).getTitle());
                newsAggregatorModel.setAuthor(((SyndEntryImpl) o).getAuthor());
                newsAggregatorModel.setLink(((SyndEntryImpl) o).getLink());
                newsAggregatorModel.setPublishedDate(((SyndEntryImpl) o).getPublishedDate());
                newsAggregatorModel.setUpdatedDate(((SyndEntryImpl) o).getUpdatedDate());
                newsAggregatorModel.setLastBuildDate(readRss("https://www.rand.org/topics/international-affairs.xml/feed")[0]);
                newsAggregatorModel.setFeedProvider(readRss("https://www.rand.org/topics/international-affairs.xml/feed")[1]);
                newsAggregatorRepository.save(newsAggregatorModel);
            }
           // =========================================================================
             URL feedsource4 = new URL("https://www.rt.com/rss/news/");
            SyndFeedInput input4 = new SyndFeedInput();
            SyndFeed feed4 = input4.build(new XmlReader(feedsource4));
            List res4 = feed4.getEntries();
            

            for(Object o : res4){
               
                NewsAggregatorModel newsAggregatorModel = new NewsAggregatorModel();

                newsAggregatorModel.setTitle(((SyndEntryImpl) o).getTitle());
                newsAggregatorModel.setAuthor(((SyndEntryImpl) o).getAuthor());
                newsAggregatorModel.setLink(((SyndEntryImpl) o).getLink());
                newsAggregatorModel.setPublishedDate(((SyndEntryImpl) o).getPublishedDate());
                newsAggregatorModel.setUpdatedDate(((SyndEntryImpl) o).getUpdatedDate());
                newsAggregatorModel.setLastBuildDate(readRss("https://www.rt.com/rss/news/")[0]);
                newsAggregatorModel.setFeedProvider(readRss("https://www.rt.com/rss/news/")[1]);
                newsAggregatorRepository.save(newsAggregatorModel);
            }
            URL feedsource5 = new URL("https://talkingpointsmemo.com/world-news/feed");
            SyndFeedInput input5 = new SyndFeedInput();
            SyndFeed feed5 = input5.build(new XmlReader(feedsource5));
            List res5 = feed5.getEntries();
            

            for(Object o : res5){
               
                NewsAggregatorModel newsAggregatorModel = new NewsAggregatorModel();

                newsAggregatorModel.setTitle(((SyndEntryImpl) o).getTitle());
                newsAggregatorModel.setAuthor(((SyndEntryImpl) o).getAuthor());
                newsAggregatorModel.setLink(((SyndEntryImpl) o).getLink());
                newsAggregatorModel.setPublishedDate(((SyndEntryImpl) o).getPublishedDate());
                newsAggregatorModel.setUpdatedDate(((SyndEntryImpl) o).getUpdatedDate());
                newsAggregatorModel.setLastBuildDate(readRss("https://talkingpointsmemo.com/world-news/feed")[0]);
                newsAggregatorModel.setFeedProvider(readRss("https://talkingpointsmemo.com/world-news/feed")[1]);
                newsAggregatorRepository.save(newsAggregatorModel);
            }
           
        };
    }

    private String[] readRss(String urlAddress) throws IOException {
		// TODO Auto-generated method stub
    	URL rssUrl = new URL(urlAddress);
    	BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String line;
    	String temp1 = "";
    	String temp2 = "";
    	while((line = in.readLine())!= null){
    		if(line.contains("<lastBuildDate>")){
    			int firstPos = line.indexOf("<lastBuildDate>");
    			temp1 = line.substring(firstPos);
    			temp1 = temp1.replace("<lastBuildDate>", "");
    			int lastPos = temp1.indexOf("</lastBuildDate>");
    			temp1 = temp1.substring(0, lastPos);
    		
    		}
    		if(line.contains("<link>")){
    			int firstPos = line.indexOf("<link>");
    			temp2 = line.substring(firstPos);
    			temp2 = temp2.replace("<link>", "");
    			int lastPos = temp2.indexOf("</link>");
    			temp2 = temp2.substring(0, lastPos);
    		}
    	}
    	String arr[] = new String[2];
    	arr[0] = temp1;
    	arr[1] = temp2;
    	
    	in.close();
    	return arr;
		
	}

	

        //
}



