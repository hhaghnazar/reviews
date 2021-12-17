package org.wecancodeit.reviews;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Bad Request, Laptop Not Found!")
public class LaptopNotFoundException extends Exception {
}
