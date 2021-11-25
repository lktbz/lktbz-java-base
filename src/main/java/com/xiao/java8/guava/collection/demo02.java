package com.xiao.java8.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

/**
 *  Multimap 使用
 */
public class demo02 {
    Map<String ,List<StudentScore>> stuMap=new HashMap<String , List<StudentScore>>();
    @Test
    public  void test(){
        ArrayList<StudentScore> objects = Lists.newArrayList();
        for(int i=0;i<20;i++){
            StudentScore studentScore = new StudentScore();
            studentScore.setCourseId(10+i);
            studentScore.setScore(200+i);
            addStudentScore("peida",studentScore);
        }
        List<StudentScore> peida = stuMap.get("peida");
        for (StudentScore s:peida
             ) {
            System.out.println(s.getCourseId()+"--->"+s.getScore());
        }

    }
    @Test
    public void testGuava(){
        ArrayListMultimap<String, StudentScore> objectObjectArrayListMultimap = ArrayListMultimap.create();
        for(int i=0;i<20;i++){
            StudentScore studentScore = new StudentScore();
            studentScore.setCourseId(10+i);
            studentScore.setScore(200+i);
            objectObjectArrayListMultimap.put("zs",studentScore);
        }
        for (String kname:objectObjectArrayListMultimap.keySet()){
            List<StudentScore> studentScores = objectObjectArrayListMultimap.get(kname);
            System.out.println(studentScores);
        }
    }

    private void addStudentScore(String peida, StudentScore studentScore) {
        List<StudentScore> studentScores = stuMap.get(peida);
        if (studentScores==null){
            /**
             * key 不存在则，创建数组
             */
            studentScores =new ArrayList();
            stuMap.put(peida,studentScores);
        }else
        {
            /**
             * key 存在 直接添加到数组
             */
            studentScores.add(studentScore);
        }
    }
    /**
     * 使用guava 替换
     */
}

class StudentScore{
    int courseId;
    int score;

    @Override
    public String toString() {
        return "StudentScore{" +
                "courseId=" + courseId +
                ", score=" + score +
                '}';
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}