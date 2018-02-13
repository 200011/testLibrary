package test.library.model;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponseBody {
    @JsonView
    private String msg;

    @JsonView
    private String code;

    public final String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public final String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }
}
