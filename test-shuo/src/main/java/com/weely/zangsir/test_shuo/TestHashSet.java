package com.weely.zangsir.test_shuo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class TestHashSet {
	final static Set<String> defaultStopWords = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            "play", "start", "by", "a", "all", "am", "an", "and", "any", "are", "as", "at", "be", "but", "by", "do", "does",
            "for","from", "had", "has", "have", "he", "his", "hers", "i", "id", "I’m", "in", "is", "it", "its", "lets",
            "me", "more", "my", "of", "off", "on", "or", "other", "so", "some", "than", "that", "the", "then", "there",
            "these", "they", "this", "to", "too", "was", "we", "with", "would", "your", "internet")));
   public static void main(String args[]) {
      
      // create hash set
      HashSet <String> newset = new HashSet <String>();

      // populate hash set
      newset.add("Learning"); 
      newset.add("Easy");
      newset.add("Simply");  

      // check the existence of element
      //boolean exist = newset.contains("Simply");

      //System.out.println("Is the element 'Simply' exists: "+ exist);
      
      
      
      ////// another way
      Set<String> appNames = new HashSet<>(Arrays.asList(
    		  "rise up",
    		  "helix jump",
    		  "love balls",
    		  "fortnite",
    		  "instagram",
    		  "snapchat",
    		  "messenger",
    		  "facebook",
    		  "google maps",
    		  "harry potter: hogwarts mystery",
    		  "bitmoji",
    		  "gmail",
    		  "spotify music",
    		  "netflix",
    		  "granny",
    		  "uber",
    		  "sky rusher",
    		  "whatsapp messenger",
    		  "pandora music",
    		  "cash app",
    		  "snake vs block",
    		  "amazon",
    		  "lyft",
    		  "google photos",
    		  "waze navigation & live traffic",
    		  "color road",
    		  "wish",
    		  "soundcloud",
    		  "venmo",
    		  "musically",
    		  "google docs",
    		  "mr gun",
    		  "google drive",
    		  "splashy",
    		  "hulu",
    		  "pinterest",
    		  "uber eats",
    		  "paypal",
    		  "baseball boy",
    		  "impossible bottle flip",
    		  "the cube",
    		  "vpn 360",
    		  "grandpa",
    		  "offerup",
    		  "flip the gun",
    		  "yelp",
    		  "word link",
    		  "microsoft outlook",
    		  "mmx hill dash 2",
    		  "poshmark",
    		  "word collect: word puzzle game",
    		  "best vpn proxy betternet",
    		  "subway surfers",
    		  "flying arrow",
    		  "walmart",
    		  "songpop 2",
    		  "letgo",
    		  "candy crush saga",
    		  "shazam",
    		  "roblox",
    		  "google slides",
    		  "toon blast",
    		  "groupon",
    		  "photomath",
    		  "twisty road",
    		  "find my family, friends, phone",
    		  "credit karma",
    		  "rolly vortex",
    		  "doordash",
    		  "marco polo video walkie talkie",
    		  "x-vpn unlimited vpn proxy",
    		  "lego star wars",
    		  "ebay",
    		  "episode",
    		  "iheartradio",
    		  "solitaire",
    		  "musi",
    		  "mcdonald's",
    		  "google translate",
    		  "knife hit",
    		  "dropbox",
    		  "chase mobile",
    		  "mlb tap sports baseball 2018",
    		  "parade",
    		  "starbucks",
    		  "unicorn",
    		  "amazon prime video",
    		  "huji cam",
    		  "bank of america mobile banking",
    		  "target",
    		  "color your call",
    		  "choices",
    		  "groupme",
    		  "fitbit",
    		  "houseparty",
    		  "picsart photo editor & collage",
    		  "xbox",
    		  "aliexpress shopping app",
    		  "layout from instagram",
    		  "color by number",
    		  "twitter",
    		  "start"));
      
      
      String query = "Facebook";
      
      
      
      
      // for each word in query, check if it is an app name
      String[] words = query.split(" ");
      for (String word:words){
          //System.out.println(word);
          if (appNames.contains(word.toLowerCase()) && !defaultStopWords.contains(word.toLowerCase())) {
        	  System.out.print(word + " is an app recognized\n");
          }
      }
      
      
      ////////// implememnt a generic function that checks if a query is an app name that exists in a hashmap of (name,id)
      TestHashSet obj = new TestHashSet();
      List<String[]> content = obj.readData();
      //System.out.println(content.toString());
      HashMap<String, String> mapNameId = new HashMap<String, String>();
      
      //map.put(5, "Five");

      for (String[] tup:content) {
    	  //System.out.println(tup[0]);
    	  //System.out.println(tup[1]);
    	  mapNameId.put(tup[1], tup[0]);
    	  
      }
      
      if (mapNameId.containsKey(query.toLowerCase()) && !defaultStopWords.contains(query.toLowerCase())) {
    	  System.out.print(query + " is an app recognized with ID " + mapNameId.get(query.toLowerCase()) + "\n");
      }
      
      
      System.out.println("\n========\n below is returned through a method to check if query exists\n");
      SingleEntityResult<String> result = checkAppName(query);
      if (result!=null) {
      System.out.println("ID: " + result.getIdResult());
      System.out.println("NAME: " + result.getNameResult());
      }
      
      System.out.println("=============Ngram below");
      String [] ng = ngrams("this is very good sir in indeed", 3);
      for (String s:ng) {
      System.out.println(s);
      }
      for (int i=0;i<5;i++) {
    	  System.out.println(i);
      }
      
      //below code was some first-pass testing of if an app name is recognized, no stop word or 
      //boolean ex = appNames.contains(query.toLowerCase());
      //System.out.println(query +  " app exists: " + ex);
      //System.out.print(ex?query + " app exists":query + " app doesn't exist");
   }    
   
   public List<String[]> readData() { 
	    String fileName = "file/appNames.txt";
	    ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
	    List<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split("\t"));
	        }
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    } catch (IOException e1) {
			
			e1.printStackTrace();
		}
	    return content;
	}
   
   public static SingleEntityResult<String> checkAppName(String query) {
	      TestHashSet obj = new TestHashSet();
	      List<String[]> content = obj.readData();
	      //System.out.println(content.toString());
	      HashMap<String, String> mapNameId = new HashMap<String, String>();
	      
	      //map.put(5, "Five");
          //fill in the hashmap
	      for (String[] tup:content) {
	    	  //System.out.println(tup[0]);
	    	  System.out.println(tup[1]);
	    	  mapNameId.put(tup[1], tup[0]);
	    	  
	      }
	      SingleEntityResult<String> result = null;
	      if (mapNameId.containsKey(query.toLowerCase()) && !defaultStopWords.contains(query.toLowerCase())) {
	    	  //System.out.print(query + " is an app recognized\n with ID " + mapNameId.get(query.toLowerCase()));
	      
	          result = SingleEntityResult.create(mapNameId.get(query.toLowerCase()), query.toLowerCase());
	      }
	      return result;
	   
	   
   }
   
   public static String[] ngrams(String s, int len) {
	    String[] parts = s.split(" ");
	    String[] result = new String[parts.length - len + 1];
	    for(int i = 0; i < parts.length - len + 1; i++) {
	       StringBuilder sb = new StringBuilder();
	       for(int k = 0; k < len; k++) {
	           if(k > 0) sb.append(' ');
	           sb.append(parts[i+k]);
	       }
	       result[i] = sb.toString();
	    }
	    return result;
	}
   
}