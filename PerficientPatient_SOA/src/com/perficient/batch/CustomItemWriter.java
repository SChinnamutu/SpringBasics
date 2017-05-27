package com.perficient.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * @author Sasikumar Chinnaumthu
 *
 */
public class CustomItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> bookNameWithAuthor) throws Exception {
		System.out.println(bookNameWithAuthor.size());
		System.out.println("Write File");
	}

}
