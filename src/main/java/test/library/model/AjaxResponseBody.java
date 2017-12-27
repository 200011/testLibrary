package test.library.model;

import com.fasterxml.jackson.annotation.JsonView;
import test.library.entity.Book;

import java.util.List;

public class AjaxResponseBody {

    @JsonView()
    String msg;
    @JsonView()
    String code;
    @JsonView()
    List<Book> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Book> getResult() {
        return result;
    }

    public void setResult(List<Book> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AjaxResponseResult [msg=" + msg + ", code=" + code + ", result=" + result + "]";
    }
}
