package com.turkcell.pair3.core.events.factories;

import com.turkcell.pair3.core.events.RegisterEvent;

public class RegisterEventFactory {
    public static RegisterEvent create(String email, String password) {
        return new RegisterEvent(email, password);
    }
}
