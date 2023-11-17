package com.dons.krohn.exeption;

public class ChannelNotFoundException extends RuntimeException{
    public ChannelNotFoundException(String message) {
        super(message);
    }
}
