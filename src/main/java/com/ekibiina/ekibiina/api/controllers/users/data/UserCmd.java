package com.ekibiina.ekibiina.api.controllers.users.data;

import java.util.Set;

public class UserCmd {
    public  record Req(
            String email, String password, String displayName, Set<String> roleNames) {
    }

    public record Resp(
            Long id,
            String firstName,
            String lastName,
            String email,
            String phoneNumber) {
    }
}
