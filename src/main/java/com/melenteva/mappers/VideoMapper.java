package com.melenteva.mappers;

import com.melenteva.model.Video;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VideoMapper {

    @Insert("INSERT INTO VIDEO (videoName, videoAuthor, videoURL) VALUES (#{videoName}, #{videoAuthor}, #{videoURL})")
    public void addVideo(Video video);


    @Update("UPDATE VIDEO SET videoName = #{videoName},videoAuthor = #{videoAuthor},videoURL = #{videoURL} WHERE ID = #{id}")
    public void updateVideo(Video video);


    @Delete("DELETE FROM VIDEO WHERE ID = #{id}")
    public void removeVideo(@Param("id")int id);

    @Results(value={
            @Result(javaType=Video.class),
            @Result(property="id", column="ID"),
            @Result(property="videoName", column="videoName"),
            @Result(property="videoAuthor", column="videoAuthor"),
            @Result(property="videoURL", column="videoURL")
    })
    @Select(value="SELECT ID,videoName,videoAuthor,videoURL FROM VIDEO WHERE ID = #{id} ")
    public Video getVideoById(@Param("id") int id);


    @Results(value={
            @Result(javaType=Video.class),
            @Result(property="id", column="ID"),
            @Result(property="videoName", column="videoName"),
            @Result(property="videoAuthor", column="videoAuthor"),
            @Result(property="videoURL", column="videoURL")
    })
    @Select(value="SELECT ID,videoName,videoAuthor,videoURL FROM VIDEO")
    public List<Video> listVideo();



    @Results(value={
            @Result(javaType=Video.class),
            @Result(property="id", column="ID"),
            @Result(property="videoName", column="videoName"),
            @Result(property="videoAuthor", column="videoAuthor"),
            @Result(property="videoURL", column="videoURL")
    })

    @Select(value="SELECT * FROM VIDEO WHERE videoName LIKE #{videoName} AND videoAuthor LIKE #{videoAuthor} AND videoURL LIKE #{videoURL}")
    public List<Video> searchlistVideo(@Param("videoName")String videoName, @Param("videoAuthor") String videoAuthor, @Param("videoURL") String videoURL);
}


