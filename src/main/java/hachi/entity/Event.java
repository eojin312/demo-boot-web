package hachi.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {
    interface ValidateLimit { }
    interface ValidateName{}

    public Long id;

    @NotBlank(groups = ValidateName.class)
    public String name;


    public Long getId() {
        return id;
    }

    @Min(value = 0, groups = ValidateLimit.class) // @Vaild 테스트를 위해서 limit 의 값이 0 이하로 들어올 수 없게 해준다.
    public Integer limit;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
