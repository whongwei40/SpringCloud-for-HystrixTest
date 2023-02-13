package entity;

import lombok.Data;

import java.util.Objects;

/**
 * @author dongjunzi
 * @version 1.0
 * @date 2023/2/13 14:15
 */
//下注实体类
@Data
public class option {

    public option(Integer name, Integer count) {
        this.name=name;
        this.count=count;
    }

    private Integer name;
    private Integer count;

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        option option = (option) o;
        return Objects.equals(name, option.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
