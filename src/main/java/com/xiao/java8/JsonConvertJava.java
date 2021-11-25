package com.xiao.java8;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 使用gsonFormat 测试json 转换成实体类
 *
 *
 * 测试json
  {
          "id": 0,
          "title_hello": "aaa",
          "children": [
             {
                  "id": 9,
                 "title_hello": "QA测试12",
                  "children": null
             },
              {
                  "id": 21,
                  "title_hello": "鱿鱼",
                  "children": null
              }
         ]
      }
 */
//生成的实体类
@NoArgsConstructor
@Data
public class JsonConvertJava {


    private Integer id;
    private String titleHello;
    private List<ChildrenDTO> children;

    @NoArgsConstructor
    @Data
    public static class ChildrenDTO {
        private Integer id;
        private String titleHello;
        private Object children;
    }
}
