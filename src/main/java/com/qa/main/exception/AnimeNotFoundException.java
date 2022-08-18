package com.qa.main.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Anime does not exist with that ID")
public class AnimeNotFoundException extends NoSuchElementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7811623002959611117L;

}
