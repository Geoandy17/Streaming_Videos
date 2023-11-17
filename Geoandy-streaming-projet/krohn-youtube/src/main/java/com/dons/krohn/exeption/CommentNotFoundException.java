package com.dons.krohn.exeption;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String s){
        super(s);
    }
}
