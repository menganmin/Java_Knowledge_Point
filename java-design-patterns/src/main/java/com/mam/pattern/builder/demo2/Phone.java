package com.mam.pattern.builder.demo2;

/**
 * @Author Anmin
 * @Date 2022/12/06
 **/
public class Phone {
    private String cup;
    private String screen;
    private String memory;
    private String mainboard;

    private Phone(Builder builder){
        this.cup = builder.cup;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cup='" + cup + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }

    public static final class Builder{
        private String cup;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder cup(String cup){
            this.cup = cup;
            return this;
        }
        public Builder screen(String screen){
            this.screen = screen;
            return this;
        }
        public Builder memory(String memory){
            this.memory = memory;
            return this;
        }
        public Builder mainboard(String mainboard){
            this.mainboard = mainboard;
            return this;
        }
        //使用构建者创建Phone对象
        public Phone builder(){
            return new Phone(this);
        }
    }
}
