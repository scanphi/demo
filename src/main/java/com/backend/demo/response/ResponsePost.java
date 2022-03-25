package com.backend.demo.response;

import java.util.HashMap;
import java.util.Map;

public class ResponsePost {
    Long id;
    Boolean success;

    public ResponsePost() {
    }

    public ResponsePost(Long id, Boolean success) {
        this.id = id;
        this.success = success;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
