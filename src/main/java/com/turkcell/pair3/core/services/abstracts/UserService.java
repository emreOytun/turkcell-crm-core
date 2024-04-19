package com.turkcell.pair3.core.services.abstracts;

import com.turkcell.pair3.core.services.dtos.requests.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
   void add(RegisterRequest request);
}
