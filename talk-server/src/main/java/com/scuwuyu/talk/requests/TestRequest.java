package com.scuwuyu.talk.requests;


import javax.validation.constraints.NotNull;

/**
 * Created by lxf on 2016/4/12.
 */
public class TestRequest {

    @NotNull(message = "test_1003")
    private Integer age;

    @NotNull(message = "test_1002")
    private String name;

    /**
     * 嵌入对象以inner方式作为入参
     */
    @NotNull(message = "test_1004")
    private TestInnerRequest testInnerRequest;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestInnerRequest getTestInnerRequest() {
        return testInnerRequest;
    }

    public void setTestInnerRequest(TestInnerRequest testInnerRequest) {
        this.testInnerRequest = testInnerRequest;
    }
}
