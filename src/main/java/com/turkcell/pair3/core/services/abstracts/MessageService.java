package com.turkcell.pair3.core.services.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessage(String key, Object... args);
}
