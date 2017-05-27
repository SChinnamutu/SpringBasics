package com.perficient.batch;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author Dinesh Rajput
 *
 */
public class CustomItemReader implements ItemReader<String>{
	
	public Queue<String> notificationList = new LinkedList<String>();
	
	@Override
	public String read() throws Exception, UnexpectedInputException,ParseException {
		return notificationList.poll();
	}
	
	public void addToQueue(){
		for (int i = 0; i < 20; i++) {
			notificationList.add(String.valueOf(i));
		}
	}
	
}


//private int bookCount = 0;
		/*if(bookCount < bookNameList.size()){
			return bookNameList.get(bookCount++);
		}else{
			return null;
		}*/