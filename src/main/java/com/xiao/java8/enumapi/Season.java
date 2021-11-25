package com.xiao.java8.enumapi;

/**
 * @Classname Season
 * @Description 替换NormalStyle 中常用的写法
 * @Date 2021/6/4
 * @Created by lktbz
 */
public enum  Season {
    SPRING(1),SUMMER(2),AUTUMN(3),WINNER(4);
    private int code;
   //构造私有
   private Season(int code) {
        this.code = code;
    }
    //提供get构造函数
    public int getCode() {
        return code;
    }

}
/**
 * java p 反编译
 *
 * public final class com.xiao.java8.enumapi.Season extends java.lang.Enum<com.xiao.java8.enumapi.Season> {
 *   public static final com.xiao.java8.enumapi.Season SPRING;
 *
 *   public static final com.xiao.java8.enumapi.Season SUMMER;
 *
 *   public static final com.xiao.java8.enumapi.Season AUTUMN;
 *
 *   public static final com.xiao.java8.enumapi.Season WINNER;
 *
 *   public static com.xiao.java8.enumapi.Season[] values();
 *     Code:
 *        0: getstatic     #1                  // Field $VALUES:[Lcom/xiao/java8/enumapi/Season;
 *        3: invokevirtual #2                  // Method "[Lcom/xiao/java8/enumapi/Season;".clone:()Ljava/lang/Object;
 *        6: checkcast     #3                  // class "[Lcom/xiao/java8/enumapi/Season;"
 *        9: areturn
 *
 *   public static com.xiao.java8.enumapi.Season valueOf(java.lang.String);
 *     Code:
 *        0: ldc           #4                  // class com/xiao/java8/enumapi/Season
 *        2: aload_0
 *        3: invokestatic  #5                  // Method java/lang/Enum.valueOf:(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
 *        6: checkcast     #4                  // class com/xiao/java8/enumapi/Season
 *        9: areturn
 *
 *   public int getCode();
 *     Code:
 *        0: aload_0
 *        1: getfield      #7                  // Field code:I
 *        4: ireturn
 *
 *   static {};
 *     Code:
 *        0: new           #4                  // class com/xiao/java8/enumapi/Season
 *        3: dup
 *        4: ldc           #8                  // String SPRING
 *        6: iconst_0
 *        7: iconst_1
 *        8: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *       11: putstatic     #10                 // Field SPRING:Lcom/xiao/java8/enumapi/Season;
 *       14: new           #4                  // class com/xiao/java8/enumapi/Season
 *       17: dup
 *       18: ldc           #11                 // String SUMMER
 *       20: iconst_1
 *       21: iconst_2
 *       22: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *       25: putstatic     #12                 // Field SUMMER:Lcom/xiao/java8/enumapi/Season;
 *       28: new           #4                  // class com/xiao/java8/enumapi/Season
 *       31: dup
 *       32: ldc           #13                 // String AUTUMN
 *       34: iconst_2
 *       35: iconst_3
 *       36: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *       39: putstatic     #14                 // Field AUTUMN:Lcom/xiao/java8/enumapi/Season;
 *       42: new           #4                  // class com/xiao/java8/enumapi/Season
 *       45: dup
 *       46: ldc           #15                 // String WINNER
 *       48: iconst_3
 *       49: iconst_4
 *       50: invokespecial #9                  // Method "<init>":(Ljava/lang/String;II)V
 *       53: putstatic     #16                 // Field WINNER:Lcom/xiao/java8/enumapi/Season;
 *       56: iconst_4
 *       57: anewarray     #4                  // class com/xiao/java8/enumapi/Season
 *       60: dup
 *       61: iconst_0
 *       62: getstatic     #10                 // Field SPRING:Lcom/xiao/java8/enumapi/Season;
 *       65: aastore
 *       66: dup
 *       67: iconst_1
 *       68: getstatic     #12                 // Field SUMMER:Lcom/xiao/java8/enumapi/Season;
 *       71: aastore
 *       72: dup
 *       73: iconst_2
 *       74: getstatic     #14                 // Field AUTUMN:Lcom/xiao/java8/enumapi/Season;
 *       77: aastore
 *       78: dup
 *       79: iconst_3
 *       80: getstatic     #16                 // Field WINNER:Lcom/xiao/java8/enumapi/Season;
 *       83: aastore
 *       84: putstatic     #1                  // Field $VALUES:[Lcom/xiao/java8/enumapi/Season;
 *
 *
 *
 *       根据字节码发现多了两个方法，分别是values  和valuesof
 */
