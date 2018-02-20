package com.typicode;

import com.typicode.comments.Comments;
import com.typicode.posts.Posts;

public class Rest {
	public final static String baseUrl = "https://jsonplaceholder.typicode.com/posts";
	public static Posts posts(){
		return new Posts();
	}
	
	public static Comments comments(){
		return new Comments();
	}
	
}
