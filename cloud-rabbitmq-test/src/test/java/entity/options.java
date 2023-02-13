package entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * 下注实体类容器
 * @author dongjunzi
 * @version 1.0
 * @date 2023/2/13 14:18
 */
@Data
public class options {
    private ArrayList selectOptions=new ArrayList<option>();
}
